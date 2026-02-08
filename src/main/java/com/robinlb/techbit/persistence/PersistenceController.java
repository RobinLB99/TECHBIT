package com.robinlb.techbit.persistence;

import com.robinlb.techbit.model.ArchivoAdjunto;
import com.robinlb.techbit.model.ClienteNatural;
import com.robinlb.techbit.model.Empleado;
import com.robinlb.techbit.model.TicketSoporte;
import com.robinlb.techbit.model.Usuario;
import com.robinlb.techbit.persistence.exceptions.NonexistentEntityException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joel
 */
public class PersistenceController {

  static {
    System.out.println("DEBUG: Iniciando bloque estático de PersistenceController para configurar propiedades DB.");
    // Read environment variables and set them as system properties
    Map<String, String> env = System.getenv();
    String dbHost = env.get("DB_HOST");
    String dbPort = env.get("DB_PORT");
    String dbName = env.get("DB_NAME");
    String dbUser = env.get("DB_USER");
    String dbPassword = env.get("DB_PASSWORD");

    System.out.println("DEBUG: Env DB_HOST = " + dbHost);
    System.out.println("DEBUG: Env DB_PORT = " + dbPort);
    System.out.println("DEBUG: Env DB_NAME = " + dbName);
    System.out.println("DEBUG: Env DB_USER = " + dbUser);
    System.out.println("DEBUG: Env DB_PASSWORD = " + (dbPassword != null ? "[SET]" : "[NOT SET]")); // Evitar logear la contraseña real

    if (dbHost != null) { System.setProperty("DB_HOST", dbHost); }
    if (dbPort != null) { System.setProperty("DB_PORT", dbPort); }
    if (dbName != null) { System.setProperty("DB_NAME", dbName); }
    if (dbUser != null) { System.setProperty("DB_USER", dbUser); }
    if (dbPassword != null) { System.setProperty("DB_PASSWORD", dbPassword); }

    System.out.println("DEBUG: Propiedad de Sistema DB_HOST = " + System.getProperty("DB_HOST"));
    System.out.println("DEBUG: Propiedad de Sistema DB_PORT = " + System.getProperty("DB_PORT"));
    System.out.println("DEBUG: Propiedad de Sistema DB_NAME = " + System.getProperty("DB_NAME"));
    System.out.println("DEBUG: Propiedad de Sistema DB_USER = " + System.getProperty("DB_USER"));
    System.out.println("DEBUG: Propiedad de Sistema DB_PASSWORD = " + (System.getProperty("DB_PASSWORD") != null ? "[SET]" : "[NOT SET]"));
    System.out.println("DEBUG: Bloque estático de PersistenceController finalizado.");
  }

  Map<String, String> jpaProperties = new HashMap<>();
  { // Bloque inicializador de instancia para popular jpaProperties
      jpaProperties.put("jakarta.persistence.jdbc.url", "jdbc:postgresql://" + System.getProperty("DB_HOST") + ":" + System.getProperty("DB_PORT") + "/" + System.getProperty("DB_NAME") + "?serverTimezone=UTC");
      jpaProperties.put("jakarta.persistence.jdbc.user", System.getProperty("DB_USER"));
      jpaProperties.put("jakarta.persistence.jdbc.password", System.getProperty("DB_PASSWORD"));
      jpaProperties.put("jakarta.persistence.jdbc.driver", "org.postgresql.Driver");
      jpaProperties.put("jakarta.persistence.schema-generation.database.action", "create-or-extend-tables");
  }

  EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.robinlb_TechBit_war_1.0.0PU", jpaProperties);

  EmpleadoJpaController empleadoJpa = new EmpleadoJpaController(emf);
  UsuarioJpaController usuarioJpa = new UsuarioJpaController(emf);
  ClienteNaturalJpaController clienteJpa = new ClienteNaturalJpaController(emf);
  TicketSoporteJpaController ticketJpa = new TicketSoporteJpaController(emf);
  ArchivoAdjuntoJpaController archivoJpa = new ArchivoAdjuntoJpaController(emf);

  /**
   *
   * @param empleado
   */
  public void createEmploy(Empleado empleado) {
    empleadoJpa.create(empleado);
  }

  public void destroyEmploy(Long id) {
    try {
      empleadoJpa.destroy(id);
    } catch (NonexistentEntityException ex) {
      Logger.getLogger(PersistenceController.class.getName()).log(
        Level.SEVERE,
        null,
        ex
      );
    }
  }

  public void updateEmploy(Empleado empleado) {
    try {
      empleadoJpa.edit(empleado);
    } catch (Exception ex) {
      Logger.getLogger(PersistenceController.class.getName()).log(
        Level.SEVERE,
        null,
        ex
      );
    }
  }

  public List<Empleado> findTecnicoSoportePorCargo(String cargo) {
    return empleadoJpa.findTecnicoSoportePorCargo(cargo);
  }

  public Empleado viewEmploy(Long id) {
    return empleadoJpa.findEmpleado(id);
  }

  public Collection<Empleado> employList() {
    return empleadoJpa.findEmpleadoEntities();
  }

  /**
   *
   * @param usuario
   */
  public void createUser(Usuario usuario) {
    usuarioJpa.create(usuario);
  }

  public void destroyUsuario(Long id) {
    try {
      usuarioJpa.destroy(id);
    } catch (NonexistentEntityException ex) {
      Logger.getLogger(PersistenceController.class.getName()).log(
        Level.SEVERE,
        null,
        ex
      );
    }
  }

  public void updateUser(Usuario usuario) {
    try {
      usuarioJpa.edit(usuario);
    } catch (Exception ex) {
      Logger.getLogger(PersistenceController.class.getName()).log(
        Level.SEVERE,
        null,
        ex
      );
    }
  }

  public Usuario viewUser(Long id) {
    return usuarioJpa.findUsuario(id);
  }

  public Usuario viewUserForNameuser(String username) {
    return usuarioJpa.findUsuarioForUsername(username);
  }

  public Usuario viewUserForEmploy(Empleado empleado) {
    return usuarioJpa.findUsuarioForEmpleado(empleado);
  }

  public Usuario findNaturalClientUserForUsername(String username) {
    return usuarioJpa.findUsuarioClienteNaturalForUsername(username);
  }

  public Usuario findNaturalClienteUserForClienteNatural(
    ClienteNatural usuarioFinal
  ) {
    return usuarioJpa.findUsuarioClienteNaturalForClienteNatural(usuarioFinal);
  }

  public List<Usuario> findAllClienteNaturalUser() {
    return usuarioJpa.findAllUsuarioClienteNatural();
  }

  public Collection<Usuario> usersList() {
    return usuarioJpa.findUsuarioEntities();
  }

  public Long countUsers() {
    return usuarioJpa.getUserCount();
  }

  public Long countUsersClients() {
    return usuarioJpa.getUserClientCount();
  }

  // Cliente natural
  public void createNaturalClient(ClienteNatural client) {
    clienteJpa.create(client);
  }

  public void deleteNaturalClient(Long id) throws NonexistentEntityException {
    clienteJpa.destroy(id);
  }

  public void editNaturalClient(ClienteNatural client) throws Exception {
    clienteJpa.edit(client);
  }

  public ClienteNatural findNaturalClient(Long id) {
    return clienteJpa.findClienteNatural(id);
  }

  public List<ClienteNatural> findAllNaturalClients() {
    return clienteJpa.findClienteNaturalEntities();
  }

  public ClienteNatural findClienteNaturalForNUI(String nui) {
    return clienteJpa.findClienteNaturalForNUI(nui);
  }

  public Long countClienteNaturalForDirIP(String ip) {
    return clienteJpa.countClienteNaturalForDirIP(ip);
  }

  public Long countClienteNaturalForDirMAC(String mac) {
    return clienteJpa.countClienteNaturalForDirMAC(mac);
  }

  // Ticket de soporte
  public void createTicket(TicketSoporte ticket) {
    ticketJpa.create(ticket);
  }

  public void deleteTicket(Long id) throws NonexistentEntityException {
    ticketJpa.destroy(id);
  }

  public void updateTicket(TicketSoporte ticket) throws Exception {
    ticketJpa.edit(ticket);
  }

  public TicketSoporte findTicket(Long id) {
    return ticketJpa.findTicketSoporte(id);
  }

  public List<TicketSoporte> findTicketsNoAsigment() {
    return ticketJpa.findTicketSoporteListNoAsignados();
  }

  public List<TicketSoporte> findTicketByEstado(String estado) {
    return null;
  }

  public TicketSoporte findTicketSoporteByClienteNatural(
    ClienteNatural usuarioFinal
  ) {
    return ticketJpa.findTicketSoporteByClienteNatural(usuarioFinal);
  }

  public List<TicketSoporte> findAllTickets() {
    return ticketJpa.findTicketSoporteEntities();
  }

  // Archivos Adjuntos
  public void createAdjunto(ArchivoAdjunto adjunto) {
    archivoJpa.create(adjunto);
  }

  public void updateAdjunto(ArchivoAdjunto adjunto) throws Exception {
    archivoJpa.edit(adjunto);
  }
}
