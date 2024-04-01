package com.chinasoft.studentarrivaladmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinasoft.studentarrivaladmin.mapper.StudentMapper;
import com.chinasoft.studentarrivaladmin.model.entity.Student;
import com.chinasoft.studentarrivaladmin.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @author 86178
 * @description 针对表【student】的数据库操作Service实现
 * @createDate 2024-04-01 14:52:03
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {

}




