package org.example;

public class Euro {
    private int valueInCents;

    public Euro(int value) {
        this.valueInCents = value;
    }

    public Euro() {
    }

    public int getValueInCents() {
        return valueInCents;
    }

    public Euro add(int other) {
        return new Euro(this.valueInCents + other);
    }

    public Euro subtract(int other) {
        return new Euro(this.valueInCents - other);
    }


    public String convertToEuro(int value) {
        return String.format("%d.%02d", value / 100, Math.abs(value % 100));
    }

    @Override
    public String toString() {
        return String.format("%.2f EUR", valueInCents / 100.0);
    }
}