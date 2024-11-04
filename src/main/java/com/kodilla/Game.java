package com.kodilla;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = null;
        boolean isPvP = true;

        int playerOneScore = 0;
        int playerTwoScore = 0;
        int computerScore = 0;

        try {
            while (true) {
                OutputDisplay.displayInstructions();
                OutputDisplay.outputYourChoice();
                String choice = scanner.nextLine();

                if ("1".equals(choice)) {
                    board = new Board(3);
                    break;
                } else if ("2".equals(choice)) {
                    board = new Board(10);
                    break;
                } else if ("3".equals(choice)) {
                    OutputDisplay.displayHowToPlay();
                } else if ("4".equals(choice)) {
                    board = chooseBoardSize(scanner);
                    isPvP = false;
                    break;
                } else {
                    OutputDisplay.outputWrongChoice();
                }
            }

            if (board == null) {
                OutputDisplay.outputDidntChoose();
                return;
            }

            BoardData boardData = new BoardData(board);

            boolean playAgain = true;
            while (playAgain) {
                board.clearBoard();
                PlayerMove.setBoard(board);
                ComputerMove.setBoard(board);

                boolean gameOver = false;

                while (!gameOver) {
                    boardData.displayBoard();

                    PlayerMove.playerOneMove(scanner);
                    boardData.displayBoard();


                    if (board.checkWin('X')) {
                        playerOneScore++;
                        OutputDisplay.outputPlayerXWon();
                        gameOver = true;
                    } else if (board.isFull()) {
                        OutputDisplay.outputDraw();
                        gameOver = true;
                    }
                    if (gameOver) {
                        break;
                    }

                    if (isPvP) {
                        PlayerMove.playerTwoMove(scanner);

                    } else {
                        ComputerMove.makeMove();

                    }


                    if (board.checkWin('O')) {
                        if (isPvP) {
                            playerTwoScore++;
                            OutputDisplay.outputPlayerOWon();
                        } else {
                            computerScore++;
                            OutputDisplay.outputComputerWon();
                        }
                        gameOver = true;
                    } else if (board.isFull()) {
                        gameOver = true;
                        OutputDisplay.outputDraw();
                    }

                }


                boardData.displayBoard();

                playAgain = isPlayAgain(playerOneScore, isPvP, playerTwoScore, computerScore, scanner);
            }
        } finally {
            scanner.close();
        }
    }

    private static boolean isPlayAgain(int playerOneScore, boolean isPvP, int playerTwoScore, int computerScore, Scanner scanner) {
        boolean playAgain;
        System.out.println("Wynik:");
        System.out.println("Gracz X: " + playerOneScore);
        if (isPvP) {
            System.out.println("Gracz O: " + playerTwoScore);
        } else {
            System.out.println("Komputer: " + computerScore);
        }
        while (true) {
            OutputDisplay.outputPlayAgain();
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("tak")) {
                return true;
            } else if (response.equals("nie")) {
                OutputDisplay.outputThanksForPlaying();
                return false;
            } else {
                OutputDisplay.outputWrongChoice();
            }
        }

    }

    private static Board chooseBoardSize(Scanner scanner) {
        while (true) {
            OutputDisplay.outputBoardSize();
            String choice = scanner.nextLine();
            if ("1".equals(choice)) {
                return new Board(3);
            } else if ("2".equals(choice)) {
                return new Board(10);
            } else {
                OutputDisplay.outputWrongChoice();
            }
        }
    }
}