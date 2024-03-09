package com.robinlb.techbit.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.OneToMany;

/**
 *
 * @author Robin
 */
@Entity
@Table(name = "cliente_empresarial")
@NamedQueries({
    @NamedQuery(name = "ClienteEmpresarial.findAll", query = "SELECT c FROM ClienteEmpresarial c")})
public class ClienteEmpresarial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cliente_e_id")
    private Long clienteEId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "razon_social")
    private String razonSocial;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre_comercial")
    private String nombreComercial;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ruc")
    private String ruc;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefono")
    private String telefono;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;

    @OneToMany
    private Collection<Catalogo> catalogo;

    public ClienteEmpresarial() {
    }

    public ClienteEmpresarial(Long clienteEId, String razonSocial, String nombreComercial, String ruc, String telefono, String email, String estado, Collection<Catalogo> catalogo) {
        this.clienteEId = clienteEId;
        this.razonSocial = razonSocial;
        this.nombreComercial = nombreComercial;
        this.ruc = ruc;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
        this.catalogo = catalogo;
    }

    public Long getClienteEId() {
        return clienteEId;
    }

    public void setClienteEId(Long clienteEId) {
        this.clienteEId = clienteEId;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<Catalogo> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Collection<Catalogo> catalogo) {
        this.catalogo = catalogo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteEId != null ? clienteEId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteEmpresarial)) {
            return false;
        }
        ClienteEmpresarial other = (ClienteEmpresarial) object;
        if ((this.clienteEId == null && other.clienteEId != null) || (this.clienteEId != null && !this.clienteEId.equals(other.clienteEId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClienteEmpresarial{" + "clienteEId=" + clienteEId + ", razonSocial=" + razonSocial + ", nombreComercial=" + nombreComercial + ", ruc=" + ruc + ", telefono=" + telefono + ", email=" + email + ", estado=" + estado + ", catalogo=" + catalogo + '}';
    }

}
