/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Slawek
 */
@Entity
@Table(name = "DOSTAWCY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dostawcy.findAll", query = "SELECT d FROM Dostawcy d"),
    @NamedQuery(name = "Dostawcy.findByNid", query = "SELECT d FROM Dostawcy d WHERE d.nid = :nid"),
    @NamedQuery(name = "Dostawcy.findByRegon", query = "SELECT d FROM Dostawcy d WHERE d.regon = :regon"),
    @NamedQuery(name = "Dostawcy.findByNip", query = "SELECT d FROM Dostawcy d WHERE d.nip = :nip"),
    @NamedQuery(name = "Dostawcy.findByNazwaDostawcy", query = "SELECT d FROM Dostawcy d WHERE d.nazwaDostawcy = :nazwaDostawcy"),
    @NamedQuery(name = "Dostawcy.findByMiasto", query = "SELECT d FROM Dostawcy d WHERE d.miasto = :miasto"),
    @NamedQuery(name = "Dostawcy.findByUlica", query = "SELECT d FROM Dostawcy d WHERE d.ulica = :ulica"),
    @NamedQuery(name = "Dostawcy.findByNumer", query = "SELECT d FROM Dostawcy d WHERE d.numer = :numer"),
    @NamedQuery(name = "Dostawcy.findByKodPocztowy", query = "SELECT d FROM Dostawcy d WHERE d.kodPocztowy = :kodPocztowy"),
    @NamedQuery(name = "Dostawcy.findByPoczta", query = "SELECT d FROM Dostawcy d WHERE d.poczta = :poczta"),
    @NamedQuery(name = "Dostawcy.findByTelefon", query = "SELECT d FROM Dostawcy d WHERE d.telefon = :telefon")})
public class Dostawcy implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "NID")
    private BigDecimal nid;
    @Basic(optional = false)
    @Column(name = "REGON")
    private BigInteger regon;
    @Basic(optional = false)
    @Column(name = "NIP")
    private String nip;
    @Basic(optional = false)
    @Column(name = "NAZWA_DOSTAWCY")
    private String nazwaDostawcy;
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

    public Dostawcy() {
    }

    public Dostawcy(BigDecimal nid) {
        this.nid = nid;
    }

    public Dostawcy(BigDecimal nid, BigInteger regon, String nip, String nazwaDostawcy, String miasto, String numer, String kodPocztowy, String poczta) {
        this.nid = nid;
        this.regon = regon;
        this.nip = nip;
        this.nazwaDostawcy = nazwaDostawcy;
        this.miasto = miasto;
        this.numer = numer;
        this.kodPocztowy = kodPocztowy;
        this.poczta = poczta;
    }

    public BigDecimal getNid() {
        return nid;
    }

    public void setNid(BigDecimal nid) {
        BigDecimal oldNid = this.nid;
        this.nid = nid;
        changeSupport.firePropertyChange("nid", oldNid, nid);
    }

    public BigInteger getRegon() {
        return regon;
    }

    public void setRegon(BigInteger regon) {
        BigInteger oldRegon = this.regon;
        this.regon = regon;
        changeSupport.firePropertyChange("regon", oldRegon, regon);
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        String oldNip = this.nip;
        this.nip = nip;
        changeSupport.firePropertyChange("nip", oldNip, nip);
    }

    public String getNazwaDostawcy() {
        return nazwaDostawcy;
    }

    public void setNazwaDostawcy(String nazwaDostawcy) {
        String oldNazwaDostawcy = this.nazwaDostawcy;
        this.nazwaDostawcy = nazwaDostawcy;
        changeSupport.firePropertyChange("nazwaDostawcy", oldNazwaDostawcy, nazwaDostawcy);
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nid != null ? nid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dostawcy)) {
            return false;
        }
        Dostawcy other = (Dostawcy) object;
        if ((this.nid == null && other.nid != null) || (this.nid != null && !this.nid.equals(other.nid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikacja.Dostawcy[ nid=" + nid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
