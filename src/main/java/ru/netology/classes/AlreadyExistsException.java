package ru.netology.classes;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(String msg) {
        super(msg);
    }
}
