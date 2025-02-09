package com.chess.myexceptions;

public class ColorTypeError extends IllegalArgumentException {
    public ColorTypeError(String message) {
        super(message);
    }
}
