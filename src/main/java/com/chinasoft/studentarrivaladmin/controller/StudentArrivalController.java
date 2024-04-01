package com.chinasoft.studentarrivaladmin.controller;

import com.chinasoft.studentarrivaladmin.model.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/student")
public class StudentArrivalController {

    /**
     * (3)新生入学报道流程如下：开始----新生填入学号与姓名---->匹配信息正确后
     * ---->填写出发地（重庆市内），以及新生寄语---->结束
     * 请根据上述需求设计出相应的表或者字段，其次设计出统计报道率接口、
     * 男女比例接口、报道流程可能需要的接口。并实现功能逻辑。
     */

    @PostMapping("/login")
    public Result studentLogin() {
        return null;
    }
}
