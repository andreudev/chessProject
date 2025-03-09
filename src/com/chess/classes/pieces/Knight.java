package com.chess.classes.pieces;

public class Knight extends Piece {

    public Knight() {
        this.priority = 5;
    }

    public String getName() {
        return "KT";
    }

    @Override
    public int compareTo(Piece o) {
        return this.priority - o.priority;
    }
}
