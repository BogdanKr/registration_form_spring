package ua.registration_form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.registration_form.entity.RoleType;
import ua.registration_form.entity.User;
import ua.registration_form.repository.UserRepository;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<User> allUsers = userRepository.findAll();
        model.put("users", allUsers);
        return "main";
    }

    @PostMapping("addUser")// Map ONLY POST Requests
    public String addNewUser(@RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String email,
                             @RequestParam String password,
                             Map<String, Object> model) {
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
        model.put("users", allUsers);

        return "main";
    }

    @PostMapping()
    public String findByFirstName(@RequestParam String findName, Map<String, Object> model) {
        List<User> byFirstName;
        if (findName != null && !findName.isEmpty())
            byFirstName = userRepository.findByFirstName(findName);
        else byFirstName = userRepository.findAll();

        model.put("users", byFirstName);
        return "main";
    }

}
