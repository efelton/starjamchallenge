package starjamchallenge;

/**
 * This class provides the JavaBook implementation of the User Interface.
 * 
 * @author Eoghan
 */

import java.awt.Font;
import javabook.*;

public class JavaBookGameInputOutput extends GameInputOutput {

    // windows that will be used during the game
    MainWindow mWindow;
    InputBox iBox;
    OutputBox oBox;
    MessageBox warningBox; // used to warn the user that they have entered a duplicate

    
    // In the constructor create the windows that will be used during the game
    // and link them to each other appropriately.
    JavaBookGameInputOutput() {
        // Create the graphical objects and link them to each other
	mWindow = new MainWindow();
	iBox = new InputBox(mWindow);
	oBox = new OutputBox(mWindow);
        warningBox = new MessageBox(mWindow);
        
        // set a monospaced font so the guesses and clues line up nicely
        // REFERENCE: code to set this font came from stackoverflow
        // http://stackoverflow.com/questions/7434845/setting-the-default-font-of-swing-program-in-java
        oBox.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        oBox.setLocation(200, 50);
/*      // I would like to be able to set the location of the input box, 
        // but there doesn't seem to be a good way.
        // If i set the location before the box is displayed the library gives a null
        // error (the dialog has not been created).
        // I cannot set the location after the box is displayed because it has already
        // been seen by the user and closed.
//      iBox.setLocation(0,0); */
    }
    
    // Show the game record and inform the user that they have won
    public void handleGameWon(GuessRecord rec) {
        oBox.show();
        oBox.clear();
        oBox.print(rec.getStringRecord());
        oBox.print("YOU WIN!!\n");
    }

    // Show the game record and inform the user that they have lost
    public void handleGameLost(GuessRecord rec) {
        oBox.show();
        oBox.clear();
        oBox.print(rec.getStringRecord());
        oBox.print("YOU LOOSE the code was " + rec.getTargetString() + "\n");
    }

    // Use a warn box to inform the user that they have entered a duplicate
    public void handleDuplicateGuess() {
        warningBox.show("You have duplicated a guess that you have already made. Please try again.\n");
    }
    
    // Prompt user for the input
    public String promptUserForInput() {
        String str = null;
        do {
            str=iBox.getString("Enter a 4 character sequence from ROYGBIV or 0 to exit\n");
        } while (!InputChecker.isGood(str));
        return str;    
    }
    
    // Prompt user to play again
    public boolean promptToPlayAgain() {
        return promptToPlay("Play again Y/N:");
    }
    
    // Show the current situation in the game
    public void showCurrentGameState(GuessRecord rec) {
        oBox.show();
        oBox.clear();
        oBox.print(rec.getStringRecord());
    }
    
    // introduce the game: show instructions and prompt the user to continue
    public boolean introduceGame() {
        oBox.show();
        oBox.clear();
        oBox.print("INTRODUCTION\n" + "The fate of the world rests on your "
                + "shoulders. A lethal virus \nis about to be on leashed on the "
                + "web. You can stop the virus's \nrelease if you can guess the "
                + "sequence of 4 colors that delete \nthe virus.\n\n");
        oBox.print("The possible colors are\n" +
                  "R - Red\n" +
                  "O - Orange\n" +
                  "Y - Yellow\n" +
                  "G - Green\n" +
                  "B - Blue\n" +
                  "I - Indigo\n" +
                  "V - Violet\n" +
                  "You have only 8 chances to guess the code.");
        return promptToPlay("Are you ready to save the world (Y/N)?");
    }

    // show a prompt message to the user and get string input from 
    // the user.
    // Translate the string input into a boolean that indicates whether
    // they want to continue or not
    private boolean promptToPlay(String promptMessage) {
        boolean playGame;
        String str;
        
        str = iBox.getString(promptMessage);
        playGame = InputChecker.isPlayAgainGame(str);
        return playGame;
    }

    // After the user has chosen to quit the game close down the windows.
    public void cleanUp() {
        oBox.dispose();
        mWindow.dispose();
    }

}
