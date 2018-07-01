package com.besafx.android.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskWarn implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer code;

    private TaskWarnType type;

    private String content;

    private Date date;

    private Task task;

    private Person toPerson;

    public enum TaskWarnType {
        Auto, Manual
    }
}
