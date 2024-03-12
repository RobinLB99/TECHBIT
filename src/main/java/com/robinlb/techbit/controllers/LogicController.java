package com.robinlb.techbit.controllers;

import com.robinlb.techbit.model.Empleado;
import com.robinlb.techbit.model.Usuario;
import com.robinlb.techbit.persistence.PersistenceController;
import java.util.Collection;

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
        Collection<Usuario> usuarios = perControl.usersList();
        Usuario usuario = null;
        
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equals(nombreUsuario)) {
                usuario = u;
                break;
            }
        }
        return usuario;
    }

    public Collection<Usuario> listaUsuarios() {
        return perControl.usersList();
    }

}
