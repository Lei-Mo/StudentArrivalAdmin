package com.chinasoft.studentarrivaladmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chinasoft.studentarrivaladmin.entity.result.Result;
import com.chinasoft.studentarrivaladmin.model.entity.Student;

import java.util.Map;

public interface ArriveReportService extends IService<Student> {


    Map<String, Object> getArriveReportStatistics();

    Result getFromAddrCount();

    Result getCandidateTypeCount();
}
