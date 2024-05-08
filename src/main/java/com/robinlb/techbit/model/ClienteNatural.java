package com.robinlb.techbit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Robin
 */
@Entity
@Table(name = "cliente_natural")
@NamedQueries({
  @NamedQuery(name = "ClienteNatural.findAll", query = "SELECT c FROM ClienteNatural c")})
public class ClienteNatural extends Persona implements Serializable {

  @NotNull
  @Column(name = "Direccion_IP", length = 15, nullable = false)
  private String ipDirection;

  @NotNull
  @Column(name = "Direccion_MAC", length = 17, nullable = false)
  private String macDirection;

  public ClienteNatural() {
  }

  public ClienteNatural(String ipDirection, String macDirection, Long id, String nombres, String apellidos, String cedula, String telefono, String email) {
    super(id, nombres, apellidos, cedula, telefono, email);
    this.ipDirection = ipDirection;
    this.macDirection = macDirection;
  }

  public String getIpDirection() {
    return ipDirection;
  }

  public void setIpDirection(String ipDirection) {
    this.ipDirection = ipDirection;
  }

  public String getMacDirection() {
    return macDirection;
  }

  public void setMacDirection(String macDirection) {
    this.macDirection = macDirection;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 79 * hash + Objects.hashCode(this.ipDirection);
    hash = 79 * hash + Objects.hashCode(this.macDirection);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final ClienteNatural other = (ClienteNatural) obj;
    if (!Objects.equals(this.ipDirection, other.ipDirection)) {
      return false;
    }
    return Objects.equals(this.macDirection, other.macDirection);
  }

  @Override
  public String toString() {
    return "ClienteNatural{ ID: " + super.getId() + ", ipDirection=" + ipDirection + ", macDirection=" + macDirection + '}';
  }

}
