package ru.netology;

import ru.netology.classes.Product;
import ru.netology.repository.Repository;

public class ProductManager {
    protected Repository repo;

    protected ProductManager(Repository repo) {
        this.repo = repo;
    }

    public Product[] searchBy(String search) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (product.matches(search)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

//    public boolean matches(Product product, String search) {
//        return product.getName().contains(search);
//    }

    public void save(Product product) {
        repo.addProduct(product);
    }
}
