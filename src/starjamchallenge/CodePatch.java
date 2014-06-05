/*
 * This class will be used to hold the pattern of 4 colours that is a Code Patch.
 * The answer, the current guess and the guess history will all use this class.
*/

package starjamchallenge;

import java.util.Random;
/**
 *
 * @author Eoghan
 */
public class CodePatch {
    private Colour[] code;
    final int codePatchLength = 4;
    
    private final Random rand = new Random();
    
    // constructs a codepatch from 4 Colour enums passed in
    public CodePatch (Colour c1, Colour c2, Colour c3, Colour c4) {
        code = new Colour[codePatchLength];
        
        code[0] = c1; code[1] = c2; code[2]=c3; code [3]=c4;
    }
    
    // Constructs a code patch from a passed in string.
    // only call this if assured this is a properly formatted string with 
    // appropriate characters in it
    // Ref: casting string to enum
    // http://stackoverflow.com/questions/604424/java-convert-string-to-enum
    // casting a char to a string
    // http://www.mkyong.com/java/how-to-convert-char-to-string-in-java/
    public CodePatch (String str) {
        code = new Colour[codePatchLength];
        
        for (int i=0; i< codePatchLength; i++) {
            String tempstr = Character.toString(str.charAt(i));
            tempstr = tempstr.toUpperCase();
        
            code[i] = Colour.valueOf(tempstr);
        }
    }
    
    // Returns a code patch as a string. E.g. ROYG will be returned
    // as "R O Y G"
    // Reference for converting a StringBuffer to a string
    //http://www.coderanch.com/t/385588/java/java/convert-StringBuffer-String
    public String toString () {
        StringBuffer str = new StringBuffer();

        for (int i=0; i<codePatchLength; i++) {
            str.append(code[i]);
            str.append(" ");
        }
        return str.toString();
    }
    
    // if no args supplied to constructor then generate the colours of the code patch randomly
    // code for generating random numbers taken from
    // http://www.javapractices.com/topic/TopicAction.do?Id=62
    public CodePatch () {
        code = new Colour[codePatchLength];

        for (int i=0; i<codePatchLength; i++) {
            code[i] = Colour.fromInteger(rand.nextInt(7));
        }
    }
    
    
    // assume that neither CodePatch for equals check is null
    // and that both CodePatches are properly formed
    public boolean equals (CodePatch otherCode) {
        boolean matches = true;
        for (int i=0; i < codePatchLength; i++)
            matches = matches && (code[i] == otherCode.code[i]);
        return matches;
    }

    // Returns a stringbuffer containing an status of the comparison
    // between this CodePatch (presumed to be the target) and another
    // one (presumed to be the user's guess)
    public StringBuffer getComparisonReport (CodePatch otherCode) {
        StringBuffer report = new StringBuffer();
        report.append("Code: ");
        report.append(makeMatchString(otherCode));
        
        report.append("Guessed: ");
        report.append (otherCode.toString());
        
        report.append("Clues: ");
        report.append(countClues(otherCode));
        return report;
    }
    
    // match otherCode against the target CodePatch and return the number of clues
    // NOTE: This code and the supporting private methods initialiseCountClueBoolArrays()
    // and checkIfColourMatches() comprise quite a complex way to count the number of clues. 
    // There was probably a significantly easier way to implement this.
    
    // However I am pretty confident this works.
    // I have junit tests that test against 9 different cases:
    // RRRR to RRRR => clues = 0 (match 4)
    // RRRR to BBBB => clues = 0 (match 0)
    // RBBB to RYYY => clues = 0 (match 1)
    // RYYY to RYRY => clues = 0 (match 3)
    // RRBB to RYRY => clues = 1 (match 1)
    // RBBB to YRRY => clues = 1 (match 0) ** NOT clues = 2
    // YRRY to RBBB => clues = 1 (match 0) ** NOT clues = 2
    // RBRB to BBBB => clues = 0 (match 2)
    // RYRY to RYYY => clues = 0 (match 3)
    // & all pass successfully
    public int countClues(CodePatch otherCode) {
        // keep track of whenever a colour in the target 
        // CodePatch is matched correctly or used as a clue
        
        // 2 arrays of 4 booleans used to keep track of whether a clue has 
        // been counted or not
        // used x Color set to true if it has already been matched or used for a clue
        // if it has then it is not eligible to be used again.
        boolean [] usedThisColour = new boolean[4];
        boolean [] usedOtherColour = new boolean[4];
        
        initialiseCountClueBoolArrays(usedThisColour, otherCode, usedOtherColour);   

        int clueCount = 0;

        for (int j=0; j<codePatchLength; j++){
            // check if the jth colour in this.codepatch can match against any of the colours of otherCodePatch
            if (checkIfColourMatches(j, usedThisColour, usedOtherColour, otherCode, clueCount))
                clueCount++;
        }
        return clueCount;
    }

    // set up the 2 initial boolean arrays that are used when counting the clues between 2 strings
    private void initialiseCountClueBoolArrays(boolean[] usedThisColour, CodePatch otherCode, boolean[] usedOtherColour) {
        // array of 4 booleans

        for (int i=0; i<codePatchLength; i++) {
            // check if the colours of this.code and othercode match
            usedThisColour[i] = ( code[i] == otherCode.code[i]); 
            usedOtherColour[i] = usedThisColour[i];
        }
    }

    
    // check if the jth colour in this.codepatch can match against any of the colours of otherCodePatch
    private boolean checkIfColourMatches(int j, boolean[] usedThisColour, boolean[] usedOtherColour, CodePatch otherCode, int clueCount) {
        // see if the colour can match against one of the other parts of the target
        boolean foundClue =false ;
        for (int k=0; k<codePatchLength; k++) {
            if (!foundClue && !usedThisColour [k]  && !usedOtherColour[j] && (code[j] == otherCode.code[k])) { 
                // found a clue
                foundClue = true;
                usedThisColour[k] = true;
                usedOtherColour[j] = true;
            }
        }
        return foundClue;
    }
    // returns a string that can be shown to the user showing
    // how they their guess matched against the target code patch
    // if they get everything wrong then _ _ _ _
    // if they get some right e.g. _ R _ O (the R and the O are shown 
    // in the positions they appear in the target string).
    private String makeMatchString(CodePatch otherCode) {
        StringBuffer strbuf = new StringBuffer();
        for (int i=0; i<codePatchLength; i++) {
            if (code[i] == otherCode.code[i]) {
                strbuf.append(code[i]);
                strbuf.append(" ");
            }
            else {
                strbuf.append("_ ");
            }
        }
        return strbuf.toString();
    }
}
