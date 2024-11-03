package com.kodilla;

public class Board {
    private final int size;
    private final char[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new char[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public int getSize() {
        return size;
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean makeMove(int row, int col, char player) {
        if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == ' ') {
            board[row][col] = player;
            return true;
        } else {
            System.out.println("Ruch (" + (row + 1) + ", " + (col + 1) + ") jest nieprawidłowy. Spróbuj ponownie.");
            return false;
        }
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(char player) {
        int winCondition = (size == 3) ? 3 : 5;


        for (int row = 0; row < size; row++) {
            if (checkLine(player, winCondition, board[row])) {
                return true;
            }
        }


        for (int col = 0; col < size; col++) {
            char[] column = new char[size];
            for (int row = 0; row < size; row++) {
                column[row] = board[row][col];
            }
            if (checkLine(player, winCondition, column)) {
                return true;
            }
        }

        // Check diagonals and anti-diagonals
        if (checkDiagonals(player, winCondition)) {
            return true;
        }

        return false;
    }

    private boolean checkLine(char player, int winCondition, char[] line) {
        int count = 0;
        for (char cell : line) {
            if (cell == player) {
                count++;
                if (count == winCondition) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkDiagonals(char player, int winCondition) {
        int count;

        // Check main diagonals
        for (int start = 0; start <= size - winCondition; start++) {
            count = 0;
            for (int i = 0; i < size - start; i++) {
                if (board[start + i][i] == player) {
                    count++;
                    if (count == winCondition) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }

            count = 0;
            for (int i = 0; i < size - start; i++) {
                if (board[i][start + i] == player) {
                    count++;
                    if (count == winCondition) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Check anti-diagonals
        for (int start = 0; start <= size - winCondition; start++) {
            count = 0;
            for (int i = 0; i < size - start; i++) {
                if (board[start + i][size - 1 - i] == player) {
                    count++;
                    if (count == winCondition) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }

            count = 0;
            for (int i = 0; i < size - start; i++) {
                if (board[i][size - 1 - (start + i)] == player) {
                    count++;
                    if (count == winCondition) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        return false;
    }
}