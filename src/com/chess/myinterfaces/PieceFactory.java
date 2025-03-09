package com.chess.myinterfaces;

import com.chess.classes.pieces.Piece;

public interface PieceFactory {
    Piece createPiece(Object value);
}