package pl.grzeku.RockPaperScissors;


import java.util.Scanner;

public class RockPaperScissorsGame {

    static FinalScore game() {

        Scanner inputScanner = new Scanner(System.in);
        int userWinCounter = 0;
        int computerWinCounter = 0;
        int numberOfGames = 0;

        String move = null;
        final String QUIT_COMMAND = "quit";

        while (numberOfGames == 0 || !move.equalsIgnoreCase(QUIT_COMMAND)) {
            System.out.println("Enter: rock, paper or scissors to play or quit to go back to main menu");
            move = inputScanner.nextLine();

            if (move.equalsIgnoreCase(QUIT_COMMAND)) {
                if (numberOfGames == 0) {
                    System.out.println(" Not enough data to calculate the ratio");
                } else {
                    double percentageOfVictories = 100;
                    if (computerWinCounter != 0) {
                        percentageOfVictories = ((double) userWinCounter / (double) computerWinCounter) * 100.0d;
                    }

                    System.out.println(" Your win/lose ratio percentage " + String.format("%.2f", percentageOfVictories) + "%");
                }

                break;
            } else if (!move.equalsIgnoreCase("rock") && !move.equalsIgnoreCase("paper") && !move.equalsIgnoreCase("scissors")) {
                System.out.println("Type correct weapon name");
            } else {

                int randomMove = (int) (Math.random() * 3);
                String computerMove;

                if (randomMove == 0) {
                    computerMove = "rock";
                } else if (randomMove == 1) {
                    computerMove = "paper";
                } else {
                    computerMove = "scissors";
                }

                System.out.println("Computer move:" + computerMove);


                if (move.equalsIgnoreCase(computerMove)) {
                    System.out.println("It's a tie.");
                } else if ((move.equalsIgnoreCase("rock") && computerMove.equalsIgnoreCase("scissors")
                        || (move.equalsIgnoreCase("scissors") && computerMove.equalsIgnoreCase("paper")
                        || (move.equalsIgnoreCase("paper") && computerMove.equalsIgnoreCase("rock"))))) {
                    System.out.println("You won!");
                    ++userWinCounter;

                    System.out.println("and you won " + userWinCounter + " times.");

                } else {
                    System.out.println("You lost");
                    ++computerWinCounter;
                    System.out.println("and you lost " + computerWinCounter + " times.");
                }

            }
            numberOfGames++;
        }

        return new FinalScore(computerWinCounter, userWinCounter);
    }
}

