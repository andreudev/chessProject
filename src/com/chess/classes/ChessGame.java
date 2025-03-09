package com.chess.classes;

import com.chess.arrays.PiecesList;
import com.chess.enums.Algorithm;
import com.chess.enums.Color;
import com.chess.enums.DataType;
import com.chess.enums.Numbers;
import com.chess.utils.YArgs;

import java.util.*;

public class ChessGame {
    private final Algorithm algorithm;
    private final DataType dataType;
    private final Color color;
    private final Numbers numbers;
    private PiecesList<?> pieces;
    private final Random random = new Random();

    public ChessGame(String[] args) {
        Map<String, String> map = YArgs.splitArgs(args);
        this.algorithm = Algorithm.checkFromString(map.get("a"));
        this.dataType = DataType.checkFromString(map.get("t"));
        this.color = Color.checkFromInitial(map.get("c"));
        this.numbers = Numbers.checkFromValue(Integer.parseInt(map.get("r")));
        setPieces();
        System.out.println("Algorithm: " + (algorithm != null ? algorithm.getAlgorithm() : null));
        System.out.println("Type: " + (dataType != null ? dataType.getDescription() : null));
        System.out.println("Color: " + (color != null ? color.getName() : null));
        System.out.println("Numbers: " + (numbers != null ? numbers.getValue() : null));
        System.out.println("Pieces: " + pieces);
        selectAlgorithm();
        System.out.println("Sorted pieces: " + pieces);
    }

    private void selectAlgorithm() {
        if (algorithm != null) {
            long startTime = System.currentTimeMillis();
            pieces.setSortingStrategy(algorithm.getSortingStrategy());
            pieces.sort();
            long endTime = System.currentTimeMillis();
            System.out.println("Time: " + (endTime - startTime) + " ms");
        }
    }

    private void setPieces() {
        if (dataType != null) {
            pieces = generateRandomPieces(dataType.getDataType());
        }
    }

    private PiecesList<?> generateRandomPieces(String type) {
        if (type.equals("c")) {
            List<Character> list = new ArrayList<>();
            while (list.size() < numbers.getValue()) {
                int piece = 'a' + random.nextInt(numbers.getValue());
                if (!list.contains((char) piece)) {
                    list.add((char) piece);
                }
            }
            return new PiecesList<>(list);
        } else if (type.equals("n")) {
            List<Integer> list = new ArrayList<>();
            while (list.size() < numbers.getValue()) {
                int piece = random.nextInt(numbers.getValue()) + 1;
                if (!list.contains(piece)) {
                    list.add(piece);
                }
            }
            return new PiecesList<>(list);
        }

        return new PiecesList<>();
    }
}
