package com.robinlb.techbit.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.OneToMany;

/**
 *
 * @author Robin
 */
@Entity
@Table(name = "ticket_soporte")
@NamedQueries({
  @NamedQuery(name = "TicketSoporte.findAll", query = "SELECT t FROM TicketSoporte t")})
public class TicketSoporte implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ticket_id")
  private Long ticketId;

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "titulo")
  private String titulo;

  @Basic(optional = false)
  @NotNull
  @Lob
  @Size(min = 1, max = 2147483647)
  @Column(name = "descripcion")
  private String descripcion;

  @Basic(optional = false)
  @NotNull
  @Column(name = "prioridad")
  private int prioridad;

  @Basic(optional = false)
  @NotNull
  @Column(name = "estado")
  private int estado;

  @Basic(optional = false)
  @NotNull
  @Column(name = "creacion")
  @Temporal(TemporalType.TIMESTAMP)
  private Date creacion;

  @Basic(optional = false)
  @NotNull
  @Column(name = "vencimiento")
  @Temporal(TemporalType.TIMESTAMP)
  private Date vencimiento;

  @Basic(optional = false)
  @NotNull
  @Column(name = "categoria")
  private int categoria;

  @Basic(optional = false)
  @NotNull
  @Column(name = "nivel_calamiento")
  private int nivelCalamiento;

  @Basic(optional = false)
  @NotNull
  @Column(name = "tiempo_respuesta")
  @Temporal(TemporalType.TIME)
  private Date tiempoRespuesta;

  @Basic(optional = false)
  @NotNull
  @Column(name = "tiempo_solucion")
  @Temporal(TemporalType.TIME)
  private Date tiempoSolucion;

  @JoinColumn(name = "archivos_adjuntos", referencedColumnName = "files_id")
  @ManyToOne(optional = false)
  private ArchivoAdjunto archivoAdjunto;

  @JoinColumn(name = "cliente_natural", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private ClienteNatural clienteNatural;

  @JoinColumn(name = "solucion_respuesta", referencedColumnName = "res_sol_id")
  @OneToMany
  private Collection<SolucionRespuesta> solucionRespuesta;

  @JoinColumn(name = "usuario", referencedColumnName = "usuario_id")
  @ManyToOne(optional = false)
  private Usuario usuario;

  public TicketSoporte() {
  }

  public TicketSoporte(Long ticketId, String titulo, String descripcion, int prioridad, int estado, Date creacion, Date vencimiento, int categoria, int nivelCalamiento, Date tiempoRespuesta, Date tiempoSolucion, ArchivoAdjunto archivoAdjunto, ClienteNatural clienteNatural, Collection<SolucionRespuesta> solucionRespuesta, Usuario usuario) {
    this.ticketId = ticketId;
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.prioridad = prioridad;
    this.estado = estado;
    this.creacion = creacion;
    this.vencimiento = vencimiento;
    this.categoria = categoria;
    this.nivelCalamiento = nivelCalamiento;
    this.tiempoRespuesta = tiempoRespuesta;
    this.tiempoSolucion = tiempoSolucion;
    this.archivoAdjunto = archivoAdjunto;
    this.clienteNatural = clienteNatural;
    this.solucionRespuesta = solucionRespuesta;
    this.usuario = usuario;
  }

  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public int getPrioridad() {
    return prioridad;
  }

  public void setPrioridad(int prioridad) {
    this.prioridad = prioridad;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }

  public Date getCreacion() {
    return creacion;
  }

  public void setCreacion(Date creacion) {
    this.creacion = creacion;
  }

  public Date getVencimiento() {
    return vencimiento;
  }

  public void setVencimiento(Date vencimiento) {
    this.vencimiento = vencimiento;
  }

  public int getCategoria() {
    return categoria;
  }

  public void setCategoria(int categoria) {
    this.categoria = categoria;
  }

  public int getNivelCalamiento() {
    return nivelCalamiento;
  }

  public void setNivelCalamiento(int nivelCalamiento) {
    this.nivelCalamiento = nivelCalamiento;
  }

  public Date getTiempoRespuesta() {
    return tiempoRespuesta;
  }

  public void setTiempoRespuesta(Date tiempoRespuesta) {
    this.tiempoRespuesta = tiempoRespuesta;
  }

  public Date getTiempoSolucion() {
    return tiempoSolucion;
  }

  public void setTiempoSolucion(Date tiempoSolucion) {
    this.tiempoSolucion = tiempoSolucion;
  }

  public ArchivoAdjunto getArchivoAdjunto() {
    return archivoAdjunto;
  }

  public void setArchivoAdjunto(ArchivoAdjunto archivoAdjunto) {
    this.archivoAdjunto = archivoAdjunto;
  }

  public ClienteNatural getClienteNatural() {
    return clienteNatural;
  }

  public void setClienteNatural(ClienteNatural clienteNatural) {
    this.clienteNatural = clienteNatural;
  }

  public Collection<SolucionRespuesta> getSolucionRespuesta() {
    return solucionRespuesta;
  }

  public void setSolucionRespuesta(Collection<SolucionRespuesta> solucionRespuesta) {
    this.solucionRespuesta = solucionRespuesta;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (ticketId != null ? ticketId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TicketSoporte)) {
      return false;
    }
    TicketSoporte other = (TicketSoporte) object;
    if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "TicketSoporte{" + "ticketId=" + ticketId + ", titulo=" + titulo + ", descripcion=" + descripcion + ", prioridad=" + prioridad + ", estado=" + estado + ", creacion=" + creacion + ", vencimiento=" + vencimiento + ", categoria=" + categoria + ", nivelCalamiento=" + nivelCalamiento + ", tiempoRespuesta=" + tiempoRespuesta + ", tiempoSolucion=" + tiempoSolucion + ", archivoAdjunto=" + archivoAdjunto + ", clienteNatural=" + clienteNatural + ", solucionRespuesta=" + solucionRespuesta + ", usuario=" + usuario + '}';
  }

}
