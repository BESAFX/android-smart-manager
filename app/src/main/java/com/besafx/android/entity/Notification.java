package com.besafx.android.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Notification {

    private String code;

    private String title;

    private String message;

    private Date date;

    private String type;

    private String icon;

    private String sender;

    private String receiver;
}
