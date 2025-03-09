package com.chess.classes.pieces;

public class Bishop extends Piece {

    public Bishop() {
        this.priority = 4;
    }

    public String getName() {
        return "BP";
    }

    @Override
    public int compareTo(Piece o) {
        return this.priority - o.priority;
    }
}
