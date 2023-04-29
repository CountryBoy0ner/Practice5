package org.example;

public class DiscountPercentPurchase extends AbstractPurchase {
    private double discount;
    final private int LIMIT_DISCOUNT = 5;
    public void setDiscountPercent(double discountPercent) {
        this.discount = discountPercent;
    }

    public double getDiscountPercent() {return discount;}

    public DiscountPercentPurchase() {
        super();
        this.discount = 0;
    }

    public DiscountPercentPurchase(Product product, int quantity, int discount) {
        super(product, quantity);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }


    @Override
    protected Euro getFinalCost(Euro baseCost) {
        Euro finalCost = baseCost;
        if (getQuantity()>=LIMIT_DISCOUNT){
            finalCost = baseCost.sub(baseCost.mul(discount/100, RoundMethod.ROUND, 0));
        }
        return finalCost;
    }

    @Override
    public String toString() { // наверное стоит заменить на super на я хз как
        return super.toString() + ";" + discount;
    }
}
