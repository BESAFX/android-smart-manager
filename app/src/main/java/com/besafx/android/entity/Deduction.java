package com.besafx.android.entity;

import com.besafx.android.entity.enums.DeductionType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Deduction implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Date date;

    private Double amount;

    private String note;

    private DeductionType deductionType;

    private Person person;
}
