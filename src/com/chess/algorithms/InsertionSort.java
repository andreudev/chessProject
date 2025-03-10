package com.chess.algorithms;

import com.chess.myinterfaces.SortingStrategy;
import com.chess.myinterfaces.BoardView;
import com.chess.classes.pieces.Piece;
import com.chess.arrays.PiecesList;

/**
 * The InsertionSort class implements the insertion sort algorithm for sorting pieces on a chessboard.
 *
 * @param <T> the type of elements to be sorted, which must be comparable
 */
public class InsertionSort<T extends Comparable<T>> implements SortingStrategy<T> {
    private final int interval;

    /**
     * Constructs an InsertionSort instance with the specified interval.
     *
     * @param interval the interval in milliseconds between each insertion operation
     */
    public InsertionSort(int interval) {
        this.interval = interval;
    }

    /**
     * Sorts the given list of pieces using the insertion sort algorithm and updates the board view.
     *
     * @param list the list of pieces to be sorted
     * @param view the board view to be updated after each insertion
     */
    @Override
    public void sort(PiecesList<T> list, BoardView view) {
        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j = j - 1;
                view.displayBoard((PiecesList<Piece>) list);
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            list.set(j + 1, key);
            view.displayBoard((PiecesList<Piece>) list);
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}