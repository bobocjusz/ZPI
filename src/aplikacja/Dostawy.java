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
@Table(name = "DOSTAWY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dostawy.findAll", query = "SELECT d FROM Dostawy d"),
    @NamedQuery(name = "Dostawy.findByIddostawy", query = "SELECT d FROM Dostawy d WHERE d.iddostawy = :iddostawy"),
    @NamedQuery(name = "Dostawy.findByDataDostawy", query = "SELECT d FROM Dostawy d WHERE d.dataDostawy = :dataDostawy"),
    @NamedQuery(name = "Dostawy.findByStatus", query = "SELECT d FROM Dostawy d WHERE d.status = :status")})
public class Dostawy implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDDOSTAWY")
    private BigDecimal iddostawy;
    @Basic(optional = false)
    @Column(name = "DATA_DOSTAWY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDostawy;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "NP", referencedColumnName = "NP")
    @ManyToOne(optional = false)
    private Pracownicy np;
    @JoinColumn(name = "NID", referencedColumnName = "NID")
    @ManyToOne(optional = false)
    private Dostawcy nid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dostawy")
    private Collection<OpisyDostaw> opisyDostawCollection;
    @OneToMany(mappedBy = "iddostawy")
    private Collection<Ksiegowosc> ksiegowoscCollection;

    public Dostawy() {
    }

    public Dostawy(BigDecimal iddostawy) {
        this.iddostawy = iddostawy;
    }

    public Dostawy(BigDecimal iddostawy, Date dataDostawy, String status) {
        this.iddostawy = iddostawy;
        this.dataDostawy = dataDostawy;
        this.status = status;
    }

    public BigDecimal getIddostawy() {
        return iddostawy;
    }

    public void setIddostawy(BigDecimal iddostawy) {
        this.iddostawy = iddostawy;
    }

    public Date getDataDostawy() {
        return dataDostawy;
    }

    public void setDataDostawy(Date dataDostawy) {
        this.dataDostawy = dataDostawy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pracownicy getNp() {
        return np;
    }

    public void setNp(Pracownicy np) {
        this.np = np;
    }

    public Dostawcy getNid() {
        return nid;
    }

    public void setNid(Dostawcy nid) {
        this.nid = nid;
    }

    @XmlTransient
    public Collection<OpisyDostaw> getOpisyDostawCollection() {
        return opisyDostawCollection;
    }

    public void setOpisyDostawCollection(Collection<OpisyDostaw> opisyDostawCollection) {
        this.opisyDostawCollection = opisyDostawCollection;
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
    
}
