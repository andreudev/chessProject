package com.chess.algorithms;

import com.chess.myinterfaces.SortingStrategy;
import com.chess.myinterfaces.BoardView;
import com.chess.classes.pieces.Piece;
import com.chess.arrays.PiecesList;

public class QuickSort<T extends Comparable<T>> implements SortingStrategy<T> {
    private final int interval;

    public QuickSort(int interval) {
        this.interval = interval;
    }

    @Override
    public void sort(PiecesList<T> list, BoardView view) {
        quickSort(list, 0, list.size() - 1, view);
    }

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