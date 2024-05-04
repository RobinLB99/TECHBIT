package com.robinlb.techbit.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author Robin
 */
@Entity
@Table(name = "solucion_respuesta")
@NamedQueries({
    @NamedQuery(name = "SolucionRespuesta.findAll", query = "SELECT s FROM SolucionRespuesta s")})
public class SolucionRespuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "res_sol_id")
    private Long resSolId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private int tipo;

    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "detalle")
    private String detalle;

    public SolucionRespuesta() {
    }

    public SolucionRespuesta(Long resSolId, int tipo, String detalle) {
        this.resSolId = resSolId;
        this.tipo = tipo;
        this.detalle = detalle;
    }

    public Long getResSolId() {
        return resSolId;
    }

    public void setResSolId(Long resSolId) {
        this.resSolId = resSolId;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resSolId != null ? resSolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolucionRespuesta)) {
            return false;
        }
        SolucionRespuesta other = (SolucionRespuesta) object;
        if ((this.resSolId == null && other.resSolId != null) || (this.resSolId != null && !this.resSolId.equals(other.resSolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SolucionRespuesta{" + "resSolId=" + resSolId + ", tipo=" + tipo + ", detalle=" + detalle + '}';
    }

}
