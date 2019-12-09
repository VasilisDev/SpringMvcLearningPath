package com.bill.learning.controller.personal;


import com.bill.learning.service.PersonalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/personal")
public class PersonalController {

    private final
    PersonalService personalService;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

   @GetMapping("/all")
    public String displayPersonalInformation(Model model) {
      model.addAttribute("personals",personalService.findAll());
      return "personal";
   }
   @GetMapping("/redirect")
    public String personalRedirect(){
      return "redirect:personal-redirect";
   }
}
