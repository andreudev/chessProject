package com.chess.classes;

import com.chess.arrays.PiecesList;
import com.chess.classes.pieces.Piece;
import com.chess.enums.Algorithm;
import com.chess.enums.Color;
import com.chess.enums.DataType;
import com.chess.enums.Numbers;
import com.chess.utils.YArgs;

import java.util.Map;

/**
 * The ChessGame class represents a chess game with various configurations.
 */
public class ChessGame {
    private final Algorithm algorithm;
    private final DataType dataType;
    private final Color color;
    private final Numbers numbers;
    private final int seconds;
    private PiecesList<Piece> pieces;
    private ChessBoard board = new ChessBoard();

    /**
     * Constructs a ChessGame instance with the specified arguments.
     *
     * @param args the command-line arguments for configuring the game
     */
    public ChessGame(String[] args) {
        Map<String, String> map = YArgs.splitArgs(args);
        this.algorithm = Algorithm.checkFromString(map.get("a"));
        this.dataType = DataType.checkFromString(map.get("t"));
        this.color = Color.checkFromInitial(map.get("c"));
        this.numbers = Numbers.checkFromValue(Integer.parseInt(map.get("r")));
        this.seconds = (Integer.parseInt(map.get("s")) >= 100 && Integer.parseInt(map.get("s")) <= 1000)
                ? Integer.parseInt(map.get("s"))
                : 0;
        board.setPieces(dataType, numbers, color);
    }

    /**
     * Displays the game configuration information.
     */
    private void showInfo() {
        System.out.println("Algorithm: " + (algorithm != null ? algorithm.getAlgorithm() : "Algorithm not found"));
        System.out.println("Type: " + (dataType != null ? dataType.getDescription() : "Type not found"));
        System.out.println("Color: " + (color != null ? color.getName() : "Color not found"));
        System.out.println("Numbers: " + (numbers != null ? numbers.getValue() : "Numbers not found"));
        System.out.println("Seconds: " + (seconds > 0 ? seconds : "Invalid seconds"));
        System.out.println("Pieces: " + board.getPieces());
    }

    /**
     * Starts the chess game by displaying the configuration and selecting the
     * algorithm.
     */
    public void startGame() {
        showInfo();
        if (validateParameters()) {
            board.selectAlgorithm(algorithm, seconds);
        } else {
            System.out.println("Invalid parameters!");
        }
    }

    /**
     * Validates the game parameters.
     *
     * @return true if all parameters are valid, false otherwise
     */
    private boolean validateParameters() {
        return algorithm != null && dataType != null && color != null && numbers != null && seconds > 0;
    }
}