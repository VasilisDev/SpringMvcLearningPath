package com.bill.learning.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Professional {

    private String position;
    private String company;
    private Integer years;
    private String location;
    private List<String> skillSets;
    private List<String> previousJobs;


}