package com.kodilla;

import javax.print.attribute.standard.MediaSize;
import java.util.Scanner;


public class BoardData {
    public static final Board board = mark;

    public BoardData(Board board) {
        this.board = board;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean playerOneTurn = true;


        while (true) {
            board.printBoard();
            OutputDisplay.drawSpace();

            if (checkIsGameOver(board)) {
                break;
            }

            if (playerOneTurn) {
                playerOneMove(scanner);
                playerOneTurn = false;
            } else {
                playerTwoMove(scanner);
                playerOneTurn = true;
            }

        }
    }

    private static boolean checkIsGameOver(Board board) { //zmienic nazwe

        char[][] boardArray = board.getBoard();

        if (userWon(boardArray, 'X')) {
            return true;
        } else if (userWon(boardArray, 'O')){
            return true;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getBoard()[i][j] == ' ') {
                    return false;
                }
            }
        }
        OutputDisplay.printTie();
        return true;
    }

    private static boolean userWon(char[][] boardArray, char symbol) {
        if ((boardArray[0][0] == symbol && boardArray[0][1] == symbol && boardArray[0][2] == symbol) ||
                (boardArray[1][0] == symbol && boardArray[1][1] == symbol && boardArray[1][2] == symbol) ||
                (boardArray[2][0] == symbol && boardArray[2][1] == symbol && boardArray[2][2] == symbol) ||

                (boardArray[0][0] == symbol && boardArray[1][0] == symbol && boardArray[2][0] == symbol) ||
                (boardArray[0][1] == symbol && boardArray[1][1] == symbol && boardArray[2][1] == symbol) ||
                (boardArray[0][2] == symbol && boardArray[1][2] == symbol && boardArray[2][2] == symbol) ||

                (boardArray[0][0] == symbol && boardArray[1][1] == symbol && boardArray[2][2] == symbol) ||
                (boardArray[0][2] == symbol && boardArray[1][1] == symbol && boardArray[2][0] == symbol)) {
            System.out.println("Player " + symbol + " won!");
            return true;
        }
        return false;
    }

    public static boolean isSpaceAvailable(Board board, int position) {

        if (position < 1 || position > 9) {
            return false;
        }
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        OutputDisplay.invalidPos();
        return board.getBoard()[row][col] == ' ';
    }

    public static void placeMark(int position, char mark) {
        if (position < 1 || position > 9) {

            return;
        }

        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        board.getBoard()[row][col] = mark;
    }



}
