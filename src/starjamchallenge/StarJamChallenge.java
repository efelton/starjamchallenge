package starjamchallenge;

/**
 *
 * @author Eoghan
 */
public class StarJamChallenge {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GamePlayer player = new GamePlayer();
        player.mainLoop();
    }
}

/*
 * REFERENCES:
 * 
 *
 * Reference: Using bufferedReader to get input
 * http://www.javadb.com/using-bufferedreader-to-read-input-number-from-user
 *
 * When to use StringBuffer versus String in java
 * http://www.javaworld.com/javaworld/jw-03-2000/jw-0324-javaperf.html
 * 
 * Using enum types in java
 * http://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
 * 
 * Converting an enum to a string in java
 * http://javarevisited.blogspot.ie/2011/12/convert-enum-string-java-example.html
 * 
 * Comparing StringBuffers in java 
 * http://stackoverflow.com/questions/2012305/comparing-stringbuffer-content-with-equals
 * 
 * Casting int to enum
 * http://stackoverflow.com/questions/5878952/cast-int-to-enum-in-java
 * 
 * Generating random numbers
 * http://www.javapractices.com/topic/TopicAction.do?Id=62
 * 
 * Example java utility class comprising of static methods
 * http://www.java.happycodings.com/Java_Util_Package/code13.html
 * 
 * Using arrays in java
 * http://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html
 * 
 * Use of regular expressions in Java
 * http://www.vogella.com/articles/JavaRegularExpressions/article.html
 * 
 * casting string to enum
 * http://stackoverflow.com/questions/604424/java-convert-string-to-enum
 * 
 * casting a char to a string
 * http://www.mkyong.com/java/how-to-convert-char-to-string-in-java/
 *
 * Reference for converting a StringBuffer to a string
 * http://www.coderanch.com/t/385588/java/java/convert-StringBuffer-String
 * 
 * Portable char by char input in java (as opposed to line by line)
 * http://stackoverflow.com/questions/1066318/how-to-read-a-single-char-from-the-console-in-java-as-the-user-types-it
 * 
 * Reference: Handling io exceptions in a safe and readable manner
 * http://stackoverflow.com/questions/1045829/how-can-i-handle-an-ioexception-which-i-know-can-never-be-thrown-in-a-safe-and
 *
 * Use of the template pattern (console ui versus graphical ui)
 * http://stackoverflow.com/questions/669271/what-is-the-difference-between-the-template-method-and-the-strategy-patterns
 *
 * How to set the font on a JDialog; used to get a monospaced font for showing the 
 * current game status so that all the guesses and clues line up
 * http://stackoverflow.com/questions/7434845/setting-the-default-font-of-swing-program-in-java
 *
 */
