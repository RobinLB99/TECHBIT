package com.landv.techbit.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Robin
 */
@Entity
@Table(name = "empleado")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")})
public class Empleado extends Persona implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cargo")
    private String cargo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "departamento")
    private String departamento;

    @Basic(optional = false)
    @NotNull
    @Column(name = "tiene_usuario_asignado")
    private boolean tieneUsuarioAsignado;

    public Empleado() {
    }

    public Empleado(Date fechaNacimiento, String cargo, String departamento, boolean tieneUsuarioAsignado, Long personaId, String nombres, String apellidos, String cedula, String telefono, String email) {
        super(personaId, nombres, apellidos, cedula, telefono, email);
        this.fechaNacimiento = fechaNacimiento;
        this.cargo = cargo;
        this.departamento = departamento;
        this.tieneUsuarioAsignado = tieneUsuarioAsignado;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public boolean getTieneUsuarioAsignado() {
        return tieneUsuarioAsignado;
    }

    public void setTieneUsuarioAsignado(boolean tieneUsuarioAsignado) {
        this.tieneUsuarioAsignado = tieneUsuarioAsignado;
    }

    @Override
    public String toString() {
        return "Empleado{" + "fechaNacimiento=" + fechaNacimiento + ", cargo=" + cargo + ", departamento=" + departamento + ", tieneUsuarioAsignado=" + tieneUsuarioAsignado + '}';
    }

}
