package ua.registration_form.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import ua.registration_form.dto.UserDTO;

@Data
@Service
public class LoginFormService {
    public String inputUser(UserDTO user){
        return "";
    }
}
