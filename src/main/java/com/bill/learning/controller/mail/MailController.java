package com.bill.learning.controller.mail;


import com.bill.learning.domain.MailObject;
import com.bill.learning.mail.EmailServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/contact")
public class MailController {

    @NotNull
    private final EmailServiceImpl emailService;


    public MailController(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public String initForm(Model model) {
        MailObject emailForm = new MailObject();
        model.addAttribute("emailForm", emailForm);
        return "contact-us";
    }

    @PostMapping
    public String submitForm(Model model,
                             @Valid @ModelAttribute("emailForm") MailObject emailForm,
                             Errors errors) {
        model.addAttribute("emailForm", emailForm);
        String returnVal = "contact-us";
        if (errors.hasErrors()) {
            returnVal = "contact-us";
        } else {
            model.addAttribute("emailForm", emailForm);
            emailService.sendSimpleMessage(emailForm.getTo(),
                    emailForm.getSubject(), emailForm.getText());
        }
        return returnVal;
    }
}
