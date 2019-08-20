package ua.registration_form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.registration_form.entity.RoleType;
import ua.registration_form.entity.User;
import ua.registration_form.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }

    public User addUser(String firstName,
                        String lastName,
                        String email,
                        String password) {
        User userFromDb = userRepository.findByEmail(email);
        if (userFromDb != null) {
            return userFromDb;
        }

        User newUser = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .active(true)
                .roleType(RoleType.USER)
                .build();
        userRepository.save(newUser);
        return null;
    }

    public void userEdit(String firstName,
                         String lastName,
                         String email,
                         String password,
                         String roleType,
                         User user) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        switch (roleType) {
            case "USER":
                user.setRoleType(RoleType.USER);
                break;
            case "ADMIN":
                user.setRoleType(RoleType.ADMIN);
                break;
        }
        userRepository.save(user);
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public List<User> findByName(String findName) {
        List<User> users;
        if (findName != null && !findName.isEmpty())
            users = userRepository.findByFirstName(findName);
        else {
            users = userRepository.findAll();
        }
        return users;
    }
}
