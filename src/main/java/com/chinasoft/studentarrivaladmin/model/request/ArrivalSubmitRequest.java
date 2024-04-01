package com.chinasoft.studentarrivaladmin.model.request;

import lombok.Data;

@Data
public class ArrivalSubmitRequest {

    private Long studentId;

    private String fromAddr;

    private String message;
}
