package com.landv.techbit.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Robin
 */
@Entity
@Table(name = "cliente_natural")
@NamedQueries({
    @NamedQuery(name = "ClienteNatural.findAll", query = "SELECT c FROM ClienteNatural c")})
public class ClienteNatural extends Persona implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;

    @JoinColumn(name = "servicios_activos_id", referencedColumnName = "catalogo_id")
    @OneToMany(mappedBy = "catalogo_id")
    private Collection<Catalogo> serviciosActivosId;

    public ClienteNatural() {
    }

    public ClienteNatural(String estado, Collection<Catalogo> serviciosActivosId, Long personaId, String nombres, String apellidos, String cedula, String telefono, String email) {
        super(personaId, nombres, apellidos, cedula, telefono, email);
        this.estado = estado;
        this.serviciosActivosId = serviciosActivosId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<Catalogo> getServiciosActivosId() {
        return serviciosActivosId;
    }

    public void setServiciosActivosId(Collection<Catalogo> serviciosActivosId) {
        this.serviciosActivosId = serviciosActivosId;
    }

    @Override
    public String toString() {
        return "ClienteNatural{" + "estado=" + estado + ", serviciosActivosId=" + serviciosActivosId + '}';
    }

}
