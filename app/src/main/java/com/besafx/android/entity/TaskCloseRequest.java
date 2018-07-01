package com.besafx.android.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskCloseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer code;

    //True  --- Close Request
    //False --- Extension Request
    private Boolean type;

    private Boolean approved;

    private Date approvedDate;

    private Task task;

    private Person person;

    private Date date;

    private String note;


}
