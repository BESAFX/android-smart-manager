package com.besafx.android.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Double amount;

    private Date startDate;

    private Date endDate;

    private Receipt receipt;

    private Person person;
}
