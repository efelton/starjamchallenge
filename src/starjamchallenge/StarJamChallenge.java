/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package starjamchallenge;

import java.io.BufferedReader;
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
    
    private static void gameLoop (){
        CodePatch target = new CodePatch();
        GuessRecord rec = new GuessRecord(target);

        boolean gameWon = false;
        boolean gameLost = false;
        
        try {
            while (rec.remainingLives()>0 && !gameWon && !gameLost) {
                // print out the record
                
                System.out.print(rec.getStringRecord());
            
                String str;
                do {
                    // get the input from the user
                    System.out.print("Enter a 4 character sequence from ROYGBIV or 0 to exit\n");
                    BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));

                    str = inp.readLine();
                } while (!InputChecker.isGood(str));
            
                // check if terminating
                if (InputChecker.isRequestingTermination(str)) {
                    break;
                }

                // make guess string into codepatch
                CodePatch guess = new CodePatch(str);
                
                // check for game won and handle
                if (rec.checkCorrectGuess(guess)){
                    gameWon = true;
                }
                
                // check if duplicate
                if (rec.isDuplicateGuess(guess)) {
                    System.out.print("You have duplicated a guess that you have already made. Please try again.\n");
                } else { // otherwise add to the record && check for game lost
                    rec.addGuess(guess);
                    if (rec.remainingLives()==0) {
                        gameLost = true;
                    }
                }
                
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    
        if (gameWon) {
             System.out.print(rec.getStringRecord());
             System.out.print("YOU WIN!!\n");
        }
        if (gameLost) {
             System.out.print(rec.getStringRecord());
             System.out.print("YOU LOOSE the code was ");
             System.out.print(target.toString());
             System.out.print("\n");
        }

}
        // check for game lost
        // check for game won
        // check for exit

}

/*
 * REFERENCES:
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
