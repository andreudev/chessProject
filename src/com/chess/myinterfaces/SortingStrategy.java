package com.chess.myinterfaces;

import com.chess.arrays.PiecesList;

public interface SortingStrategy<T extends Comparable<T>> {
    void sort(PiecesList<T> list, BoardView view);
}