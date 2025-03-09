package com.chess.classes.pieces;

public class King extends Piece {

    public King() {
        this.priority = 1;
    }

    public String getName() {
        return "KG";
    }

    @Override
    public int compareTo(Piece o) {
        return this.priority - o.priority;
    }
}
