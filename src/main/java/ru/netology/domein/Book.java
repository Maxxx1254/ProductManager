package ru.netology.domein;

public class Book extends Product{

    protected String authors;

    public Book(int id, String names, int prices, String authors) {
        super(id, names, prices);
        this.authors = authors;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }
}
