package com.besafx.android.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer code;

    private String name;

    private String address;

    private Person manager;

    private Company company;

    private List<Branch> branches = new ArrayList<>();
}
