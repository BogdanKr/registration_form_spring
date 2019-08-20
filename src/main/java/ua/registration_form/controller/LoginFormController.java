package ua.registration_form.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.registration_form.dto.UserDTO;
import ua.registration_form.entity.Exceptions.WrongInputException;
import ua.registration_form.service.LoginFormService;

@Slf4j
@Controller
public class LoginFormController {

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/mylogin", method = RequestMethod.POST)
    public String loginFormController(UserDTO user) throws WrongInputException {
        //here come data from login page
        log.info("{}", user);
        //loginFormService.checkInput(user);
        return "main";
    }


}
