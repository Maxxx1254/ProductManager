package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.domein.Book;
import ru.netology.domein.Product;
import ru.netology.domein.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repositiry.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    Product first = new Book(1, "book1", 560, "author1");
    Product second = new Book(2, "book2", 560, "author2");
    Product third = new Smartphone(3, "Smartphone1", 51000, "manufacturer1");
    Product forth = new Smartphone(4, "Smartphone2", 100000, "manufacturer2");


    @Test
    public void saveAndRemoveProduct() {
        ProductRepository repo = new ProductRepository();

        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(forth);

        repo.removeById(3);

        repo.findAll();

        Product[] expected = {first, second, forth};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void addProduct() {
        ProductManager repo = new ProductManager();
        repo.add(first);
        repo.add(second);
        repo.add(third);
        repo.add(forth);


        Product[] expected = {second};
        Product[] actual = repo.searchBy("book2");

        assertArrayEquals(expected, actual);
    }
}