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
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dagmara
 */
@Entity
@Table(name = "TOWARY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Towary.findAll", query = "SELECT t FROM Towary t"),
    @NamedQuery(name = "Towary.findByIdtowaru", query = "SELECT t FROM Towary t WHERE t.idtowaru = :idtowaru"),
    @NamedQuery(name = "Towary.findByNazwaTowaru", query = "SELECT t FROM Towary t WHERE t.nazwaTowaru = :nazwaTowaru"),
    @NamedQuery(name = "Towary.findByIloscWSklepie", query = "SELECT t FROM Towary t WHERE t.iloscWSklepie = :iloscWSklepie"),
    @NamedQuery(name = "Towary.findByCenaSklepowa", query = "SELECT t FROM Towary t WHERE t.cenaSklepowa = :cenaSklepowa"),
    @NamedQuery(name = "Towary.findByMinimumTowar", query = "SELECT t FROM Towary t WHERE t.minimumTowar = :minimumTowar"),
    @NamedQuery(name = "Towary.findByOpis", query = "SELECT t FROM Towary t WHERE t.opis = :opis"),
    //@NamedQuery(name = "Towary.findByxxx", query = "SELECT t FROM Towary t WHERE t.iloscWSklepie < t.opisyZamowienCollection.ilosc and t.idtowaru = t.opisyZamowienCollection.idtowaru"),
    @NamedQuery(name = "Towary.findByZdjecie", query = "SELECT t FROM Towary t WHERE t.zdjecie = :zdjecie")})
public class Towary implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDTOWARU")
    private BigDecimal idtowaru;
    @Basic(optional = false)
    @Column(name = "NAZWA_TOWARU")
    private String nazwaTowaru;
    @Basic(optional = false)
    @Column(name = "ILOSC_W_SKLEPIE")
    private BigInteger iloscWSklepie;
    @Basic(optional = false)
    @Column(name = "CENA_SKLEPOWA")
    private double cenaSklepowa;
    @Basic(optional = false)
    @Column(name = "MINIMUM_TOWAR")
    private BigInteger minimumTowar;
    @Column(name = "OPIS")
    private String opis;
    @Column(name = "ZDJECIE")
    private String zdjecie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "towary")
    private Collection<OpisyDostaw> opisyDostawCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtowaru")
    private Collection<OpisyZamowien> opisyZamowienCollection;
    @JoinColumn(name = "KATEGORIA", referencedColumnName = "IDENTYFIKATOR")
    @ManyToOne(optional = false)
    private Kategorie kategoria;

    public Towary() {
    }

    public Towary(BigDecimal idtowaru) {
        this.idtowaru = idtowaru;
    }

    public Towary(BigDecimal idtowaru, String nazwaTowaru, BigInteger iloscWSklepie, double cenaSklepowa, BigInteger minimumTowar) {
        this.idtowaru = idtowaru;
        this.nazwaTowaru = nazwaTowaru;
        this.iloscWSklepie = iloscWSklepie;
        this.cenaSklepowa = cenaSklepowa;
        this.minimumTowar = minimumTowar;
    }

    public BigDecimal getIdtowaru() {
        return idtowaru;
    }

    public void setIdtowaru(BigDecimal idtowaru) {
        BigDecimal oldIdtowaru = this.idtowaru;
        this.idtowaru = idtowaru;
        changeSupport.firePropertyChange("idtowaru", oldIdtowaru, idtowaru);
    }

    public String getNazwaTowaru() {
        return nazwaTowaru;
    }

    public void setNazwaTowaru(String nazwaTowaru) {
        String oldNazwaTowaru = this.nazwaTowaru;
        this.nazwaTowaru = nazwaTowaru;
        changeSupport.firePropertyChange("nazwaTowaru", oldNazwaTowaru, nazwaTowaru);
    }

    public BigInteger getIloscWSklepie() {
        return iloscWSklepie;
    }

    public void setIloscWSklepie(BigInteger iloscWSklepie) {
        BigInteger oldIloscWSklepie = this.iloscWSklepie;
        this.iloscWSklepie = iloscWSklepie;
        changeSupport.firePropertyChange("iloscWSklepie", oldIloscWSklepie, iloscWSklepie);
    }

    public double getCenaSklepowa() {
        return cenaSklepowa;
    }

    public void setCenaSklepowa(double cenaSklepowa) {
        double oldCenaSklepowa = this.cenaSklepowa;
        this.cenaSklepowa = cenaSklepowa;
        changeSupport.firePropertyChange("cenaSklepowa", oldCenaSklepowa, cenaSklepowa);
    }

    public BigInteger getMinimumTowar() {
        return minimumTowar;
    }

    public void setMinimumTowar(BigInteger minimumTowar) {
        BigInteger oldMinimumTowar = this.minimumTowar;
        this.minimumTowar = minimumTowar;
        changeSupport.firePropertyChange("minimumTowar", oldMinimumTowar, minimumTowar);
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        String oldOpis = this.opis;
        this.opis = opis;
        changeSupport.firePropertyChange("opis", oldOpis, opis);
    }

    public String getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(String zdjecie) {
        String oldZdjecie = this.zdjecie;
        this.zdjecie = zdjecie;
        changeSupport.firePropertyChange("zdjecie", oldZdjecie, zdjecie);
    }

    @XmlTransient
    public Collection<OpisyDostaw> getOpisyDostawCollection() {
        return opisyDostawCollection;
    }

    public void setOpisyDostawCollection(Collection<OpisyDostaw> opisyDostawCollection) {
        this.opisyDostawCollection = opisyDostawCollection;
    }

    @XmlTransient
    public Collection<OpisyZamowien> getOpisyZamowienCollection() {
        return opisyZamowienCollection;
    }

    public void setOpisyZamowienCollection(Collection<OpisyZamowien> opisyZamowienCollection) {
        this.opisyZamowienCollection = opisyZamowienCollection;
    }

    public Kategorie getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategorie kategoria) {
        Kategorie oldKategoria = this.kategoria;
        this.kategoria = kategoria;
        changeSupport.firePropertyChange("kategoria", oldKategoria, kategoria);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtowaru != null ? idtowaru.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Towary)) {
            return false;
        }
        Towary other = (Towary) object;
        if ((this.idtowaru == null && other.idtowaru != null) || (this.idtowaru != null && !this.idtowaru.equals(other.idtowaru))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikacja.Towary[ idtowaru=" + idtowaru + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
