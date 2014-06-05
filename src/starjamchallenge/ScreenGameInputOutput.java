package starjamchallenge;

import javax.swing.*;        

/**
 *
 * @author Eoghan
 */
public class ScreenGameInputOutput extends GameInputOutput {
    
    ScreenGameInputOutput () {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    public void handleGameWon(GuessRecord rec) {
        // do graphical implementation
    }
    
    public void handleGameLost(GuessRecord rec) {
        // do graphical implementation        
    }
    
    public void handleDuplicateGuess() {
        // do graphical implementation        
    }
    
    public String promptUserForInput() {
        // do graphical implementation        
        return "rrrr";
    }
    
    public boolean promptToPlayAgain() {
        // do graphical implementation        
        return false;
    }
    
    public void showCurrentGameState(GuessRecord rec) {
        // do graphical implementation        
    }
    
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
}
