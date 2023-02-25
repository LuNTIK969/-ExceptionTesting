package ru.netology.classes.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookTest {

    Book book = new Book(2, "Harry Potter Boxed Set. Complete Collection", 7_612, "Joanne Rowling");

    @Test
    public void shouldFindNameTrue() {

        boolean actual = book.matches("Harry Potter Boxed Set. Complete Collection");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldFindNameFalse() {

        boolean actual = book.matches("H. P. Boxed Set. Complete Collection");

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldFindAuthorTrue() {

        boolean actual = book.matches("Joanne Rowling");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldFindAuthorFalse() {

        boolean actual = book.matches("J. Rowling");

        Assertions.assertFalse(actual);
    }

}