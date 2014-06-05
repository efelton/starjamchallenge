package starjamchallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * This was the initial implementation of a Console User Interface done for the Stars challenge.
 * This code is never used in the current project because it was required to have a JavaBook 
 * user interface. This code is provided for completeness.
 * 
 * @author Eoghan
 */
public class ConsoleGameInputOutput extends GameInputOutput {

    public void handleGameWon(GuessRecord rec) {
        System.out.print(rec.getStringRecord());
        System.out.print("YOU WIN!!\n");
    }

    public void handleGameLost(GuessRecord rec) {
        System.out.print(rec.getStringRecord());
        System.out.print("YOU LOOSE the code was ");
        System.out.print(rec.getTargetString());
        System.out.print("\n");
    }

    public void handleDuplicateGuess() {
        System.out.print("You have duplicated a guess that you have already made. Please try again.\n");
    }

    // Reference: Using bufferedReader to get input
    // http://www.javadb.com/using-bufferedreader-to-read-input-number-from-user
    //
    // Reference: Handling io exceptions in a safe and readable manner
    // http://stackoverflow.com/questions/1045829/how-can-i-handle-an-ioexception-which-i-know-can-never-be-thrown-in-a-safe-and
    public String promptUserForInput() {
        String str = null;
        try {
            do {
                System.out.print("Enter a 4 character sequence from ROYGBIV or 0 to exit\n");
                BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
                str = inp.readLine();
            } while (!InputChecker.isGood(str));
        } catch (Exception e) {
            throw new RuntimeException("Do not expect this to happen.",e);
        }
        return str;
    }
    
    // Seems to be no good way to do char by char input in a portable manner
    // Reference: http://stackoverflow.com/questions/1066318/how-to-read-a-single-char-from-the-console-in-java-as-the-user-types-it
    // So took line input and parsed it
    public boolean promptToPlayAgain() {
        boolean gamePlayAgain = false;
        String str;
        try {
            System.out.println("Play again Y/N:");
            BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
            str = inp.readLine();
            gamePlayAgain = InputChecker.isPlayAgainGame(str);
        } catch (Exception e) {
            throw new RuntimeException("Do not expect this to happen.",e);
        }
        return gamePlayAgain;
    }
    
    public void showCurrentGameState(GuessRecord rec) {
        System.out.print(rec.getStringRecord());
    }    
    
}
