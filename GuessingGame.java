// Sean O'Dell, CSE 142, Spring 2015, Section BG
// Programming Assignment #5, 05/04/15
//
// This program's behavior is to allow the user to play a number guessing game as many times as
// they desire.

import java.util.*;

public class GuessingGame {
   public static final int LARGEST_NUM = 100;
   public static void main(String[] args) {
      Random rand = new Random();
      Scanner console = new Scanner(System.in);
      haiku();
      char againAnswer = 'Y';
      int totalGames = 0;
      int totalGuesses = 0;
      int bestGame = 1000000;
      int guesses = 0;
      while (againAnswer == 'Y' || againAnswer == 'y') {    // Prompts user for whether or not they
         totalGames++;                                      // would like to play the game again 
         guesses = playGame(console, rand);                 // and then plays the game when told to  
         totalGuesses += guesses;                           // do so. When the user does not want 
         System.out.print("Do you want to play again? ");   // to play again,it reports the games' 
         againAnswer = console.next().charAt(0);            // statistics.
         System.out.println();
         bestGame = Math.min(bestGame, guesses);
      }
      reportStats(totalGuesses, totalGames, bestGame);
   }
   
   // Prints a haiku
   public static void haiku() {
      System.out.println("Rocketing foreward");
      System.out.println("A tail of stars together");
      System.out.println("In the milky way");
      System.out.println();
   }
   
   // Prompts player one game and returns the number of guesses it took to win
   public static int playGame(Scanner console, Random rand) {
      int chosenNum = rand.nextInt(LARGEST_NUM) + 1;
      System.out.println("I'm thinking of a number between 1 and " + LARGEST_NUM + "...");
      int guess = -1;
      int guesses = 0;
      while (guess != chosenNum) {              // Prompts player for guesses and prints if the
         System.out.print("Your guess? ");      // guess is higher or lower than the actual number
         guess = console.nextInt();
         guesses++;
         if (guess > chosenNum) {
            System.out.println("It's lower.");
         } else {
            System.out.println("It's higher.");
         }
      }
      if (guesses == 1) {
         System.out.println("You got it right in " + guesses + " guess!");
      } else {
         System.out.println("You got it right in " + guesses + " guesses!");
      }
      return guesses;
   }
   
   // reports overall results of games played.  Takes in the total number of guesses, the total
   // games played and the number of guesses used in the best game.
   public static void reportStats(int totalGuesses, int totalGames, int bestGame) {
      double guessesPerGame = (double) totalGuesses / totalGames;
      System.out.println("Overall results:");
      System.out.println("Total games   = " + totalGames);
      System.out.println("Total guesses = " + totalGuesses);
      System.out.println("Guesses/game  = " + Math.round(guessesPerGame * 10) / 10.0);
      System.out.println("Best game     = " + bestGame);
   }
}