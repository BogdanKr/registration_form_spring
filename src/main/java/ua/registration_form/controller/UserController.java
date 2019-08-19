package ua.registration_form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.registration_form.entity.RoleType;
import ua.registration_form.entity.User;
import ua.registration_form.repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepository userRepository;

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

        return "redirect:/user/main";
    }

    @GetMapping("{user}")
    public String serEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", RoleType.values());
        return "userEdit";
    }
    @PostMapping
    public String userSaveEdit(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String roleType,
            @RequestParam("userId") User user){

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        switch (roleType){
            case "USER":
                user.setRoleType(RoleType.USER);
                break;
            case "ADMIN":
                user.setRoleType(RoleType.ADMIN);
                break;
        }

        userRepository.save(user);

        return "redirect:/user/main";
    }


}
