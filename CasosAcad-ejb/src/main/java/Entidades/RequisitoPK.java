/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juank
 */
@Embeddable
public class RequisitoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_requisito", nullable = false)
    private int idRequisito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_requisito", nullable = false)
    private int idTipoRequisito;

    public RequisitoPK() {
    }

    public RequisitoPK(int idRequisito, int idTipoRequisito) {
        this.idRequisito = idRequisito;
        this.idTipoRequisito = idTipoRequisito;
    }

    public int getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(int idRequisito) {
        this.idRequisito = idRequisito;
    }

    public int getIdTipoRequisito() {
        return idTipoRequisito;
    }

    public void setIdTipoRequisito(int idTipoRequisito) {
        this.idTipoRequisito = idTipoRequisito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRequisito;
        hash += (int) idTipoRequisito;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitoPK)) {
            return false;
        }
        RequisitoPK other = (RequisitoPK) object;
        if (this.idRequisito != other.idRequisito) {
            return false;
        }
        if (this.idTipoRequisito != other.idTipoRequisito) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.RequisitoPK[ idRequisito=" + idRequisito + ", idTipoRequisito=" + idTipoRequisito + " ]";
    }
    
}
