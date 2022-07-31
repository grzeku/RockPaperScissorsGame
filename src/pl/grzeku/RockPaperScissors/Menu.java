package pl.grzeku.RockPaperScissors;

import java.io.IOException;
import java.util.Scanner;

public class Menu {


    public static void main(String[] args) throws IOException {

        int END_OF_GAME = 4;
        spacer();
        intro();

        Scanner scanner = new Scanner(System.in);
        FinalScore lastScore = null;
        int whatToDo = 0;
        do {
            gameMenu();
            whatToDo = scanner.nextInt();

            spacer();

            switch (whatToDo) {
                case 1 -> lastScore = RockPaperScissorsGame.game();
                case 2 -> Scoreboard.scores(lastScore);
                case 3 -> new SaveToFile();
            }

        } while (whatToDo != END_OF_GAME);
    }

    private static void intro() {
        System.out.println("Welcome to Rock, Paper, Scissors game");
    }

    public static void gameMenu() {
        System.out.println("\n\tPress 1 to play \n\tPress 2 check scoreboard \n\tPress 3 to save and quit \n\tPress 4 to quit");
    }

    public static void spacer() {
        System.out.println("********************************");
    }
}
