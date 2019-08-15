package ua.registration_form.entity.Exceptions;

public class WrongInputException extends Exception {
    public WrongInputException(String message) {
        super(message);
    }
}
