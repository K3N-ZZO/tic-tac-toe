package com.kodilla;

import java.util.Scanner;

import static com.kodilla.BoardData.isSpaceAvailable;
import static com.kodilla.BoardData.placeMark;

public class PlayerMove {

    public void playerOneMove(Scanner scanner) { //Stworzyc klase gracza
        OutputDisplay.printXMove();
        String input = scanner.nextLine();
        int position = Integer.parseInt(input);
        if (isSpaceAvailable(board, position) && position <= 9) {
            placeMark(position, 'X');
        } else {
            OutputDisplay.invalidXMove();
            board.printBoard();
            playerOneMove(scanner);
        }
    }


    public void playerTwoMove(Scanner scanner) {
        OutputDisplay.printOMove();
        String input = scanner.nextLine();
        int position = Integer.parseInt(input);
        if (isSpaceAvailable(board, position) && position <= 9) {
            placeMark(position, 'O');
        } else {
            OutputDisplay.invalidOMove();
            BoardData.board.printBoard();
            playerTwoMove(scanner);
        }
    }
}
