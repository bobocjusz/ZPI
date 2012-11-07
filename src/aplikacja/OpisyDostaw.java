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
@Table(name = "OPISY_DOSTAW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpisyDostaw.findAll", query = "SELECT o FROM OpisyDostaw o"),
    @NamedQuery(name = "OpisyDostaw.findByIddostawy", query = "SELECT o FROM OpisyDostaw o WHERE o.opisyDostawPK.iddostawy = :iddostawy"),
    @NamedQuery(name = "OpisyDostaw.findByIdtowaru", query = "SELECT o FROM OpisyDostaw o WHERE o.opisyDostawPK.idtowaru = :idtowaru"),
    @NamedQuery(name = "OpisyDostaw.findByIlosc", query = "SELECT o FROM OpisyDostaw o WHERE o.ilosc = :ilosc"),
    @NamedQuery(name = "OpisyDostaw.findByCenaProducenta", query = "SELECT o FROM OpisyDostaw o WHERE o.cenaProducenta = :cenaProducenta")})
public class OpisyDostaw implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OpisyDostawPK opisyDostawPK;
    @Basic(optional = false)
    @Column(name = "ILOSC")
    private BigInteger ilosc;
    @Basic(optional = false)
    @Column(name = "CENA_PRODUCENTA")
    private double cenaProducenta;
    @JoinColumn(name = "IDTOWARU", referencedColumnName = "IDTOWARU", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Towary towary;
    @JoinColumn(name = "IDDOSTAWY", referencedColumnName = "IDDOSTAWY", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dostawy dostawy;

    public OpisyDostaw() {
    }

    public OpisyDostaw(OpisyDostawPK opisyDostawPK) {
        this.opisyDostawPK = opisyDostawPK;
    }

    public OpisyDostaw(OpisyDostawPK opisyDostawPK, BigInteger ilosc, double cenaProducenta) {
        this.opisyDostawPK = opisyDostawPK;
        this.ilosc = ilosc;
        this.cenaProducenta = cenaProducenta;
    }

    public OpisyDostaw(BigInteger iddostawy, BigInteger idtowaru) {
        this.opisyDostawPK = new OpisyDostawPK(iddostawy, idtowaru);
    }

    public OpisyDostawPK getOpisyDostawPK() {
        return opisyDostawPK;
    }

    public void setOpisyDostawPK(OpisyDostawPK opisyDostawPK) {
        this.opisyDostawPK = opisyDostawPK;
    }

    public BigInteger getIlosc() {
        return ilosc;
    }

    public void setIlosc(BigInteger ilosc) {
        this.ilosc = ilosc;
    }

    public double getCenaProducenta() {
        return cenaProducenta;
    }

    public void setCenaProducenta(double cenaProducenta) {
        this.cenaProducenta = cenaProducenta;
    }

    public Towary getTowary() {
        return towary;
    }

    public void setTowary(Towary towary) {
        this.towary = towary;
    }

    public Dostawy getDostawy() {
        return dostawy;
    }

    public void setDostawy(Dostawy dostawy) {
        this.dostawy = dostawy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opisyDostawPK != null ? opisyDostawPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpisyDostaw)) {
            return false;
        }
        OpisyDostaw other = (OpisyDostaw) object;
        if ((this.opisyDostawPK == null && other.opisyDostawPK != null) || (this.opisyDostawPK != null && !this.opisyDostawPK.equals(other.opisyDostawPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikacja.OpisyDostaw[ opisyDostawPK=" + opisyDostawPK + " ]";
    }
    
}
