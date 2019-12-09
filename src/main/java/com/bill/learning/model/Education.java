package com.bill.learning.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Education {

    private String educationLevel;
    private String institution;
    private String degree;
    private String specialization;
    private Integer year;


}