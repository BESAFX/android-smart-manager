package com.besafx.android.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskOperationAttach implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String link;

    private Long size;

    private TaskOperation taskOperation;


}
