package com.kodilla;

import java.util.Scanner;


public class BoardData {
    private final Board board;

    public BoardData(Board board) {
        this.board = board;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean playerOneTurn = true;

        while (true) {
            board.printBoard();
            System.out.println("----------");

            if (gameOver(board)) {
                break;
            }

//something new happend here
            if (playerOneTurn) {
                playerOneMove(scanner);
                playerOneTurn = false;
            } else {
                playerTwoMove(scanner);
                playerOneTurn = true;
            }

        }
    }

    private static boolean gameOver(Board board) { //zmienic nazwe

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
        System.out.println("Tie! Game over!");
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
            System.out.println("Player " +symbol+ " won!");
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
        return board.getBoard()[row][col] == ' ';
    }

    public void placeMark(int position, char mark) {
        if (position < 1 || position > 9) {
            System.out.println("Invalid position!");
            return;
        }

        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        board.getBoard()[row][col] = mark;
    }

    public void playerOneMove(Scanner scanner) { //Stworzyc klase gracza
        System.out.println("Give a number from 1 to 9 where to put X: ");
        String input = scanner.nextLine();
        int position = Integer.parseInt(input);
        if (isSpaceAvailable(board, position) && position <= 9) {
            placeMark(position, 'X');
        } else {
            System.out.println("You cannot put X here!");
            board.printBoard();
            playerOneMove(scanner);
        }
    }


    public void playerTwoMove(Scanner scanner) {
        System.out.println("Give a number from 1 to 9 where to put O: ");
        String input = scanner.nextLine();
        int position = Integer.parseInt(input);
        if (isSpaceAvailable(board, position) && position <= 9) {
            placeMark(position, 'O');
        } else {
            System.out.println("You cannot put O here!");
            board.printBoard();
            playerTwoMove(scanner);
        }
    }


}
