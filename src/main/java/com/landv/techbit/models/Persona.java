package com.landv.techbit.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Robin
 */
@Entity
@Table(catalog = "db_techbit", schema = "")
@XmlRootElement
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(nullable = false, name = "ID")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50, name = "Apellidos")
    private String apellidos;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(nullable = false, length = 10, name = "Cedula")
    private String cedula;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100, name = "Email")
    private String email;

    @Basic(optional = false)
    @NotNull
    @Size(min = 5, max = 50)
    @Column(nullable = false, length = 50, name = "Nombres")
    private String nombres;

    @Basic(optional = false)
    @Size(max = 10)
    @Column(length = 10, name = "Telefono")
    private String telefono;

    public Persona() {
    }

    public Persona(Long id, String apellidos, String cedula, String email, String nombres, String telefono) {
        this.id = id;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.email = email;
        this.nombres = nombres;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", apellidos=" + apellidos + ", cedula=" + cedula + ", email=" + email + ", nombres=" + nombres + ", telefono=" + telefono + '}';
    }

}
