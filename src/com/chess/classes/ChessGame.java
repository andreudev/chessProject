package com.chess.classes;

import com.chess.arrays.PiecesList;
import com.chess.classes.pieces.Piece;
import com.chess.enums.Algorithm;
import com.chess.enums.Color;
import com.chess.enums.DataType;
import com.chess.enums.Numbers;
import com.chess.utils.PieceGenerator;
import com.chess.utils.YArgs;

import java.util.Map;

public class ChessGame {
    private final Algorithm algorithm;
    private final DataType dataType;
    private final Color color;
    private final Numbers numbers;
    private PiecesList<Piece> pieces;
    private ChessBoard board = new ChessBoard();

    public ChessGame(String[] args) {
        Map<String, String> map = YArgs.splitArgs(args);
        this.algorithm = Algorithm.checkFromString(map.get("a"));
        this.dataType = DataType.checkFromString(map.get("t"));
        this.color = Color.checkFromInitial(map.get("c"));
        this.numbers = Numbers.checkFromValue(Integer.parseInt(map.get("r")));
        board.setPieces(dataType, numbers, color);
        System.out.println("Algorithm: " + (algorithm != null ? algorithm.getAlgorithm() : null));
        System.out.println("Type: " + (dataType != null ? dataType.getDescription() : null));
        System.out.println("Color: " + (color != null ? color.getName() : null));
        System.out.println("Numbers: " + (numbers != null ? numbers.getValue() : null));
        System.out.println("Pieces: " + board.getPieces());
        board.selectAlgorithm(algorithm);
        System.out.println("Sorted pieces: " + board.getPieces());
    }

}