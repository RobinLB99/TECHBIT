package com.landv.techbit.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.OneToMany;

/**
 *
 * @author Robin
 */
@Entity
@Table(name = "factura")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "factura_id")
    private Long facturaId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_factura")
    private double valorFactura;

    @JoinColumn(name = "empleado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado empleado;

    @JoinColumn(name = "cliente_natural", referencedColumnName = "id")
    @ManyToOne
    private ClienteNatural clienteNatural;

    @JoinColumn(name = "empresa", referencedColumnName = "cliente_e_id")
    @ManyToOne
    private ClienteEmpresarial clienteEmpresarial;

    @JoinColumn(name = "lista", referencedColumnName = "unidad_id")
    @NotNull
    @OneToMany(mappedBy = "unidad_id")
    private Collection<UnidadAdquirida> unidadAdquirida;

    public Factura() {
    }

    public Factura(Long facturaId, double valorFactura, Empleado empleado, ClienteNatural clienteNatural, ClienteEmpresarial clienteEmpresarial, Collection<UnidadAdquirida> unidadAdquirida) {
        this.facturaId = facturaId;
        this.valorFactura = valorFactura;
        this.empleado = empleado;
        this.clienteNatural = clienteNatural;
        this.clienteEmpresarial = clienteEmpresarial;
        this.unidadAdquirida = unidadAdquirida;
    }

    public Long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Long facturaId) {
        this.facturaId = facturaId;
    }

    public double getValorFactura() {
        return valorFactura;
    }

    public void setValorFactura(double valorFactura) {
        this.valorFactura = valorFactura;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public ClienteNatural getClienteNatural() {
        return clienteNatural;
    }

    public void setClienteNatural(ClienteNatural clienteNatural) {
        this.clienteNatural = clienteNatural;
    }

    public ClienteEmpresarial getClienteEmpresarial() {
        return clienteEmpresarial;
    }

    public void setClienteEmpresarial(ClienteEmpresarial clienteEmpresarial) {
        this.clienteEmpresarial = clienteEmpresarial;
    }

    public Collection<UnidadAdquirida> getUnidadAdquirida() {
        return unidadAdquirida;
    }

    public void setUnidadAdquirida(Collection<UnidadAdquirida> unidadAdquirida) {
        this.unidadAdquirida = unidadAdquirida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaId != null ? facturaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.facturaId == null && other.facturaId != null) || (this.facturaId != null && !this.facturaId.equals(other.facturaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Factura{" + "facturaId=" + facturaId + ", valorFactura=" + valorFactura + ", empleado=" + empleado + ", clienteNatural=" + clienteNatural + ", clienteEmpresarial=" + clienteEmpresarial + ", unidadAdquirida=" + unidadAdquirida + '}';
    }

}
