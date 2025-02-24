package com.chess.enums;

import com.chess.algorithms.InsertionSort;
import com.chess.algorithms.QuickSort;
import com.chess.algorithms.BubbleSort;
import com.chess.myexceptions.AlgorithmTypeError;
import com.chess.myinterfaces.SortingStrategy;

public enum Algorithm {
    MERGE_SORT("Merge sort","m"), QUICK_SORT("Quick sort","q"), INSERTION_SORT("Insertion sort","i"), BUBBLE_SORT("Bubble sort","b");

    private final String algorithm;
    private final String algorithmInitial;

    Algorithm(String algorithm, String initial) {
        this.algorithmInitial = initial;
        this.algorithm = algorithm;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getAlgorithmInitial() {
        return algorithmInitial;
    }

    private static Algorithm fromString(String algorithm) throws AlgorithmTypeError {
        for (Algorithm algo : Algorithm.values()) {
            if (algo.algorithmInitial.equals(algorithm)) {
                return algo;
            }
        }
        throw new AlgorithmTypeError("Invalid algorithm: " + algorithm);
    }

    public static Algorithm checkFromString(String algorithm) {
        try {
            return fromString(algorithm);
        } catch (AlgorithmTypeError e) {
            e.printStackTrace();
            return null;
        }
    }

    public SortingStrategy<?> getSortingStrategy() {
        return switch (this) {
            case MERGE_SORT, QUICK_SORT -> new QuickSort<>();
            case INSERTION_SORT -> new InsertionSort<>();
            case BUBBLE_SORT -> new BubbleSort<>();
            default -> null;
        };
    }
}
