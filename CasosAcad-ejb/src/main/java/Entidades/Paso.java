/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juank
 */
@Entity
@Table(name = "paso", catalog = "casosacadtpi135", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paso.findAll", query = "SELECT p FROM Paso p")
    , @NamedQuery(name = "Paso.findByIdPaso", query = "SELECT p FROM Paso p WHERE p.pasoPK.idPaso = :idPaso")
    , @NamedQuery(name = "Paso.findByIdTipoPaso", query = "SELECT p FROM Paso p WHERE p.pasoPK.idTipoPaso = :idTipoPaso")
    , @NamedQuery(name = "Paso.findByDescripcionpaso", query = "SELECT p FROM Paso p WHERE p.descripcionpaso = :descripcionpaso")
    , @NamedQuery(name = "Paso.findByFechainicio", query = "SELECT p FROM Paso p WHERE p.fechainicio = :fechainicio")
    , @NamedQuery(name = "Paso.findByFechasfinal", query = "SELECT p FROM Paso p WHERE p.fechasfinal = :fechasfinal")
    , @NamedQuery(name = "Paso.findByEstadopaso", query = "SELECT p FROM Paso p WHERE p.estadopaso = :estadopaso")})
public class Paso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PasoPK pasoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion_paso", nullable = false, length = 50)
    private String descripcionpaso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fechas_final", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechasfinal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Estado_paso", nullable = false, length = 10)
    private String estadopaso;
    @JoinColumn(name = "id_tipo_paso", referencedColumnName = "id_tipo_paso", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoPaso tipoPaso;

    public Paso() {
    }

    public Paso(PasoPK pasoPK) {
        this.pasoPK = pasoPK;
    }

    public Paso(PasoPK pasoPK, String descripcionpaso, Date fechainicio, Date fechasfinal, String estadopaso) {
        this.pasoPK = pasoPK;
        this.descripcionpaso = descripcionpaso;
        this.fechainicio = fechainicio;
        this.fechasfinal = fechasfinal;
        this.estadopaso = estadopaso;
    }

    public Paso(int idPaso, int idTipoPaso) {
        this.pasoPK = new PasoPK(idPaso, idTipoPaso);
    }

    public PasoPK getPasoPK() {
        return pasoPK;
    }

    public void setPasoPK(PasoPK pasoPK) {
        this.pasoPK = pasoPK;
    }

    public String getDescripcionpaso() {
        return descripcionpaso;
    }

    public void setDescripcionpaso(String descripcionpaso) {
        this.descripcionpaso = descripcionpaso;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechasfinal() {
        return fechasfinal;
    }

    public void setFechasfinal(Date fechasfinal) {
        this.fechasfinal = fechasfinal;
    }

    public String getEstadopaso() {
        return estadopaso;
    }

    public void setEstadopaso(String estadopaso) {
        this.estadopaso = estadopaso;
    }

    public TipoPaso getTipoPaso() {
        return tipoPaso;
    }

    public void setTipoPaso(TipoPaso tipoPaso) {
        this.tipoPaso = tipoPaso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pasoPK != null ? pasoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paso)) {
            return false;
        }
        Paso other = (Paso) object;
        if ((this.pasoPK == null && other.pasoPK != null) || (this.pasoPK != null && !this.pasoPK.equals(other.pasoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Paso[ pasoPK=" + pasoPK + " ]";
    }
    
}
