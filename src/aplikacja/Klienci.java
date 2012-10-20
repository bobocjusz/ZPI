package aplikacja;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;


@Entity
@Table(name = "KLIENCI", catalog = "", schema = "DAGMARA")
@NamedQueries({
    @NamedQuery(name = "Klienci.findAll", query = "SELECT k FROM Klienci k"),
    @NamedQuery(name = "Klienci.findByNik", query = "SELECT k FROM Klienci k WHERE k.nik = :nik"),
    @NamedQuery(name = "Klienci.findByNip", query = "SELECT k FROM Klienci k WHERE k.nip = :nip"),
    @NamedQuery(name = "Klienci.findByNazwaFirmy", query = "SELECT k FROM Klienci k WHERE k.nazwaFirmy = :nazwaFirmy"),
    @NamedQuery(name = "Klienci.findByNazwisko", query = "SELECT k FROM Klienci k WHERE k.nazwisko = :nazwisko"),
    @NamedQuery(name = "Klienci.findByImie", query = "SELECT k FROM Klienci k WHERE k.imie = :imie"),
    @NamedQuery(name = "Klienci.findByMiasto", query = "SELECT k FROM Klienci k WHERE k.miasto = :miasto"),
    @NamedQuery(name = "Klienci.findByUlica", query = "SELECT k FROM Klienci k WHERE k.ulica = :ulica"),
    @NamedQuery(name = "Klienci.findByNumer", query = "SELECT k FROM Klienci k WHERE k.numer = :numer"),
    @NamedQuery(name = "Klienci.findByKodPocztowy", query = "SELECT k FROM Klienci k WHERE k.kodPocztowy = :kodPocztowy"),
    @NamedQuery(name = "Klienci.findByPoczta", query = "SELECT k FROM Klienci k WHERE k.poczta = :poczta"),
    @NamedQuery(name = "Klienci.findByTelefon", query = "SELECT k FROM Klienci k WHERE k.telefon = :telefon"),
    @NamedQuery(name = "Klienci.findByLogin", query = "SELECT k FROM Klienci k WHERE k.login = :login")})
public class Klienci implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "NIK")
    private BigDecimal nik;
    @Column(name = "NIP")
    private String nip;
    @Column(name = "NAZWA_FIRMY")
    private String nazwaFirmy;
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Column(name = "IMIE")
    private String imie;
    @Basic(optional = false)
    @Column(name = "MIASTO")
    private String miasto;
    @Column(name = "ULICA")
    private String ulica;
    @Basic(optional = false)
    @Column(name = "NUMER")
    private String numer;
    @Basic(optional = false)
    @Column(name = "KOD_POCZTOWY")
    private String kodPocztowy;
    @Basic(optional = false)
    @Column(name = "POCZTA")
    private String poczta;
    @Column(name = "TELEFON")
    private String telefon;
    @Column(name = "LOGIN")
    private String login;

    public Klienci() {
    }

    public Klienci(BigDecimal nik) {
        this.nik = nik;
    }

    public Klienci(BigDecimal nik, String miasto, String numer, String kodPocztowy, String poczta) {
        this.nik = nik;
        this.miasto = miasto;
        this.numer = numer;
        this.kodPocztowy = kodPocztowy;
        this.poczta = poczta;
    }

    public BigDecimal getNik() {
        return nik;
    }

    public void setNik(BigDecimal nik) {
        BigDecimal oldNik = this.nik;
        this.nik = nik;
        changeSupport.firePropertyChange("nik", oldNik, nik);
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        String oldNip = this.nip;
        this.nip = nip;
        changeSupport.firePropertyChange("nip", oldNip, nip);
    }

    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public void setNazwaFirmy(String nazwaFirmy) {
        String oldNazwaFirmy = this.nazwaFirmy;
        this.nazwaFirmy = nazwaFirmy;
        changeSupport.firePropertyChange("nazwaFirmy", oldNazwaFirmy, nazwaFirmy);
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        String oldNazwisko = this.nazwisko;
        this.nazwisko = nazwisko;
        changeSupport.firePropertyChange("nazwisko", oldNazwisko, nazwisko);
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        String oldImie = this.imie;
        this.imie = imie;
        changeSupport.firePropertyChange("imie", oldImie, imie);
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        String oldMiasto = this.miasto;
        this.miasto = miasto;
        changeSupport.firePropertyChange("miasto", oldMiasto, miasto);
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        String oldUlica = this.ulica;
        this.ulica = ulica;
        changeSupport.firePropertyChange("ulica", oldUlica, ulica);
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        String oldNumer = this.numer;
        this.numer = numer;
        changeSupport.firePropertyChange("numer", oldNumer, numer);
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        String oldKodPocztowy = this.kodPocztowy;
        this.kodPocztowy = kodPocztowy;
        changeSupport.firePropertyChange("kodPocztowy", oldKodPocztowy, kodPocztowy);
    }

    public String getPoczta() {
        return poczta;
    }

    public void setPoczta(String poczta) {
        String oldPoczta = this.poczta;
        this.poczta = poczta;
        changeSupport.firePropertyChange("poczta", oldPoczta, poczta);
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        String oldTelefon = this.telefon;
        this.telefon = telefon;
        changeSupport.firePropertyChange("telefon", oldTelefon, telefon);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        String oldLogin = this.login;
        this.login = login;
        changeSupport.firePropertyChange("login", oldLogin, login);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nik != null ? nik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klienci)) {
            return false;
        }
        Klienci other = (Klienci) object;
        if ((this.nik == null && other.nik != null) || (this.nik != null && !this.nik.equals(other.nik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.Klienci[ nik=" + nik + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
