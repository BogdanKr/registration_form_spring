package ua.registration_form.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class RegFormController {
//    @Autowired
//    private final RegFormService regFormService;
//
//    @Autowired
//    public RegFormController(RegFormService regFormService) {
//        this.regFormService = regFormService;
//    }
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(value = "/reg_form", method = RequestMethod.POST)
//    public void registrationFormController(NoteDTO note) {
//        log.info("{}", note);
//    }
//
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity handlerRuntimeException(RuntimeException ex) {
//        return new ResponseEntity(HttpStatus.BAD_REQUEST);
//    }
}
