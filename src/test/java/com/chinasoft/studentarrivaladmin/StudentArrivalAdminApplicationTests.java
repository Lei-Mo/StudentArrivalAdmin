package com.chinasoft.studentarrivaladmin;

import com.chinasoft.studentarrivaladmin.mapper.StudentMapper;
import com.chinasoft.studentarrivaladmin.service.ArriveReportService;
import com.chinasoft.studentarrivaladmin.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class StudentArrivalAdminApplicationTests {

    @Autowired
    StudentService studentService;

    @Autowired
    ArriveReportService arriveReportService;

    @Autowired
    StudentMapper studentMapper;

    @Test
    void contextLoads() {
        System.out.println(studentService.list());
    }

    @Test
    void count() {
        Map<String, Long> map = studentMapper.getFromAddrCount();
        map.remove(null);
        System.out.println(map);

    }


}
