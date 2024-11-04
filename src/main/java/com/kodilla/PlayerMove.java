package com.kodilla;

import java.util.Scanner;

public class PlayerMove {
    private static Board board;

    public static void setBoard(Board board) {
        PlayerMove.board = board;
    }

    public static void playerOneMove(Scanner scanner) {
        boolean validMove = false;
        while (!validMove) {
            OutputDisplay.outputPlayerXMove();
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            scanner.nextLine();

            try {
                validMove = board.makeMove(row, col, 'X');
            } catch (IndexOutOfBoundsException e) {
                OutputDisplay.outputIndexOutOfBounds();
            } catch (IllegalArgumentException e) {
                OutputDisplay.outputAlreadyTaken();
            }
        }
    }

    public static void playerTwoMove(Scanner scanner) {
        boolean validMove = false;
        while (!validMove) {
            OutputDisplay.outputPlayerOMove();
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            scanner.nextLine();

            try {
                validMove = board.makeMove(row, col, 'O');
            } catch (IndexOutOfBoundsException e) {
                OutputDisplay.outputIndexOutOfBounds();
            } catch (IllegalArgumentException e) {
                OutputDisplay.outputAlreadyTaken();
            }
        }
    }
}