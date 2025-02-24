package com.chess.enums;

import com.chess.myexceptions.NumbersTypesErrors;

public enum Numbers {
    ONE(1),TWO(2),FOUR(4),EIGHT(8), TEN(10), SIXTEEN(16);

    private final int value;

    private Numbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private static Numbers fromValue(int value) throws NumbersTypesErrors {
        for (Numbers numbers : Numbers.values()) {
            if (numbers.getValue() == value) {
                return numbers;
            }
        }
        throw new NumbersTypesErrors("Invalid number: " + value);
    }

    public static Numbers checkFromValue(int value) {
        try {
            return fromValue(value);
        } catch (NumbersTypesErrors e) {
            e.printStackTrace();
            return null;
        }
    }


}
