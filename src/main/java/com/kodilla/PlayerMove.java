package com.kodilla;

import java.util.Scanner;

public class PlayerMove {
    private static Board board;

    public static void setBoard(Board board) {
        PlayerMove.board = board;
    }

    public static void playerOneMove(Scanner scanner) {
        System.out.print("Gracz X - wprowadź wiersz i kolumnę (dla planszy 3x3 od 1 do 3, dla planszy 10x10 od 1 do 10): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Próbujesz wykonać ruch w wierszu: " + row + ", kolumnie: " + col);
        row -= 1;
        col -= 1;
        if (!board.makeMove(row, col, 'X')) {
            System.out.println("Nieprawidłowy ruch, spróbuj ponownie.");
            playerOneMove(scanner);
        }
    }

    public static void playerTwoMove(Scanner scanner) {
        System.out.print("Gracz O - wprowadź wiersz i kolumnę (dla planszy 3x3 od 1 do 3, dla planszy 10x10 od 1 do 10): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Próbujesz wykonać ruch w wierszu: " + row + ", kolumnie: " + col);
        row -= 1;
        col -= 1;
        if (!board.makeMove(row, col, 'O')) {
            System.out.println("Nieprawidłowy ruch, spróbuj ponownie.");
            playerTwoMove(scanner);
        }
    }
}