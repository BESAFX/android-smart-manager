package com.besafx.android.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vacation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Date date;

    private Integer days;

    private String note;

    private VacationType vacationType;

    private Person person;


}
