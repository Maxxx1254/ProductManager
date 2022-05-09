package ru.netology;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domein.Book;
import ru.netology.domein.Product;
import ru.netology.domein.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repositiry.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

public class ProductManagerTestNonEmpty {
    private ProductRepository repository = Mockito.mock(ProductRepository.class);
    private ProductManager manager = new ProductManager(repository);
    Product first = new Book(1, "book1", 560, "author1");
    Product second = new Book(2, "book2", 560, "author2");
    Product third = new Smartphone(3, "Smartphone1", 51000, "manufacturer1");
    Product forth = new Smartphone(4, "Smartphone2", 100000, "manufacturer2");

    @Test
    public void testFeatureSearchById(){
        Product[] returned = {first, second, third, forth};
        doReturn(returned).when(repository).findAll();

        Product[] expected = {second};
        Product[] actual = manager.searchBy("book2");

        assertArrayEquals(expected, actual);
    }
}