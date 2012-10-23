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
@Table(name = "STANOWISKA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stanowiska.findAll", query = "SELECT s FROM Stanowiska s"),
    @NamedQuery(name = "Stanowiska.findByIdentyfikator", query = "SELECT s FROM Stanowiska s WHERE s.identyfikator = :identyfikator"),
    @NamedQuery(name = "Stanowiska.findByStanowisko", query = "SELECT s FROM Stanowiska s WHERE s.stanowisko = :stanowisko")})
public class Stanowiska implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDENTYFIKATOR")
    private BigDecimal identyfikator;
    @Basic(optional = false)
    @Column(name = "STANOWISKO")
    private String stanowisko;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stanowisko")
    private Collection<Pracownicy> pracownicyCollection;

    public Stanowiska() {
    }

    public Stanowiska(BigDecimal identyfikator) {
        this.identyfikator = identyfikator;
    }

    public Stanowiska(BigDecimal identyfikator, String stanowisko) {
        this.identyfikator = identyfikator;
        this.stanowisko = stanowisko;
    }

    public BigDecimal getIdentyfikator() {
        return identyfikator;
    }

    public void setIdentyfikator(BigDecimal identyfikator) {
        this.identyfikator = identyfikator;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    @XmlTransient
    public Collection<Pracownicy> getPracownicyCollection() {
        return pracownicyCollection;
    }

    public void setPracownicyCollection(Collection<Pracownicy> pracownicyCollection) {
        this.pracownicyCollection = pracownicyCollection;
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
        if (!(object instanceof Stanowiska)) {
            return false;
        }
        Stanowiska other = (Stanowiska) object;
        if ((this.identyfikator == null && other.identyfikator != null) || (this.identyfikator != null && !this.identyfikator.equals(other.identyfikator))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikacja.Stanowiska[ identyfikator=" + identyfikator + " ]";
    }
    
}
