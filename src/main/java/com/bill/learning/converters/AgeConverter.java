package com.bill.learning.converters;


import java.beans.PropertyEditorSupport;


public class AgeConverter extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (!text.trim().isEmpty())
            super.setValue(Integer.parseInt(text.trim()));
    }
}