package com.besafx.android.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer code;

    private Double amount;

    private String reason;

    private String managerComment;

    private String financialManagerComment;

    private Date dateCreate;

    private Date managerDateApproved;

    private Date financialManagerDateApproved;

    private Boolean managerApproved;

    private Boolean financialManagerApproved;

    private Boolean transferred;

    private Person fromPerson;

    private List<NoticeAttach> noticeAttaches = new ArrayList<>();
}
