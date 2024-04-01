package com.chinasoft.studentarrivaladmin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName student
 */
@TableName(value = "student")
@Data
public class Student implements Serializable {
    /**
     *
     */
    @TableId
    private Long studentId;

    /**
     *
     */
    private String college;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String gender;

    /**
     *
     */
    private String politicalStatus;

    /**
     *
     */
    private String major;

    /**
     *
     */
    private String clazz;

    /**
     *
     */
    private String candidateId;

    /**
     *
     */
    private String cardId;

    /**
     *
     */
    private Date birthday;

    /**
     *
     */
    private String nation;

    /**
     *
     */
    private String dormitoryId;

    /**
     *
     */
    private String graduatedSchool;

    /**
     *
     */
    private String graduatedClass;

    /**
     *
     */
    private String candidateType;

    /**
     *
     */
    private String note;

    /**
     *
     */
    private Integer isArrived;

    /**
     *
     */
    private String fromAddr;

    /**
     *
     */
    private String message;

    /**
     *
     */
    private Date arriveTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}