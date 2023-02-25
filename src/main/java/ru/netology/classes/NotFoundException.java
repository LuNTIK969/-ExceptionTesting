package ru.netology.classes;

public class NotFoundException extends RuntimeException {

    public NotFoundException (String msg) {
        super(msg);
    }
}
