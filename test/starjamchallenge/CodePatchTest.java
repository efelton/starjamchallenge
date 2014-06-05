package starjamchallenge;

import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 *
 * @author Eoghan
 */
public class CodePatchTest extends TestCase {
    
    public CodePatchTest(String testName) {
        super(testName);
    }

    /**
     * Test of equals method, of class CodePatch.
     */
    public void testEquals() {
        System.out.println("equals");
        CodePatch instance = new CodePatch (Colour.R, Colour.R, Colour.R, Colour.R);
        CodePatch otherCode = new CodePatch (Colour.R, Colour.R, Colour.R, Colour.R);

        boolean expResult = true;
        boolean result = instance.equals(otherCode);
        assertEquals(expResult, result);

        // new different Code Patch
        otherCode = new CodePatch (Colour.R, Colour.R, Colour.R, Colour.B);
        expResult = false;
        result = instance.equals(otherCode);
        assertEquals(expResult, result);

        /*
        CodePatch sent;
        for(int qq=0;qq<100;qq++) {
            sent = new CodePatch();
            sent.print();
        }
        */    
        
    }

    public void testGetComparisonReport() {
        CodePatch instance = new CodePatch (Colour.R, Colour.R, Colour.R, Colour.R);
        CodePatch otherCode = new CodePatch (Colour.B, Colour.B, Colour.B, Colour.B);
        
        StringBuffer report = instance.getComparisonReport(otherCode);
        assertEquals(report.substring(0,31).toString(), "Code: _ _ _ _ Guessed: B B B B ");

        CodePatch correctGuessCode = new CodePatch (Colour.R, Colour.G, Colour.I, Colour.V);
        report = correctGuessCode.getComparisonReport(correctGuessCode);
        assertEquals(report.substring(0,31).toString(), "Code: R G I V Guessed: R G I V ");
        
        CodePatch otherIncorrectGuess = new CodePatch (Colour.R, Colour.G, Colour.V, Colour.I);
        report = correctGuessCode.getComparisonReport(otherIncorrectGuess);
        assertEquals(report.substring(0,31).toString(), "Code: R G _ _ Guessed: R G V I ");
        
        // check the clue counts
        assertEquals(report.toString(), "Code: R G _ _ Guessed: R G V I Clues: 2");
    }

    // Had difficulty understanding exactly how the clues worked 
    // My assumptions as follows
    // RRRR to RRRR => clues = 0 (match 4)
    // RRRR to BBBB => clues = 0 (match 0)
    // RBBB to RYYY => clues = 0 (match 1)
    // RYYY to RYRY => clues = 0 (match 3)
    // RRBB to RYRY => clues = 1 (match 1)
    // RBBB to YRRY => clues = 1 (match 0) ** NOT clues = 2
    // YRRY to RBBB => clues = 1 (match 0) ** NOT clues = 2
    public void testCountClues () {
        CodePatch instance = new CodePatch (Colour.R, Colour.R, Colour.R, Colour.R);
        CodePatch otherCode = new CodePatch (Colour.B, Colour.B, Colour.B, Colour.B);
        
        // RRRR to BBBB => clues = 0 (match 0)
        assertEquals(instance.countClues(otherCode),0);
        // RRRR to RRRR => clues = 0 (match 4)
        assertEquals(instance.countClues(instance),0);

        // RBBB to RYYY => clues = 0 (match 1)
        CodePatch codeRBBB = new CodePatch (Colour.R, Colour.B, Colour.B, Colour.B);
        CodePatch codeRYYY = new CodePatch  (Colour.R, Colour.Y, Colour.Y, Colour.Y);
        assertEquals(codeRBBB.countClues(codeRYYY),0);

        // RYYY to RYRY => clues = 0 (match 3)
        CodePatch codeRYRY = new CodePatch (Colour.R, Colour.Y, Colour.R, Colour.Y);


        // RRBB to RYRY => clues = 1 (match 1)
        CodePatch codeRRBB = new CodePatch (Colour.R, Colour.R, Colour.B, Colour.B);
        assertEquals(codeRYRY.countClues(codeRRBB),1);

        // RBBB to YRRY => clues = 1 (match 0) ** NOT clues = 2
        CodePatch codeYRRY = new CodePatch (Colour.Y, Colour.R, Colour.R, Colour.Y);
        assertEquals(codeRBBB.countClues(codeYRRY),1);
        
        // YRRY to RBBB => clues = 1 (match 0) ** NOT clues = 2
        assertEquals(codeYRRY.countClues(codeRBBB),1);

    }
    
    // noticed incorrect count of clues for a guess of RBRB against BBBB
    // Code: _ B _ B Guessed: R B R B Clues: 2
    // Clues obviously should be 0
    public void testCountCluesIssue() {
        CodePatch codeRBRB = new CodePatch (Colour.R, Colour.B, Colour.R, Colour.B);
        CodePatch codeBBBB = new CodePatch (Colour.B, Colour.B, Colour.B, Colour.B);
        
        assertEquals(codeBBBB.countClues(codeRBRB),0);
        
    }

    public void testAnotherCountCluesEdgeCase () {
        CodePatch codeRYRY = new CodePatch ("RYRY");
        CodePatch codeRYYY = new CodePatch ("RYYY");
        
        // MUST GET THIS TEST CASE WORKING
        assertEquals(codeRYRY.countClues(codeRYYY),0);
    }
    
    public void testStringConstructor () {
        CodePatch codeRBRB = new CodePatch (Colour.R, Colour.B, Colour.R, Colour.B);
        CodePatch equiv = new CodePatch("rbrb");
        assert (codeRBRB.equals(equiv));

    }
}
