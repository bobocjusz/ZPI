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
        String expression = "[A-Z]([a-z]+|\\s[A-Z][a-z]){2,30}";  
        CharSequence inputStr = imie;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        if (!matcher.matches() || imie.length() == 0) {
            JOptionPane.showMessageDialog(null, "Popraw imię! ", "Error", JOptionPane.ERROR_MESSAGE);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
    public boolean validujNazwisko(String nazwisko) {
        boolean sprawdzone = true;
        String expression = "[A-Z]([a-z]+|\\s*-*[A-Z][a-z]){2,30}";
        CharSequence inputStr = nazwisko;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        if (!matcher.matches() || nazwisko.length() == 0) {
            JOptionPane.showMessageDialog(null, "Popraw nazwisko! ", "Error", JOptionPane.ERROR_MESSAGE);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
    public boolean validujFirma (String nazwa_firmy) {
        boolean sprawdzone = true;
        if (nazwa_firmy.length() == 0) {
            JOptionPane.showMessageDialog(null, "Wypełnij nazwę firmy! ", "Error", JOptionPane.ERROR_MESSAGE);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
    public boolean validujMiasto (String miasto) {
        boolean sprawdzone = true;
        String expression = "[A-Z]([a-z]+|\\s*-*[A-Z][a-z]){2,30}";
        CharSequence inputStr = miasto;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        if (!matcher.matches() || miasto.length() == 0) {
            JOptionPane.showMessageDialog(null, "Popraw miasto! ", "Error", JOptionPane.ERROR_MESSAGE);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
     public boolean validujNumerDomu (String numer) {
        boolean sprawdzone = true;
        if (numer.length() == 0) {
            JOptionPane.showMessageDialog(null, "Wypełnij numer domu/mieszkania! ", "Error", JOptionPane.ERROR_MESSAGE);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
    public boolean validujKodPocztowy (String kod) {
        boolean sprawdzone = true;
        String expression = "\\d{2}-\\d{3}";
        CharSequence inputStr = kod;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        if (!matcher.matches() || kod.length() == 0) {
            JOptionPane.showMessageDialog(null, "Błędny kod pocztowy! ", "Error", JOptionPane.ERROR_MESSAGE);
            sprawdzone = false;
        }
        return sprawdzone;
    }

    public boolean validujPoczte (String poczta) {
        boolean sprawdzone = true;
        String expression = "[A-Z]([a-z]+|\\s*-*[A-Z][a-z]){2,30}";
        CharSequence inputStr = poczta;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        if (!matcher.matches() || poczta.length() == 0) {
            JOptionPane.showMessageDialog(null, "Popraw pocztę! ", "Error", JOptionPane.ERROR_MESSAGE);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
    public boolean validujNumer (String numer) {
        boolean sprawdzone = true;
        String expression = "(\\d{7,13})*";
        CharSequence inputStr = numer;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(null, "Popraw numer telefonu! ", "Error", JOptionPane.ERROR_MESSAGE);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
    public static void main (String[] args) {
        Validator valid = new Validator();
        //valid.validujImie("Daa Ja");
        //valid.validujNazwisko("Gawel");
        //valid.validujMiasto("San Francisco");
        //valid.validujKodPocztowy("63-940");
        valid.validujNumer("665212227");
    }
}
