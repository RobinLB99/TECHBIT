package com.landv.techbit.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Robin
 */
@Entity
@Table(catalog = "db_techbit", schema = "")
@XmlRootElement
public class Empleado extends Persona implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String cargo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String departamento;

    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double sueldo;

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean tieneUsuario;

    public Empleado() {
    }

    public Empleado(Long id, String cargo, String departamento, Date fechaNacimiento, double sueldo, boolean tieneUsuario, String apellidos, String cedula, String email, String nombres, String telefono) {
        super(id, apellidos, cedula, email, nombres, telefono);
        this.cargo = cargo;
        this.departamento = departamento;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
        this.tieneUsuario = tieneUsuario;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean getTieneUsuario() {
        return tieneUsuario;
    }

    public void setTieneUsuario(boolean tieneUsuario) {
        this.tieneUsuario = tieneUsuario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "cargo=" + cargo + ", departamento=" + departamento + ", fechaNacimiento=" + fechaNacimiento + ", sueldo=" + sueldo + ", tieneUsuario=" + tieneUsuario + '}';
    }

}
