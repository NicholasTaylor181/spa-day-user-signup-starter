package org.launchcode.spaday.controllers;


import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayIndex() {
        return "user/index";
    }

    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";

    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here
        if (user.getPassword().equals(verify)) {
            model.addAttribute(user);
            return "user/index";

        } else {
            model.addAttribute("error", true);
            model.addAttribute("previousUsername", user.getUsername());
            model.addAttribute("previousEmail", user.getEmail());
            return "user/add";
        }

    }

}
