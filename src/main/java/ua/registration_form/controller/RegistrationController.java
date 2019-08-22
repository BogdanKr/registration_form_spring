package ua.registration_form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.registration_form.entity.RoleType;
import ua.registration_form.entity.User;
import ua.registration_form.service.RegFormService;

import java.util.Map;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    RegFormService regFormService;

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String addUser(User user, Map<String, Object> model) {
        boolean userFromDb = regFormService.regUser(user);
        if (!userFromDb) {
            model.put("message", "User already exist ");
            return "registration";
        }
        model.put("message", "User successful registered");
        return "login";
    }

    @GetMapping("edit/{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("usr", user);
        model.addAttribute("roles", RoleType.values());
        return "userEdit";
    }
}
