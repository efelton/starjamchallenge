
package starjamchallenge;

/**
 *
 * @author Eoghan
 */

// Utility class provides static functions to check if the user provided input string is good 
// Design: this will use regular expressions
// Used this sample utility class as an example to work from
// http://www.java.happycodings.com/Java_Util_Package/code13.html
//
// Discussions of java regular expressions consulted from
// http://www.vogella.com/articles/JavaRegularExpressions/article.html

public class InputChecker {
    public static boolean isGood (String str) {
        return str.contentEquals("0") || str.matches("[roygbivROYGBIV0]{4}");
    }
    
    // if the string isGood then the string is terminating if it contains a zero, "0"
    // this function should not be called unless the str is definitely good
    public static boolean isRequestingTermination (String str) {
        return str.contains("0");
    }
    
    public static boolean isPlayAgainGame (String str) {
        if (str.matches(".*[yY].*"))
            return true;
        else if (str.matches(".*[nN].*"))
            return false;
        else
            return true;
    }
        
}
