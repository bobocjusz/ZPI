/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dagmara
 */
@Entity
@Table(name = "PRACOWNICY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pracownicy.findAll", query = "SELECT p FROM Pracownicy p"),
    @NamedQuery(name = "Pracownicy.findByNp", query = "SELECT p FROM Pracownicy p WHERE p.np = :np"),
    @NamedQuery(name = "Pracownicy.findByNazwisko", query = "SELECT p FROM Pracownicy p WHERE p.nazwisko = :nazwisko"),
    @NamedQuery(name = "Pracownicy.findByImie", query = "SELECT p FROM Pracownicy p WHERE p.imie = :imie"),
    @NamedQuery(name = "Pracownicy.findByPesel", query = "SELECT p FROM Pracownicy p WHERE p.pesel = :pesel"),
    @NamedQuery(name = "Pracownicy.findByNip", query = "SELECT p FROM Pracownicy p WHERE p.nip = :nip"),
    @NamedQuery(name = "Pracownicy.findByMiasto", query = "SELECT p FROM Pracownicy p WHERE p.miasto = :miasto"),
    @NamedQuery(name = "Pracownicy.findByUlica", query = "SELECT p FROM Pracownicy p WHERE p.ulica = :ulica"),
    @NamedQuery(name = "Pracownicy.findByNumer", query = "SELECT p FROM Pracownicy p WHERE p.numer = :numer"),
    @NamedQuery(name = "Pracownicy.findByKodPocztowy", query = "SELECT p FROM Pracownicy p WHERE p.kodPocztowy = :kodPocztowy"),
    @NamedQuery(name = "Pracownicy.findByPoczta", query = "SELECT p FROM Pracownicy p WHERE p.poczta = :poczta")})
public class Pracownicy implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "NP")
    private BigDecimal np;
    @Basic(optional = false)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Basic(optional = false)
    @Column(name = "IMIE")
    private String imie;
    @Basic(optional = false)
    @Column(name = "PESEL")
    private String pesel;
    @Basic(optional = false)
    @Column(name = "NIP")
    private String nip;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "np")
    private Collection<Dostawy> dostawyCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pracownicy")
    private Hasla hasla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "np")
    private Collection<Zamowienia> zamowieniaCollection;
    @JoinColumn(name = "STANOWISKO", referencedColumnName = "IDENTYFIKATOR")
    @ManyToOne
    private Stanowiska stanowisko;

    public Pracownicy() {
    }

    public Pracownicy(BigDecimal np) {
        this.np = np;
    }

    public Pracownicy(BigDecimal np, String nazwisko, String imie, String pesel, String nip, String miasto, String numer, String kodPocztowy, String poczta) {
        this.np = np;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.pesel = pesel;
        this.nip = nip;
        this.miasto = miasto;
        this.numer = numer;
        this.kodPocztowy = kodPocztowy;
        this.poczta = poczta;
    }

    public BigDecimal getNp() {
        return np;
    }

    public void setNp(BigDecimal np) {
        this.np = np;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
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

    @XmlTransient
    public Collection<Dostawy> getDostawyCollection() {
        return dostawyCollection;
    }

    public void setDostawyCollection(Collection<Dostawy> dostawyCollection) {
        this.dostawyCollection = dostawyCollection;
    }

    public Hasla getHasla() {
        return hasla;
    }

    public void setHasla(Hasla hasla) {
        this.hasla = hasla;
    }

    @XmlTransient
    public Collection<Zamowienia> getZamowieniaCollection() {
        return zamowieniaCollection;
    }

    public void setZamowieniaCollection(Collection<Zamowienia> zamowieniaCollection) {
        this.zamowieniaCollection = zamowieniaCollection;
    }

    public Stanowiska getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(Stanowiska stanowisko) {
        this.stanowisko = stanowisko;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (np != null ? np.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pracownicy)) {
            return false;
        }
        Pracownicy other = (Pracownicy) object;
        if ((this.np == null && other.np != null) || (this.np != null && !this.np.equals(other.np))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikacja.Pracownicy[ np=" + np + " ]";
    }
    
}
