package com.besafx.android.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer code;

    private String name;

    private Person manager;

    private Branch branch;

    private List<Employee> employees = new ArrayList<>();
}
