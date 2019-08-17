package ua.registration_form.controller;

//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.registration_form.entity.User;

@Controller
public class PagesController {
    @RequestMapping("/api")
    public String mainPage() {
        return "index.html";
    }

    @RequestMapping("/form")
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

    @RequestMapping("/")
    public String helloPage(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User)authentication.getPrincipal();

//        model.addAttribute("firstName", user.getFirstName());
//        model.addAttribute("roles", user.getRoleType());
        return "hello";
    }
}
