package ua.registration_form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.registration_form.entity.RoleType;
import ua.registration_form.entity.User;
import ua.registration_form.service.UserService;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/main")
    public String main(@RequestParam(required = false) String findName, Model model) {
        model.addAttribute("users", userService.findByName(findName));
        model.addAttribute("filter", findName);
        return "main";
    }

    @PostMapping("addUser")// Map ONLY POST Requests
    public String addNewUser(@RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String email,
                             @RequestParam String password,
                             Model model) {
        boolean userFromDb = userService.addUser(firstName, lastName, email, password);
        if (!userFromDb) {
            model.addAttribute("message", "User already exist ");
            return "main";
        }
        model.addAttribute("users", userService.allUsers());

        return "redirect:/user/main";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("usr", user);
        model.addAttribute("roles", RoleType.values());
        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @PostMapping
    public String userSaveEdit(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam(required = false) boolean active,
            @RequestParam(required = false) String roleType,
            @RequestParam("userId") User user) {
        userService.userEdit(firstName, lastName, email, password, active, roleType, user);
        return roleType == null ? "redirect:/" : "redirect:/user/main";
    }
}
