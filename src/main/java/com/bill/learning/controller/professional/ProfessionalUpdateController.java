package com.bill.learning.controller.professional;

import com.bill.learning.converters.YearConverter;
import com.bill.learning.model.Professional;
import com.bill.learning.service.ProfessionalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/professional/update")
@Controller
public class ProfessionalUpdateController {



    private final Validator professionalValidator;
    private final ProfessionalService professionalService;

    public ProfessionalUpdateController(Validator professionalValidator, ProfessionalService professionalService) {
        this.professionalValidator = professionalValidator;
        this.professionalService = professionalService;
    }

    @InitBinder("professionalForm")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(professionalValidator);
        binder.registerCustomEditor(Integer.class, "years", new YearConverter());
    }

    @GetMapping
    public String initForm(Model model) {
        Professional professionalForm = new Professional();
        model.addAttribute("professionalForm", professionalForm);
        model.addAttribute("skills", professionalService.findSkills());
        model.addAttribute("previousJobs", professionalService.findPreviousJobs());
        model.addAttribute("locations", professionalService.findLocations());
        return "prof-update";
    }

    @PostMapping
    public String submitForm(
            Model model,
            @ModelAttribute("professionalForm") @Validated Professional professionalForm,
            Errors errors) {

        model.addAttribute("professional", professionalForm);
        String returnVal = "professional";
        if (errors.hasErrors()) {
            model.addAttribute("skills", professionalService.findSkills());
            model.addAttribute("previousJobs", professionalService.findPreviousJobs());
            model.addAttribute("locations", professionalService.findLocations());
            returnVal = "prof-update";
        }
        return returnVal;
    }
}
