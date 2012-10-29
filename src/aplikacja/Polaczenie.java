package aplikacja;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Vector;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import java.lang.Object;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;


public class Polaczenie {
    Connection connection;
    String tekst;
    Vector columnNames;
    Vector data;
    Validator valid;
    int np; String nazwisko; String imie; String pesel; String nip; String miasto; String ulica;
    String numer; String kod_pocztowy; String poczta; String stanowisko;
    int maxx;
   
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
            ResultSet result = w.executeQuery("SELECT * FROM Klienci WHERE NIP = '" + NIP + "'");      
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
            ResultSet result = w.executeQuery("SELECT * FROM Hasla WHERE Identyfikator = " + identyfikator + " AND Haslo = '" + Haslo + "'");      
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
            public String edycjaDostawcy (Integer NID,String NIP, String Nazwa_firmy, String Miasto, String Ulica, String Numer, String Kod_pocztowy, String Poczta, String Telefon) throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            w.executeUpdate("UPDATE DOSTAWCY SET NIP='"+NIP+"', Nazwa_dostawcy='"+Nazwa_firmy+"',Miasto='"+Miasto+"', Ulica='"+Ulica+"', Numer='"+Numer+"', Kod_pocztowy='"+Kod_pocztowy+"', Poczta='"+Poczta+"', Telefon='"+Telefon+"' WHERE NID='"+NID+"'");
            tekst = "Zmieniono zapis w bazie danych !!";
            connection.commit();
            w.close();                 
        } 
        else {
            tekst = "Nie moge się połączyć! I jest mega dupa";
        }
        return tekst;
    }
            
    public String zapiszDostawe (int NID, String data, String Status, int pracownik) throws ClassNotFoundException, SQLException {
        //if (valid.validujImie(Imie)) {
            if (connection != null) {
                java.sql.Statement s = connection.createStatement();          
                s.execute("INSERT INTO DOSTAWY (NID, Data_dostawy, Status, NP) VALUES ("+ NID + ", to_date('" + data + "', 'dd/MM/yyyy'), '" + Status + "', " +  pracownik + ")");
                //zapiszOpisDostawy();
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
    
    public String zapiszOpisDostawy (int towar, int ilosc, int cena) throws ClassNotFoundException, SQLException {
        //if (valid.validujImie(Imie)) {
            if (connection != null) {
                java.sql.Statement w = connection.createStatement();
                ResultSet result = w.executeQuery("select max(IdDostawy) from dostawy"); 
                if (result.next()) {
                    maxx = result.getInt(1);             
                    
                }  
                //tekst = "Dodano do bazy danych!";
             
                w.executeQuery("INSERT INTO Opisy_dostaw VALUES (" + maxx + ", " + towar + ", " + ilosc + ", " + cena + ")"); 
                w.close(); 
            } 
            else {
                tekst = "Nie moge się połączyć! I jest mega dupa";
            }
        return tekst;
    }
       public String zapiszTowar(String nazwa_towaru, int ilosc_w_sklepie, float cena_sklepowa, int minimum_towar, String opis, String zdjecie, int kategoria) throws ClassNotFoundException, SQLException {
        //if (valid.validujImie(Imie)) {
            if (connection != null) {
                java.sql.Statement s = connection.createStatement();  
              int cena_sklepowa2=2;
              
                s.execute("INSERT INTO TOWARY (Nazwa_towaru, Ilosc_w_sklepie, Cena_sklepowa, Minimum_towar, Opis, Zdjecie, Kategoria) VALUES ('" + nazwa_towaru + "', '" + ilosc_w_sklepie + "', '" + cena_sklepowa2+ "', '" + minimum_towar + "', '" + opis + "', '/files/Pictures/"+zdjecie + "', '" + kategoria + "')");
                tekst = "Dodano do bazy danych!";
                s.close();
            } 
            else {
                tekst = "Nie moge się połączyć! I jest mega dupa";
            }
            return tekst;
       }
       
          public String usunTowar(Integer ID) throws SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            w.executeQuery("DELETE FROM TOWARY WHERE IDTOWARU='" + ID + "'");
            tekst = "Usunięto towar z bazy danych !!";
            connection.commit();
            w.close();                 
        } 
        else {
            tekst = "Nie moge się połączyć! I jest mega dupa";
        }
        return tekst;
    } 
          public void wyslijzdjecie (String sciezkazdjecia, String nazwazdjecia) throws java.io.FileNotFoundException, java.io.IOException, java.net.SocketException
          {FTPClient client = new FTPClient(); 
              FileInputStream fis = null; 
            
                   client.connect("cytrynowypatrol.no-ip.org");      
                    client.login("oracle", "123");
                  client.setFileType(FTP.BINARY_FILE_TYPE);
                  client.setFileTransferMode(FTP.BINARY_FILE_TYPE);   
                   fis = new FileInputStream(sciezkazdjecia);
                  client.storeFile(nazwazdjecia, fis);
               client.logout();
                fis.close(); 
                
       
          }
}