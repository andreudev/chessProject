package com.chess.arrays;

import com.chess.algorithms.BubbleSort;
import com.chess.myinterfaces.SortingStrategy;
import com.chess.myinterfaces.BoardView;

import java.util.*;

public class PiecesList<T extends Comparable<T>> extends AbstractList<T> {
    private final List<T> pieces;
    private SortingStrategy<T> sortingStrategy;

    public PiecesList(List<T> pieces) {
        this.pieces = pieces;
        this.sortingStrategy = new BubbleSort<>();
    }

    public PiecesList() {
        this.pieces = new ArrayList<>();
    }

    public void setSortingStrategy(SortingStrategy<?> sortingStrategy) {
        this.sortingStrategy = (SortingStrategy<T>) sortingStrategy;
    }

    public void sort(BoardView view) {
        sortingStrategy.sort(this, view);
    }

    @Override
    public int size() {
        return pieces.size();
    }

    @Override
    public T get(int index) {
        return pieces.get(index);
    }

    @Override
    public T set(int index, T element) {
        return pieces.set(index, element);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PiecesList<?> that = (PiecesList<?>) o;
        return Objects.equals(pieces, that.pieces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieces);
    }
}