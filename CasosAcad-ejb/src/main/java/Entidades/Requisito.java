/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juank
 */
@Entity
@Table(name = "requisito", catalog = "casosacadtpi135", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisito.findAll", query = "SELECT r FROM Requisito r")
    , @NamedQuery(name = "Requisito.findByIdRequisito", query = "SELECT r FROM Requisito r WHERE r.requisitoPK.idRequisito = :idRequisito")
    , @NamedQuery(name = "Requisito.findByIdTipoRequisito", query = "SELECT r FROM Requisito r WHERE r.requisitoPK.idTipoRequisito = :idTipoRequisito")
    , @NamedQuery(name = "Requisito.findByDescripcionrequisito", query = "SELECT r FROM Requisito r WHERE r.descripcionrequisito = :descripcionrequisito")
    , @NamedQuery(name = "Requisito.findByNombrerequisito", query = "SELECT r FROM Requisito r WHERE r.nombrerequisito = :nombrerequisito")
    , @NamedQuery(name = "Requisito.findByExpiracion", query = "SELECT r FROM Requisito r WHERE r.expiracion = :expiracion")
    , @NamedQuery(name = "Requisito.findByEstadorequisito", query = "SELECT r FROM Requisito r WHERE r.estadorequisito = :estadorequisito")})
public class Requisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitoPK requisitoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Descripcion_requisito", nullable = false, length = 10)
    private String descripcionrequisito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Nombre_requisito", nullable = false, length = 10)
    private String nombrerequisito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Expiracion", nullable = false, length = 10)
    private String expiracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Estado_requisito", nullable = false, length = 10)
    private String estadorequisito;
    @JoinColumn(name = "id_tipo_requisito", referencedColumnName = "id_tipo_requisito", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoRequisito tipoRequisito;

    public Requisito() {
    }

    public Requisito(RequisitoPK requisitoPK) {
        this.requisitoPK = requisitoPK;
    }

    public Requisito(RequisitoPK requisitoPK, String descripcionrequisito, String nombrerequisito, String expiracion, String estadorequisito) {
        this.requisitoPK = requisitoPK;
        this.descripcionrequisito = descripcionrequisito;
        this.nombrerequisito = nombrerequisito;
        this.expiracion = expiracion;
        this.estadorequisito = estadorequisito;
    }

    public Requisito(int idRequisito, int idTipoRequisito) {
        this.requisitoPK = new RequisitoPK(idRequisito, idTipoRequisito);
    }

    public RequisitoPK getRequisitoPK() {
        return requisitoPK;
    }

    public void setRequisitoPK(RequisitoPK requisitoPK) {
        this.requisitoPK = requisitoPK;
    }

    public String getDescripcionrequisito() {
        return descripcionrequisito;
    }

    public void setDescripcionrequisito(String descripcionrequisito) {
        this.descripcionrequisito = descripcionrequisito;
    }

    public String getNombrerequisito() {
        return nombrerequisito;
    }

    public void setNombrerequisito(String nombrerequisito) {
        this.nombrerequisito = nombrerequisito;
    }

    public String getExpiracion() {
        return expiracion;
    }

    public void setExpiracion(String expiracion) {
        this.expiracion = expiracion;
    }

    public String getEstadorequisito() {
        return estadorequisito;
    }

    public void setEstadorequisito(String estadorequisito) {
        this.estadorequisito = estadorequisito;
    }

    public TipoRequisito getTipoRequisito() {
        return tipoRequisito;
    }

    public void setTipoRequisito(TipoRequisito tipoRequisito) {
        this.tipoRequisito = tipoRequisito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitoPK != null ? requisitoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisito)) {
            return false;
        }
        Requisito other = (Requisito) object;
        if ((this.requisitoPK == null && other.requisitoPK != null) || (this.requisitoPK != null && !this.requisitoPK.equals(other.requisitoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Requisito[ requisitoPK=" + requisitoPK + " ]";
    }
    
}
