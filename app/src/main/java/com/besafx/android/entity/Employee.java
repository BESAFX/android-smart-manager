package com.besafx.android.entity;

import com.besafx.android.entity.enums.EmployeeType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer code;

    private String role;

    private EmployeeType employeeType;

    private Date employeeDate;

    private Person person;

    private Department department;
}
