package ua.registration_form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.registration_form.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
