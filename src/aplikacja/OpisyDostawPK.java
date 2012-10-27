/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Dagmara
 */
@Embeddable
public class OpisyDostawPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "IDDOSTAWY")
    private BigInteger iddostawy;
    @Basic(optional = false)
    @Column(name = "IDTOWARU")
    private BigInteger idtowaru;

    public OpisyDostawPK() {
    }

    public OpisyDostawPK(BigInteger iddostawy, BigInteger idtowaru) {
        this.iddostawy = iddostawy;
        this.idtowaru = idtowaru;
    }

    public BigInteger getIddostawy() {
        return iddostawy;
    }

    public void setIddostawy(BigInteger iddostawy) {
        this.iddostawy = iddostawy;
    }

    public BigInteger getIdtowaru() {
        return idtowaru;
    }

    public void setIdtowaru(BigInteger idtowaru) {
        this.idtowaru = idtowaru;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddostawy != null ? iddostawy.hashCode() : 0);
        hash += (idtowaru != null ? idtowaru.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpisyDostawPK)) {
            return false;
        }
        OpisyDostawPK other = (OpisyDostawPK) object;
        if ((this.iddostawy == null && other.iddostawy != null) || (this.iddostawy != null && !this.iddostawy.equals(other.iddostawy))) {
            return false;
        }
        if ((this.idtowaru == null && other.idtowaru != null) || (this.idtowaru != null && !this.idtowaru.equals(other.idtowaru))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikacja.OpisyDostawPK[ iddostawy=" + iddostawy + ", idtowaru=" + idtowaru + " ]";
    }
    
}
