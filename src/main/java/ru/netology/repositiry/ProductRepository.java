package ru.netology.repositiry;

import ru.netology.domein.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastProduct = tmp.length - 1;
        tmp[lastProduct] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        int length = products.length;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new RuntimeException("Element with id: " + id + " not found. ");
        }
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
            products = tmp;
        }
    }
}
