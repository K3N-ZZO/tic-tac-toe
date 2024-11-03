package com.kodilla;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = null;
        boolean isPvP = true;

        try {
            while (true) {
                displayInstructions();
                System.out.print("Twój wybór: ");
                String choice = scanner.nextLine();

                if ("1".equals(choice)) {
                    board = new Board(3);
                    break;
                } else if ("2".equals(choice)) {
                    board = new Board(10);
                    break;
                } else if ("3".equals(choice)) {
                    GameInstructions.display();
                } else if ("4".equals(choice)) {
                    board = chooseBoardSize(scanner);
                    isPvP = false;
                    break;
                } else {
                    System.out.println("Nieprawidłowy wybór, spróbuj ponownie.");
                }
            }

            if (board == null) {
                System.out.println("Nie wybrano planszy. Koniec gry.");
                return;
            }

            BoardData boardData = new BoardData(board);
            PlayerMove.setBoard(board);
            boardData.startGame(isPvP, scanner);
        } finally {
            scanner.close();
        }
    }

    private static void displayInstructions() {
        System.out.println("Wybierz opcję:");
        System.out.println("1. Gra (Plansza 3x3) - Gracz vs Gracz");
        System.out.println("2. Gra (Plansza 10x10) - Gracz vs Gracz");
        System.out.println("3. Instrukcje obsługi");
        System.out.println("4. Gra z komputerem");
        System.out.print("Wprowadź numer opcji, aby kontynuować: ");
    }

    private static Board chooseBoardSize(Scanner scanner) {
        while (true) {
            System.out.println("Wybierz rozmiar planszy:");
            System.out.println("1. Plansza 3x3");
            System.out.println("2. Plansza 10x10");
            System.out.print("Twój wybór: ");
            String choice = scanner.nextLine();
            if ("1".equals(choice)) {
                return new Board(3);
            } else if ("2".equals(choice)) {
                return new Board(10);
            } else {
                System.out.println("Nieprawidłowy wybór, spróbuj ponownie.");
            }
        }
    }
}