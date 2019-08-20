package ua.registration_form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.registration_form.entity.Message;


public interface MessageRepository extends JpaRepository<Message, Long> {

}
