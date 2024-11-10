package com.kodilla;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static int[] getPlayerMove(char player){
        if (player == 'X'){
            OutputDisplay.outputPlayerXMove();
        } else if (player == 'O') {
            OutputDisplay.outputPlayerOMove();
        }

        int row = scanner.nextInt() - 1;
        int col = scanner.nextInt() - 1;
        scanner.nextLine();

        return new int[]{ row,col };
    }
    public static void closeScanner(){
        scanner.close();
    }
}
