package com.chess.classes.pieces;

public class Rook extends Piece {

    public Rook() {
        this.priority = 3;
    }

    public String getName() {
        return "RK";
    }

    @Override
    public int compareTo(Piece o) {
        return this.priority - o.priority;
    }
}
