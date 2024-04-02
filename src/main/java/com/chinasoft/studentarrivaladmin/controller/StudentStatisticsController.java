package com.chinasoft.studentarrivaladmin.controller;

import com.chinasoft.studentarrivaladmin.entity.result.Result;
import com.chinasoft.studentarrivaladmin.service.ArriveReportService;
import com.chinasoft.studentarrivaladmin.service.GenderReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/statistics")
public class StudentStatisticsController {

    @Autowired
    private ArriveReportService arriveReportService;

    @Autowired
    private GenderReportService genderReportService;

    @GetMapping("/arriveReport")
    public Result arriveReport() {
        // 查询数据库
        Map<String, Object> statistics = arriveReportService.getArriveReportStatistics();

        // 构造响应
        Result result = new Result();
        result.setCode(HttpStatus.OK.value());
        result.setMsg(HttpStatus.OK.getReasonPhrase());
        result.setData(statistics);

        // 返回响应
        return result;
    }

    @GetMapping("/genderReport")
    public Result genderReport() {
        // 查询数据库
        Map<String, Object> statistics = genderReportService.getGenderReportStatistics();

        // 构造响应
        Result result = new Result();
        result.setCode(HttpStatus.OK.value());
        result.setMsg(HttpStatus.OK.getReasonPhrase());
        result.setData(statistics);

        // 返回响应
        return result;
    }


    /**
     * 获取不同起始地的数量
     */
    @GetMapping("/getFromAddrCount")
    public Result getFromAddrCount() {
        Result result = arriveReportService.getFromAddrCount();

        return result;
    }

    @GetMapping("/getAllStudentInfo")
    public Result getAllStudentInfo() {
        Result result = new Result();
        result.setData(arriveReportService.list());
        result.setCode(HttpStatus.OK.value());
        return result;
    }

    @GetMapping("/getCandidateTypeCount")
    public Result getCandidateTypeCount() {
        return arriveReportService.getCandidateTypeCount();
    }

}
