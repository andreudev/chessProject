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
        case 'c', 'd' -> new Rook();
        case 'e', 'f' -> new Bishop();
        case 'g', 'h' -> new Knight();
        default -> new Pawn();
        };
    }
}