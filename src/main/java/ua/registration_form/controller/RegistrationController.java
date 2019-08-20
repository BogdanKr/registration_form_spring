package ua.registration_form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.registration_form.entity.RoleType;
import ua.registration_form.entity.User;
import ua.registration_form.repository.UserRepository;
import ua.registration_form.service.UserService;

import java.util.Map;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
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
        return "redirect:/greeting";
    }
    @GetMapping("edit/{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("usr", user);
        model.addAttribute("roles", RoleType.values());
        return "userEdit";
    }

//    @PostMapping
//    public String userSaveEdit(
//            @RequestParam String firstName,
//            @RequestParam String lastName,
//            @RequestParam String email,
//            @RequestParam String password,
//            @RequestParam(required = false) String roleType,
//            @RequestParam("userId") User user) {
//        userService.userEdit(firstName, lastName, email, password, roleType, user);
//        return roleType == null ? "greeting" : "redirect:/user/main";
//    }
}
