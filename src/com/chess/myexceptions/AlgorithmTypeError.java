package com.chess.myexceptions;

public class AlgorithmTypeError extends IllegalArgumentException {
    public AlgorithmTypeError(String message) {
        super(message);
    }
}
