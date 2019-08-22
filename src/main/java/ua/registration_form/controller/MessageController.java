package ua.registration_form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ua.registration_form.dto.MessageDto;
import ua.registration_form.entity.Message;
import ua.registration_form.entity.User;
import ua.registration_form.service.MessageService;

import java.util.List;

@Controller
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/{user}")
    public String myMessages(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) Message message) {
        List<MessageDto> messages = messageService.messageListForUser(currentUser, user);
        model.addAttribute("messages", messages);
        model.addAttribute("message", message);
        model.addAttribute("isCurrentUser", currentUser.equals(user));
        return "userMessages";
    }

    @PostMapping("/{usr}")
    public String updateMessage(@AuthenticationPrincipal User currentUser,
                                @PathVariable Long usr,
                                @RequestParam("id") Message message,
                                @RequestParam("text") String text,
                                @RequestParam("tag") String tag) {
        messageService.updateMessage(currentUser, message, text, tag);
        return "redirect:/messages/" + usr;
    }


    @GetMapping("/{message}/like")
    public String like(@AuthenticationPrincipal User currentUser,
                       @PathVariable Message message,
                       RedirectAttributes redirectAttributes,
                       @RequestHeader(required = false) String referer) {
        messageService.messageLike(currentUser, message);
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(referer).build();
        uriComponents.getQueryParams()
                .entrySet()
                .forEach(pair -> redirectAttributes.addAttribute(pair.getKey(), pair.getValue()));
        return "redirect:" + uriComponents.getPath();
    }
}

