package org.example;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class TestRunner {
    @Test
    public void testEuroCentsConstructor() {
        Euro euro = new Euro(100);
        assertEquals(100, euro.getVALUE_IN_CENTS());
    }

    @Test
    public void testEuroEmptyConstructor() {
        Euro euro1 = new Euro();
        assertEquals(0, euro1.getVALUE_IN_CENTS());
    }

    @Test
    public void testEuroAndCentsConstructor() {
        Euro euro2 = new Euro(10, 20);
        assertEquals(1020, euro2.getVALUE_IN_CENTS());
    }

    @Test
    public void testEuroObjectConstructor() {
        Euro euro2 = new Euro(10, 20);
        Euro euro3 = new Euro(euro2);
        assertEquals(1020, euro3.getVALUE_IN_CENTS());
    }

    @Test
    public void testEuroToString() {
        Euro euro = new Euro(100);
        assertEquals("1.00", euro.toString());
    }

    @Test
    void testEuroAddition() {
        Euro euro = new Euro(1020);
        Euro addedEuro = euro.add(new Euro(200));
        assertEquals(1220, addedEuro.getVALUE_IN_CENTS());
    }

    @Test
    void testEuroSubtraction() {
        Euro euro = new Euro(1020);
        Euro subEuro = euro.sub(new Euro(20));
        assertEquals(1000, subEuro.getVALUE_IN_CENTS());
    }

    @Test
    void testEuroMultiplicationEuro() {
        Euro euro = new Euro(1020);
        Euro mulEuro = euro.mul(4, RoundMethod.CEIL, 0);
        assertEquals(4080, mulEuro.getVALUE_IN_CENTS());

    }

    @Test
    void testEuroMultiplicationInt() {
        Euro euro = new Euro(1020);
        Euro mulEuro1 = euro.mul(2);
        assertEquals(2040, mulEuro1.getVALUE_IN_CENTS());
    }

    @Test
    void testEuroGetEuroAndCoins() {
        Euro euro = new Euro(1020);
        assertEquals(10, euro.getEuro());
        assertEquals(20, euro.getCoins());
    }

    @Test
    void testEuroRoundingCeil() {
        Euro euro1 = new Euro(10, 50);
        Euro roundedEuro1 = euro1.round(RoundMethod.CEIL, 2);
        assertEquals(1100, roundedEuro1.getVALUE_IN_CENTS());
    }

    @Test
    void testEuroRoundingFloor() {
        Euro euro2 = new Euro(1050);
        Euro roundedEuro2 = euro2.round(RoundMethod.FLOOR, 2);
        assertEquals(1000, roundedEuro2.getVALUE_IN_CENTS());
    }

    @Test
    void testEuroRoundingRound() {
        Euro euro3 = new Euro(1050);
        Euro roundedEuro3 = euro3.round(RoundMethod.ROUND, 2);
        assertEquals(1100, roundedEuro3.getVALUE_IN_CENTS());
    }

    @Test
    void testUnitsDiscountPurchaseConstructor() {
        Product product = new Product("Cola", new Euro(10, 20));
        DiscountOnUnitPurchase purchase1 = new DiscountOnUnitPurchase(product, 5, new Euro(20));
        assertEquals("Cola", purchase1.getProduct().getName());
        assertEquals(1020, purchase1.getProduct().getPriceInEuro().getVALUE_IN_CENTS());
        assertEquals(5, purchase1.getQuantity());
        assertEquals(20, purchase1.getDiscount().getVALUE_IN_CENTS());
    }

    @Test
    void testUnitsDiscountPurchaseEmptyConstructor() {
        DiscountOnUnitPurchase purchase11 = new DiscountOnUnitPurchase();
        assertNull(purchase11.getProduct());
        assertEquals(0, purchase11.getQuantity());
        assertNull(purchase11.getDiscount());
    }

    @Test
    void testPercentDiscountPurchaseConstructor() {
        Product product = new Product("Cola", new Euro(10, 20));
        DiscountPercentPurchase purchase2 = new DiscountPercentPurchase(product, 5, 50);
        assertEquals("Cola", purchase2.getProduct().getName());
        assertEquals(1020, purchase2.getProduct().getPriceInEuro().getVALUE_IN_CENTS());
        assertEquals(5, purchase2.getQuantity());
        assertEquals(50, purchase2.getDiscount());
    }

    @Test
    void testPercentDiscountPurchaseEmptyConstructor() {
        DiscountPercentPurchase purchase22 = new DiscountPercentPurchase();
        assertNull(purchase22.getProduct());
        assertEquals(0, purchase22.getQuantity());
        assertEquals(0, purchase22.getDiscount());
    }

    @Test
    void testTransportPurchaseConstructor() {
        Product product = new Product("Cola", new Euro(10, 20));
        TransportPurchase purchase3 = new TransportPurchase(product, 5, new Euro(10000));
        assertEquals("Cola", purchase3.getProduct().getName());
        assertEquals(1020, purchase3.getProduct().getPriceInEuro().getVALUE_IN_CENTS());
        assertEquals(5, purchase3.getQuantity());
        assertEquals(10000, purchase3.getShippingCost().getVALUE_IN_CENTS());
    }


    @Test
    void testProductConstructor() {
        Product product1 = new Product("Milk", new Euro(1000));
        assertEquals("Milk", product1.getName());
        assertEquals(1000, product1.getPriceInEuro().getVALUE_IN_CENTS());
    }

    @Test
    public void testProductEmptyConstructor() {
        Product product = new Product();
        assertEquals("", product.getName());
        assertEquals(0, product.getPriceInEuro().getVALUE_IN_CENTS());
    }

    @Test
    void testSearchLastPlace() {
        Product product = new Product("Iphone", new Euro(1000));
        AbstractPurchase[] purchases1 = new AbstractPurchase[]{
                new DiscountOnUnitPurchase(product, 10, new Euro(200)),
                new DiscountOnUnitPurchase(product, 20, new Euro(500)),
                new DiscountPercentPurchase(product, 5, 60),
                new DiscountPercentPurchase(product, 20, 50),
                new TransportPurchase(product, 10, new Euro(14000)),
                new TransportPurchase(product, 0, new Euro(500))
        };
        Arrays.sort(purchases1);
        assertEquals(5, Runner.search(purchases1));
    }

    @Test
    void testSearchLessThanMin() {
        Product product2 = new Product("Smth1", new Euro(100));
        AbstractPurchase[] purchases3 = new AbstractPurchase[]{
                new DiscountOnUnitPurchase(product2, 10, new Euro(10)),
                new DiscountOnUnitPurchase(product2, 8, new Euro(20)),
                new DiscountPercentPurchase(product2, 5, 0),
                new DiscountPercentPurchase(product2, 6, 0),
                new TransportPurchase(product2, 1, new Euro(1000)),
                new TransportPurchase(product2, 1, new Euro(1000))
        };
        Arrays.sort(purchases3);
        assertEquals(5, Runner.search(purchases3));
    }

    @Test
    void testSearchGreaterThanMax() {
        Product product1 = new Product("Smth", new Euro(100));
        AbstractPurchase[] purchases2 = new AbstractPurchase[]{
                new DiscountOnUnitPurchase(product1, 1, new Euro(10)),
                new DiscountOnUnitPurchase(product1, 2, new Euro(20)),
                new DiscountPercentPurchase(product1, 5, 0),
                new DiscountPercentPurchase(product1, 4, 0),
                new TransportPurchase(product1, 3, new Euro(0)),
                new TransportPurchase(product1, 1, new Euro(0))
        };
        Arrays.sort(purchases2);
        assertEquals(0, Runner.search(purchases2));

    }

    @Test
    public void testSearchFirstPlace() {
        Product product = new Product("Iphone", new Euro(1000));
        AbstractPurchase[] purchases = new AbstractPurchase[]{
                new DiscountOnUnitPurchase(product, 1, new Euro(500)),
                new DiscountOnUnitPurchase(product, 20, new Euro(500)),
                new DiscountPercentPurchase(product, 5, 10),
                new DiscountPercentPurchase(product, 1, 50),
                new TransportPurchase(product, 10, new Euro(14000)),
                new TransportPurchase(product, 30, new Euro(17500))
        };
        Arrays.sort(purchases);
        assertEquals(5, Runner.search(purchases));
    }

    @Test
    void testGetCostUnitsDiscountPurchase() {
        Product product = new Product("Smth", new Euro(1000));
        DiscountOnUnitPurchase purchase = new DiscountOnUnitPurchase(product, 5, new Euro(200));
        assertEquals(4000, purchase.getCost().getVALUE_IN_CENTS());
    }

    @Test
    void testGetCostPercentDiscountPurchase() {
        Product product = new Product("Smth", new Euro(1000));
        DiscountPercentPurchase purchase = new DiscountPercentPurchase(product, 5, 50);
        assertEquals(2500, purchase.getCost().getVALUE_IN_CENTS());
    }

    @Test
    void testGetCostTransportPurchase() {
        Product product = new Product("Smth", new Euro(1000));
        TransportPurchase purchase = new TransportPurchase(product, 5, new Euro(1000));
        assertEquals(6000, purchase.getCost().getVALUE_IN_CENTS());
    }
}

