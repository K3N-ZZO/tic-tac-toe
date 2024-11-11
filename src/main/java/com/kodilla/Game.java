package com.kodilla;

import java.io.*;
import java.util.Scanner;

public class Game {
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            Board board = null;
            boolean isPvP = true;
            int playerOneScore = 0;
            int playerTwoScore = 0;
            int computerScore = 0;
            boolean exit = false;

            while (!exit) {
                while (true) {
                    OutputDisplay.displayInstructions();
                    OutputDisplay.outputYourChoice();
                    String choice = scanner.nextLine();

                    if ("0".equals(choice)) {
                        exit = true;
                        OutputDisplay.outputThanksForPlaying();
                        break;
                    } else if ("1".equals(choice)) {
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
                    } else if ("5".equals(choice)) {
                        deleteSaveFile();
                    } else if ("6".equals(choice)) {
                        GameState loadedState = loadGame();
                        if (loadedState != null) {
                            board = loadedState.getBoard();
                            isPvP = loadedState.isPvP();
                            playerOneScore = loadedState.getPlayerOneScore();
                            playerTwoScore = loadedState.getPlayerTwoScore();
                            computerScore = loadedState.getComputerScore();
                            break;
                        } else {
                            OutputDisplay.outputLoadGameFailed();
                        }
                    } else {
                        OutputDisplay.outputWrongChoice();
                    }
                }

                if (exit) {
                    break;
                }

                boolean playAgain = true;
                while (playAgain) {
                    if (board == null) {
                        board = new Board(3);
                    }
                    board.clearBoard();
                    PlayerMove.setBoard(board);
                    ComputerMove.setBoard(board);

                    boolean gameOver = false;

                    while (!gameOver) {
                        OutputDisplay.displayBoard(board);

                        PlayerMove.playerOneMove();
                        OutputDisplay.displayBoard(board);

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
                            PlayerMove.playerTwoMove();
                        } else {
                            ComputerMove.makeMove(board);
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

                    OutputDisplay.displayBoard(board);
                    playAgain = isPlayAgain(playerOneScore, isPvP, playerTwoScore, computerScore, scanner);
                }

                saveGame(new GameState(board, isPvP, playerOneScore, playerTwoScore, computerScore));
            }
        }
    }

    private static boolean isPlayAgain(int playerOneScore, boolean isPvP, int playerTwoScore, int computerScore, Scanner scanner) {
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

    private static void saveGame(GameState gameState) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("gamestate.ser"));
            oos.writeObject(gameState);
            OutputDisplay.outputGameSaved();
        } catch (IOException e) {
            OutputDisplay.outputGameSaveFailed();
        }
    }

    private static GameState loadGame() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("gamestate.ser"))) {
            return (GameState) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    private static void deleteSaveFile() {
        File saveFile = new File("gamestate.ser");
        if (saveFile.exists()) {
            if (saveFile.delete()) {
                OutputDisplay.outputSaveFileDeleted();
            } else {
                OutputDisplay.outputSaveFileDeleteFailed();
            }
        } else {
            OutputDisplay.outputSaveFileNotFound();
        }
    }
}
