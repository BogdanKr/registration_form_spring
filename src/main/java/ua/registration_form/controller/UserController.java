package ua.registration_form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.registration_form.repository.UserRepository;

//@Controller
public class UserController {
//    @Autowired
//    private UserRepository userRepository;



//    @PostMapping(path="/add") // Map ONLY POST Requests
//    public String addNewUser (@RequestParam String firstName,
//                              @RequestParam String lastName,
//                              @RequestParam String email,
//                              @RequestParam String password) {
//        User n = User.builder()
//                .firstName(firstName)
//                .lastName(lastName)
//                .email(email)
//                .password(password)
//                .build();
//        userRepository.save(n);
//        return "Saved";
//    }
//
//    @GetMapping     //(path="/all")
//    public  String getAllUsers() {
//        Iterable<User> users = userRepository.findAll();
//        // This returns a JSON or XML with the users
//        return "users";
//    }
//
}
