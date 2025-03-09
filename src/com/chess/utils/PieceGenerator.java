package com.chess.utils;

import com.chess.arrays.PiecesList;
import com.chess.classes.pieces.Piece;
import com.chess.enums.Numbers;
import com.chess.myinterfaces.PieceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PieceGenerator {
    private static final Random random = new Random();

    public static PiecesList<Piece> generateRandomPieces(String type, Numbers numbers) {
        PieceFactory factory;
        List<Object> randomValues = new ArrayList<>();
        List<Piece> pieces = new ArrayList<>();

        if (type.equalsIgnoreCase("c")) {
            factory = new CharacterPieceFactory();
            while (randomValues.size() < numbers.getValue()) {
                char piece = (char) ('a' + random.nextInt(numbers.getValue()));
                if (!randomValues.contains(piece)) {
                    randomValues.add(piece);
                }
            }
        } else if (type.equalsIgnoreCase("n")) {
            factory = new NumberPieceFactory();
            while (randomValues.size() < numbers.getValue()) {
                int piece = random.nextInt(numbers.getValue()) + 1;
                if (!randomValues.contains(piece)) {
                    randomValues.add(piece);
                }
            }
        } else {
            return new PiecesList<>();
        }

        for (Object value : randomValues) {
            pieces.add(factory.createPiece(value));
        }

        return new PiecesList<>(pieces);
    }
}