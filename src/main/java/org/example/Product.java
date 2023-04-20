package org.example;

public class Product {

    private String name;
    private Euro priceInCents;

    public Product(String name, Euro priceInCents) {
        this.name = name;
        this.priceInCents = priceInCents;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public Euro getPriceInCents() {
        return priceInCents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriceInCents(Euro priceInCents) {
        this.priceInCents = priceInCents;
    }

    public String toString() {
        return convertToEuro(priceInCents);
    }

    private String convertToEuro(Euro priceInCents) {
        return priceInCents.convertToEuro(priceInCents.getValueInCents());
    }


}
