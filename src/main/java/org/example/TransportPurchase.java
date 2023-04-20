package org.example;

public class TransportPurchase extends AbstractPurchase {
    private Euro shippingCost;

    public TransportPurchase(Product product, int quantity, Euro shippingCost) {
        super(product, quantity);
        this.shippingCost = shippingCost;
    }

    public Euro getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Euro shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override

    public String toString() {
        return String.format("%s;%s;%s;%s", getClass().getSimpleName(),
                getProduct().getName(), getQuantity(), getCost());
    }

    @Override
    public Euro getCost() {
        return new Euro((product.getPriceInCents().getValueInCents() * this.quantity)+shippingCost.getValueInCents());
    }
}