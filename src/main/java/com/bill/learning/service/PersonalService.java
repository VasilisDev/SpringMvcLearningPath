package com.bill.learning.service;

import com.bill.learning.model.Personal;


import java.util.Collections;
import java.util.List;

public interface PersonalService {

    default Personal findAll() {
        return new Personal();
    }

    default List<String> findHobbies() {
        return Collections.singletonList("No Hobbies Found");
    }

    default List<String> findReading() {
        return Collections.singletonList("No Readings found!");
    }

    default List<String> findEducationLevel() {
        return Collections.singletonList("No Education levels found!");
    }
}
