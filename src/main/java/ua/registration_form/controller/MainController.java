package ua.registration_form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.registration_form.entity.Message;
import ua.registration_form.entity.User;
import ua.registration_form.repository.MessageRepository;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public String greeting(Model model) {
        List<Message> messageList = messageRepository.findAll();
        model.addAttribute("messages", messageList);
        return "greeting";
    }

    @PostMapping
    public String addMessage(@AuthenticationPrincipal User user,
                             @RequestParam String text,
                             @RequestParam String tag,
                             Model model) {
        Message message = new Message(text, tag, user);
        if (text.isEmpty() && tag.isEmpty()) return greeting(model);
        messageRepository.save(message);
        List<Message> messageList = messageRepository.findAll();
        model.addAttribute("messages", messageList);
        return "greeting";
    }

    @GetMapping("/form")
    public String regForm() {
        return "reg_form";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/mylogin")
    public String myLogin() {
        return "mylogin";
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handlerRuntimeException(RuntimeException ex) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
