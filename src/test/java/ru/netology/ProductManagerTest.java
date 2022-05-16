package ru.netology;

import org.testng.annotations.Test;
import ru.netology.domein.Book;
import ru.netology.domein.Product;
import ru.netology.domein.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repositiry.NotFoundException;
import ru.netology.repositiry.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductManagerTest {
    Product first = new Book(1, "book1", 560, "author1");
    Product second = new Book(2, "book2", 560, "author2");
    Product third = new Smartphone(3, "Smartphone1", 51000, "manufacturer1");
    Product forth = new Smartphone(4, "Smartphone2", 100000, "manufacturer2");


    @Test
    public void saveAndRemoveProductById() {
        ProductRepository repo = new ProductRepository();

        repo.saveProduct(first);
        repo.saveProduct(second);
        repo.saveProduct(third);
        repo.saveProduct(forth);

        repo.removeById(3);

        repo.findAll();

        Product[] expected = {first, second, forth};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void addAndSearchProductByWord() {
        ProductManager manager = new ProductManager();
        manager.addProduct(first);
        manager.addProduct(second);
        manager.addProduct(third);
        manager.addProduct(forth);


        Product[] expected = {second};
        Product[] actual = manager.searchBy("book2");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testChallengeException() {
        ProductRepository repository = new ProductRepository();
        repository.saveProduct(first);
        repository.saveProduct(second);
        repository.saveProduct(third);
        repository.saveProduct(forth);

        assertThrows(NotFoundException.class, () -> {repository.removeById(13);});
    }
}