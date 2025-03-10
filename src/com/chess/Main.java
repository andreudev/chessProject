package com.chess;

import com.chess.classes.ChessGame;

public class Main {
    public static void main(String[] args) {

        ChessGame chess = new ChessGame(args);
        chess.startGame();
    }
}