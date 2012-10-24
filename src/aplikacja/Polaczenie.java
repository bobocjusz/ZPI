package aplikacja;

import java.sql.*;
import java.util.Vector;
import javax.persistence.Query;
import javax.swing.JOptionPane;


public class Polaczenie {
    Connection connection;
    String tekst;
    Vector columnNames;
    Vector data;
    Validator valid;
    int np; String nazwisko; String imie; String pesel; String nip; String miasto; String ulica;
    String numer; String kod_pocztowy; String poczta; String stanowisko;
   
    public Polaczenie() throws ClassNotFoundException, SQLException {
        valid = new Validator();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection( "jdbc:oracle:thin:@cytrynowypatrol.no-ip.org:1521:DB11G", "DAGMARA", "123");
            tekst = "Połączono!";
        } 
        catch (ClassNotFoundException e) {
            tekst=("Nie chodzi bilbioteka, jest lipa");
            e.printStackTrace();
        }
    }
    
    public String zapiszKlient (String NIP, String Nazwa_firmy, String Nazwisko, String Imie, String Miasto, String Ulica, String Numer, String Kod_pocztowy, String Poczta, String Telefon) throws ClassNotFoundException, SQLException {
        //if (valid.validujImie(Imie)) {
            if (connection != null) {
                java.sql.Statement s = connection.createStatement();          
                s.execute("INSERT INTO KLIENCI (NIP, Nazwa_firmy, Nazwisko, Imie, Miasto, Ulica, Numer, Kod_pocztowy, Poczta, Telefon) VALUES ('"+ NIP + "', '" + Nazwa_firmy + "', '" + Nazwisko + "', '" + Imie + "', '" + Miasto + "', '" + Ulica + "', '" + Numer + "', '" + Kod_pocztowy + "', '" + Poczta + "', '" + Telefon + "')");
                tekst = "Dodano do bazy danych!";
                s.close();
            } 
            else {
                tekst = "Nie moge się połączyć! I jest mega dupa";
            } 
        //}
        //else {            
        //    tekst = "Popraw imię!";
        //}
        return tekst;
    }
    
    public String edycjaKlient (Integer NIK,String NIP, String Nazwa_firmy, String Nazwisko, String Imie, String Miasto, String Ulica, String Numer, String Kod_pocztowy, String Poczta, String Telefon) throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            w.executeUpdate("UPDATE KLIENCI SET NIP='"+NIP+"', Nazwa_firmy='"+Nazwa_firmy+"', Nazwisko='"+Nazwisko+"', Imie='"+Imie+"', Miasto='"+Miasto+"', Ulica='"+Ulica+"', Numer='"+Numer+"', Kod_pocztowy='"+Kod_pocztowy+"', Poczta='"+Poczta+"', Telefon='"+Telefon+"' WHERE NIK='"+NIK+"'");
            tekst = "Zmieniono zapis w bazie danych !!";
            connection.commit();
            w.close();                 
        } 
        else {
            tekst = "Nie moge się połączyć! I jest mega dupa";
        }
        return tekst;
    }     
    
    public boolean znajdzNIP (String NIP) throws SQLException {
        boolean jest = false;
        if (NIP.length() != 0) {
            java.sql.Statement w = connection.createStatement();
            ResultSet result = w.executeQuery("SELECT * FROM DAGMARA.Klienci WHERE NIP = '" + NIP + "'");      
            if (result.next()) {
                JOptionPane.showMessageDialog(null, "NIP klienta juz istnieje! ", "Error", JOptionPane.ERROR_MESSAGE);
                jest = true;
                w.close(); 
            }  
        }
        return jest;
    }
    
    public String usunKlient (Integer NIK) throws SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            w.executeQuery("DELETE FROM KLIENCI WHERE NIK='" + NIK + "'");
            tekst = "Usunięto klienta z bazy danych !!";
            connection.commit();
            w.close();                 
        } 
        else {
            tekst = "Nie moge się połączyć! I jest mega dupa";
        }
        return tekst;
    }    
    
    public String znajdzPracownik (Integer NP) throws SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            ResultSet result = w.executeQuery("SELECT * FROM PRACOWNICY inner JOIN Stanowiska ON Pracownicy.Stanowisko = Stanowiska.Identyfikator WHERE Pracownicy.NP=" + NP); 
            if (result.next()) {
                np = result.getInt(1);
                nazwisko = result.getString(2);
                imie = result.getString(3);
                pesel = result.getString(4);
                nip = result.getString(5);
                miasto = result.getString(6);
                ulica = result.getString(7);
                numer = result.getString(8);
                kod_pocztowy = result.getString(9);
                poczta = result.getString(10);
                stanowisko = result.getString(13);               
                w.close(); 
            }  
        } 
        else {
            tekst = "Nie moge się połączyć! I jest mega dupa";
        }
        return tekst;
    }    
    
    public String edycjaHasla (Integer Identyfikator, String Haslo) throws SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            w.executeUpdate("UPDATE HASLA SET Haslo = '" + Haslo + "' WHERE Identyfikator = " + Identyfikator);
            tekst = "Hasło zostało zmienione! ";
            connection.commit();
            w.close();                 
        } 
        else {
            tekst = "Nie moge się połączyć! I jest mega dupa";
        }
        return tekst;
    }    
    
    public boolean znajdzHaslo (Integer identyfikator, String Haslo) throws SQLException {
        boolean dobre = false;
        if (Haslo.length() != 0) {
            java.sql.Statement w = connection.createStatement();
            ResultSet result = w.executeQuery("SELECT * FROM DAGMARA.Hasla WHERE Identyfikator = " + identyfikator + " AND Haslo = '" + Haslo + "'");      
            if (result.next()) {
                //JOptionPane.showMessageDialog(null, "NIP klienta juz istnieje! ", "Error", JOptionPane.ERROR_MESSAGE);
                dobre = true;
                w.close(); 
            }  
        }
        return dobre;
    }
    
    public String zmianaDanych (Integer NP, String Nazwisko, String Miasto, String Ulica, String Numer, String Kod_pocztowy, String Poczta) throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            w.executeUpdate("UPDATE PRACOWNICY SET Nazwisko = '" + Nazwisko + "', Miasto = '" + Miasto + "', Ulica = '" + Ulica + "', Numer = '" + Numer + "', Kod_pocztowy = '" + Kod_pocztowy + "', Poczta = '" + Poczta + "' WHERE NP = " + NP);
            tekst = "Zmieniono zapis w bazie danych !!";
            connection.commit();
            w.close();                 
        } 
        else {
            tekst = "Nie moge się połączyć! I jest mega dupa";
        }
        return tekst;
    }    
    
        public String zapiszDostawca (String NIP, String Nazwa_dostawcy, String Miasto, String Ulica, String Numer, String Kod_pocztowy, String Poczta, String Telefon) throws ClassNotFoundException, SQLException {
        //if (valid.validujImie(Imie)) {
            if (connection != null) {
                java.sql.Statement s = connection.createStatement();          
                s.execute("INSERT INTO DOSTAWCY (NIP, Nazwa_dostawcy, Miasto, Ulica, Numer, Kod_pocztowy, Poczta, Telefon) VALUES ('"+ NIP + "', '" + Nazwa_dostawcy + "', '" + Miasto + "', '" + Ulica + "', '" + Numer + "', '" + Kod_pocztowy + "', '" + Poczta + "', '" + Telefon + "')");
                tekst = "Dodano do bazy danych!";
                s.close();
            } 
            else {
                tekst = "Nie moge się połączyć! I jest mega dupa";
            } 
        //}
        //else {            
        //    tekst = "Popraw imię!";
        //}
        return tekst;
    }
           public String usunDostawca (Integer NID) throws SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            w.executeQuery("DELETE FROM DOSTAWCY WHERE NID='" + NID + "'");
            tekst = "Usunięto dostawcę z bazy danych !!";
            connection.commit();
            w.close();                 
        } 
        else {
            tekst = "Nie moge się połączyć! I jest mega dupa";
        }
        return tekst;
    } 
}