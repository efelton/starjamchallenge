/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package starjamchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Eoghan
 */
public class StarJamChallenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         gameLoop();
    }

    // Reference: Using bufferedReader to get input
    // http://www.javadb.com/using-bufferedreader-to-read-input-number-from-user
    private static void gameLoop (){
        GuessRecord rec = setUpNewGame();
        
        boolean gameWon = false;
        boolean gameLost = false;
        boolean gameQuit = false;
        
        try {
            while (!gameQuit && !gameWon && !gameLost) {                
                showCurrentGameState(rec);
            
                String str = promptUserForInput();
            
                if (InputChecker.isRequestingTermination(str)) {
                    gameQuit = true;
                } else {
                    // make guess string into codepatch
                    CodePatch guess = new CodePatch(str);
                
                    // check for game won and handle
                    if (rec.checkCorrectGuess(guess))
                        gameWon = true;
                    gameLost = processGuess(rec, guess);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    
        if (gameWon) 
             handleGameWon(rec);
        if (gameLost) 
             handleGameLost(rec);
    }

    
    private static GuessRecord setUpNewGame() {
        CodePatch target = new CodePatch();
        GuessRecord rec = new GuessRecord(target);
        return rec;
    }
    
    private static void handleGameLost(GuessRecord rec) {
        System.out.print(rec.getStringRecord());
        System.out.print("YOU LOOSE the code was ");
        System.out.print(rec.getTargetString());
        System.out.print("\n");

    }

    private static void handleGameWon(GuessRecord rec) {
        System.out.print(rec.getStringRecord());
        System.out.print("YOU WIN!!\n");
    }

    private static String promptUserForInput() throws IOException {
        String str;
        
        do {
            // get the input from the user
            System.out.print("Enter a 4 character sequence from ROYGBIV or 0 to exit\n");
            BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));

            str = inp.readLine();
        } while (!InputChecker.isGood(str));
        return str;
    }

    private static void handleDuplicateGuess() {
        System.out.print("You have duplicated a guess that you have already made. Please try again.\n");
    }

    private static boolean processGuess(GuessRecord rec, CodePatch guess) {
        boolean gameLost = false;
        
        // check if duplicate
        if (rec.isDuplicateGuess(guess)) {
            handleDuplicateGuess();
        } else { // otherwise add to the record && check for game lost
            rec.addGuess(guess);
            if (rec.remainingLives()==0) {
                gameLost = true;
            }
        }
        return gameLost;
    }

    private static void showCurrentGameState(GuessRecord rec) {
        System.out.print(rec.getStringRecord());
    }

}

/*
 * REFERENCES:
 * 
 *
 * Reference: Using bufferedReader to get input
 * http://www.javadb.com/using-bufferedreader-to-read-input-number-from-user
 *
 * When to use StringBuffer versus String in java
 * http://www.javaworld.com/javaworld/jw-03-2000/jw-0324-javaperf.html
 * 
 * Using enum types in java
 * http://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
 * 
 * Converting an enum to a string in java
 * http://javarevisited.blogspot.ie/2011/12/convert-enum-string-java-example.html
 * 
 * Comparing StringBuffers in java 
 * http://stackoverflow.com/questions/2012305/comparing-stringbuffer-content-with-equals
 * 
 * Casting int to enum
 * http://stackoverflow.com/questions/5878952/cast-int-to-enum-in-java
 * 
 * Generating random numbers
 * http://www.javapractices.com/topic/TopicAction.do?Id=62
 * 
 * Example java utility class comprising of static methods
 * http://www.java.happycodings.com/Java_Util_Package/code13.html
 * 
 * Using arrays in java
 * http://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html
 * 
 * Use of regular expressions in Java
 * http://www.vogella.com/articles/JavaRegularExpressions/article.html
 * 
 * casting string to enum
 * http://stackoverflow.com/questions/604424/java-convert-string-to-enum
 * 
 * casting a char to a string
 * http://www.mkyong.com/java/how-to-convert-char-to-string-in-java/
 *
 * Reference for converting a StringBuffer to a string
 * http://www.coderanch.com/t/385588/java/java/convert-StringBuffer-String

 */
