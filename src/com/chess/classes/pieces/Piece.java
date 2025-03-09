package com.chess.classes.pieces;

public abstract class Piece implements Comparable<Piece> {
    public int priority;

    public Piece() {
        this.priority = 0;
    }
    public abstract String getName();
}
