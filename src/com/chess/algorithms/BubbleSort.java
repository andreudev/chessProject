package com.chess.algorithms;

import com.chess.myinterfaces.SortingStrategy;
import com.chess.myinterfaces.BoardView;
import com.chess.classes.pieces.Piece;
import com.chess.arrays.PiecesList;

/**
 * The BubbleSort class implements the bubble sort algorithm for sorting pieces on a chessboard.
 *
 * @param <T> the type of elements to be sorted, which must be comparable
 */
public class BubbleSort<T extends Comparable<T>> implements SortingStrategy<T> {
    private final int interval;

    /**
     * Constructs a BubbleSort instance with the specified interval.
     *
     * @param interval the interval in milliseconds between each swap operation
     */
    public BubbleSort(int interval) {
        this.interval = interval;
    }

    /**
     * Sorts the given list of pieces using the bubble sort algorithm and updates the board view.
     *
     * @param list the list of pieces to be sorted
     * @param view the board view to be updated after each swap
     */
    @Override
    public void sort(PiecesList<T> list, BoardView view) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    view.displayBoard((PiecesList<Piece>) list);
                    try {
                        Thread.sleep(interval);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}