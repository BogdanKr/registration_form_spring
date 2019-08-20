package ua.registration_form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.registration_form.dto.NoteDTO;
import ua.registration_form.entity.RoleType;
import ua.registration_form.entity.User;
import ua.registration_form.repository.UserRepository;

@Service
public class RegFormService {
    @Autowired
    UserRepository userRepository;

    public String inputNote(NoteDTO note) {
        return "";
    }

    public boolean regUser(User user){
        User userFromDb = userRepository.findByEmail(user.getEmail());
        if (userFromDb != null) {
            return false;
        }
        user.setEmail(user.getUsername());
        user.setActive(true);
        user.setRoleType(RoleType.USER);
        user.setFirstName("");
        user.setLastName("");
        userRepository.save(user);
        return true;
    }
}
