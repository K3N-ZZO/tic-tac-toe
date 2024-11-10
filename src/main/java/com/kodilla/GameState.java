package com.kodilla;

import java.io.Serializable;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;
    private Board board;
    private boolean isPvP;
    private int playerOneScore;
    private int playerTwoScore;
    private int computerScore;

    public GameState(Board board, boolean isPvP, int playerOneScore, int playerTwoScore, int computerScore) {
        this.board = board;
        this.isPvP = isPvP;
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
        this.computerScore = computerScore;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isPvP() {
        return isPvP;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    public int getComputerScore() {
        return computerScore;
    }
}
