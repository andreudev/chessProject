package com.chess.utils;

import com.chess.arrays.PiecesList;
import com.chess.classes.pieces.Piece;
import com.chess.myinterfaces.BoardView;

public class WhiteBoardView implements BoardView {
    @Override
    public void displayBoard(PiecesList<Piece> pieces) {
        System.out.println("White board view");
        System.out.println(pieces);
    }
}
