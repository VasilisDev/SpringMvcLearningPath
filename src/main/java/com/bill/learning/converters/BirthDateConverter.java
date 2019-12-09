package com.bill.learning.converters;


import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class BirthDateConverter extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (!text.trim().isEmpty())
            super.setValue(LocalDate.parse(text.trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}