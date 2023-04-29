package org.example;

import java.text.DecimalFormat;


public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private Product product;
    private int quantity;


    public AbstractPurchase() {
        this(null, 0);
    }

    public AbstractPurchase(Product product) {   //7task
        this.product = product;
    }

    public AbstractPurchase(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    protected abstract Euro getFinalCost(Euro baseCost);

    public Euro getCost(){
        Euro baseCost = product.getPriceInEuro().mul(quantity);
        Euro finalCost = getFinalCost(baseCost);
        return finalCost.round(RoundMethod.FLOOR, 2);
    }

    @Override
    public int compareTo(AbstractPurchase other) {
        return Double.compare((double)other.getCost().getVALUE_IN_CENTS(), (double)this.getCost().getVALUE_IN_CENTS());
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        String var10000 = this.getClass().getSimpleName();
        return var10000 + ";" + this.product + ";" + this.quantity + ";" + this.getProduct().getPriceInEuro();
    }
}
