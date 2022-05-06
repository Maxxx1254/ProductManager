package ru.netology.manager;


import ru.netology.domein.Product;
import ru.netology.repositiry.ProductRepository;

public class ProductManager {
    protected Product[] products = new Product[0];
    protected ProductRepository repository = new ProductRepository();

    public ProductManager(Product[] products) {
        this.products = products;
    }

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
        repository.save(product);
    }


    public Product[] searchBy(String text) {
            Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
            for (Product product: repository.findAll())
                if (matches(product, text)) {
                    int length = result.length + 1;
                    Product[] tmp = new Product[length];
                    System.arraycopy(result, 0, tmp,0, result.length);
                    int findProduct = tmp.length - 1;
                    tmp[findProduct] = product;
                    result = tmp;
                }
            return result;
        }

        public boolean matches(Product product, String search) {
            return product.getNames().contains(search);
        }

}

