package com.kodilla;

import org.junit.jupiter.api.Test;

import static com.kodilla.PlayerMove.board; // Zakładam, że `board` jest importowaną klasą
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTestSuite {

    @Test
    public void testOWinsInRow() {
        // Zupełnie nowa gra
        TicTacToe game = new TicTacToe();
        board.makeMove(0, 0); // X move
        board.makeMove(1, 0); // O move
        board.makeMove(0, 1); // X move
        board.makeMove(1, 1); // O move
        board.makeMove(2, 0); // X move
        board.makeMove(1, 2); // O move

        assertEquals('O', game.checkWinner());
    }

    @Test
    public void testOWinsInColumn() {
        TicTacToe game = new TicTacToe();
        board.makeMove(0, 0); // X move
        board.makeMove(0, 1); // O move
        board.makeMove(1, 0); // X move
        board.makeMove(1, 1); // O move
        board.makeMove(2, 2); // X move
        board.makeMove(2, 1); // O move

        assertEquals('O', game.checkWinner());
    }

    @Test
    public void testOWinsInDiagonal() {
        TicTacToe game = new TicTacToe();
        board.makeMove(0, 0); // X move
        board.makeMove(0, 2); // O move
        board.makeMove(1, 2); // X move
        board.makeMove(1, 1); // O move
        board.makeMove(2, 1); // X move
        board.makeMove(2, 0); // O move

        assertEquals('O', game.checkWinner());
    }

    @Test
    public void testXWinsInRow() {
        TicTacToe game = new TicTacToe();
        board.makeMove(0, 0); // X move
        board.makeMove(1, 0); // O move
        board.makeMove(0, 1); // X move
        board.makeMove(1, 1); // O move
        board.makeMove(0, 2); // X move

        assertEquals('X', game.checkWinner());
    }

    @Test
    public void testXWinsInColumn() {
        TicTacToe game = new TicTacToe();
        board.makeMove(0, 0); // X move
        board.makeMove(1, 1); // O move
        board.makeMove(1, 0); // X move
        board.makeMove(2, 2); // O move
        board.makeMove(2, 0); // X move

        assertEquals('X', game.checkWinner());
    }

    @Test
    public void testXWinsInDiagonal() {
        TicTacToe game = new TicTacToe();
        board.makeMove(0, 0); // X move
        board.makeMove(1, 0); // O move
        board.makeMove(1, 1); // X move
        board.makeMove(2, 0); // O move
        board.makeMove(2, 2); // X move

        assertEquals('X', game.checkWinner());
    }

    @Test
    public void testGameDraw() {
        TicTacToe game = new TicTacToe();
        board.makeMove(0, 0);
        board.makeMove(0, 1);
        board.makeMove(0, 2);
        board.makeMove(1, 0);
        board.makeMove(1, 1);
        board.makeMove(1, 2);
        board.makeMove(2, 0);
        board.makeMove(2, 2);
        board.makeMove(2, 1);

        char winner = game.checkWinner();
        assertFalse(winner == 'X' || winner == 'O');
        assertTrue(game.isDraw());
    }

    @Test
    public void testInvalidMoveThrowsException() {
        TicTacToe game = new TicTacToe();
        board.makeMove(0, 0);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            board.makeMove(0, 0);
        });
        assertEquals("Invalid move", thrown.getMessage());
    }
}