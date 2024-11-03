package com.kodilla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTestSuite {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board(3);
    }

    @Test
    public void testInitializeBoard() {
        char[][] expectedBoard = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        assertArrayEquals(expectedBoard, board.getBoard(), "Plansza powinna być zainicjalizowana pustymi polami.");
    }

    @Test
    public void testMakeMoveValid() {
        assertTrue(board.makeMove(0, 0, 'X'), "Ruch powinien być prawidłowy.");
        assertEquals('X', board.getBoard()[0][0], "Pole powinno być oznaczone jako 'X'.");
    }

    @Test
    public void testMakeMoveInvalid() {
        board.makeMove(0, 0, 'X');
        assertFalse(board.makeMove(0, 0, 'O'), "Ruch powinien być nieprawidłowy, ponieważ pole jest już zajęte.");
        assertEquals('X', board.getBoard()[0][0], "Pole powinno pozostać oznaczone jako 'X'.");
    }

    @Test
    public void testIsFullWhenNotFull() {
        assertFalse(board.isFull(), "Plansza powinna być uznana za niepełną.");
    }

    @Test
    public void testIsFullWhenFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.makeMove(i, j, 'X');
            }
        }
        assertTrue(board.isFull(), "Plansza powinna być uznana za pełną.");
    }

    @Test
    public void testCheckWinHorizontal() {
        for (int i = 0; i < 3; i++) {
            board.makeMove(0, i, 'X');
        }
        assertTrue(board.checkWin('X'), "Gracz 'X' powinien wygrać poziomo.");
    }

    @Test
    public void testCheckWinVertical() {
        for (int i = 0; i < 3; i++) {
            board.makeMove(i, 0, 'X');
        }
        assertTrue(board.checkWin('X'), "Gracz 'X' powinien wygrać pionowo.");
    }

    @Test
    public void testCheckWinDiagonal() {
        for (int i = 0; i < 3; i++) {
            board.makeMove(i, i, 'X');
        }
        assertTrue(board.checkWin('X'), "Gracz 'X' powinien wygrać na przekątnej.");
    }

    @Test
    public void testCheckWinAntiDiagonal() {
        for (int i = 0; i < 3; i++) {
            board.makeMove(i, 2 - i, 'X');
        }
        assertTrue(board.checkWin('X'), "Gracz 'X' powinien wygrać na antydiagonalnej.");
    }
}