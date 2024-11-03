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
            System.out.print("Gracz X - wprowadź wiersz i kolumnę (1-3 dla planszy 3x3, 1-10 dla planszy 10x10): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            scanner.nextLine();

            try {
                validMove = board.makeMove(row, col, 'X');
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Nieprawidłowy ruch: przekroczenie zakresu planszy. Spróbuj ponownie.");
            } catch (IllegalArgumentException e) {
                System.out.println("Nieprawidłowy ruch: pole już zajęte. Spróbuj ponownie.");
            }
        }
    }

    public static void playerTwoMove(Scanner scanner) {
        boolean validMove = false;
        while (!validMove) {
            System.out.print("Gracz O - wprowadź wiersz i kolumnę (1-3 dla planszy 3x3, 1-10 dla planszy 10x10): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            scanner.nextLine();

            try {
                validMove = board.makeMove(row, col, 'O');
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Nieprawidłowy ruch: przekroczenie zakresu planszy. Spróbuj ponownie.");
            } catch (IllegalArgumentException e) {
                System.out.println("Nieprawidłowy ruch: pole już zajęte. Spróbuj ponownie.");
            }
        }
    }
}