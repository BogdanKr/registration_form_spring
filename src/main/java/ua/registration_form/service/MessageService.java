package ua.registration_form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ua.registration_form.dto.MessageDto;
import ua.registration_form.entity.Message;
import ua.registration_form.entity.User;
import ua.registration_form.repository.MessageRepository;

import java.util.List;

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

    public List<MessageDto> messageListForUser(User currentUser, User author) {
        return messageRepository.findByUser(author, currentUser);
    }

    public void messageLike(User currentUser,
                            Message message){
        List<User> likes = message.getLikes();
        if (likes.contains(currentUser)) likes.remove(currentUser);
        else likes.add(currentUser);
        messageRepository.save(message);
    }
}
