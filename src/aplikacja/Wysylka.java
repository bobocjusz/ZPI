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
@Table(name = "WYSYLKA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wysylka.findAll", query = "SELECT w FROM Wysylka w"),
    @NamedQuery(name = "Wysylka.findByIdentyfikator", query = "SELECT w FROM Wysylka w WHERE w.identyfikator = :identyfikator"),
    @NamedQuery(name = "Wysylka.findByRodzaj", query = "SELECT w FROM Wysylka w WHERE w.rodzaj = :rodzaj"),
    @NamedQuery(name = "Wysylka.findByCena", query = "SELECT w FROM Wysylka w WHERE w.cena = :cena")})
public class Wysylka implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDENTYFIKATOR")
    private BigDecimal identyfikator;
    @Column(name = "RODZAJ")
    private String rodzaj;
    @Basic(optional = false)
    @Column(name = "CENA")
    private double cena;
    @OneToMany(mappedBy = "wysylka")
    private Collection<Zamowienia> zamowieniaCollection;

    public Wysylka() {
    }

    public Wysylka(BigDecimal identyfikator) {
        this.identyfikator = identyfikator;
    }

    public Wysylka(BigDecimal identyfikator, double cena) {
        this.identyfikator = identyfikator;
        this.cena = cena;
    }

    public BigDecimal getIdentyfikator() {
        return identyfikator;
    }

    public void setIdentyfikator(BigDecimal identyfikator) {
        this.identyfikator = identyfikator;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @XmlTransient
    public Collection<Zamowienia> getZamowieniaCollection() {
        return zamowieniaCollection;
    }

    public void setZamowieniaCollection(Collection<Zamowienia> zamowieniaCollection) {
        this.zamowieniaCollection = zamowieniaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identyfikator != null ? identyfikator.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wysylka)) {
            return false;
        }
        Wysylka other = (Wysylka) object;
        if ((this.identyfikator == null && other.identyfikator != null) || (this.identyfikator != null && !this.identyfikator.equals(other.identyfikator))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikacja.Wysylka[ identyfikator=" + identyfikator + " ]";
    }
    
}
