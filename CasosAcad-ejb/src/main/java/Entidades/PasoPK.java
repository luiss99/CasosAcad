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
public class PasoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_paso", nullable = false)
    private int idPaso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_paso", nullable = false)
    private int idTipoPaso;

    public PasoPK() {
    }

    public PasoPK(int idPaso, int idTipoPaso) {
        this.idPaso = idPaso;
        this.idTipoPaso = idTipoPaso;
    }

    public int getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(int idPaso) {
        this.idPaso = idPaso;
    }

    public int getIdTipoPaso() {
        return idTipoPaso;
    }

    public void setIdTipoPaso(int idTipoPaso) {
        this.idTipoPaso = idTipoPaso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPaso;
        hash += (int) idTipoPaso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasoPK)) {
            return false;
        }
        PasoPK other = (PasoPK) object;
        if (this.idPaso != other.idPaso) {
            return false;
        }
        if (this.idTipoPaso != other.idTipoPaso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PasoPK[ idPaso=" + idPaso + ", idTipoPaso=" + idTipoPaso + " ]";
    }
    
}
