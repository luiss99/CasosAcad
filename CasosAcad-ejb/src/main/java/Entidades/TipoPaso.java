/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juank
 */
@Entity
@Table(name = "tipo_paso", catalog = "casosacadtpi135", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPaso.findAll", query = "SELECT t FROM TipoPaso t")
    , @NamedQuery(name = "TipoPaso.findByIdTipoPaso", query = "SELECT t FROM TipoPaso t WHERE t.idTipoPaso = :idTipoPaso")
    , @NamedQuery(name = "TipoPaso.findByNombretipopaso", query = "SELECT t FROM TipoPaso t WHERE t.nombretipopaso = :nombretipopaso")})
public class TipoPaso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_paso", nullable = false)
    private Integer idTipoPaso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Nombre_tipo_paso", nullable = false, length = 10)
    private String nombretipopaso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPaso")
    private List<Paso> pasoList;

    public TipoPaso() {
    }

    public TipoPaso(Integer idTipoPaso) {
        this.idTipoPaso = idTipoPaso;
    }

    public TipoPaso(Integer idTipoPaso, String nombretipopaso) {
        this.idTipoPaso = idTipoPaso;
        this.nombretipopaso = nombretipopaso;
    }

    public Integer getIdTipoPaso() {
        return idTipoPaso;
    }

    public void setIdTipoPaso(Integer idTipoPaso) {
        this.idTipoPaso = idTipoPaso;
    }

    public String getNombretipopaso() {
        return nombretipopaso;
    }

    public void setNombretipopaso(String nombretipopaso) {
        this.nombretipopaso = nombretipopaso;
    }

    @XmlTransient
    public List<Paso> getPasoList() {
        return pasoList;
    }

    public void setPasoList(List<Paso> pasoList) {
        this.pasoList = pasoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPaso != null ? idTipoPaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPaso)) {
            return false;
        }
        TipoPaso other = (TipoPaso) object;
        if ((this.idTipoPaso == null && other.idTipoPaso != null) || (this.idTipoPaso != null && !this.idTipoPaso.equals(other.idTipoPaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TipoPaso[ idTipoPaso=" + idTipoPaso + " ]";
    }
    
}
