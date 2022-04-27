package com.example.mailsenderdemoapp.model;

import lombok.Data;

import java.util.List;

@Data
public class Mail {
    private String mailFrom;
    private String mailTo;
    private String mailCc;
    private String mailBcc;
    private String mailSubject;
    private String mailContent;
    private String contenType;
    private List<Object> attachments;
}
