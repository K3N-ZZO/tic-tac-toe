package com.kodilla;

import java.util.Random;

public class ComputerMove {
    private static Board board;
    static Random random = new Random();

    public static void setBoard(Board board) {
        ComputerMove.board = board;
    }

    public static void makeMove(Board board) {
        boolean validMove = false;
        int row = 0, col = 0;

        while (!validMove) {
            row = random.nextInt(board.getSize());
            col = random.nextInt(board.getSize());
            try {
                validMove = board.makeMove(row, col, 'O');
            } catch (IndexOutOfBoundsException e) {
                OutputDisplay.outputComputerIndexOutOfBounds();
            } catch (IllegalArgumentException e) {
                OutputDisplay.outputComputerAlreadyTaken();
            }
        }
        OutputDisplay.outputComputerMove((row + 1),(col + 1));
    }
}