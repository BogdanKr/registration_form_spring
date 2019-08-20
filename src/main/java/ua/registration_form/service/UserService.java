package ua.registration_form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.registration_form.entity.Exceptions.WrongInputException;
import ua.registration_form.entity.RoleType;
import ua.registration_form.entity.User;
import ua.registration_form.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) throw new UsernameNotFoundException("Wrong input!!");
        return user;
    }

    public boolean addUser(String firstName,
                           String lastName,
                           String email,
                           String password) {
        User userFromDb = userRepository.findByEmail(email);
        if (userFromDb != null) {
            return false;
        }

        User newUser = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(passwordEncoder.encode(password))
                .active(true)
                .roleType(RoleType.USER)
                .build();
        userRepository.save(newUser);
        return true;
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
        user.setPassword(passwordEncoder.encode(password));
        if (roleType == null) roleType = "USER";
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
