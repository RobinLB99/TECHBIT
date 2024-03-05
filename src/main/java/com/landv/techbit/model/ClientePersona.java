package com.landv.techbit.model;

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
import java.io.Serializable;

/**
 *
 * @author Robin
 */
@Entity
@Table(name = "PCliente", catalog = "db_techbit", schema = "")
@XmlRootElement
public class ClientePersona extends Persona implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(nullable = false, length = 10, name = "Estado")
    private String estado;

    public ClientePersona() {
    }

    public ClientePersona(Long id, String estado, String apellidos, String cedula, String email, String nombres, String telefono) {
        super(id, apellidos, cedula, email, nombres, telefono);
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ClientePersona{" + "estado=" + estado + '}';
    }

}
