package ua.registration_form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.registration_form.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstName(String firstName);

    User findByEmail(String email);
}
