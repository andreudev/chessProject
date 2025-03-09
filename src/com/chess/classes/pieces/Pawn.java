package com.chess.classes.pieces;

public class Pawn extends Piece {

    public Pawn() {
        this.priority = 6;
    }

    public String getName() {
        return "PN";
    }

    @Override
    public int compareTo(Piece o) {
        return this.priority - o.priority;
    }
}
