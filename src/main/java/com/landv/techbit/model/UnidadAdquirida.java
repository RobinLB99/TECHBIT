package com.landv.techbit.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import javax.persistence.OneToOne;

/**
 *
 * @author Robin
 */
@Entity
@Table(name = "unidad_adquirida")
@NamedQueries({
    @NamedQuery(name = "UnidadAdquirida.findAll", query = "SELECT u FROM UnidadAdquirida u")})
public class UnidadAdquirida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "unidad_id")
    private Long unidadId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;

    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_total")
    private double precioTotal;

    @JoinColumn(name = "catalogo_id", referencedColumnName = "catalogo_id")
    @OneToOne
    private Catalogo catalogo;

    public UnidadAdquirida() {
    }

    public UnidadAdquirida(Long unidadId, int cantidad, double precioTotal, Catalogo catalogo) {
        this.unidadId = unidadId;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
        this.catalogo = catalogo;
    }

    public Long getUnidadId() {
        return unidadId;
    }

    public void setUnidadId(Long unidadId) {
        this.unidadId = unidadId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unidadId != null ? unidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadAdquirida)) {
            return false;
        }
        UnidadAdquirida other = (UnidadAdquirida) object;
        if ((this.unidadId == null && other.unidadId != null) || (this.unidadId != null && !this.unidadId.equals(other.unidadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UnidadAdquirida{" + "unidadId=" + unidadId + ", cantidad=" + cantidad + ", precioTotal=" + precioTotal + ", catalogo=" + catalogo + '}';
    }

}
