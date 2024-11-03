package com.kodilla;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    public void testWinOInRow() {
        Board board = new Board(3);
        board.makeMove(0, 0, 'O');
        board.makeMove(0, 1, 'O');
        board.makeMove(0, 2, 'O');
        assertTrue(board.checkWin('O'));
    }

    @Test
    public void testWinOInRow10x10() {
        Board board = new Board(10);
        for (int i = 0; i < 5; i++) {
            board.makeMove(0, i, 'O');
        }
        assertTrue(board.checkWin('O'));
    }
    @Test
    public void testWinOInColumn() {
        Board board = new Board(3);
        board.makeMove(0, 0, 'O');
        board.makeMove(1, 0, 'O');
        board.makeMove(2, 0, 'O');
        assertTrue(board.checkWin('O'));
    }

    @Test
    public void testWinOInColumn10x10() {
        Board board = new Board(10);
        for (int i = 0; i < 5; i++) {
            board.makeMove(i, 0, 'O');
        }
        assertTrue(board.checkWin('O'));
    }

    @Test
    public void testWinOInDiagonal() {
        Board board = new Board(3);
        board.makeMove(0, 0, 'O');
        board.makeMove(1, 1, 'O');
        board.makeMove(2, 2, 'O');
        assertTrue(board.checkWin('O'));
    }

    @Test
    public void testWinOInAntiDiagonal() {
        Board board = new Board(3);
        board.makeMove(0, 2, 'O');
        board.makeMove(1, 1, 'O');
        board.makeMove(2, 0, 'O');
        assertTrue(board.checkWin('O'));
    }

    @Test
    public void testWinOInDiagonal10x10() {
        Board board = new Board(10);
        for (int i = 0; i < 5; i++) {
            board.makeMove(i, i, 'O');
        }
        assertTrue(board.checkWin('O'));
    }

    @Test
    public void testWinOInAntiDiagonal10x10() {
        Board board = new Board(10);
        for (int i = 0; i < 5; i++) {
            board.makeMove(i, 4 - i, 'O');
        }
        assertTrue(board.checkWin('O'));
    }
    @Test
    public void testWinXInRow() {
        Board board = new Board(3);
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'X');
        board.makeMove(0, 2, 'X');
        assertTrue(board.checkWin('X'));
    }

    @Test
    public void testWinXInRow10x10() {
        Board board = new Board(10);
        for (int i = 0; i < 5; i++) {
            board.makeMove(0, i, 'X');
        }
        assertTrue(board.checkWin('X'));
    }

    @Test
    public void testWinXInColumn() {
        Board board = new Board(3);
        board.makeMove(0, 0, 'X');
        board.makeMove(1, 0, 'X');
        board.makeMove(2, 0, 'X');
        assertTrue(board.checkWin('X'));
    }

    @Test
    public void testWinXInColumn10x10() {
        Board board = new Board(10);
        for (int i = 0; i < 5; i++) {
            board.makeMove(i, 0, 'X');
        }
        assertTrue(board.checkWin('X'));
    }

    @Test
    public void testWinXInDiagonal() {
        Board board = new Board(3);
        board.makeMove(0, 0, 'X');
        board.makeMove(1, 1, 'X');
        board.makeMove(2, 2, 'X');
        assertTrue(board.checkWin('X'));
    }

    @Test
    public void testWinXInAntiDiagonal() {
        Board board = new Board(3);
        board.makeMove(0, 2, 'X');
        board.makeMove(1, 1, 'X');
        board.makeMove(2, 0, 'X');
        assertTrue(board.checkWin('X'));
    }

    @Test
    public void testWinXInDiagonal10x10() {
        Board board = new Board(10);
        for (int i = 0; i < 5; i++) {
            board.makeMove(i, i, 'X');
        }
        assertTrue(board.checkWin('X'));
    }

    @Test
    public void testWinXInAntiDiagonal10x10() {
        Board board = new Board(10);
        for (int i = 0; i < 5; i++) {
            board.makeMove(i, 4 - i, 'X');
        }
        assertTrue(board.checkWin('X'));
    }

    @Test
    public void testDraw() {
        Board board = new Board(3);
        // XOX
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'O');
        board.makeMove(0, 2, 'X');

        // OXO
        board.makeMove(1, 0, 'O');
        board.makeMove(1, 1, 'X');
        board.makeMove(1, 2, 'O');

        // XOX
        board.makeMove(2, 0, 'X');
        board.makeMove(2, 1, 'O');
        board.makeMove(2, 2, 'X');

        assertTrue(board.isFull());
    }

    @Test
    public void testDraw10x10() {
        Board board = new Board(10);
        // Naprzemienny wzorzec X i O
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board.makeMove(i, j, (i + j) % 2 == 0 ? 'X' : 'O');
            }
        }

        assertTrue(board.isFull());
    }

    @Test
    public void testInvalidMoveThrowsException() {
        Board board = new Board(3);

        // Przekroczenie zakresu planszy
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            board.makeMove(3, 3, 'X');
        });
        assertEquals("Nieprawidłowy ruch", exception.getMessage());

        // Pola już zajęte
        board.makeMove(0, 0, 'X');
        exception = assertThrows(IllegalArgumentException.class, () -> {
            board.makeMove(0, 0, 'O');
        });
        assertEquals("Pole już zajęte", exception.getMessage());
    }
}
