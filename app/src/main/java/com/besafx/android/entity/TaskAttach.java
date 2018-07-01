package com.besafx.android.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAttach implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Attach attach;

    private Task task;
}
