package ua.registration_form.entity;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public enum DBNote implements Note {
    NOTE_1("Bogdan", "Krasun", "krabog@gmail.com", "123", RoleType.ADMIN),
    NOTE_2("Max", "Gorbachev", "max@ua.ua", "max555", RoleType.USER),
    NOTE_3("Vova", "Putin", "vovan@mail.ru", "vovan_123", RoleType.USER),
    NOTE_4("Petya", "Poroshenko", "pet@gmail.com", "poroh2019", RoleType.USER),
    ;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private RoleType roleType;

    DBNote(String firstName, String lastName, String email, String password, RoleType roleType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roleType = roleType;
    }


}
