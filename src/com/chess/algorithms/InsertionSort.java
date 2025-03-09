package com.chess.algorithms;

import com.chess.myinterfaces.SortingStrategy;
import com.chess.myinterfaces.BoardView;
import com.chess.classes.pieces.Piece;
import com.chess.arrays.PiecesList;

public class InsertionSort<T extends Comparable<T>> implements SortingStrategy<T> {
    private final int interval;

    public InsertionSort(int interval) {
        this.interval = interval;
    }

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