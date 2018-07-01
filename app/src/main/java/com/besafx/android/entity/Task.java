package com.besafx.android.entity;

import com.besafx.android.entity.enums.CloseType;
import com.besafx.android.entity.enums.CommentType;
import com.besafx.android.entity.enums.Importance;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer code;

    private String title;

    private Integer warn;

    private Double deduction;

    private Double deductionOnAutoClose;

    private CloseType closeType;

    private Importance importance;

    private CommentType commentType;

    private Integer commentTypeCount;

    private String content;

    private Date startDate;

    private Date endDate;

    private Person person;

    private List<TaskTo> taskTos = new ArrayList<>();

    private List<TaskCloseRequest> taskCloseRequests = new ArrayList<>();

    private List<TaskOperation> taskOperations = new ArrayList<>();

    private List<TaskWarn> taskWarns = new ArrayList<>();

    private List<TaskDeduction> taskDeductions = new ArrayList<>();

    private List<TaskAttach> taskAttaches = new ArrayList<>();

    private String toNames;

}
