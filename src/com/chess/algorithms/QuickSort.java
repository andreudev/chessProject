package com.chess.algorithms;

import com.chess.myinterfaces.SortingStrategy;
import com.chess.myinterfaces.BoardView;
import com.chess.classes.pieces.Piece;
import com.chess.arrays.PiecesList;

/**
 * The QuickSort class implements the quick sort algorithm for sorting pieces on a chessboard.
 *
 * @param <T> the type of elements to be sorted, which must be comparable
 */
public class QuickSort<T extends Comparable<T>> implements SortingStrategy<T> {
    private final int interval;

    /**
     * Constructs a QuickSort instance with the specified interval.
     *
     * @param interval the interval in milliseconds between each partition operation
     */
    public QuickSort(int interval) {
        this.interval = interval;
    }

    /**
     * Sorts the given list of pieces using the quick sort algorithm and updates the board view.
     *
     * @param list the list of pieces to be sorted
     * @param view the board view to be updated after each partition
     */
    @Override
    public void sort(PiecesList<T> list, BoardView view) {
        quickSort(list, 0, list.size() - 1, view);
    }

    /**
     * Recursively sorts the sublists of the given list using the quick sort algorithm.
     *
     * @param list the list of pieces to be sorted
     * @param low the starting index of the sublist to be sorted
     * @param high the ending index of the sublist to be sorted
     * @param view the board view to be updated after each partition
     */
    private void quickSort(PiecesList<T> list, int low, int high, BoardView view) {
        if (low < high) {
            int pi = partition(list, low, high, view);
            view.displayBoard((PiecesList<Piece>) list);
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            quickSort(list, low, pi - 1, view);
            quickSort(list, pi + 1, high, view);
        }
    }

    /**
     * Partitions the given list around a pivot element and updates the board view.
     *
     * @param list the list of pieces to be partitioned
     * @param low the starting index of the sublist to be partitioned
     * @param high the ending index of the sublist to be partitioned
     * @param view the board view to be updated after each swap
     * @return the index of the pivot element after partitioning
     */
    private int partition(PiecesList<T> list, int low, int high, BoardView view) {
        T pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) < 0) {
                i++;
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                view.displayBoard((PiecesList<Piece>) list);
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        T temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        view.displayBoard((PiecesList<Piece>) list);
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return i + 1;
    }
}