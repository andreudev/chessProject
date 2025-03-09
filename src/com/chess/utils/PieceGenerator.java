package com.chess.utils;

import com.chess.arrays.PiecesList;
import com.chess.enums.Numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PieceGenerator {
    private static final Random random = new Random();

    public static PiecesList<?> generateRandomPieces(String type, Numbers numbers) {
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