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
@Table(name = "HASLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hasla.findAll", query = "SELECT h FROM Hasla h"),
    @NamedQuery(name = "Hasla.findByIdentyfikator", query = "SELECT h FROM Hasla h WHERE h.identyfikator = :identyfikator"),
    @NamedQuery(name = "Hasla.findByLogin", query = "SELECT h FROM Hasla h WHERE h.login = :login"),
    @NamedQuery(name = "Hasla.findByHaslo", query = "SELECT h FROM Hasla h WHERE h.haslo = :haslo")})
public class Hasla implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDENTYFIKATOR")
    private BigDecimal identyfikator;
    @Basic(optional = false)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @Column(name = "HASLO")
    private String haslo;
    @JoinColumn(name = "IDENTYFIKATOR", referencedColumnName = "NP", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pracownicy pracownicy;

    public Hasla() {
    }

    public Hasla(BigDecimal identyfikator) {
        this.identyfikator = identyfikator;
    }

    public Hasla(BigDecimal identyfikator, String login, String haslo) {
        this.identyfikator = identyfikator;
        this.login = login;
        this.haslo = haslo;
    }

    public BigDecimal getIdentyfikator() {
        return identyfikator;
    }

    public void setIdentyfikator(BigDecimal identyfikator) {
        this.identyfikator = identyfikator;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Pracownicy getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(Pracownicy pracownicy) {
        this.pracownicy = pracownicy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identyfikator != null ? identyfikator.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hasla)) {
            return false;
        }
        Hasla other = (Hasla) object;
        if ((this.identyfikator == null && other.identyfikator != null) || (this.identyfikator != null && !this.identyfikator.equals(other.identyfikator))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikacja.Hasla[ identyfikator=" + identyfikator + " ]";
    }
    
}
