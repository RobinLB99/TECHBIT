package com.robinlb.techbit.model;

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
import javax.validation.constraints.Size;
import java.io.Serializable;
import javax.persistence.OneToOne;

/**
 *
 * @author Robin
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_id")
    private Long usuarioId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contrase\u00f1a")
    private String contraseña;

    @Basic(optional = false)
    @NotNull
    @Column(name = "privilegios")
    private String privilegios;

    @JoinColumn(name = "empresa", referencedColumnName = "cliente_e_id")
    @OneToOne
    private ClienteEmpresarial clienteEmpresarial;

    @JoinColumn(name = "clienteNatural", referencedColumnName = "id")
    @OneToOne
    private ClienteNatural clienteNatural;

    @JoinColumn(name = "empleado", referencedColumnName = "id")
    @OneToOne
    private Empleado empleado;

    public Usuario() {
    }

    public Usuario(Long usuarioId, String nombreUsuario, String contraseña, String administrador, ClienteEmpresarial clienteEmpresarial, ClienteNatural clienteNatural, Empleado empleado) {
        this.usuarioId = usuarioId;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.privilegios = privilegios;
        this.clienteEmpresarial = clienteEmpresarial;
        this.clienteNatural = clienteNatural;
        this.empleado = empleado;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(String privilegios) {
        this.privilegios = privilegios;
    }

    public ClienteEmpresarial getClienteEmpresarial() {
        return clienteEmpresarial;
    }

    public void setClienteEmpresarial(ClienteEmpresarial clienteEmpresarial) {
        this.clienteEmpresarial = clienteEmpresarial;
    }

    public ClienteNatural getClienteNatural() {
        return clienteNatural;
    }

    public void setClienteNatural(ClienteNatural clienteNatural) {
        this.clienteNatural = clienteNatural;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuarioId=" + usuarioId + ", nombreUsuario=" + nombreUsuario + ", contrase\u00f1a=" + contraseña + ", privilegios=" + privilegios + ", clienteEmpresarial=" + clienteEmpresarial + ", clienteNatural=" + clienteNatural + ", empleado=" + empleado + '}';
    }

}
