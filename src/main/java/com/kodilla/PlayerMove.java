package com.kodilla;

import java.util.Scanner;

public class PlayerMove {
    static Board board;
    static Scanner scanner = new Scanner(System.in);

    public static void setBoard(Board board) {
        PlayerMove.board = board;
    }

    public static void playerOneMove() {
        boolean validMove = false;
        while (!validMove) {
            int[] move = InputHandler.getPlayerMove('X');
            int row = move[0];
            int col = move[1];

            try {
                validMove = board.makeMove(row, col, 'X');
            } catch (IndexOutOfBoundsException e) {
                OutputDisplay.outputIndexOutOfBounds();
            } catch (IllegalArgumentException e) {
                OutputDisplay.outputAlreadyTaken();
            }
        }
    }

    public static void playerTwoMove() {
        boolean validMove = false;
        while (!validMove) {
            int[] move = InputHandler.getPlayerMove('O');
            int row = move[0];
            int col = move[1];


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