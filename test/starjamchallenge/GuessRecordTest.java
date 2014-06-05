
package starjamchallenge;

import static junit.framework.Assert.assertFalse;
import junit.framework.TestCase;

/**
 *
 * @author Eoghan
 */
public class GuessRecordTest extends TestCase {
    
    public GuessRecordTest(String testName) {
        super(testName);
    }

    /**
     * Test of checkCorrectGuess method, of class GuessRecord.
     */
    public void testCheckCorrectGuess() {

        CodePatch guess = new CodePatch(Colour.R,Colour.R,Colour.R,Colour.R);
        CodePatch target = new CodePatch(Colour.B,Colour.B,Colour.B,Colour.B);
        GuessRecord instance = new GuessRecord(target);

        assertFalse(instance.checkCorrectGuess(guess));
        assert(instance.checkCorrectGuess(target));
    }
    
    public void testMakeGuess() {
        CodePatch target = new CodePatch(Colour.B,Colour.B,Colour.B,Colour.B);
        GuessRecord instance = new GuessRecord(target);
        
        assert(instance.remainingLives()==8);

        CodePatch guess = new CodePatch(Colour.R,Colour.R,Colour.R,Colour.R);
        assertFalse(instance.isDuplicateGuess(guess));
        instance.addGuess(guess);
        assert(instance.remainingLives()==7);
        
        CodePatch guess2 = new CodePatch(Colour.R,Colour.B,Colour.R,Colour.B);
        assertFalse(instance.isDuplicateGuess(guess2));
        instance.addGuess(guess2);
        assert(instance.remainingLives()==6);
        
        assert(instance.isDuplicateGuess(guess));
        
        System.out.print(instance.getStringRecord());
    }
}