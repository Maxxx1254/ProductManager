package ru.netology.manager;


import ru.netology.domein.Product;
import ru.netology.repositiry.ProductRepository;

public class ProductManager {
    protected Product[] products = new Product[0];
    protected ProductRepository repository = new ProductRepository();

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }
     public ProductManager() {
     }

    public void add(Product product) {
        Product[] tmp = new  Product[products.length + 1];
        System.arraycopy(products, 0, tmp, 0, products.length);
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public Product[] findAll() { return products;}
    public Product[] searchBy(String text) {
            Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
            for (Product product: repository.findAll())
                if (matches(product, text)) {
                    for (int i = 0; i < products.length; i++) {
                        result[i] = product;
                    }
                    // "добавляем в конец" массива result продукт product
                }
            return result;
        }

        // метод определения соответствия товара product запросу search
        public boolean matches(Product product, String search) {
            return product.getNames().contains(search);
        }

}

