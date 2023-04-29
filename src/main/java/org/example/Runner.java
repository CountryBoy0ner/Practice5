package org.example;

import java.util.Arrays;

public class Runner {
    static Product uniqueProducts = new Product("apple", new Euro(200));

    public static void main(String[] args) {
        int numberOfProducts = 6;
        AbstractPurchase[] purchases = new AbstractPurchase[]{
                new DiscountOnUnitPurchase(uniqueProducts, 40, new Euro(20)),
                new DiscountOnUnitPurchase(uniqueProducts, 10, new Euro(20)),
                new DiscountPercentPurchase(uniqueProducts, 10, 25),
                new DiscountPercentPurchase(uniqueProducts, 100, 25),
                new TransportPurchase(uniqueProducts, 10, new Euro(500)),
                new TransportPurchase(uniqueProducts, 40, new Euro(5000))
        };
        display(purchases);
        Arrays.sort(purchases);
        System.out.println("----------------sorted-----------------");
        display(purchases);
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("min Cost=" + purchases[purchases.length - 1]);
        System.out.println(purchases[search(purchases)]);
    }

    private static void display(AbstractPurchase[] abstractPurchase) {
        for (AbstractPurchase purchase : abstractPurchase) {
            System.out.println(purchase);
        }
    }

    public static int search(AbstractPurchase[] purchases) {
        Product product1 = new Product("target", new Euro(0));
        AbstractPurchase target =  new TransportPurchase(uniqueProducts, 10, new Euro(500));
        int index = Arrays.binarySearch(purchases, target);
        if (index < 0) {
            throw new RuntimeException("search failed");
        } else {
            return index;
        }
    }
}
