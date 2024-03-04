package com.landv.techbit.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Robin
 */
@Entity
@Table(name = "ECliente", catalog = "db_techbit", schema = "")
@XmlRootElement
public class ClienteEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull
    @Column(name = "EClienteID", nullable = false)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "Nombre_Comercial", length = 100, nullable = false)
    @Size(min = 1, max = 100)
    private String nombreComercial;

    @Basic(optional = false)
    @NotNull
    @Column(name = "Razon_Social", length = 100, nullable = false)
    @Size(min = 1, max = 100)
    private String razonSocial;

    @Basic(optional = false)
    @NotNull
    @Column(name = "RUC", length = 13, nullable = false)
    @Size(min = 1, max = 13)
    private String ruc;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Telefono", length = 10, nullable = false)
    @Size(min = 1, max = 10)
    private String telefono;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Email", length = 100, nullable = false)
    @Size(min = 1, max = 100)
    private String email;

    public ClienteEmpresa() {
    }

    public ClienteEmpresa(Long id, String nombreComercial, String razonSocial, String ruc, String telefono, String email) {
        this.id = id;
        this.nombreComercial = nombreComercial;
        this.razonSocial = razonSocial;
        this.ruc = ruc;
        this.telefono = telefono;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteEmpresa)) {
            return false;
        }
        ClienteEmpresa other = (ClienteEmpresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClienteEmpresa{" + "id=" + id + ", nombreComercial=" + nombreComercial + ", razonSocial=" + razonSocial + ", ruc=" + ruc + ", telefono=" + telefono + ", email=" + email + '}';
    }

}
