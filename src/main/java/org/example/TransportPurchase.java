package org.example;

public class TransportPurchase extends AbstractPurchase {
    private Euro shippingCost;

    public TransportPurchase(Product product, int quantity, Euro shippingCost) {
        super(product, quantity);
        this.shippingCost = shippingCost;
    }

    public TransportPurchase() {}

    public Euro getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Euro shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override

    public String toString() {
        return super.toString()+";"+shippingCost.convertToEuro();
    }

    @Override
    protected Euro getFinalCost(Euro baseCost) {
        return baseCost.add(shippingCost);
    }
}