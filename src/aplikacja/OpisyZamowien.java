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
 * @author Dagmara
 */
@Entity
@Table(name = "OPISY_ZAMOWIEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpisyZamowien.findAll", query = "SELECT o FROM OpisyZamowien o"),
    @NamedQuery(name = "OpisyZamowien.findByIdent", query = "SELECT o FROM OpisyZamowien o WHERE o.ident = :ident"),
    @NamedQuery(name = "OpisyZamowien.findByIdZamowienia", query = "SELECT o FROM OpisyZamowien o WHERE o.idzamowienia1.idzamowienia = :idzamowienia1"),
    @NamedQuery(name = "OpisyZamowien.findByIlosc", query = "SELECT o FROM OpisyZamowien o WHERE o.ilosc = :ilosc")})
public class OpisyZamowien implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDENT")
    private BigDecimal ident;
    @Basic(optional = false)
    @Column(name = "ILOSC")
    private BigInteger ilosc;
    @JoinColumn(name = "IDZAMOWIENIA1", referencedColumnName = "IDZAMOWIENIA")
    @ManyToOne(optional = false)
    private Zamowienia idzamowienia1;
    @JoinColumn(name = "IDTOWARU", referencedColumnName = "IDTOWARU")
    @ManyToOne(optional = false)
    private Towary idtowaru;

    public OpisyZamowien() {
    }

    public OpisyZamowien(BigDecimal ident) {
        this.ident = ident;
    }

    public OpisyZamowien(BigDecimal ident, BigInteger ilosc) {
        this.ident = ident;
        this.ilosc = ilosc;
    }

    public BigDecimal getIdent() {
        return ident;
    }

    public void setIdent(BigDecimal ident) {
        BigDecimal oldIdent = this.ident;
        this.ident = ident;
        changeSupport.firePropertyChange("ident", oldIdent, ident);
    }

    public BigInteger getIlosc() {
        return ilosc;
    }

    public void setIlosc(BigInteger ilosc) {
        BigInteger oldIlosc = this.ilosc;
        this.ilosc = ilosc;
        changeSupport.firePropertyChange("ilosc", oldIlosc, ilosc);
    }

    public Zamowienia getIdzamowienia1() {
        return idzamowienia1;
    }

    public void setIdzamowienia1(Zamowienia idzamowienia1) {
        Zamowienia oldIdzamowienia1 = this.idzamowienia1;
        this.idzamowienia1 = idzamowienia1;
        changeSupport.firePropertyChange("idzamowienia1", oldIdzamowienia1, idzamowienia1);
    }

    public Towary getIdtowaru() {
        return idtowaru;
    }

    public void setIdtowaru(Towary idtowaru) {
        Towary oldIdtowaru = this.idtowaru;
        this.idtowaru = idtowaru;
        changeSupport.firePropertyChange("idtowaru", oldIdtowaru, idtowaru);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ident != null ? ident.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpisyZamowien)) {
            return false;
        }
        OpisyZamowien other = (OpisyZamowien) object;
        if ((this.ident == null && other.ident != null) || (this.ident != null && !this.ident.equals(other.ident))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikacja.OpisyZamowien[ ident=" + ident + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
    
}
