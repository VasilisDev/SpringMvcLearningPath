package com.bill.learning.mail;


public interface EmailService {
    void sendSimpleMessage(String to,String subject, String text);
}