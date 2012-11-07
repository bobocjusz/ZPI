/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dagmara
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
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "NID")
    private BigDecimal nid;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nid")
    private Collection<Dostawy> dostawyCollection;

    public Dostawcy() {
    }

    public Dostawcy(BigDecimal nid) {
        this.nid = nid;
    }

    public Dostawcy(BigDecimal nid, String nip, String nazwaDostawcy, String miasto, String numer, String kodPocztowy, String poczta) {
        this.nid = nid;
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
        this.nid = nid;
    }

    public BigInteger getRegon() {
        return regon;
    }

    public void setRegon(BigInteger regon) {
        this.regon = regon;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNazwaDostawcy() {
        return nazwaDostawcy;
    }

    public void setNazwaDostawcy(String nazwaDostawcy) {
        this.nazwaDostawcy = nazwaDostawcy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getPoczta() {
        return poczta;
    }

    public void setPoczta(String poczta) {
        this.poczta = poczta;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @XmlTransient
    public Collection<Dostawy> getDostawyCollection() {
        return dostawyCollection;
    }

    public void setDostawyCollection(Collection<Dostawy> dostawyCollection) {
        this.dostawyCollection = dostawyCollection;
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
    
}
