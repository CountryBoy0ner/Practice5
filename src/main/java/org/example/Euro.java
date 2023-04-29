package org.example;

public class Euro {
    private final int VALUE_IN_CENTS;

    public Euro(int value) {
        this.VALUE_IN_CENTS = value;
    }

    public Euro() {
        this.VALUE_IN_CENTS = 0;
    }

    public Euro(Euro euro) {
        this.VALUE_IN_CENTS = euro.VALUE_IN_CENTS;
    }

    public Euro(int euros, int cents) {
        this.VALUE_IN_CENTS = (euros * 100) + cents;
    }

    public int getVALUE_IN_CENTS() {
        return VALUE_IN_CENTS;
    }

    public int getEuro() {
        return VALUE_IN_CENTS / 100;
    }

    public int getCoins() {
        return VALUE_IN_CENTS % 100;
    }

    public Euro add(Euro euro) {
        return new Euro(VALUE_IN_CENTS + euro.getVALUE_IN_CENTS());
    }

    public Euro sub(Euro euro) {
        return new Euro(VALUE_IN_CENTS - euro.getVALUE_IN_CENTS());
    }

    public Euro round(RoundMethod roundMethod, int d) {
        return new Euro(round(VALUE_IN_CENTS, roundMethod, d));
    }

    private static Euro round(double roundedValue, RoundMethod roundMethod, int d) {
        int tenPow = (int) Math.pow(10, d);
        int result = (int) roundMethod.roundFunction(roundedValue / tenPow) * tenPow;
        return new Euro(result);
    }

    public Euro mul(int k) {
        return new Euro(VALUE_IN_CENTS * k);
    }

    public Euro mul(double k, RoundMethod roundMethod, int d) {
        int tenPow = (int) Math.pow(10, d);
        return new Euro(round(VALUE_IN_CENTS * k / tenPow, roundMethod, d));
    }

    public int compareTo(Euro euro) {
        return Integer.compare(VALUE_IN_CENTS, euro.VALUE_IN_CENTS);
    }

    @Override
    public String toString() {
     return convertToEuro();

    }

    public String convertToEuro() {
        return String.format("%d.%02d", getVALUE_IN_CENTS() / 100, Math.abs(getVALUE_IN_CENTS() % 100));
    }
}