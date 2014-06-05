Submission from Eoghan Felton -- 4 May 2013

The StarJamChallenge

Notes

(1) This project is INCOMPLETE: certain functions have not been implemented

	a. There is NO function to play again. If you win or lose then the program terminates. Simply ran out of time to finish this. Should take about 20 mins more to do.
	b. Bug on clue counting: the program incorrectly returns Clues = 1 for RBBB against RBGB when it should be 0. I haven't been able to track down and fix this issue in the time.

(2) To run

Navigate to the dist directory in the cmd line and execute

java -jar "StarJamChallenge.jar"

(3) list of references; mostly to do with Java syntax and usage at which I am VERY rusty

/*
 * REFERENCES:
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

 */

(4) 	a. The prompt string "Enter a sequence a 4 character sequence from ROYGBIV or 0 to exit:" seems incorrect. I changed it to "Enter a 4 character sequence from ROYGBIV or 0 to exit:"
	b. The prompt string "YOU LOOSE the code was: " is bad english. Should be "YOU LOSE the code was:". This has been implemented as specified.

(5) Find source code and test cases as well as executable jar in zip file.

(6) I spent about 6 hourse on this in total. I have not coded in about 4 years and it is much longer since I did any java, so I am not too unhappy with my performance. I would have liked to finish everything though.