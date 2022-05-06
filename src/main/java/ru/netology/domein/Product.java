package ru.netology.domein;

import java.util.Objects;

public class Product {
    protected int id;
    protected String names;
    protected int prices;

    public Product(int id, String names, int prices) {
        this.id = id;
        this.names = names;
        this.prices = prices;
    }

    public Product(int id) {
        this.id = id;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNames() {
        return names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return id == that.id && Objects.equals(names, that.names) && Objects.equals(prices, that.prices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, names, prices);
    }
}
