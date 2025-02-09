package com.chess.myexceptions;

public class DataTypeError extends IllegalArgumentException {
  public DataTypeError(String message) {
    super(message);
  }
}
