package com.kodilla;

import java.util.Random;

public class ComputerMove {
    private static Board board;

    public static void setBoard(Board board) {
        ComputerMove.board = board;
    }

    public static void makeMove() { //powinien otrzymac argument board
        Random random = new Random();  // przesunac wyzej jako pole klasy
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
        System.out.println("Komputer wykonał ruch na pozycji: " + (row + 1) + "," + (col + 1));
    }
}