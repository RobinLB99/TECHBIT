package com.robinlb.techbit.persistence;

import com.robinlb.techbit.model.ArchivoAdjunto;
import com.robinlb.techbit.model.ClienteNatural;
import com.robinlb.techbit.model.Empleado;
import com.robinlb.techbit.model.TicketSoporte;
import com.robinlb.techbit.model.Usuario;
import com.robinlb.techbit.persistence.exceptions.NonexistentEntityException;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Robin
 */
public class PersistenceController {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.robinlb_TechBit_war_1.0PU");

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
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateEmploy(Empleado empleado) {
        try {
            empleadoJpa.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateUser(Usuario usuario) {
        try {
            usuarioJpa.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario viewUser(Long id) {
        return usuarioJpa.findUsuario(id);
    }
    
    public Usuario viewUserForNameuser(String username) {
      return usuarioJpa.findUsuarioForUsername(username);
    }
    
    public Usuario findNaturalClientUserForUsername(String username) {
      return usuarioJpa.findUsuarioClienteNaturalForUsername(username);
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
    
    public List<TicketSoporte> findTicketByEstado(String estado) {
      return null;
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
