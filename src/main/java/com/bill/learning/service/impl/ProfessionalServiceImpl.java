package com.bill.learning.service.impl;

import com.bill.learning.service.ProfessionalService;
import com.bill.learning.model.Professional;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProfessionalServiceImpl implements ProfessionalService {
    @Override
    public Professional findAll() {
        Professional professional = new Professional();
        professional.setYears(3);
        professional.setSkillSets(Arrays.asList("c/c++","java","javascript","html","css"));
        professional.setPreviousJobs(Collections.singletonList("No professional experience"));
        professional.setPosition("Student");
        professional.setLocation("Athens");
        professional.setCompany("No company");
        return professional;
    }

    @Override
    public List<String> findSkills() {
        return  Arrays.asList("c/c++","java","javascript","html","css");
    }

    @Override
    public List<String> findPreviousJobs() {
        return Collections.singletonList("No professional experience");
    }

    @Override
    public List<String> findLocations() {
        return Arrays.asList("America", "Europe");
    }
}
