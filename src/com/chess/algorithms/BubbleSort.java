package com.chess.algorithms;

import com.chess.myinterfaces.SortingStrategy;
import com.chess.myinterfaces.BoardView;
import com.chess.classes.pieces.Piece;
import com.chess.arrays.PiecesList;

public class BubbleSort<T extends Comparable<T>> implements SortingStrategy<T> {
    private final int interval;

    public BubbleSort(int interval) {
        this.interval = interval;
    }

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