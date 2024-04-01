package com.chinasoft.studentarrivaladmin;

import com.chinasoft.studentarrivaladmin.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentArrivalAdminApplicationTests {

    @Autowired
    StudentService studentService;

    @Test
    void contextLoads() {
        System.out.println(studentService.list());
    }

}
