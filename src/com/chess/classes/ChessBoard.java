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

/**
 * The ChessBoard class represents a chessboard with pieces and a view.
 */
public class ChessBoard {
    private PiecesList<Piece> pieces;
    private BoardView view;
    private int interval;

    /**
     * Sets the pieces on the chessboard based on the specified data type, numbers, and color.
     *
     * @param dataType the data type of the pieces
     * @param numbers the number of pieces
     * @param color the color of the board view
     */
    public void setPieces(DataType dataType, Numbers numbers, Color color) {
        if (dataType != null) {
            pieces = PieceGenerator.generateRandomPieces(dataType.getDataType(), numbers);
            setBoardView(color);
        }
    }

    /**
     * Sets the board view based on the specified color.
     *
     * @param color the color of the board view
     */
    private void setBoardView(Color color) {
        if (color == Color.WHITE) {
            view = new WhiteBoardView();
        } else if (color == Color.BLACK) {
            view = new BlackBoardView();
        }
    }

    /**
     * Selects the sorting algorithm for the pieces and sorts them.
     *
     * @param algorithm the sorting algorithm to be used
     * @param interval the interval in milliseconds between each sorting operation
     */
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

    /**
     * Gets the list of pieces on the chessboard.
     *
     * @return the list of pieces
     */
    public PiecesList<Piece> getPieces() {
        return pieces;
    }
}