package com.bill.learning.service.impl;

import com.bill.learning.service.PersonalService;
import com.bill.learning.model.Biography;
import com.bill.learning.model.Education;
import com.bill.learning.model.Personal;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class PersonalServiceImpl implements PersonalService {

    @Override
    public Personal findAll() {
        Education education = new Education();
        education.setDegree("Bachelor");
        education.setEducationLevel("University");
        education.setInstitution("Tei of Athens");
        education.setSpecialization("Software engineer");
        education.setYear(2015);

        Biography biography = new Biography();
        biography.setFirstName("Bill");
        biography.setLastName("Tsakiris");
        biography.setAge(25);
        biography.setBirthDate(LocalDate.of(1994,5,3));
        biography.setCountry("Greece");
        biography.setLocation("Piraeus");
        biography.setHobbies(Arrays.asList("Football","Basketball","Gym","Running"));
        biography.setReadings(Arrays.asList("Magazine","Newspaper","Diaries"));

        Personal personal = new Personal();
        personal.setBiography(biography);
        personal.setEducation(education);

        return personal;
    }

    @Override
    public List<String> findHobbies() {
     return  Arrays.asList("Not Applicable","Singing",
             "Football","Basketball","Traveling","Painting","Gym","Running","Swimming","Writing");
    }

    @Override
    public List<String> findReading() {
      return  Arrays.asList("Not Applicable","Novel","Magazine","Newspaper","Diaries");
    }

    @Override
    public List<String> findEducationLevel() {
        return Arrays.asList("Not Applicable","Doctoral","Masters","College","Vocational","High School");
    }
}
