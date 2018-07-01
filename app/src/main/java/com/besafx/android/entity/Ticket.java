package com.besafx.android.entity;

import com.besafx.android.entity.enums.TicketType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer code;

    private String reason;

    private TicketType ticketType;

    private Date fromDate;

    private Date toDate;

    private String ipAddress;

    private String managerComment;

    private Date dateCreate;

    private Date dateApproved;

    private Boolean approved;

    private Person fromPerson;

    private Person toPerson;
}
