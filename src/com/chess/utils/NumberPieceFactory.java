package com.chess.utils;

import com.chess.classes.pieces.*;
import com.chess.myinterfaces.PieceFactory;

public class NumberPieceFactory implements PieceFactory {
    @Override
    public Piece createPiece(Object value) {
        int number = (int) value;
        return switch (number) {
        case 1 -> new King();
        case 2 -> new Queen();
        case 3, 4 -> new Bishop();
        case 5, 6 -> new Knight();
        case 7, 8 -> new Rook();
        default -> new Pawn();
        };
    }
}