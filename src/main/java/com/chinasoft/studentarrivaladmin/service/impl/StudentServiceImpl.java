package com.chinasoft.studentarrivaladmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinasoft.studentarrivaladmin.constant.StudentConstant;
import com.chinasoft.studentarrivaladmin.mapper.StudentMapper;
import com.chinasoft.studentarrivaladmin.model.entity.Student;
import com.chinasoft.studentarrivaladmin.model.request.ArrivalSubmitRequest;
import com.chinasoft.studentarrivaladmin.model.request.LoginRequest;
import com.chinasoft.studentarrivaladmin.model.result.Result;
import com.chinasoft.studentarrivaladmin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 86178
 * @description 针对表【student】的数据库操作Service实现
 * @createDate 2024-04-01 14:52:03
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Result studentLogin(LoginRequest loginRequest) {
        if (loginRequest == null) {
            return new Result(HttpStatus.FORBIDDEN.value(), null, "用户信息错误");
        }

        // query student
        Student student = new Student();
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("studentId", loginRequest.getStudentId())
                .eq("name", loginRequest.getName());
        List<Student> students = studentMapper.selectList(queryWrapper);
        if (students.size() == 1) {
            return new Result(HttpStatus.OK.value(), students.get(0), "OK");
        } else {
            return new Result(HttpStatus.FORBIDDEN.value(), null, "用户信息错误");
        }
    }

    /**
     * 填写出发地（重庆市内），以及新生寄语，同时修改为已报道状态，同时添加报道时间
     */
    @Override
    public Result arrivalSubmit(ArrivalSubmitRequest arrivalSubmitRequest) {
        if (arrivalSubmitRequest == null) {
            return new Result(HttpStatus.FORBIDDEN.value(), null, "请输入正确信息");
        }

        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("studentId", arrivalSubmitRequest.getStudentId())
                .set("fromAddr", arrivalSubmitRequest.getFromAddr())
                .set("message", arrivalSubmitRequest.getMessage())
                .set("isArrived", StudentConstant.ARRIVED)
                .set("arriveTime", new Date());
        int updateRes = studentMapper.update(null, updateWrapper);
        if (updateRes == 1) {
            return new Result(HttpStatus.OK.value(), null, "OK");
        } else {
            return new Result(HttpStatus.FORBIDDEN.value(), null, "更新失败");

        }
    }
}




