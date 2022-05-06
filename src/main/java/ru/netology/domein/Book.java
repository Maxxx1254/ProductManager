package ru.netology.domein;

public class Book extends Product{

    private String authors;

    public Book(int id, String names, int prices, String authors) {
        super(id, names, prices);
        this.authors = authors;
    }

}
