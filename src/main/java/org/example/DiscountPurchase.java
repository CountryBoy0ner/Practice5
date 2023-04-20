package org.example;

public class DiscountPurchase extends AbstractPurchase {
    private int discount;

    public DiscountPurchase() {
        super();
        this.discount = 0;
    }

    public DiscountPurchase(Product product, int quantity, int discount) {
        super(product, quantity);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public Euro getCost() {
        Euro result = new Euro(product.getPriceInCents().getValueInCents() * this.quantity);
        if (this.quantity > 10) {
            result = new Euro((product.getPriceInCents().getValueInCents() - discount) * this.quantity);
        }
        return result;
    }
}
