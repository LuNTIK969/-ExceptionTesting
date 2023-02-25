package ru.netology.classes.book;

import lombok.*;
import ru.netology.classes.Product;

@Getter
@Setter


public class Book extends Product {
    protected String author;

    public Book() {
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        }
        if (search.matches(getAuthor())) {
            return true;
        } else {
            return false;
        }
    }

}
