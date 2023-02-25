package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.classes.AlreadyExistsException;
import ru.netology.classes.NotFoundException;
import ru.netology.classes.book.Book;
import ru.netology.classes.Product;
import ru.netology.classes.smartphone.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    Product bookOne = new Book(1, "Best choice", 928, "Торстен Гавенер");
    Product bookTwo = new Book(2, "Harry Potter Boxed Set. Complete Collection", 7_612, "Joanne Rowling");
    Product smartphoneOne = new Smartphone(5, "OnePlus 7Pro", 44_000, "BBK Electronics");
    Product smartphoneTwo = new Smartphone(6, "Best choice", 48_000, "BBK Electronics");


    @Test
    public void shouldSetNewId() {
        Smartphone smartphone = new Smartphone();

        smartphone.setId(9);

        int expected = 9;
        int actual = smartphone.getId();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddThenRemoveById() {
        Repository repo = new Repository();

        repo.addProduct(bookOne);
        repo.addProduct(bookTwo);
        repo.addProduct(smartphoneOne);
        repo.addProduct(smartphoneTwo);
        repo.removeById(smartphoneOne.getId());

        Product[] expected = {bookOne, bookTwo, smartphoneTwo};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSetPrice() {
        Product repo = new Product();

        repo.setPrice(3_283);

        int expected = 3_283;
        int actual = repo.getPrice();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetName() {
        Book book = new Book();

        book.setName("Темпоральный ускоритель");

        String expected = "Темпоральный ускоритель";
        String actual = book.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetAuthor() {
        Book book = new Book();

        book.setAuthor("Гоголь");

        String expected = "Гоголь";
        String actual = book.getAuthor();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetManufacture() {
        Smartphone smartphone = new Smartphone();

        smartphone.setManufacturer("Sony Ericsson");

        String expected = "Sony Ericsson";
        String actual = smartphone.getManufacturer();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveById() {
        Repository repo = new Repository();

        repo.addProduct(bookOne);
        repo.addProduct(bookTwo);
        repo.addProduct(smartphoneOne);
        repo.addProduct(smartphoneTwo);

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        });
    }

    @Test
    public void shouldNotAddProduct() {
        Repository repo = new Repository();

        repo.addProduct(bookOne);
        repo.addProduct(bookTwo);
        repo.addProduct(smartphoneOne);
        repo.addProduct(smartphoneTwo);

        assertThrows(AlreadyExistsException.class, () -> {
            repo.addProduct(bookOne);
        });
    }
}