package com.landv.techbit.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Robin
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "UsuarioID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Basic(optional = false)
    @Column(name = "Nombre_Usuario", nullable = false, length = 50)
    @Size(min = 10, max = 50)
    @NotNull
    private String nombreUsuario;

    @Basic(optional = false)
    @Column(name = "Password", nullable = false, length = 50)
    @Size(min = 10, max = 50)
    @NotNull
    private String password;

    @Basic(optional = false)
    @Column(name = "Tipo_Acceso", nullable = false, length = 20)
    @Size(min = 10, max = 20)
    @NotNull
    private String tipoAcceso;

    @Basic(optional = false)
    @Column(name = "FK_EmpleadoID", nullable = false)
    @NotNull
    private Empleado empleado;

    public Usuario() {
    }

    public Usuario(Long id, String nombreUsuario, String password, String tipoAcceso, Empleado empleado) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.tipoAcceso = tipoAcceso;
        this.empleado = empleado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoAcceso() {
        return tipoAcceso;
    }

    public void setTipoAcceso(String tipoAcceso) {
        this.tipoAcceso = tipoAcceso;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", tipoAcceso=" + tipoAcceso + '}';
    }

}
