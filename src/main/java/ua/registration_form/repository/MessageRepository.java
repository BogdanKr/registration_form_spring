package ua.registration_form.repository;

import org.springframework.data.repository.CrudRepository;
import ua.registration_form.entity.Message;


public interface MessageRepository extends CrudRepository<Message, Long> {

}
