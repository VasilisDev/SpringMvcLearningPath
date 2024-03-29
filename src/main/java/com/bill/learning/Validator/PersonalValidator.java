package com.bill.learning.Validator;
import com.bill.learning.model.Biography;
import com.bill.learning.model.Personal;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component("personalValidator")
public class PersonalValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {

        return Personal.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Personal personForm = (Personal) obj;
        Biography bio = personForm.getBiography();
        //Education educ = personForm.getEducation();

        ValidationUtils.rejectIfEmpty(errors, "biography.firstName", "firstName.empty");
        ValidationUtils.rejectIfEmpty(errors, "biography.lastName", "lastName.empty");
        ValidationUtils.rejectIfEmpty(errors, "biography.age", "age.empty");
        ValidationUtils.rejectIfEmpty(errors, "biography.birthDate", "birthDate.empty");
        ValidationUtils.rejectIfEmpty(errors, "biography.location", "location.empty");
        ValidationUtils.rejectIfEmpty(errors, "biography.country", "country.empty");


        ValidationUtils.rejectIfEmpty(errors, "education.educationLevel", "educationLevel.empty");
        ValidationUtils.rejectIfEmpty(errors, "education.degree", "degree.empty");
        ValidationUtils.rejectIfEmpty(errors, "education.institution", "institution.empty");
        ValidationUtils.rejectIfEmpty(errors, "education.year", "year.empty");


        try{
            if(bio.getHobbies().size() < 2){
                errors.rejectValue("biography.hobbies", "hobbies.two");
            }
        }catch(Exception e){
            errors.rejectValue("biography.hobbies", "hobbies.two");
        }

        try{
            if(bio.getReadings().size() < 2){
                errors.rejectValue("biography.readings", "readings.two");
            }
        }catch(Exception e){
            errors.rejectValue("biography.readings", "readings.two");
        }
    }
}