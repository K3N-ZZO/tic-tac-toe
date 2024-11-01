package com.kodilla;

public class OutputDisplay {
    static void fail(){
        System.out.println("Wrong input! ");
    }
    static void invalidPos(){
        System.out.println("Invalid position! ");
    }
    static void printXMove(){
        System.out.println("Give a number from 1 to 9 where to put X: ");
    }
    static void printOMove(){
        System.out.println("Give a number from 1 to 9 where to put O: ");
    }
    static void invalidXMove(){
        System.out.println("You cannot place X here! ");
    }
    static void invalidOMove(){
        System.out.println("You cannot place O here! ");
    }
    static void printTie(){
        System.out.println("Tie! Game Over! ");
    }
    static void drawSpace(){
        System.out.println("---------------");
    }
}
