package ua.registration_form.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")  //name of column in BD
    private User auth;

    public Message(String text, String tag, User user) {
        this.text = text;
        this.tag = tag;
        this.auth = user;
    }
}
