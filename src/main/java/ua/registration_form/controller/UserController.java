package ua.registration_form.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.registration_form.entity.RoleType;
import ua.registration_form.entity.User;
import ua.registration_form.repository.UserRepository;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false) String findName, Model model) {
        List<User> users ;

        if (findName != null && !findName.isEmpty())
            users = userRepository.findByFirstName(findName);
        else {
            users = userRepository.findAll();
        }

        model.addAttribute("users", users);
        return "main";
    }

    @PostMapping("addUser")// Map ONLY POST Requests
    public String addNewUser(@RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String email,
                             @RequestParam String password,
                             Model model) {
        User newUser = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .active(true)
                .roleType(RoleType.USER)
                .build();
        userRepository.save(newUser);

        Iterable<User> allUsers = userRepository.findAll();
        model.addAttribute("users", allUsers);

        return "main";
    }

}
