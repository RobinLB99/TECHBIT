package com.landv.techbit.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(nullable = false, name = "EmpleadoID")
    private Long id;

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
        super(apellidos, cedula, email, nombres, telefono);
        this.id = id;
        this.cargo = cargo;
        this.departamento = departamento;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
        this.tieneUsuario = tieneUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", cargo=" + cargo + ", departamento=" + departamento + ", fechaNacimiento=" + fechaNacimiento + ", sueldo=" + sueldo + ", tieneUsuario=" + tieneUsuario + '}';
    }

}
