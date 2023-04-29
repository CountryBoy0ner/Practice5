package org.example;

import java.text.DecimalFormat;

public class DiscountOnUnitPurchase extends AbstractPurchase {
    private Euro discount;

    public DiscountOnUnitPurchase(Euro discount) {
        this.discount = discount;
    }


    public DiscountOnUnitPurchase(Product product, int quantity, Euro discount) {
        super(product, quantity);
        this.discount = discount;
    }

    public DiscountOnUnitPurchase() {

    }

    public Euro getDiscount() {
        return discount;
    }

    public void setDiscount(Euro discount) {
        this.discount = discount;
    }


    @Override
    protected Euro getFinalCost(Euro baseCost) {
        return baseCost.sub(discount.mul(getQuantity()));
    }


    @Override
    public String toString() { // наверное стоит заменить на super на я хз как

        return super.toString() + ";" + discount;
    }

}
