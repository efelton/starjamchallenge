package starjamchallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Eoghan
 * Abstract Class to handle the input and output that might take place during the game
 * 
 * This program was initially implemented with Input/Output happening by means of the Console.
 * I was personally motivated to use an abstract class to allow for a concrete implementation of a gui
 * This idea was came from a discussion at
 * http://stackoverflow.com/questions/669271/what-is-the-difference-between-the-template-method-and-the-strategy-patterns
 * Given that we finally had to implement the program using JavaBook, it was very convenient for
 * me to implement a new UI strategy for JavaBook.
 * 
 * See the JavaBookGameInputOutput class for my implementation of the JavaBook ui strategy.
 */
public abstract class GameInputOutput {

    public abstract void handleGameWon(GuessRecord rec) ;
    public abstract void handleGameLost(GuessRecord rec) ;
    public abstract void handleDuplicateGuess() ;
    public abstract String promptUserForInput() ;
    public abstract boolean promptToPlayAgain() ;
    public abstract void showCurrentGameState(GuessRecord rec) ;
    public boolean introduceGame() {return true;}
    public void cleanUp() {}
}
