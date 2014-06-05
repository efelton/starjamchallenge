/*
* Enumeration of the allowed colours
*/
package starjamchallenge;

/**
 * Enumeration class used for the 7 colours.
 * In hindsight, it would probably have been simpler to just use letters for 
 * colours and strings for the code patches, but enums were alright.
 * 
 * @author Eoghan
 */
public enum Colour {
    R, O, Y, G, B, I, V;
    
    // code to cast int to enum pretty much cut & pasted from discussion at
    // http://stackoverflow.com/questions/5878952/cast-int-to-enum-in-java
    public static Colour fromInteger(int x) {
        switch(x) {
        case 0:
            return R;
        case 1:
            return O;
        case 2:
            return Y;
        case 3:
            return G;
        case 4:
            return B;
        case 5:
            return I;
        case 6:
            return V;
        }
        return null;
    }

}

