package com.kodilla;

import java.util.Random;

public class ComputerMove {
    private static Board board;

    public static void setBoard(Board board) {
        ComputerMove.board = board;
    }

    public static void makeMove() {
        Random random = new Random();
        int row, col;

        do {
            row = random.nextInt(board.getSize());
            col = random.nextInt(board.getSize());
        } while (!board.makeMove(row, col, 'O'));

        System.out.println("Komputer wykonał ruch na pozycji: " + (row + 1) + ", " + (col + 1));
    }
}