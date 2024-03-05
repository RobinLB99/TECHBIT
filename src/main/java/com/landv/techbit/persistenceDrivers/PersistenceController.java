package com.landv.techbit.persistenceDrivers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Robin
 */
public class PersistenceController {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.landv_TechBit_war_1.0PU");

}
