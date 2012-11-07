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
public class OpisyZamowienPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "IDZAMOWIENIA")
    private BigInteger idzamowienia;
    @Basic(optional = false)
    @Column(name = "IDTOWARU")
    private BigInteger idtowaru;

    public OpisyZamowienPK() {
    }

    public OpisyZamowienPK(BigInteger idzamowienia, BigInteger idtowaru) {
        this.idzamowienia = idzamowienia;
        this.idtowaru = idtowaru;
    }

    public BigInteger getIdzamowienia() {
        return idzamowienia;
    }

    public void setIdzamowienia(BigInteger idzamowienia) {
        this.idzamowienia = idzamowienia;
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
        hash += (idzamowienia != null ? idzamowienia.hashCode() : 0);
        hash += (idtowaru != null ? idtowaru.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpisyZamowienPK)) {
            return false;
        }
        OpisyZamowienPK other = (OpisyZamowienPK) object;
        if ((this.idzamowienia == null && other.idzamowienia != null) || (this.idzamowienia != null && !this.idzamowienia.equals(other.idzamowienia))) {
            return false;
        }
        if ((this.idtowaru == null && other.idtowaru != null) || (this.idtowaru != null && !this.idtowaru.equals(other.idtowaru))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikacja.OpisyZamowienPK[ idzamowienia=" + idzamowienia + ", idtowaru=" + idtowaru + " ]";
    }
    
}
