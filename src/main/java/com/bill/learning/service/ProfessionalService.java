package com.bill.learning.service;

import com.bill.learning.model.Professional;

import java.util.Collections;
import java.util.List;

public interface ProfessionalService {
    default Professional findAll() {
        return new Professional();
    }

    default List<String> findSkills() {
        return Collections.singletonList("No Skills found!");
    }

    default List<String> findPreviousJobs() {
        return Collections.singletonList("No previous jobs found!");
    }

    default List<String> findLocations() {
        return Collections.singletonList("No locations jobs found!");
    }
}
