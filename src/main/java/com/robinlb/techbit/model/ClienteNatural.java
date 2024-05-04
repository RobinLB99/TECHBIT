package com.robinlb.techbit.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

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

  public ClienteNatural() {
  }

  public ClienteNatural(String estado, Long id, String nombres, String apellidos, String cedula, String telefono, String email) {
    super(id, nombres, apellidos, cedula, telefono, email);
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
    return "ClienteNatural{" + "estado=" + estado + '}';
  }

}
