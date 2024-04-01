package com.chinasoft.studentarrivaladmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinasoft.studentarrivaladmin.mapper.StudentMapper;
import com.chinasoft.studentarrivaladmin.model.entity.Student;
import com.chinasoft.studentarrivaladmin.service.ArriveReportService;
import com.chinasoft.studentarrivaladmin.service.GenderReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
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

        // 统计男女比例（男：女）
        // 计算男女比例（男：女）
        String ratio;
        if (femaleCount == 0) {
            // 避免除以零的错误
            ratio = maleCount + ":0";
        } else {
            // 计算比例，并格式化输出
            BigInteger maleBigInt = BigInteger.valueOf(maleCount);
            BigInteger femaleBigInt = BigInteger.valueOf(femaleCount);
            BigInteger gcd = maleBigInt.gcd(femaleBigInt); // 最大公约数
            BigInteger simplifiedMale = maleBigInt.divide(gcd);
            BigInteger simplifiedFemale = femaleBigInt.divide(gcd);
            ratio = simplifiedMale + ":" + simplifiedFemale;
        }


        Map<String, Object> statistics = new HashMap<>();
        statistics.put("maleCount", maleCount);
        statistics.put("femaleCount", femaleCount);
        statistics.put("maleToFemale", ratio);

        return statistics;
    }

}