package com.chess.myinterfaces;

import java.util.List;

public interface SortingStrategy <T extends Comparable<T>>{
    void sort(List<T> list);
}
