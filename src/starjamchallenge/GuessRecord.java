package starjamchallenge;

/**
 *
 * @author Eoghan
 */

// This is a record of all the guesses the player has made so far
public class GuessRecord {
    CodePatch[] record;
    
    public final static int maxLives = 8;
    
    private int numGuesses;
    private CodePatch target;
    
    GuessRecord(CodePatch t){
        record = new CodePatch[maxLives];
        numGuesses = 0;
        target = t;
    }

    /*
    // add new guess at the target to the record
    // won't check for duplicates or if the numGuesses has gone to high
    // don't call this unless the number of remaining lives and duplicate guesses 
    // have already been checked
    */
    public void addGuess(CodePatch guess) {
        record [numGuesses] = guess;
        numGuesses++;
    }

    // check if the user has used all their lives and the game is finished
    public int remainingLives() {
        return maxLives - numGuesses;
    }
    
    // check if the user's guess is correct
    public boolean checkCorrectGuess (CodePatch guess) {
        return target.equals(guess);
    }
    
    // check if the user's guess is a duplicate of one of guesses in the record
    public boolean isDuplicateGuess (CodePatch guess) {
        if (numGuesses == 0)
            return false;
           
        for (int i=0; i<numGuesses; i++) {
            if (guess.equals(record[i]))
                return true;
        }
        
        return false;
    }
    
    // print out the record
    public StringBuffer getStringRecord () {
        StringBuffer strRecord = new StringBuffer() ;
        
        strRecord.append(target.toString());
        strRecord.append("\n");
        
        strRecord.append("Lives: ");
        strRecord.append(remainingLives());
        strRecord.append("\n");
        
        strRecord.append("Code: _ _ _ _ Guessed: _ _ _ _ Clues:\n");
        
        for(int i=0; i < numGuesses; i++) {
            strRecord.append(target.getComparisonReport(record[i]));
            strRecord.append("\n");
        }
        
        return strRecord;
    }
    
    public String getTargetString() {
        return target.toString();
    }

}
