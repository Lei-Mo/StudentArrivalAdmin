package com.chinasoft.studentarrivaladmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinasoft.studentarrivaladmin.mapper.StudentMapper;
import com.chinasoft.studentarrivaladmin.model.entity.Student;
import com.chinasoft.studentarrivaladmin.service.ArriveReportService;
import com.chinasoft.studentarrivaladmin.service.GenderReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GenderReportServiceImpl extends ServiceImpl<StudentMapper, Student> implements GenderReportService {

    @Override
    public Map<String, Object> getGenderReportStatistics() {

        // 统计男生人数
        QueryWrapper<Student> maleQueryWrapper = new QueryWrapper<>();
        maleQueryWrapper.eq("gender", "男");
        long maleCount = this.count(maleQueryWrapper);

        // 统计女生人数
        QueryWrapper<Student> femaleQueryWrapper = new QueryWrapper<>();
        femaleQueryWrapper.eq("gender", "女");
        long femaleCount = this.count(femaleQueryWrapper);


        Map<String, Object> statistics = new HashMap<>();
        statistics.put("maleCount", maleCount);
        statistics.put("femaleCount", femaleCount);

        return statistics;
    }

}