package ru.netology.classes.smartphone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SmartphoneTest {

    Smartphone smartphone = new Smartphone(5, "OnePlus 7Pro", 44_000, "BBK Electronics");

    @Test
    public void shouldFindNameTrue() {

        boolean actual = smartphone.matches("OnePlus 7Pro");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldFindNameFalse() {

        boolean actual = smartphone.matches("O.P. 7Pro");

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldFindManufacturedTrue() {

        boolean actual = smartphone.matches("BBK Electronics");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldFindManufacturedFalse() {

        boolean actual = smartphone.matches("BBQ Electronics");

        Assertions.assertFalse(actual);
    }

}