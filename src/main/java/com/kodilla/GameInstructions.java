package com.kodilla;

public class GameInstructions {
    public static void display() {
        System.out.println("Instrukcje obsługi:");
        System.out.println("1. Gra polega na umieszczaniu znaków 'X' lub 'O' na planszy.");
        System.out.println("2. Dwóch graczy gra naprzemiennie.");
        System.out.println("3. Aby wygrać:");
        System.out.println("   - W planszy 3x3: Gracz musi ustawić 3 swoje znaki w linii poziomej, pionowej lub ukośnej.");
        System.out.println("   - W planszy 10x10: Gracz musi ustawić 5 swoich znaków w linii poziomej, pionowej lub ukośnej.");
        System.out.println("4. Każdy ruch polega na podaniu współrzędnych w postaci: numer_wiersza numer_kolumny.");
        System.out.println("5. Współrzędne podawane są od 1 do rozmiaru planszy (np. dla 3x3 od 1 do 3, dla 10x10 od 1 do 10).");
        System.out.println("6. Gra kończy się remisem, gdy wszystkie pola są zajęte i żaden z graczy nie wygrał.");
        System.out.println("Wróć do menu i wybierz opcję gry, aby rozpocząć!");
    }
}