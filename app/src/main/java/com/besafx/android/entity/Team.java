package com.besafx.android.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer code;

    private String name;

    private String authorities;

    private List<Person> persons = new ArrayList<>();


}
