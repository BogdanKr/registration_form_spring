package ua.registration_form.dto;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import ua.registration_form.entity.Message;
import ua.registration_form.entity.User;

@Getter
@ToString
public class MessageDto {
    private Long id;
    private String text;
    private String tag;
    private User auth;
    private Long likes;
    private boolean meLiked;

    public MessageDto(Message message, Long likes, boolean meLiked) {
        this.id = message.getId();
        this.text = message.getText();
        this.tag = message.getTag();
        this.auth = message.getAuth();
        this.likes = likes;
        this.meLiked = meLiked;
    }
    public String getAuthorName(){
        return auth.getFirstName();
    }
}
