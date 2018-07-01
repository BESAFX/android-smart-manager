package com.besafx.android.entity;

import com.besafx.android.entity.enums.OperationType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskOperation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer code;

    private String content;

    private Date date;

    private OperationType type;

    private Task task;

    private Person sender;

    private List<TaskOperationAttach> taskOperationAttaches = new ArrayList<>();

}
