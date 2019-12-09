package com.bill.learning.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Biography {

    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthDate;
    private String location;
    private String country;
    private List<String> hobbies;
    private List<String> readings;


}
