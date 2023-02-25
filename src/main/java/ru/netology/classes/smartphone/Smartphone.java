package ru.netology.classes.smartphone;

import lombok.*;
import ru.netology.classes.Product;

@Getter
@Setter


public class Smartphone extends Product {
    protected String manufacturer;

    public Smartphone() {
    }

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        }
        if (search.matches(getManufacturer())) {
            return true;
        } else {
            return false;
        }
    }
}
