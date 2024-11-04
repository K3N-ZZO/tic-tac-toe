package com.kodilla;

public class OutputDisplay {

    public static void outputPlayerXWon() {
        System.out.println("Gracz X wygrał! ");
    }

    public static void outputPlayerOWon() {
        System.out.println("Gracz O wygrał! ");
    }

    public static void outputComputerWon() {
        System.out.println("Komputer wygrał! ");
    }

    public static void outputDraw() {
        System.out.println("Remis!");
    }

    public static void outputWrongChoice() {
        System.out.println("Nieprawidłowy wybór, spróbuj ponownie.");
    }

    public static void outputDidntChoose() {
        System.out.println("Nie wybrano planszy. Koniec gry.");
    }

    public static void displayInstructions() {
        System.out.println("Wybierz opcję:");
        System.out.println("1. Gra (Plansza 3x3) - Gracz vs Gracz");
        System.out.println("2. Gra (Plansza 10x10) - Gracz vs Gracz");
        System.out.println("3. Instrukcja obsługi");
        System.out.println("4. Gra z komputerem");
        System.out.print("Wprowadź numer opcji, aby kontynuować: ");
    }

    public static void outputYourChoice() {
        System.out.println("Twój wybór: ");
    }


    public static void outputBoardSize() {
        System.out.println("Wybierz rozmiar planszy:");
        System.out.println("1. Plansza 3x3");
        System.out.println("2. Plansza 10x10");
        System.out.print("Twój wybór: ");
    }

    public static void displayHowToPlay() {
        System.out.println("Instrukcja obsługi:");
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

    public static void outputPlayerXMove() {
        System.out.print("Gracz X - wprowadź wiersz i kolumnę (1-3 dla planszy 3x3, 1-10 dla planszy 10x10): ");
    }

    public static void outputPlayerOMove() {
        System.out.print("Gracz O - wprowadź wiersz i kolumnę (1-3 dla planszy 3x3, 1-10 dla planszy 10x10): ");
    }

    public static void outputIndexOutOfBounds() {
        System.out.println("Nieprawidłowy ruch: przekroczenie zakresu planszy. Spróbuj ponownie.");
    }

    public static void outputAlreadyTaken() {
        System.out.println("Nieprawidłowy ruch: pole już zajęte. Spróbuj ponownie.");
    }

    public static void outputComputerIndexOutOfBounds() {
        System.out.println("Komputer wykonał nieprawidłowy ruch: przekroczenie zakresu planszy.");
    }

    public static void outputComputerAlreadyTaken() {
        System.out.println("Komputer wykonał nieprawidłowy ruch: pole już zajęte. Próbuje ponownie.");
    }

    public static void outputPlayAgain() {
        System.out.print("Czy chcesz zagrać ponownie? (tak/nie): ");
    }
    public static void outputThanksForPlaying(){
        System.out.println("Dziękuję za grę! Do zobaczenia!");
    }
}