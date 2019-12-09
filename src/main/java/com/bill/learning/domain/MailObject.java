package com.bill.learning.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class MailObject {
    @Email
    @NotNull
    @Size(min = 1, message = "Please, set an email address to send the message to it!")
    private String to;
    @NotNull
    @NotEmpty(message = "Subject must be filled!")
    @Size(min = 10, message = "Please,provide more than 10 letters in this field!")
    private String subject;
    @NotEmpty(message = "Text must be filled!")
    @NotNull
    @Size(min = 50, message = "Please, provide less than 50 letter in this field!")
    private String text;

}