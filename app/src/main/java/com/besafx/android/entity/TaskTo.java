package com.besafx.android.entity;

import com.besafx.android.entity.enums.PersonDegree;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskTo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer progress;

    private Boolean closed;

    private PersonDegree degree;

    private Date closeDate;

    private Task task;

    private Person person;


}
