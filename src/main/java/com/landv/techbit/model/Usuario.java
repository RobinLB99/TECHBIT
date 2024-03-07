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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    @Column(name = "administrador")
    private boolean administrador;

    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_credencial")
    private boolean tipoCredencial;

    @JoinColumn(name = "cliente_empresarial_id", referencedColumnName = "cliente_e_id")
    @OneToOne
    private ClienteEmpresarial clienteEmpresarialId;

    @JoinColumn(name = "cliente_natural_id", referencedColumnName = "cliente_n_id")
    @OneToOne
    private ClienteNatural clienteNaturalId;

    @JoinColumn(name = "empleado_id", referencedColumnName = "empleado_id")
    @OneToOne
    private Empleado empleadoId;

    public Usuario() {
    }

    public Usuario(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuario(Long usuarioId, String nombreUsuario, String contraseña, boolean administrador, boolean tipoCredencial, ClienteEmpresarial clienteEmpresarialId, ClienteNatural clienteNaturalId, Empleado empleadoId) {
        this.usuarioId = usuarioId;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.administrador = administrador;
        this.tipoCredencial = tipoCredencial;
        this.clienteEmpresarialId = clienteEmpresarialId;
        this.clienteNaturalId = clienteNaturalId;
        this.empleadoId = empleadoId;
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

    public boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public boolean getTipoCredencial() {
        return tipoCredencial;
    }

    public void setTipoCredencial(boolean tipoCredencial) {
        this.tipoCredencial = tipoCredencial;
    }

    public ClienteEmpresarial getClienteEmpresarialId() {
        return clienteEmpresarialId;
    }

    public void setClienteEmpresarialId(ClienteEmpresarial clienteEmpresarialId) {
        this.clienteEmpresarialId = clienteEmpresarialId;
    }

    public ClienteNatural getClienteNaturalId() {
        return clienteNaturalId;
    }

    public void setClienteNaturalId(ClienteNatural clienteNaturalId) {
        this.clienteNaturalId = clienteNaturalId;
    }

    public Empleado getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Empleado empleadoId) {
        this.empleadoId = empleadoId;
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
        return "Usuario{" + "usuarioId=" + usuarioId + ", nombreUsuario=" + nombreUsuario + ", contrase\u00f1a=" + contraseña + ", administrador=" + administrador + ", tipoCredencial=" + tipoCredencial + ", clienteEmpresarialId=" + clienteEmpresarialId + ", clienteNaturalId=" + clienteNaturalId + ", empleadoId=" + empleadoId + '}';
    }

}
