package ru.netology.domein;

public class Smartphone extends Product {

    private String manufacturers;

    public Smartphone(int id, String names, int prices, String manufacturers) {
        super(id, names, prices);
        this.manufacturers = manufacturers;
    }
}
