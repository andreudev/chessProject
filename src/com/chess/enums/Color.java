package com.chess.enums;

import com.chess.myexceptions.ColorTypeError;

public enum Color {
    WHITE("b", "Blancas"),
    BLACK("n", "Negras");

    private final String initial;
    private final String name;

    private Color(String initial, String name) {
        this.initial = initial;
        this.name = name;
    }

    public String getInitial() {
        return initial;
    }

    public String getName() {
        return name;
    }

    private static Color fromInitial(String initial) throws ColorTypeError {
        for (Color color : Color.values()) {
            if (color.getInitial().equals(initial)) {
                return color;
            }
        }
        throw new ColorTypeError("Invalid color: " + initial);
    }

    public static Color checkFromInitial(String initial) {
        try {
            return fromInitial(initial);
        } catch (ColorTypeError e) {
            e.printStackTrace();
            return null;
        }
    }
}
