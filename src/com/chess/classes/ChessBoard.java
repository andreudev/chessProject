package com.chess.classes;

import com.chess.arrays.PiecesList;
import com.chess.classes.pieces.Piece;
import com.chess.enums.Algorithm;
import com.chess.enums.DataType;
import com.chess.enums.Numbers;
import com.chess.enums.Color;
import com.chess.myinterfaces.BoardView;
import com.chess.utils.WhiteBoardView;
import com.chess.utils.BlackBoardView;
import com.chess.utils.PieceGenerator;

public class ChessBoard {
    private PiecesList<Piece> pieces;
    private BoardView view;
    private int interval;

    public void setPieces(DataType dataType, Numbers numbers, Color color) {
        if (dataType != null) {
            pieces = PieceGenerator.generateRandomPieces(dataType.getDataType(), numbers);
            setBoardView(color);
        }
    }

    private void setBoardView(Color color) {
        if (color == Color.WHITE) {
            view = new WhiteBoardView();
        } else if (color == Color.BLACK) {
            view = new BlackBoardView();
        }
    }

    public void selectAlgorithm(Algorithm algorithm, int interval) {
        if (algorithm != null) {
            this.interval = interval;
            long startTime = System.currentTimeMillis();
            pieces.setSortingStrategy(algorithm.getSortingStrategy(interval));
            pieces.sort(view);
            long endTime = System.currentTimeMillis();
            System.out.println("Time: " + (endTime - startTime) + " ms");
        }
    }

    public PiecesList<Piece> getPieces() {
        return pieces;
    }
}