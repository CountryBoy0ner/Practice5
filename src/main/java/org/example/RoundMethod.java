package org.example;

public enum RoundMethod {
    FLOOR {
        double roundFunction(double value) {
            return Math.floor(value);
        }
    },
    CEIL {
        double roundFunction(double value) {
            return Math.ceil(value);
        }
    },
    ROUND {
        double roundFunction(double value) {
            return Math.round(value);
        }
    };

    abstract double roundFunction(double value);
}