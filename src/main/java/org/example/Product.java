package org.example;

public class Product {

    private String name;
    private Euro priceInEuro;

    public Product(String name, Euro priceInEuro) {
        this.name = name;
        this.priceInEuro = priceInEuro;
    }

    public Product( Euro priceInEuro) {
        this.priceInEuro = priceInEuro;     //7task
    }

    public Product() {
        this.name = "";
        this.priceInEuro = new Euro(0) ;
    }

    public String getName() {
        return name;
    }

    public Euro getPriceInEuro() {
        return priceInEuro;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriceInEuro(Euro priceInEuro) {
        this.priceInEuro = priceInEuro;
    }

    public String toString() {
        return String.format("%s;%s", name, priceInEuro);
    }




}
