package ua.registration_form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ua.registration_form.entity.Message;
import ua.registration_form.entity.User;
import ua.registration_form.repository.MessageRepository;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public void updateMessage(User currentUser, Message message, String text, String tag) {
        if (message == null) {
            Message newMessage = new Message(text, tag, currentUser);
            messageRepository.save(newMessage);
        } else {
//            if (message.getAuth().equals(currentUser)) {
            if (!StringUtils.isEmpty(text)) message.setText(text);
            if (!StringUtils.isEmpty(tag)) message.setTag(tag);
//            }
            messageRepository.save(message);
        }
    }
}
