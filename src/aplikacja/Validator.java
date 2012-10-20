package aplikacja;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dagmara
 */
public class Validator {
    //boolean sprawdzone;
    
    public Validator() {  
        //sprawdzone = false;
    }
    
    public boolean validujImie (String imie) {
        boolean sprawdzone = true;
        String expression = "[A-Z]([a-z]+|\\s[a-z]+)";  
        CharSequence inputStr = imie;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        if (!matcher.matches() || imie.length() == 0) {
            JOptionPane.showMessageDialog(null, "Popraw imię! ", "Error", JOptionPane.ERROR_MESSAGE);
            sprawdzone = false;
        }
        return sprawdzone;
    }
}
