package ua.registration_form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/form")
    public String regForm() {
        return "reg_form";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/mylogin")
    public String myLogin() {
        return "mylogin";
    }

}
