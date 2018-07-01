package com.besafx.android.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Branch implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer code;

    private String name;

    private String address;

    private String phone;

    private String mobile;

    private String fax;

    private String email;

    private String website;

    private String commericalRegisteration;

    private String logo;

    private Person manager;

    private Region region;

    private List<Department> departments = new ArrayList<>();
}
