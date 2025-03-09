package com.chess.myinterfaces;

import com.chess.arrays.PiecesList;
import com.chess.classes.pieces.Piece;

public interface BoardView {
    void displayBoard(PiecesList<Piece> pieces);
}