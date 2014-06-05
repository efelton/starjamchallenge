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
    
    private final Random rand = new Random();
    
    public CodePatch (Colour c1, Colour c2, Colour c3, Colour c4) {
        code = new Colour[4];
        
        code[0] = c1; code[1] = c2; code[2]=c3; code [3]=c4;
    }
    
    // only call this if assured this is a properly formatted string with 
    // appropriate characters in it
    // Ref: casting string to enum
    // http://stackoverflow.com/questions/604424/java-convert-string-to-enum
    // casting a char to a string
    // http://www.mkyong.com/java/how-to-convert-char-to-string-in-java/
    public CodePatch (String str) {
        code = new Colour[4];
        
        for (int i=0; i< 4; i++) {
            String tempstr = Character.toString(str.charAt(i));
            tempstr = tempstr.toUpperCase();
        
            code[i] = Colour.valueOf(tempstr);
        }
    }
    
    // Reference for converting a StringBuffer to a string
    //http://www.coderanch.com/t/385588/java/java/convert-StringBuffer-String
    public String toString () {
        StringBuffer str = new StringBuffer();

        for (int i=0; i<4; i++) {
            str.append(code[i]);
            str.append(" ");
        }
        return str.toString();
    }
    
    // if no args supplied to constructor then generate the colours of the code patch randomly
    // code for generating random numbers taken from
    // http://www.javapractices.com/topic/TopicAction.do?Id=62
    public CodePatch () {
        code = new Colour[4];

        for (int i=0; i<4; i++) {
            code[i] = Colour.fromInteger(rand.nextInt(7));
        }
    }
    
    
    // assume that neither CodePatch for equals check is null
    // and that both CodePatches are properly formed
    public boolean equals (CodePatch otherCode) {
        return (code[0] == otherCode.code[0] && code[1] == otherCode.code[1] && 
                    code[2] == otherCode.code[2] && code[3] == otherCode.code [3] );
    }
    
    public StringBuffer getComparisonReport (CodePatch otherCode) {
        StringBuffer report = new StringBuffer();
        report.append("Code: ");
        
        for (int i=0; i<4; i++) {
            if (code[i] == otherCode.code[i]) {
                report.append(code[i]);
                report.append(" ");
            }
            else {
                report.append("_ ");
            }
        }
        
        report.append("Guessed: ");
        for (int i=0; i<4; i++) {
            report.append(otherCode.code[i]);
            report.append(" ");
        }
        
        report.append("Clues: ");
        report.append(countClues(otherCode));
        return report;
    }
    
    
    // match otherCode against the target CodePatch and count the number of clues
    public int countClues(CodePatch otherCode) {
        // keep track of whenever a colour in the target 
        // CodePatch is matched correctly or used as a clue
        // array of 4 booleans; all are initially false
        boolean [] usedColour = new boolean[4];
        for (int i=0; i<4; i++) {
            usedColour[i] = ( code[i] == otherCode.code[i]); // colours match so not a clue
        }   

        int clueCount = 0;
        boolean foundClue ;

        for (int j=0; j<4; j++){
                // see if the colour can match against one of the other parts of the target
                foundClue =false ;
                for (int k=0; k<4; k++) {
                    if (j!=k && !foundClue && !usedColour [k]  && (code[j] == otherCode.code[k])) { 
                        // found a clue
                        foundClue = true;
                        usedColour[k] = true;
                        clueCount ++;
                        
                    }
                }
        }
        return clueCount;
    }

    // method used during testing
    public void print() {
        StringBuffer str = new StringBuffer();
        for (int i=0; i<4; i++)
            str.append(code[i]);
        System.out.println(str);
    }
    
}
