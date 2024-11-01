package com.kodilla;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------Tic Tac Toe Game---------");
        Board board = new Board();
        BoardData boardData = new BoardData(board);
        boardData.startGame();

    }
}
