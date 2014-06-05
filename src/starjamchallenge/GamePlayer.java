package starjamchallenge;

/**
 * This class provides the main logic for playing a game. 
 * It prompts the user (by calls to the UI class) and then asks the UI class
 * to update the situation for the player. 
 * The log of the game is stored in the GameRecord class. A new one of these 
 * is created for each game.
 * 
 * @author Eoghan
 */
public class GamePlayer {
    GameInputOutput gameIO ;
    
    GamePlayer () {
        gameIO = new JavaBookGameInputOutput(); // select the user interface: in this case a Javabook UI.
    }
    
    void compareGuessAgainstRecord(CodePatch guess, GuessRecord rec) {
        if (rec.isDuplicateGuess(guess)) {
            gameIO.handleDuplicateGuess();
        } else {
            rec.processGuess(guess);
        }
    }

    // Checks if necessary to request the UI to handle the game 
    // being won or lost 
    // Note: it is also possible to have a game be finished by the user
    // quitting. In this situation the UI is not asked to do anything.
    void handleGameFinishConditions(GuessRecord rec) {
        if (rec.getGameWon()) {
            gameIO.handleGameWon(rec);
        }
        if (rec.getGameLost()) {
            gameIO.handleGameLost(rec);
        }
    }

    // This method keeps calling gameLoop until the game is over.
    // Once finished it handles any final presentation to the user.
    boolean playAGame() {
        GuessRecord rec = setUpNewGame();
        boolean gameQuit = false;
        while (!gameQuit && !rec.gameFinished()) {
            gameQuit = gameLoop(rec);
        }
        handleGameFinishConditions(rec);
        return gameQuit;
    }

    // Workhorse method used when playing a game
    // show the user their current situation and then get input from them.
    // If the input is good 
    // check if the user quit
    // If the input is bad, prompt the user to try again
    boolean gameLoop(GuessRecord rec) {
        boolean gameQuit = false;
        gameIO.showCurrentGameState(rec);
        String str = gameIO.promptUserForInput();
        if (InputChecker.isRequestingTermination(str)) {
            gameQuit = true;
        } else {
            CodePatch guess = new CodePatch(str);
            compareGuessAgainstRecord(guess, rec);
        }
        return gameQuit;
    }

    // This loop is the highest level function of the program.
    // It keeps playing games (calling the playGame() method) until the 
    // user quits
    public void mainLoop() {
        boolean gameQuit;
        
        gameQuit = !gameIO.introduceGame(); // show the intro screen
        while (!gameQuit) {
            gameQuit = playAGame();
            if (!gameQuit) {
                gameQuit = !gameIO.promptToPlayAgain();
            }
        } 
        gameIO.cleanUp();
    }

    // set up a new game
    GuessRecord setUpNewGame() {
        CodePatch target = new CodePatch();
        GuessRecord rec = new GuessRecord(target);
        return rec;
    }
    
}
