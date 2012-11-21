/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
@Table(name = "KATEGORIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategorie.findAll", query = "SELECT k FROM Kategorie k"),
    @NamedQuery(name = "Kategorie.findByIdentyfikator", query = "SELECT k FROM Kategorie k WHERE k.identyfikator = :identyfikator"),
    @NamedQuery(name = "Kategorie.findByNazwa", query = "SELECT k FROM Kategorie k WHERE k.nazwa = :nazwa")})
public class Kategorie implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDENTYFIKATOR")
    private BigDecimal identyfikator;
    @Basic(optional = false)
    @Column(name = "NAZWA")
    private String nazwa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategoria")
    private Collection<Towary> towaryCollection;

    public Kategorie() {
    }

    public Kategorie(BigDecimal identyfikator) {
        this.identyfikator = identyfikator;
    }

    public Kategorie(BigDecimal identyfikator, String nazwa) {
        this.identyfikator = identyfikator;
        this.nazwa = nazwa;
    }

    public BigDecimal getIdentyfikator() {
        return identyfikator;
    }

    public void setIdentyfikator(BigDecimal identyfikator) {
        BigDecimal oldIdentyfikator = this.identyfikator;
        this.identyfikator = identyfikator;
        changeSupport.firePropertyChange("identyfikator", oldIdentyfikator, identyfikator);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        String oldNazwa = this.nazwa;
        this.nazwa = nazwa;
        changeSupport.firePropertyChange("nazwa", oldNazwa, nazwa);
    }

    @XmlTransient
    public Collection<Towary> getTowaryCollection() {
        return towaryCollection;
    }

    public void setTowaryCollection(Collection<Towary> towaryCollection) {
        this.towaryCollection = towaryCollection;
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
        if (!(object instanceof Kategorie)) {
            return false;
        }
        Kategorie other = (Kategorie) object;
        if ((this.identyfikator == null && other.identyfikator != null) || (this.identyfikator != null && !this.identyfikator.equals(other.identyfikator))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikacja.Kategorie[ identyfikator=" + identyfikator + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
