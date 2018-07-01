package com.besafx.android.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attach implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String mimeType;

    private String description;

    private String link;

    private Long size;

    private Date date;

    private Person person;
}
