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
        case 3, 4 -> new Rook();
        case 5, 6 -> new Bishop();
        case 7, 8 -> new Knight();
        default -> new Pawn();
        };
    }
}