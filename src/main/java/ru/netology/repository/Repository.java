package ru.netology.repository;

import ru.netology.classes.AlreadyExistsException;
import ru.netology.classes.NotFoundException;
import ru.netology.classes.Product;


public class Repository {
    protected Product[] products = new Product[0];

    public Product[] addProduct(Product product) {
        if (findById(product.getId()) != null) {
            throw new AlreadyExistsException("Element with id: " + findById(product.getId()) + " already exists.");
        }
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
        return products.clone();
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Product[] tmp = new Product[products.length - 1];
        int temporaryCopy = 0;
        for (Product poster : products) {
            if (poster.getId() != id) {
                tmp[temporaryCopy] = poster;
                temporaryCopy++;
            }
        }
        products = tmp;
    }

    public Product[] findAll() {
        return products == null ? null : products.clone();
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}
