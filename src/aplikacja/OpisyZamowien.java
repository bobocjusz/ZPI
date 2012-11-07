/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import java.io.Serializable;
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
    @NamedQuery(name = "OpisyZamowien.findByIdzamowienia", query = "SELECT o FROM OpisyZamowien o WHERE o.opisyZamowienPK.idzamowienia = :idzamowienia"),
    @NamedQuery(name = "OpisyZamowien.findByIdtowaru", query = "SELECT o FROM OpisyZamowien o WHERE o.opisyZamowienPK.idtowaru = :idtowaru"),
    @NamedQuery(name = "OpisyZamowien.findByIlosc", query = "SELECT o FROM OpisyZamowien o WHERE o.ilosc = :ilosc")})
public class OpisyZamowien implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OpisyZamowienPK opisyZamowienPK;
    @Basic(optional = false)
    @Column(name = "ILOSC")
    private BigInteger ilosc;
    @JoinColumn(name = "IDZAMOWIENIA", referencedColumnName = "IDZAMOWIENIA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Zamowienia zamowienia;
    @JoinColumn(name = "IDTOWARU", referencedColumnName = "IDTOWARU", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Towary towary;

    public OpisyZamowien() {
    }

    public OpisyZamowien(OpisyZamowienPK opisyZamowienPK) {
        this.opisyZamowienPK = opisyZamowienPK;
    }

    public OpisyZamowien(OpisyZamowienPK opisyZamowienPK, BigInteger ilosc) {
        this.opisyZamowienPK = opisyZamowienPK;
        this.ilosc = ilosc;
    }

    public OpisyZamowien(BigInteger idzamowienia, BigInteger idtowaru) {
        this.opisyZamowienPK = new OpisyZamowienPK(idzamowienia, idtowaru);
    }

    public OpisyZamowienPK getOpisyZamowienPK() {
        return opisyZamowienPK;
    }

    public void setOpisyZamowienPK(OpisyZamowienPK opisyZamowienPK) {
        this.opisyZamowienPK = opisyZamowienPK;
    }

    public BigInteger getIlosc() {
        return ilosc;
    }

    public void setIlosc(BigInteger ilosc) {
        this.ilosc = ilosc;
    }

    public Zamowienia getZamowienia() {
        return zamowienia;
    }

    public void setZamowienia(Zamowienia zamowienia) {
        this.zamowienia = zamowienia;
    }

    public Towary getTowary() {
        return towary;
    }

    public void setTowary(Towary towary) {
        this.towary = towary;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opisyZamowienPK != null ? opisyZamowienPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpisyZamowien)) {
            return false;
        }
        OpisyZamowien other = (OpisyZamowien) object;
        if ((this.opisyZamowienPK == null && other.opisyZamowienPK != null) || (this.opisyZamowienPK != null && !this.opisyZamowienPK.equals(other.opisyZamowienPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikacja.OpisyZamowien[ opisyZamowienPK=" + opisyZamowienPK + " ]";
    }
    
}
