/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

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
    @NamedQuery(name = "Zamowienia.findByStatus", query = "SELECT z FROM Zamowienia z WHERE z.status = :status")})
public class Zamowienia implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zamowienia")
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
        this.idzamowienia = idzamowienia;
    }

    public Date getDataZamowienia() {
        return dataZamowienia;
    }

    public void setDataZamowienia(Date dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Wysylka getWysylka() {
        return wysylka;
    }

    public void setWysylka(Wysylka wysylka) {
        this.wysylka = wysylka;
    }

    public Pracownicy getNp() {
        return np;
    }

    public void setNp(Pracownicy np) {
        this.np = np;
    }

    public Klienci getNik() {
        return nik;
    }

    public void setNik(Klienci nik) {
        this.nik = nik;
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
    
}
