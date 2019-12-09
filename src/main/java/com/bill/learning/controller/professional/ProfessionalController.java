package com.bill.learning.controller.professional;


import com.bill.learning.service.ProfessionalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/professional")
public class ProfessionalController {



    private final ProfessionalService professionalService;

    public ProfessionalController(ProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

    @GetMapping
    public String getProfessional(Model model){
        model.addAttribute("professional", professionalService.findAll());
        return "professional";
    }

    @GetMapping(value="/redirect")
    public String updatePersonal(){
        return  "redirect:professional-update";
    }

}
