package com.kodilla;

import java.util.Scanner;

import static com.kodilla.BoardData.isSpaceAvailable;

public class PlayerMove {
    public void playerOneMove(Scanner scanner) { //Stworzyc klase gracza
        final Board board;

        System.out.println("Give a number from 1 to 9 where to put X: ");
        String input = scanner.nextLine();
        int position = Integer.parseInt(input);
        if (isSpaceAvailable(getBoard.board, position) && position <= 9) {
            placeMark(position, 'X');
        } else {
            System.out.println("You cannot put X here!");
            board.printBoard();
            playerOneMove(scanner);
        }
    }
}
