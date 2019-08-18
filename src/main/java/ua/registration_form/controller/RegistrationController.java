package ua.registration_form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.registration_form.entity.RoleType;
import ua.registration_form.entity.User;
import ua.registration_form.repository.UserRepository;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByEmail(user.getEmail());
        if (userFromDb != null) {
            model.put("message", "User already exist ");
            return "registration";
        }
        user.setEmail(user.getUsername());
        user.setActive(true);
        user.setRoleType(RoleType.USER);
        user.setFirstName("");
        user.setLastName("");
        userRepository.save(user);
        return "redirect:/login";
    }
}