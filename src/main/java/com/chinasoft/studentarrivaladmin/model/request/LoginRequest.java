package com.chinasoft.studentarrivaladmin.model.request;

import lombok.Data;

@Data
public class LoginRequest {

    private Long studentId;

    private String name;
}
