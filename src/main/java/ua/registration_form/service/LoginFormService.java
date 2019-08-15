package ua.registration_form.service;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ua.registration_form.dto.UserDTO;
import ua.registration_form.entity.DBNote;
import ua.registration_form.entity.Exceptions.WrongInputException;

import java.util.Arrays;

@Data
@Service
public class LoginFormService {

    public String inputUser(UserDTO user) {
        return "";
    }

    public void checkInput(UserDTO user) throws WrongInputException {
        boolean checkEmail = Arrays.stream(DBNote.values())
                .map(DBNote::getEmail)
                .anyMatch(email -> email.equals(user.getEmail()));
        if (!checkEmail) throw new WrongInputException("WRONG EMAIL!!!");

        boolean checkPass = Arrays.stream(DBNote.values())
                .filter(dbNote -> dbNote.getEmail().equals(user.getEmail()))
                .map(DBNote::getPassword)
                .anyMatch(pass -> pass.equals(user.getPassword()));
        if (!checkPass) throw new WrongInputException("WRONG PASSWORD!!!!");
    }
}
