package com.kodilla;

public class BoardData {
    private Board board;

    public BoardData(Board board) {
        this.board = board;
    }

    void displayBoard() { //przeniesc to do outputdisplay usunac ta klase przekazac board jako argument
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