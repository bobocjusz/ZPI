/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
    @NamedQuery(name = "Ksiegowosc.findByKwota", query = "SELECT k FROM Ksiegowosc k WHERE k.kwota = :kwota"),
    @NamedQuery(name = "Ksiegowosc.findByDataTransakcji", query = "SELECT k FROM Ksiegowosc k WHERE k.dataTransakcji = :dataTransakcji")})
public class Ksiegowosc implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDTRANSAKCJI")
    private BigDecimal idtransakcji;
    @Column(name = "KWOTA")
    private Double kwota;
    @Column(name = "DATA_TRANSAKCJI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTransakcji;
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
        BigDecimal oldIdtransakcji = this.idtransakcji;
        this.idtransakcji = idtransakcji;
        changeSupport.firePropertyChange("idtransakcji", oldIdtransakcji, idtransakcji);
    }

    public Double getKwota() {
        return kwota;
    }

    public void setKwota(Double kwota) {
        Double oldKwota = this.kwota;
        this.kwota = kwota;
        changeSupport.firePropertyChange("kwota", oldKwota, kwota);
    }

    public Date getDataTransakcji() {
        return dataTransakcji;
    }

    public void setDataTransakcji(Date dataTransakcji) {
        Date oldDataTransakcji = this.dataTransakcji;
        this.dataTransakcji = dataTransakcji;
        changeSupport.firePropertyChange("dataTransakcji", oldDataTransakcji, dataTransakcji);
    }

    public Zamowienia getIdzamowienia() {
        return idzamowienia;
    }

    public void setIdzamowienia(Zamowienia idzamowienia) {
        Zamowienia oldIdzamowienia = this.idzamowienia;
        this.idzamowienia = idzamowienia;
        changeSupport.firePropertyChange("idzamowienia", oldIdzamowienia, idzamowienia);
    }

    public Dostawy getIddostawy() {
        return iddostawy;
    }

    public void setIddostawy(Dostawy iddostawy) {
        Dostawy oldIddostawy = this.iddostawy;
        this.iddostawy = iddostawy;
        changeSupport.firePropertyChange("iddostawy", oldIddostawy, iddostawy);
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
