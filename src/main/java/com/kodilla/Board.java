package com.kodilla;

public class Board {
    private final char[][] board = {{' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}};

    public void printBoard() {
        System.out.println("|" + board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "|");
        System.out.println("|" + board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "|");
        System.out.println("|" + board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "|");
    }

    public char[][] getBoard() {
        return board;
    }

    //Zrobic metode na zaaktualizowanie board
    //Konstruktor z rozmiarem plnaszy petla wypelniajaca
}