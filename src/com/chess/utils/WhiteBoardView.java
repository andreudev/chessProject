package com.chess.utils;

import com.chess.arrays.PiecesList;
import com.chess.classes.pieces.Piece;
import com.chess.myinterfaces.BoardView;

public class WhiteBoardView implements BoardView {
    @Override
    public void displayBoard(PiecesList<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        sb.append(" +----+----+----+----+----+----+----+----+\n");
        for (int i = 0; i < 8; i++) {
            sb.append(8 - i).append("|");
            appendRow(sb, pieces, i);
            sb.append("\n +----+----+----+----+----+----+----+----+\n");
        }
        System.out.println(sb.toString());
    }

    private void appendRow(StringBuilder sb, PiecesList<Piece> pieces, int row) {
        if (row == 7) {
            appendPieces(sb, pieces, new int[] { 2, 6, 4, 0, 1, 5, 7, 3 });
        } else if (row == 6) {
            appendPieces(sb, pieces, new int[] { 8, 9, 10, 11, 12, 13, 14, 15 });
        } else {
            appendEmptyRow(sb);
        }
    }

    private void appendPieces(StringBuilder sb, PiecesList<Piece> pieces, int[] indices) {
        for (int index : indices) {
            sb.append(" ").append(pieces.get(index)).append(" |");
        }
    }

    private void appendEmptyRow(StringBuilder sb) {
        for (int j = 0; j < 8; j++) {
            sb.append("    |");
        }
    }
}