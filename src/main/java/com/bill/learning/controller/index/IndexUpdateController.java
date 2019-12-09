package com.bill.learning.controller.index;


import com.bill.learning.model.Home;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/index-update")
public class IndexUpdateController {


    private final Validator indexValidator;

    public IndexUpdateController(Validator indexValidator) {
        this.indexValidator = indexValidator;
    }

    @InitBinder("homeForm")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(indexValidator);
    }

    @GetMapping
    public String initForm(Model model){
        Home homeForm = new Home();
        model.addAttribute("homeForm", homeForm);
        return "i-update";
    }

    @PostMapping
    public String submitForm(Model model, @ModelAttribute("homeForm") @Validated Home homeForm, Errors errors, HttpSession session){
        model.addAttribute("homeForm", homeForm);
        String returnVal = "index";
        if(errors.hasErrors())
            returnVal = "i-update";
        else {
                session.setAttribute("homeSession", homeForm);
            }
        return returnVal;
    }
}