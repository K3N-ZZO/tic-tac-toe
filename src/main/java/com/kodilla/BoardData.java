package com.kodilla;

import java.util.Scanner;

public class BoardData {
    private final Board board;

    public BoardData(Board board) {
        this.board = board;
    }

    public void startGame(boolean isPvP, Scanner scanner) {
        char currentPlayer = 'X';
        boolean gameWon = false;

        ComputerMove.setBoard(board);

        while (!board.isFull() && !gameWon) {
            OutputDisplay.outputActualBoard();
            displayBoard();


            if (isPvP || currentPlayer == 'X') {
                if (currentPlayer == 'X') {
                    PlayerMove.playerOneMove(scanner);
                } else {
                    PlayerMove.playerTwoMove(scanner);
                }
            } else {
                ComputerMove.makeMove();
            }

            gameWon = board.checkWin(currentPlayer);
            if (!gameWon) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        OutputDisplay.outputEndGame();
        displayBoard();
        if (gameWon) {
            System.out.println("Gracz " + currentPlayer + " wygrał!");
        } else {
            OutputDisplay.outputDraw();
        }
    }

    private void displayBoard() {
        int size = board.getSize();
        char[][] boardArray = board.getBoard();

        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                System.out.print(" " + boardArray[i][j]);
                if (j < size - 1) {
                    System.out.print(" |");
                }
            }
            System.out.println();
            if (i < size - 1) {
                for (int j = 0; j < size; j++) {
                    System.out.print("---");
                    if (j < size - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}