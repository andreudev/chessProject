package com.chess.utils;

import com.chess.classes.pieces.*;
import com.chess.myinterfaces.PieceFactory;

public class CharacterPieceFactory implements PieceFactory {
    @Override
    public Piece createPiece(Object value) {
        char character = (char) value;
        return switch (character) {
        case 'a' -> new King();
        case 'b' -> new Queen();
        case 'c', 'd' -> new Bishop();
        case 'e', 'f' -> new Knight();
        case 'g', 'h' -> new Rook();
        default -> new Pawn();
        };
    }
}