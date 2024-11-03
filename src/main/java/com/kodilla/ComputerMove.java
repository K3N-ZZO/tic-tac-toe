package com.kodilla;

import java.util.Random;

public class ComputerMove {
    private static Board board;

    public static void setBoard(Board board) {
        ComputerMove.board = board;
    }

    public static void makeMove() {
        Random random = new Random();
        boolean validMove = false;
        int row = 0, col = 0;

        while (!validMove) {
            row = random.nextInt(board.getSize());
            col = random.nextInt(board.getSize());
            try {
                validMove = board.makeMove(row, col, 'O');
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Komputer wykonał nieprawidłowy ruch: przekroczenie zakresu planszy.");
            } catch (IllegalArgumentException e) {
                System.out.println("Komputer wykonał nieprawidłowy ruch: pole już zajęte. Próbuje ponownie.");
            }
        }
        System.out.println("Komputer wykonał ruch na pozycji: " + (row + 1) + "," + (col + 1));
    }
}