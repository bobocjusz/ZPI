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
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Dagmara
 */
@Entity
@Table(name = "DOSTAWY", catalog = "", schema = "DAGMARA")
@NamedQueries({
    @NamedQuery(name = "Dostawy.findAll", query = "SELECT d FROM Dostawy d"),
    @NamedQuery(name = "Dostawy.findByIddostawy", query = "SELECT d FROM Dostawy d WHERE d.iddostawy = :iddostawy"),
    @NamedQuery(name = "Dostawy.findByNid", query = "SELECT d FROM Dostawy d WHERE d.nid = :nid"),
    @NamedQuery(name = "Dostawy.findByDataDostawy", query = "SELECT d FROM Dostawy d WHERE d.dataDostawy = :dataDostawy"),
    @NamedQuery(name = "Dostawy.findByStatus", query = "SELECT d FROM Dostawy d WHERE d.status = :status"),
    @NamedQuery(name = "Dostawy.findByNp", query = "SELECT d FROM Dostawy d WHERE d.np = :np")})
public class Dostawy implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDDOSTAWY")
    private BigDecimal iddostawy;
    @Basic(optional = false)
    @Column(name = "NID")
    private BigInteger nid;
    @Basic(optional = false)
    @Column(name = "DATA_DOSTAWY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDostawy;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private String status;
    @Basic(optional = false)
    @Column(name = "NP")
    private BigInteger np;

    public Dostawy() {
    }

    public Dostawy(BigDecimal iddostawy) {
        this.iddostawy = iddostawy;
    }

    public Dostawy(BigDecimal iddostawy, BigInteger nid, Date dataDostawy, String status, BigInteger np) {
        this.iddostawy = iddostawy;
        this.nid = nid;
        this.dataDostawy = dataDostawy;
        this.status = status;
        this.np = np;
    }

    public BigDecimal getIddostawy() {
        return iddostawy;
    }

    public void setIddostawy(BigDecimal iddostawy) {
        BigDecimal oldIddostawy = this.iddostawy;
        this.iddostawy = iddostawy;
        changeSupport.firePropertyChange("iddostawy", oldIddostawy, iddostawy);
    }

    public BigInteger getNid() {
        return nid;
    }

    public void setNid(BigInteger nid) {
        BigInteger oldNid = this.nid;
        this.nid = nid;
        changeSupport.firePropertyChange("nid", oldNid, nid);
    }

    public Date getDataDostawy() {
        return dataDostawy;
    }

    public void setDataDostawy(Date dataDostawy) {
        Date oldDataDostawy = this.dataDostawy;
        this.dataDostawy = dataDostawy;
        changeSupport.firePropertyChange("dataDostawy", oldDataDostawy, dataDostawy);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public BigInteger getNp() {
        return np;
    }

    public void setNp(BigInteger np) {
        BigInteger oldNp = this.np;
        this.np = np;
        changeSupport.firePropertyChange("np", oldNp, np);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddostawy != null ? iddostawy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dostawy)) {
            return false;
        }
        Dostawy other = (Dostawy) object;
        if ((this.iddostawy == null && other.iddostawy != null) || (this.iddostawy != null && !this.iddostawy.equals(other.iddostawy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikacja.Dostawy[ iddostawy=" + iddostawy + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
