/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dagmara
 */
@Entity
@Table(name = "KSIEGOWOSC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ksiegowosc.findAll", query = "SELECT k FROM Ksiegowosc k"),
    @NamedQuery(name = "Ksiegowosc.findByIdtransakcji", query = "SELECT k FROM Ksiegowosc k WHERE k.idtransakcji = :idtransakcji"),
    @NamedQuery(name = "Ksiegowosc.findByKwota", query = "SELECT k FROM Ksiegowosc k WHERE k.kwota = :kwota")})
public class Ksiegowosc implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDTRANSAKCJI")
    private BigDecimal idtransakcji;
    @Column(name = "KWOTA")
    private Double kwota;
    @JoinColumn(name = "IDZAMOWIENIA", referencedColumnName = "IDZAMOWIENIA")
    @ManyToOne
    private Zamowienia idzamowienia;
    @JoinColumn(name = "IDDOSTAWY", referencedColumnName = "IDDOSTAWY")
    @ManyToOne
    private Dostawy iddostawy;

    public Ksiegowosc() {
    }

    public Ksiegowosc(BigDecimal idtransakcji) {
        this.idtransakcji = idtransakcji;
    }

    public BigDecimal getIdtransakcji() {
        return idtransakcji;
    }

    public void setIdtransakcji(BigDecimal idtransakcji) {
        this.idtransakcji = idtransakcji;
    }

    public Double getKwota() {
        return kwota;
    }

    public void setKwota(Double kwota) {
        this.kwota = kwota;
    }

    public Zamowienia getIdzamowienia() {
        return idzamowienia;
    }

    public void setIdzamowienia(Zamowienia idzamowienia) {
        this.idzamowienia = idzamowienia;
    }

    public Dostawy getIddostawy() {
        return iddostawy;
    }

    public void setIddostawy(Dostawy iddostawy) {
        this.iddostawy = iddostawy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransakcji != null ? idtransakcji.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ksiegowosc)) {
            return false;
        }
        Ksiegowosc other = (Ksiegowosc) object;
        if ((this.idtransakcji == null && other.idtransakcji != null) || (this.idtransakcji != null && !this.idtransakcji.equals(other.idtransakcji))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikacja.Ksiegowosc[ idtransakcji=" + idtransakcji + " ]";
    }
    
}
