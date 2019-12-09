package com.bill.learning.controller.personal;


import com.bill.learning.converters.BirthDateConverter;
import com.bill.learning.service.PersonalService;
import com.bill.learning.converters.AgeConverter;
import com.bill.learning.converters.YearConverter;
import com.bill.learning.model.Biography;
import com.bill.learning.model.Education;
import com.bill.learning.model.Personal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/personal/update")
public class PersonalUpdateController {

    private final Validator personalValidator;
    private final PersonalService personalService;

    public PersonalUpdateController(Validator personalValidator, PersonalService personalService) {
        this.personalValidator = personalValidator;
        this.personalService = personalService;
    }

    @InitBinder("personForm")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(personalValidator);
        binder.registerCustomEditor(Integer.class, "biography.age",
                new AgeConverter());
        binder.registerCustomEditor(Integer.class, "education.year",
                new YearConverter());
        binder.registerCustomEditor(LocalDate.class, "biography.birthDate",
                new BirthDateConverter());
    }

    @GetMapping
    public String initForm(Model model) {
        Biography bio = new Biography();
        Education educ = new Education();
        Personal personForm = new Personal();
        personForm.setBiography(bio);
        personForm.setEducation(educ);
        model.addAttribute("hobbiesList", personalService.findHobbies());
        model.addAttribute("readingsList", personalService.findReading());
        model.addAttribute("educLevelList", personalService.findEducationLevel());
        model.addAttribute("personForm", personForm);
        return "per-update";
    }


    @PostMapping
    public String submitForm(Model model,
                             @ModelAttribute("personForm") @Validated Personal personForm,
                             Errors errors) {
        model.addAttribute("personals", personForm);
        String returnVal = "personal";
        if (errors.hasErrors()) {
            model.addAttribute("hobbiesList", personalService.findHobbies());
            model.addAttribute("readingsList", personalService.findReading());
            model.addAttribute("educLevelList", personalService.findEducationLevel());
            returnVal = "per-update";
        }
        return returnVal;
    }
}
