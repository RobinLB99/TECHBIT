package com.robinlb.techbit.persistence;

import com.robinlb.techbit.model.Empleado;
import com.robinlb.techbit.model.Usuario;
import com.robinlb.techbit.persistence.exceptions.NonexistentEntityException;
import java.util.Collection;
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
    
    public void updateUuser(Usuario usuario) {
        try {
            usuarioJpa.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Usuario viewUser(Long id) {
        return usuarioJpa.findUsuario(id);
    }
    
    public Collection<Usuario> usersList() {
        return usuarioJpa.findUsuarioEntities();
    }
}
