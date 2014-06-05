package starjamchallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Eoghan
 * Class to handle the input and output that might take place during the game
 */
public class GameInputOutput {

    static void handleGameWon(GuessRecord rec) {
        System.out.print(rec.getStringRecord());
        System.out.print("YOU WIN!!\n");
    }

    static void handleGameLost(GuessRecord rec) {
        System.out.print(rec.getStringRecord());
        System.out.print("YOU LOOSE the code was ");
        System.out.print(rec.getTargetString());
        System.out.print("\n");
    }

    static void handleDuplicateGuess() {
        System.out.print("You have duplicated a guess that you have already made. Please try again.\n");
    }

    // Reference: Using bufferedReader to get input
    // http://www.javadb.com/using-bufferedreader-to-read-input-number-from-user
    static String promptUserForInput() {
        String str = null;
        try {
            do {
                System.out.print("Enter a 4 character sequence from ROYGBIV or 0 to exit\n");
                BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
                str = inp.readLine();
            } while (!InputChecker.isGood(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    // Seems to be no good way to do char by char input in a portable manner
    // Reference: http://stackoverflow.com/questions/1066318/how-to-read-a-single-char-from-the-console-in-java-as-the-user-types-it
    // So took line input and parsed it
    static boolean promptToPlayAgain() {
        boolean gamePlayAgain = false;
        String str;
        try {
            System.out.println("Play again Y/N:");
            BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
            str = inp.readLine();
            gamePlayAgain = InputChecker.isPlayAgainGame(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gamePlayAgain;
    }

    static void showCurrentGameState(GuessRecord rec) {
        System.out.print(rec.getStringRecord());
    }
    
    
}
