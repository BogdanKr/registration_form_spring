package ua.registration_form.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.registration_form.dto.UserDTO;
import ua.registration_form.entity.Exceptions.WrongInputException;
import ua.registration_form.service.LoginFormService;

@Slf4j
@Controller
@RequestMapping()
public class LoginFormController {

    private final LoginFormService loginFormService;

    @Autowired
    public LoginFormController(LoginFormService loginFormService) {
        this.loginFormService = loginFormService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public void loginFormController(UserDTO user) throws WrongInputException {
        //here come data from login page
        log.info("{}", user);
        loginFormService.checkInput(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String move(){
        return "login";
    }

    @ExceptionHandler(WrongInputException.class)
    public ResponseEntity handlerRuntimeException (WrongInputException ex){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
