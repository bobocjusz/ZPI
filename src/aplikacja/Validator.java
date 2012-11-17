package aplikacja;

import com.toedter.calendar.JDateChooser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Validator {
    boolean sprawdzone;
    
    public Validator() {  
        sprawdzone = true;
    }
    
    public boolean validujImie (String imie, JLabel label) {
        boolean sprawdzone = true;
        String expression = "[A-ZŁŻa-złż]{1}([a-ząćęłńóśźż]+|\\s[A-ZŁŻ][a-ząćęłńóśźż]*){1,30}";  
        CharSequence inputStr = imie;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        if (!matcher.matches() || imie.length() == 0) {
            //JOptionPane.showMessageDialog(null, "Popraw imię! ", "Błąd", JOptionPane.ERROR_MESSAGE);
            label.setVisible(true);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
    public boolean validujNazwisko(String nazwisko, JLabel label) {
        boolean sprawdzone = true;
        String expression = "[A-ZĄĆĘŁŃÓŚŹŻa-ząćęłńóśźż]{1}([a-ząćęłńóśźż]+|\\s*-*[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]){1,30}";
        CharSequence inputStr = nazwisko;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        if (!matcher.matches() || nazwisko.length() == 0) {
            //JOptionPane.showMessageDialog(null, "Popraw nazwisko! ", "Błąd", JOptionPane.ERROR_MESSAGE);
            label.setVisible(true);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
    public boolean validujFirma (String nazwa_firmy, JLabel label) {
        boolean sprawdzone = true;
        if (nazwa_firmy.length() == 0) {
            //JOptionPane.showMessageDialog(null, "Wypełnij nazwę firmy! ", "Błąd", JOptionPane.ERROR_MESSAGE);
            //label.setText("Wypełnij wymagane pole! ");
            label.setVisible(true);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
    public boolean validujMiasto (String miasto, JLabel label) {
        boolean sprawdzone = true;
        String expression = "[A-ZĄĆĘŁŃÓŚŹŻa-ząćęłńóśźż]{1}([a-ząćęłńóśźż]+|\\s*-*[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]){1,30}";
        CharSequence inputStr = miasto;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        if (!matcher.matches() || miasto.length() == 0) {
            //JOptionPane.showMessageDialog(null, "Popraw miasto! ", "Błąd", JOptionPane.ERROR_MESSAGE);
            label.setVisible(true);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
     public boolean validujNumerDomu (String numer, JLabel label) {
        boolean sprawdzone = true;
        if (numer.length() == 0) {
            //JOptionPane.showMessageDialog(null, "Wypełnij numer domu/mieszkania! ", "Błąd", JOptionPane.ERROR_MESSAGE);
            label.setVisible(true);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
    public boolean validujKodPocztowy (String kod, JLabel label) {
        boolean sprawdzone = true;
        String expression = "\\d{2}-\\d{3}";
        CharSequence inputStr = kod;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        if (!matcher.matches() || kod.length() == 0) {
            //JOptionPane.showMessageDialog(null, "Błędny kod pocztowy! ", "Błąd", JOptionPane.ERROR_MESSAGE);
            label.setVisible(true);
            sprawdzone = false;
        }
        return sprawdzone;
    }

    public boolean validujPoczte (String poczta, JLabel label) {
        boolean sprawdzone = true;
        String expression = "[A-ZĄĆĘŁŃÓŚŹŻa-ząćęłńóśźż]{1}([a-ząćęłńóśźż]+|\\s*-*[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]){1,30}";
        CharSequence inputStr = poczta;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        if (!matcher.matches() || poczta.length() == 0) {
            //JOptionPane.showMessageDialog(null, "Popraw pocztę! ", "Błąd", JOptionPane.ERROR_MESSAGE);
            label.setVisible(true);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
    public boolean validujNumer (String numer, JLabel label) {
        sprawdzone = true;
        String expression = "(\\d{7,13})*";
        CharSequence inputStr = numer;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        if (!matcher.matches()) {
            //JOptionPane.showMessageDialog(null, "Popraw numer telefonu! ", "Błąd", JOptionPane.ERROR_MESSAGE);
            label.setVisible(true);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
    public boolean validujNIP (String nip, JLabel label) {
        boolean sprawdzone = true;
        String expression = "(\\d{10})*";
        CharSequence inputStr = nip;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        if (!matcher.matches()) {
            label.setVisible(true);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
       public boolean validujPesel(String nip, JLabel label) {
        boolean sprawdzone = true;
        String expression = "(\\d{11})*";
        CharSequence inputStr = nip;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        if (!matcher.matches() || nip.length() == 0) {
            label.setVisible(true);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    public boolean validujIlosc (String ilosc, JLabel label) {
        boolean sprawdzone = true;
        String expression = "\\d{1,1000}";
        CharSequence inputStr = ilosc;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        if (!matcher.matches() || ilosc.length() == 0) {
            label.setVisible(true);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
    public boolean validujCena (String cena, JLabel label) {
         sprawdzone = true;
        String expression = "^([0-9]{1,6}).([0-9]{0,2})$";
        CharSequence inputStr = cena;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        String expression2 = "\\d";
        Pattern pattern2 = Pattern.compile(expression2);  
        Matcher matcher2 = pattern2.matcher(inputStr);  
        if (!matcher.matches() && !matcher2.matches() || cena.length() == 0 ) {
            label.setVisible(true);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
    public boolean validujDate (JDateChooser data, JLabel label) {
        boolean sprawdzone = true;
        if (data.getDate() == null) {
            label.setVisible(true);
            sprawdzone = false;
        }
        return sprawdzone;
    }
  
    public boolean test (String ilosc, JLabel label) {
        sprawdzone = true;
        String expression = "(?:\\d{10}|\\d{11})?";
        CharSequence inputStr = ilosc;  
        Pattern pattern = Pattern.compile(expression);  
        Matcher matcher = pattern.matcher(inputStr);  
        if (!matcher.matches() || ilosc.length() == 0) {
            label.setVisible(true);
            sprawdzone = false;
        }
        return sprawdzone;
    }
    
    public static void main (String[] args) {
        Validator valid = new Validator();
        JLabel label = new JLabel();
        valid.validujNumer("", label);
        //valid.validujNazwisko("Gaweł", label);
        //valid.validujFirma("San Francisco");
        //valid.validujMiasto("San Francisco");
        //valid.validujKodPocztowy("63-940");
        //valid.validujPoczte("63-940");
        //valid.test("", label);
        System.out.println(valid.sprawdzone);
    }
}
