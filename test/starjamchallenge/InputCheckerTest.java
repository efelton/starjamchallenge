package starjamchallenge;

import static junit.framework.Assert.assertFalse;
import junit.framework.TestCase;

/**
 *
 * @author Eoghan
 */
public class InputCheckerTest extends TestCase {
    
    public InputCheckerTest(String testName) {
        super(testName);
    }

    // Test whether the input string is allowable
    // "" -- fails
    // "asdfsadf" -- fails
    // "RRR" -- fails
    // "RRRt" -- fails
    // "gbiv" -- succeeds
    // "0BIV" -- succeeds (is terminating)
    // "ROYG" -- succeeds
    // "0000" -- succeeds (is terminating)
    // "0" -- succeeds (is terminating)
    // "ROYGR" -- fails
    // "00" -- fails
    // "000" -- fails
    public void testIsGood() {
        assertFalse(InputChecker.isGood(""));
        assertFalse(InputChecker.isGood("asdfsadf"));
        assertFalse(InputChecker.isGood("RRR"));
        assertFalse(InputChecker.isGood("RRRt"));
        assert(InputChecker.isGood("gbiv"));
        assert(InputChecker.isGood("0BIV"));
        assert(InputChecker.isGood("ROYG"));
        assert(InputChecker.isGood("0000"));
        assert(InputChecker.isGood("0"));
        assertFalse(InputChecker.isGood("ROYGR"));
        assertFalse(InputChecker.isGood("00"));
        assertFalse(InputChecker.isGood("000"));
    }

    
    // "gbiv" -- no
    // "0BIV" -- is terminating
    // "ROYG" -- no
    // "0000" -- is terminating
    // "0" -- is terminating
    public void testIsTerminating () {
        assertFalse(InputChecker.isRequestingTermination("gbiv"));
        assert(InputChecker.isRequestingTermination("0BIV"));
        assertFalse(InputChecker.isRequestingTermination("ROYG"));
        assert(InputChecker.isRequestingTermination("0000"));
        assert(InputChecker.isRequestingTermination("0"));
    }
}
