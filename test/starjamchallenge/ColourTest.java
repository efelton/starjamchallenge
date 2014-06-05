/*
* Test class to familiarise myself with using enums
*/
package starjamchallenge;

import junit.framework.TestCase;

/**
 *
 * @author Eoghan
 */
public class ColourTest extends TestCase {
    
    public ColourTest(String testName) {
        super(testName);
    }

    /**
     * Test of values method, of class Colour.
     */
    public void testColourEquality() {
        Colour col = Colour.R;
        
        assertTrue(col==Colour.R);
    }

    /**
     * Test of valueOf method, of class Colour.
     */

    /*
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        Colour expResult = null;
        Colour result = Colour.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */
}
