package com.kodilla;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board;
        boolean isPvP = true;

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
            PlayerMove.setBoard(board);
            boardData.startGame(isPvP, scanner);
        } finally {
            scanner.close();
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