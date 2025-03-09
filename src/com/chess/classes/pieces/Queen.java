package com.chess.classes.pieces;

public class Queen extends Piece {

    public Queen() {
        this.priority = 2;
    }

    public String getName() {
        return "QN";
    }

    @Override
    public int compareTo(Piece o) {
        return this.priority - o.priority;
    }
}
