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
@Table(name = "tipo_requisito", catalog = "casosacadtpi135", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRequisito.findAll", query = "SELECT t FROM TipoRequisito t")
    , @NamedQuery(name = "TipoRequisito.findByIdTipoRequisito", query = "SELECT t FROM TipoRequisito t WHERE t.idTipoRequisito = :idTipoRequisito")
    , @NamedQuery(name = "TipoRequisito.findByNombretiporequisito", query = "SELECT t FROM TipoRequisito t WHERE t.nombretiporequisito = :nombretiporequisito")})
public class TipoRequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_requisito", nullable = false)
    private Integer idTipoRequisito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Nombre_tipo_requisito", nullable = false, length = 10)
    private String nombretiporequisito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoRequisito")
    private List<Requisito> requisitoList;

    public TipoRequisito() {
    }

    public TipoRequisito(Integer idTipoRequisito) {
        this.idTipoRequisito = idTipoRequisito;
    }

    public TipoRequisito(Integer idTipoRequisito, String nombretiporequisito) {
        this.idTipoRequisito = idTipoRequisito;
        this.nombretiporequisito = nombretiporequisito;
    }

    public Integer getIdTipoRequisito() {
        return idTipoRequisito;
    }

    public void setIdTipoRequisito(Integer idTipoRequisito) {
        this.idTipoRequisito = idTipoRequisito;
    }

    public String getNombretiporequisito() {
        return nombretiporequisito;
    }

    public void setNombretiporequisito(String nombretiporequisito) {
        this.nombretiporequisito = nombretiporequisito;
    }

    @XmlTransient
    public List<Requisito> getRequisitoList() {
        return requisitoList;
    }

    public void setRequisitoList(List<Requisito> requisitoList) {
        this.requisitoList = requisitoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoRequisito != null ? idTipoRequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRequisito)) {
            return false;
        }
        TipoRequisito other = (TipoRequisito) object;
        if ((this.idTipoRequisito == null && other.idTipoRequisito != null) || (this.idTipoRequisito != null && !this.idTipoRequisito.equals(other.idTipoRequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TipoRequisito[ idTipoRequisito=" + idTipoRequisito + " ]";
    }
    
}
