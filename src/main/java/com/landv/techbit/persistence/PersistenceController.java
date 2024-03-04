package com.landv.techbit.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Robin
 */
public class PersistenceController {
    
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.landv_TechBit_war_1.0PU");
    
    ClientePersonaJpaController pclienteJpa = new ClientePersonaJpaController(emf);
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController(emf);
    ClienteEmpresaJpaController eclienteJpa = new ClienteEmpresaJpaController(emf);
    
}
