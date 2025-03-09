package com.chess.utils;

import com.chess.arrays.PiecesList;
import com.chess.classes.pieces.Piece;
import com.chess.myinterfaces.BoardView;

public class BlackBoardView implements BoardView {
    @Override
    public void displayBoard(PiecesList<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        sb.append(" +----+----+----+----+----+----+----+----+\n");
        for (int i = 0; i < 8; i++) {
            sb.append(8-i).append("|");

            if (i==0) {
                sb.append(" ").append(pieces.get(2)).append(" |");
                sb.append(" ").append(pieces.get(6)).append(" |");
                sb.append(" ").append(pieces.get(4)).append(" |");
                sb.append(" ").append(pieces.get(0)).append(" |");
                sb.append(" ").append(pieces.get(1)).append(" |");
                sb.append(" ").append(pieces.get(5)).append(" |");
                sb.append(" ").append(pieces.get(7)).append(" |");
                sb.append(" ").append(pieces.get(3)).append(" |");

            } else if (i==1) {
                sb.append(" ").append(pieces.get(8)).append(" |");
                sb.append(" ").append(pieces.get(9)).append(" |");
                sb.append(" ").append(pieces.get(10)).append(" |");
                sb.append(" ").append(pieces.get(11)).append(" |");
                sb.append(" ").append(pieces.get(12)).append(" |");
                sb.append(" ").append(pieces.get(13)).append(" |");
                sb.append(" ").append(pieces.get(14)).append(" |");
                sb.append(" ").append(pieces.get(15)).append(" |");
            } else
            {
                for (int j = 0; j < 8; j++) {
                    sb.append(" ");
                    sb.append("  ");
                    sb.append(" |");
                }
            }

            sb.append("\n +----+----+----+----+----+----+----+----+\n");
        }
        System.out.println(sb.toString());
    }
}
