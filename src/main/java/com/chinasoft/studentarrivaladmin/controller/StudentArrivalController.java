package com.chinasoft.studentarrivaladmin.controller;

import com.chinasoft.studentarrivaladmin.model.request.ArrivalSubmitRequest;
import com.chinasoft.studentarrivaladmin.model.request.LoginRequest;
import com.chinasoft.studentarrivaladmin.model.result.Result;
import com.chinasoft.studentarrivaladmin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/student")
public class StudentArrivalController {

    @Autowired
    private StudentService studentService;

    /**
     * (3)新生入学报道流程如下：开始----新生填入学号与姓名---->匹配信息正确后
     * ---->填写出发地（重庆市内），以及新生寄语---->结束
     * 请根据上述需求设计出相应的表或者字段，其次设计出统计报道率接口、
     * 男女比例接口、报道流程可能需要的接口。并实现功能逻辑。
     */

    @PostMapping("/login")
    public Result studentLogin(@RequestBody LoginRequest loginRequest) {

        return studentService.studentLogin(loginRequest);
    }

    /**
     * 填写出发地（重庆市内），以及新生寄语，同时修改为已报道状态，同时添加报道时间
     */

    @PostMapping("/arrivalSubmit")
    public Result arrivalSubmit(@RequestBody ArrivalSubmitRequest arrivalSubmitRequest) {
        return studentService.arrivalSubmit(arrivalSubmitRequest);
    }

}
