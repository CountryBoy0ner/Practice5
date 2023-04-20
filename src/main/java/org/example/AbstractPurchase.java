package org.example;

import java.text.DecimalFormat;


    public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
        protected Product product;
        protected int quantity;

        public AbstractPurchase() {
            this.product = null;
            this.quantity = 0;
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


        public void setProduct(Product product) {
            this.product = product;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }


        public abstract Euro getCost(); // абстрактный метод для получения стоимости покупки

        @Override
        public int compareTo(AbstractPurchase other) {
            return Double.compare(other.getCost().getValueInCents(), this.getCost().getValueInCents()); // сравниваем покупки по убыванию стоимости
        }

        @Override
        public String toString() {
            DecimalFormat df = new DecimalFormat("#.00");
            return this.getClass().getSimpleName() + ";" + this.product + ";" + this.quantity + ";" + df.format(product.getPriceInCents());
        }
    }
