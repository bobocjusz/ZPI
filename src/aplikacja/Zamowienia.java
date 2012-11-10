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
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dagmara
 */
@Entity
@Table(name = "ZAMOWIENIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zamowienia.findAll", query = "SELECT z FROM Zamowienia z"),
    @NamedQuery(name = "Zamowienia.findByIdzamowienia", query = "SELECT z FROM Zamowienia z WHERE z.idzamowienia = :idzamowienia"),
    @NamedQuery(name = "Zamowienia.findByDataZamowienia", query = "SELECT z FROM Zamowienia z WHERE z.dataZamowienia = :dataZamowienia"),
    @NamedQuery(name = "Zamowienia.findByNIK", query = "SELECT z FROM Zamowienia z WHERE z.nik.nik = :nik"),
    @NamedQuery(name = "Zamowienia.findByStatus", query = "SELECT z FROM Zamowienia z WHERE z.status = :status")})
public class Zamowienia implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDZAMOWIENIA")
    private BigDecimal idzamowienia;
    @Basic(optional = false)
    @Column(name = "DATA_ZAMOWIENIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataZamowienia;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "WYSYLKA", referencedColumnName = "IDENTYFIKATOR")
    @ManyToOne
    private Wysylka wysylka;
    @JoinColumn(name = "NP", referencedColumnName = "NP")
    @ManyToOne(optional = false)
    private Pracownicy np;
    @JoinColumn(name = "NIK", referencedColumnName = "NIK")
    @ManyToOne(optional = false)
    private Klienci nik;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idzamowienia1")
    private Collection<OpisyZamowien> opisyZamowienCollection;
    @OneToMany(mappedBy = "idzamowienia")
    private Collection<Ksiegowosc> ksiegowoscCollection;

    public Zamowienia() {
    }

    public Zamowienia(BigDecimal idzamowienia) {
        this.idzamowienia = idzamowienia;
    }

    public Zamowienia(BigDecimal idzamowienia, Date dataZamowienia, String status) {
        this.idzamowienia = idzamowienia;
        this.dataZamowienia = dataZamowienia;
        this.status = status;
    }

    public BigDecimal getIdzamowienia() {
        return idzamowienia;
    }

    public void setIdzamowienia(BigDecimal idzamowienia) {
        BigDecimal oldIdzamowienia = this.idzamowienia;
        this.idzamowienia = idzamowienia;
        changeSupport.firePropertyChange("idzamowienia", oldIdzamowienia, idzamowienia);
    }

    public Date getDataZamowienia() {
        return dataZamowienia;
    }

    public void setDataZamowienia(Date dataZamowienia) {
        Date oldDataZamowienia = this.dataZamowienia;
        this.dataZamowienia = dataZamowienia;
        changeSupport.firePropertyChange("dataZamowienia", oldDataZamowienia, dataZamowienia);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public Wysylka getWysylka() {
        return wysylka;
    }

    public void setWysylka(Wysylka wysylka) {
        Wysylka oldWysylka = this.wysylka;
        this.wysylka = wysylka;
        changeSupport.firePropertyChange("wysylka", oldWysylka, wysylka);
    }

    public Pracownicy getNp() {
        return np;
    }

    public void setNp(Pracownicy np) {
        Pracownicy oldNp = this.np;
        this.np = np;
        changeSupport.firePropertyChange("np", oldNp, np);
    }

    public Klienci getNik() {
        return nik;
    }

    public void setNik(Klienci nik) {
        Klienci oldNik = this.nik;
        this.nik = nik;
        changeSupport.firePropertyChange("nik", oldNik, nik);
    }

    @XmlTransient
    public Collection<OpisyZamowien> getOpisyZamowienCollection() {
        return opisyZamowienCollection;
    }

    public void setOpisyZamowienCollection(Collection<OpisyZamowien> opisyZamowienCollection) {
        this.opisyZamowienCollection = opisyZamowienCollection;
    }

    @XmlTransient
    public Collection<Ksiegowosc> getKsiegowoscCollection() {
        return ksiegowoscCollection;
    }

    public void setKsiegowoscCollection(Collection<Ksiegowosc> ksiegowoscCollection) {
        this.ksiegowoscCollection = ksiegowoscCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idzamowienia != null ? idzamowienia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zamowienia)) {
            return false;
        }
        Zamowienia other = (Zamowienia) object;
        if ((this.idzamowienia == null && other.idzamowienia != null) || (this.idzamowienia != null && !this.idzamowienia.equals(other.idzamowienia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikacja.Zamowienia[ idzamowienia=" + idzamowienia + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
