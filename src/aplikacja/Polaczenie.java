package aplikacja;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.Vector;
import javax.persistence.Query;


public class Polaczenie {
    Connection connection;
    String tekst;
    Vector columnNames;
    Vector data;
    Validator valid;
   
    
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
    
    public String znajdzNIP (String NIP) throws SQLException {
        java.sql.Statement w = connection.createStatement();
        ResultSet result = w.executeQuery("SELECT * FROM DAGMARA.Klienci WHERE NIP = '" + NIP + "'");      
        tekst = result.getString("NIP");
        //tekst = "";
        w.close();                      
        return tekst;
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
}