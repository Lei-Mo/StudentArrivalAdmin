package com.chinasoft.studentarrivaladmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinasoft.studentarrivaladmin.constant.StudentConstant;
import com.chinasoft.studentarrivaladmin.entity.result.Result;
import com.chinasoft.studentarrivaladmin.mapper.StudentMapper;
import com.chinasoft.studentarrivaladmin.model.entity.Student;
import com.chinasoft.studentarrivaladmin.service.ArriveReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArriveReportServiceImpl extends ServiceImpl<StudentMapper, Student> implements ArriveReportService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Map<String, Object> getArriveReportStatistics() {
        // 统计总人数
        long total = this.count();

        // 统计已报道人数
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isArrived", StudentConstant.ARRIVED);
        long arrived = this.count(queryWrapper);

        // 计算未报道人数
        long nonArrived = total - arrived;

        // 计算报道率
        double reportingRate = (total == 0) ? 0 : (double) arrived / total * 100;

        Map<String, Object> statistics = new HashMap<>();
        statistics.put("reportingRate", reportingRate);
        statistics.put("actualReportingCount", arrived);
        statistics.put("nonReportingCount", nonArrived);

        return statistics;
    }

    @Override
    public Result getFromAddrCount() {
        // QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        // queryWrapper.groupBy("fromAddr");
        // long count = this.count(queryWrapper);
        Map<String, Long> map = studentMapper.getFromAddrCount();
        map.remove(null);

        Result result = new Result();
        result.setCode(HttpStatus.OK.value());
        result.setData(map);

        return result;
    }

    @Override
    public Result getCandidateTypeCount() {
        Map map = studentMapper.getCandidateTypeCount();
        Result result = new Result();
        result.setCode(HttpStatus.OK.value());
        result.setData(map);

        return result;
    }


}