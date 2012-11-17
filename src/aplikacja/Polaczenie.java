package aplikacja;

import java.io.*;

import java.sql.*;
import java.util.Vector;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import java.lang.Object;
import java.awt.*;
import java.awt.Image.*;
import javax.imageio.ImageIO;
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
        if (connection != null) {
            java.sql.Statement s = connection.createStatement();          
            s.execute("INSERT INTO KLIENCI (NIP, Nazwa_firmy, Nazwisko, Imie, Miasto, Ulica, Numer, Kod_pocztowy, Poczta, Telefon) VALUES ('"+ NIP + "', '" + Nazwa_firmy + "', '" + Nazwisko + "', '" + Imie + "', '" + Miasto + "', '" + Ulica + "', '" + Numer + "', '" + Kod_pocztowy + "', '" + Poczta + "', '" + Telefon + "')");
            tekst = "Dodano do bazy danych!";
            s.close();
        } 
        else {
            tekst = "Nie moge się połączyć! I jest mega dupa";
        } 
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
    public boolean znajdzNIPEdycja (String starynip, String NIP) throws SQLException {
        boolean jest = false;
        if (starynip.equals(NIP))
        {
            return jest;
        }
        
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
        if (connection != null) {
            java.sql.Statement s = connection.createStatement();          
            s.execute("INSERT INTO DOSTAWCY (NIP, Nazwa_dostawcy, Miasto, Ulica, Numer, Kod_pocztowy, Poczta, Telefon) VALUES ('"+ NIP + "', '" + Nazwa_dostawcy + "', '" + Miasto + "', '" + Ulica + "', '" + Numer + "', '" + Kod_pocztowy + "', '" + Poczta + "', '" + Telefon + "')");
            tekst = "Dodano do bazy danych!";
            s.close();
        } 
        else {
            tekst = "Nie moge się połączyć! I jest mega dupa";
        } 
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
            
    public void zapiszDostawe (int NID, String data, String Status, int pracownik) throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement s = connection.createStatement();          
            s.execute("INSERT INTO DOSTAWY (NID, Data_dostawy, Status, NP) VALUES ("+ NID + ", to_date('" + data + "', 'yyyy/MM/dd'), '" + Status + "', " +  pracownik + ")");
            s.close();
        } 
    }
    
    public void edytujDostawe (int idDostawy, int NID, String data, String Status) throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement s = connection.createStatement();          
            s.execute("UPDATE DOSTAWY SET NID = " + NID + ", data_dostawy = to_date('" + data + "', 'dd/MM/yyyy'), Status = '" + Status + "' WHERE IdDostawy = " +  idDostawy);
            connection.commit();
            s.close();
        } 
    }
    
    public void edytujOpisDostawy (int idDostawy, int towar, int ilosc, float cena) throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            ResultSet result = w.executeQuery("UPDATE Opisy_dostaw SET ilosc = " + ilosc + ", cena_producenta = " + cena + "where idDostawy = " + idDostawy + "and idTowaru = " + towar); 
            connection.commit();
            w.close();
        } 
    }
    
    public void zapiszOpisDostawy (int towar, int ilosc, float cena) throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            ResultSet result = w.executeQuery("select max(IdDostawy) from dostawy"); 
            if (result.next()) {
                maxx = result.getInt(1);             
            }  
            w.executeQuery("INSERT INTO Opisy_dostaw VALUES (" + maxx + ", " + towar + ", " + ilosc + ", " + cena + ")"); 
            w.close(); 
        } 
    }
    
    public void zapiszOpisDostawyEdycja (int IdDostawy, int towar, int ilosc, float cena) throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement(); 
            w.executeQuery("INSERT INTO Opisy_dostaw VALUES (" + IdDostawy + ", " + towar + ", " + ilosc + ", " + cena + ")"); 
            w.close(); 
        } 
    }
    
    public String zapiszTowar(String nazwa_towaru, int ilosc_w_sklepie, String cena_sklepowa, int minimum_towar, String opis, String zdjecie, int kategoria) throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement s = connection.createStatement();  
            
            s.execute("INSERT INTO TOWARY (Nazwa_towaru, Ilosc_w_sklepie, Cena_sklepowa, Minimum_towar, Opis, Zdjecie, Kategoria) VALUES ('" + nazwa_towaru + "', '" + ilosc_w_sklepie + "', '" + cena_sklepowa+ "', '" + minimum_towar + "', '" + opis + "', '/files/Pictures/"+zdjecie + "', '" + kategoria + "')");
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
    
    public void wyslijzdjecie (String sciezkazdjecia, String nazwazdjecia) throws java.io.FileNotFoundException, java.io.IOException, java.net.SocketException {
        FTPClient client = new FTPClient(); 
        FileInputStream fis = null; 
        client.connect("cytrynowypatrol.no-ip.org");      
        client.login("oracle", "123");
       //   client.setKeepAlive(true);
        client.setControlKeepAliveTimeout(3000);
        client.setDataTimeout(3000); // 100 minutes
        client.setConnectTimeout(3000);
        client.setFileType(FTP.BINARY_FILE_TYPE);
        //client.setFileTransferMode(FTP.BINARY_FILE_TYPE);   
        fis = new FileInputStream(sciezkazdjecia);
        client.storeFile(nazwazdjecia, fis);
        
        client.logout();
       
        fis.close(); 
        //client.disconnect();
       
    }
     
    public Image wyciagnijzdjecie (String nazwazdjecia) throws java.io.FileNotFoundException, java.io.IOException, java.net.SocketException {
        FTPClient client = new FTPClient(); 
        FileOutputStream fos = null; 
        String nazwa = nazwazdjecia;    
        String nazwa2 = nazwa.substring(16);    
        client.connect("cytrynowypatrol.no-ip.org");      
        client.login("oracle", "123");
        client.setFileType(FTP.BINARY_FILE_TYPE);
        client.setFileTransferMode(FTP.BINARY_FILE_TYPE);   
        fos = new FileOutputStream(nazwa2);
        client.retrieveFile(nazwa2, fos);
        client.retrieveFileStream(nazwa2);
        client.logout();
        fos.close(); 
        File imageFile = new File(nazwa2);
        Image image = ImageIO.read(imageFile);        
        return image;
    }
    
    public String usunDostawe(Integer IdDostawy) throws SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            w.executeQuery("DELETE FROM Dostawy WHERE IdDostawy = " + IdDostawy);
            tekst = "Usunięto dostawę z bazy danych !!";
            connection.commit();
            w.close();                 
        } 
        else {
            tekst = "Nie moge się połączyć! I jest mega dupa";
        }
        return tekst;
    } 
    
    public void usunOpisyDostaw(Integer IdDostawy) throws SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            w.executeQuery("DELETE FROM Opisy_dostaw WHERE IdDostawy = " + IdDostawy);
            connection.commit();
            w.close();                 
        } 
    } 
    
    public void usunOpisyDostawEdycja(Integer IdDostawy, Integer towar) throws SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            w.executeQuery("DELETE FROM Opisy_dostaw WHERE IdDostawy = " + IdDostawy + " and idTowaru = " + towar);
            connection.commit();
            w.close();                 
        } 
    } 
    
    public String edycjaTowar(Boolean flagazdjecia, Integer ID,String Nazwa_towaru, Integer Ilosc_w_sklepie, String Cena_sklepowa, Integer Minimum_towar, String opis, String Zdjecie,Integer Kategoria) throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            
            if (flagazdjecia==true)
            {w.executeUpdate("UPDATE TOWARY SET Nazwa_towaru='"+Nazwa_towaru+"', Ilosc_w_sklepie='"+Ilosc_w_sklepie+"', Cena_sklepowa='"+Cena_sklepowa+"', Minimum_towar='"+Minimum_towar+"', Opis='"+opis+"', Zdjecie='/files/Pictures/"+Zdjecie+"', Kategoria='"+Kategoria+"' WHERE IDTOWARU='"+ID+"'");}
            if (flagazdjecia==false)
            {w.executeUpdate("UPDATE TOWARY SET Nazwa_towaru='"+Nazwa_towaru+"', Ilosc_w_sklepie='"+Ilosc_w_sklepie+"', Cena_sklepowa='"+Cena_sklepowa+"', Minimum_towar='"+Minimum_towar+"', Opis='"+opis+"', Kategoria='"+Kategoria+"' WHERE IDTOWARU='"+ID+"'");}   
            tekst = "Zmieniono zapis w bazie danych !!";
            connection.commit();
            w.close();                 
        } 
        else {
            tekst = "Nie moge się połączyć! I jest mega dupa";
        }
        return tekst;
    } 
    
    public String zapiszPracownik (String NIP, String Imie, String Nazwisko, String Miasto, String Ulica, String Numer, String Kod_pocztowy, String Poczta, String Pesel, Integer Stanowisko, String login, String haslo) throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement s = connection.createStatement();          
            s.execute("INSERT INTO PRACOWNICY (NIP, Nazwisko, Imie, Miasto, Ulica, Numer, Kod_pocztowy, Poczta, Pesel, Stanowisko) VALUES ('"+ NIP + "', '" + Nazwisko + "', '"+ Imie +"', '" + Miasto + "', '" + Ulica + "', '" + Numer + "', '" + Kod_pocztowy + "', '" + Poczta + "', '" + Pesel + "', '"+ Stanowisko + "')");
            
             ResultSet result = s.executeQuery("select max(NP) from Pracownicy"); 
            if (result.next()) {
                maxx = result.getInt(1);             
            }  
            s.execute("INSERT INTO HASLA (Identyfikator, Login, Haslo) VALUES ('"+ maxx +"', '"+ login +"', '"+ haslo +"')");
            s.close();
            tekst = "Dodano do bazy danych!";
        } 
        else {
            tekst = "Nie moge się połączyć! I jest mega dupa";
        } 
        return tekst;
    }
    
    public boolean znajdzLogin (String Login) throws SQLException {
        boolean jest = false;
        if (Login.length() != 0) {
            java.sql.Statement w = connection.createStatement();
            ResultSet result = w.executeQuery("SELECT * FROM HASLA WHERE LOGIN = '" + Login + "'");      
            if (result.next()) {
                JOptionPane.showMessageDialog(null, "Podany login juz istnieje! ", "Error", JOptionPane.ERROR_MESSAGE);
                jest = true;
                w.close(); 
            }  
        }
        return jest;
    }       
    
     public Boolean istniejeTowarZMinimum () throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            ResultSet result = w.executeQuery("SELECT * FROM Towary WHERE Ilosc_w_sklepie < Minimum_towar"); 
            if (result.next()) {
                return true;  
                
            }  
           w.close(); 
        } 
        return false;
    }
     
     public String usunZamowienie(Integer IdZamowienia) throws SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            w.executeQuery("DELETE FROM Zamowienia WHERE IdZamowienia = " + IdZamowienia);
            tekst = "Usunięto zamówienie z bazy danych !!";
            connection.commit();
            w.close();                 
        } 
        else {
            tekst = "Nie moge się połączyć! I jest mega dupa";
        }
        return tekst;
    } 
    
    public void usunOpisyZamowien(Integer IdZamowienia) throws SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            w.executeQuery("DELETE FROM Opisy_zamowien WHERE IdZamowienia1 = " + IdZamowienia);
            connection.commit();
            w.close();                 
        } 
    } 
    
    public void zapiszZamowienie (int NIK, int pracownik, String data, String Status, int wysylka) throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement s = connection.createStatement();          
            s.execute("INSERT INTO ZAMOWIENIA (NIK, NP, Data_zamowienia, Status, Wysylka) VALUES ("+ NIK + ", " + pracownik + ", to_date('" + data + "', 'yyyy/MM/dd'), '" + Status + "', " + wysylka + ")");
            s.close();
        } 
    }
    
    public void zapiszOpisZamowienia (int towar, int ilosc) throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            ResultSet result = w.executeQuery("select max(IdZamowienia) from Zamowienia"); 
            if (result.next()) {
                maxx = result.getInt(1);             
            }  
            w.executeQuery("INSERT INTO Opisy_zamowien(IdZamowienia1, IdTowaru, Ilosc) VALUES (" + maxx + ", " + towar + ", " + ilosc + ")"); 
            w.close(); 
        } 
    }
    
    public void edytujZamowienie (int idZamowienia, int NIK, String data, String Status, int wysylka) throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement s = connection.createStatement();          
            s.execute("UPDATE Zamowienia SET NIK = " + NIK + ", data_zamowienia = to_date('" + data + "', 'dd/MM/yyyy'), Status = '" + Status + "', Wysylka = " + wysylka + "WHERE IdZamowienia = " +  idZamowienia);
            connection.commit();
            s.close();
        } 
    }
    
    public void edytujOpisZamowienia (int idZamowienia, int towar, int ilosc) throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            ResultSet result = w.executeQuery("UPDATE Opisy_zamowien SET ilosc = " + ilosc + " where idZamowienia1 = " + idZamowienia + "and idTowaru = " + towar); 
            connection.commit();
            w.close();
        } 
    }
    
    public void zapiszOpisZamowieniaEdycja (int IdZamowienia, int towar, int ilosc) throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement(); 
            w.executeQuery("INSERT INTO Opisy_zamowien(IdZamowienia1, IdTowaru, Ilosc) VALUES (" + IdZamowienia + ", " + towar + ", " + ilosc + ")"); 
            w.close(); 
        } 
    }
    
    public void usunOpisyZamowienEdycja(Integer IdZamowienia, Integer towar) throws SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            w.executeQuery("DELETE FROM Opisy_zamowien WHERE IdZamowienia1 = " + IdZamowienia + " and idTowaru = " + towar);
            connection.commit();
            w.close();                 
        } 
    } 
    
    public boolean istniejeTowarKtoryTrzebaDomowic () throws ClassNotFoundException, SQLException {
        if (connection != null) {
            java.sql.Statement w = connection.createStatement();
            ResultSet result = w.executeQuery("SELECT * FROM Opisy_zamowien inner join Towary on Towary.idtowaru = opisy_zamowien.idTowaru WHERE ilosc_w_sklepie < ilosc"); 
            if (result.next()) {
                return true;  
            }  
           w.close(); 
        } 
        return false;
    }
}