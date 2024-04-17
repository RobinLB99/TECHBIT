package com.robinlb.techbit.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
