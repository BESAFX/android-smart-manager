package com.besafx.android.entity;

import com.besafx.android.entity.enums.PaymentMethod;
import com.besafx.android.entity.enums.ReceiptType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Receipt implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long code;

    private Date date;

    private Date lastUpdate;

    private PaymentMethod paymentMethod;

    private Long paymentMethodCode;

    private String amountString;

    private Double amountNumber;

    private String sender;

    private String receiver;

    private ReceiptType receiptType;

    private String note;

    private Person lastPerson;
}
