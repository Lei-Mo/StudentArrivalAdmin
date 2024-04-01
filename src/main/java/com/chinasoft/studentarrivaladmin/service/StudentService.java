package com.chinasoft.studentarrivaladmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chinasoft.studentarrivaladmin.model.entity.Student;
import com.chinasoft.studentarrivaladmin.model.request.ArrivalSubmitRequest;
import com.chinasoft.studentarrivaladmin.model.request.LoginRequest;
import com.chinasoft.studentarrivaladmin.model.result.Result;

/**
 * @author 86178
 * @description 针对表【student】的数据库操作Service
 * @createDate 2024-04-01 14:52:03
 */
public interface StudentService extends IService<Student> {

    Result studentLogin(LoginRequest loginRequest);

    Result arrivalSubmit(ArrivalSubmitRequest arrivalSubmitRequest);
}
