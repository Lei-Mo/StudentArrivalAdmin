package com.chinasoft.studentarrivaladmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chinasoft.studentarrivaladmin.model.entity.Student;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author 86178
 * @description 针对表【student】的数据库操作Mapper
 * @createDate 2024-04-01 14:52:03
 * @Entity com.chinasoft.studentarrivaladmin.entity.Student
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    @MapKey("fromAddr")
    Map<String, Long> getFromAddrCount();

    @MapKey("candidateType")
    Map getCandidateTypeCount();
}




