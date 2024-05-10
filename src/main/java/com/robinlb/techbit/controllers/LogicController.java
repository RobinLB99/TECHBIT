package com.robinlb.techbit.controllers;

import com.robinlb.techbit.model.ArchivoAdjunto;
import com.robinlb.techbit.model.ClienteNatural;
import com.robinlb.techbit.model.Empleado;
import com.robinlb.techbit.model.TicketSoporte;
import com.robinlb.techbit.model.Usuario;
import com.robinlb.techbit.persistence.PersistenceController;
import com.robinlb.techbit.persistence.exceptions.NonexistentEntityException;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Robin
 */
public class LogicController {

  PersistenceController perControl = new PersistenceController();

  /**
   *
   * @param empleado
   */
  public void crearEmpleado(Empleado empleado) {
    perControl.createEmploy(empleado);
  }

  public void eliminarEmpleado(Long id) {
    perControl.destroyEmploy(id);
  }

  public void actualizarEmpleado(Empleado empleado) {
    perControl.updateEmploy(empleado);
  }

  public Empleado verEmpleado(Long id) {
    return perControl.viewEmploy(id);
  }

  public Collection<Empleado> listaEmpleados() {
    return perControl.employList();
  }

  /**
   *
   * @param usuario
   */
  public void crearUsuario(Usuario usuario) {
    perControl.createUser(usuario);
  }

  public void eliminarUsuario(Long id) {
    perControl.destroyUsuario(id);
  }

  public void actualizarUsuario(Usuario usuario) {
    perControl.updateUser(usuario);
  }

  public Usuario verUsuario(Long id) {
    return perControl.viewUser(id);
  }

  public Usuario verUsuarioPorNombreUsuario(String nombreUsuario) {
    return perControl.viewUserForNameuser(nombreUsuario);
  }
  
  public Usuario verUsuarioPorEmpleado(Empleado empleado) {
    return perControl.viewUserForEmploy(empleado);
  }

  public Usuario buscarUsuarioClienteNaturalPorUsername(String username) {
    return perControl.findNaturalClientUserForUsername(username);
  }
  
  public Usuario buscarUsuarioClienteNaturalPorClienteNatural(ClienteNatural usuarioFinal) {
    return perControl.findNaturalClienteUserForClienteNatural(usuarioFinal);
  }

  public Collection<Usuario> listaUsuarios() {
    return perControl.usersList();
  }

  public Long contarUsuarios() {
    return perControl.countUsers();
  }

  public Long contarUsuariosClientes() {
    return perControl.countUsersClients();
  }

  // Clientes
  public void crearClienteNatural(ClienteNatural cliente) {
    perControl.createNaturalClient(cliente);
  }

  public void eliminarClienteNatural(Long id)
          throws NonexistentEntityException {
    perControl.deleteNaturalClient(id);
  }

  public void editarClienteNaural(ClienteNatural cliente)
          throws Exception {
    perControl.editNaturalClient(cliente);
  }

  public ClienteNatural buscarClienteNatural(Long id) {
    return perControl.findNaturalClient(id);
  }

  public List<ClienteNatural> listaClientesNaturales() {
    return perControl.findAllNaturalClients();
  }

  public ClienteNatural buscarClienteNaturalPorNUI(String nui) {
    return perControl.findClienteNaturalForNUI(nui);
  }
  
  public Long contarClientesPorIP(String ip) {
    return perControl.countClienteNaturalForDirIP(ip);
  }
  
  public Long contarClientePorMAC(String mac) {
    return perControl.countClienteNaturalForDirMAC(mac);
  }
  
  // Tickets de soporte
  public void crearTicket(TicketSoporte ticket) {
    perControl.createTicket(ticket);
  }

  public void eliminarTicket(Long id) throws NonexistentEntityException {
    perControl.deleteTicket(id);
  }

  public void actualizarTicket(TicketSoporte ticket) throws Exception {
    perControl.updateTicket(ticket);
  }

  public TicketSoporte buscarTicket(Long id) {
    return perControl.findTicket(id);
  }
  
  public TicketSoporte buscarTicketPorEstado(String estado) {
    return (TicketSoporte) perControl.findTicketByEstado(estado);
  }
  
  public TicketSoporte buscarTicketPorClienteNatural(ClienteNatural usuarioFinal) {
    return perControl.findTicketSoporteByClienteNatural(usuarioFinal);
  }
  
  public List<TicketSoporte> enlistarTickets() {
    return perControl.findAllTickets();
  }
  
  
  // Archivos adjuntos
  public void crearAdjunto(ArchivoAdjunto adjunto) {
    perControl.createAdjunto(adjunto);
  }
  
  public void editarAjunto(ArchivoAdjunto adjunto) throws Exception {
    perControl.updateAdjunto(adjunto);
  }
  
}
