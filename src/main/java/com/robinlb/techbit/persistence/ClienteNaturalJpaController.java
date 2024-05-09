package com.robinlb.techbit.persistence;

import com.robinlb.techbit.model.ClienteNatural;
import com.robinlb.techbit.persistence.exceptions.NonexistentEntityException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author joel
 */
public class ClienteNaturalJpaController implements Serializable {

  public ClienteNaturalJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(ClienteNatural clienteNatural) {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(clienteNatural);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(ClienteNatural clienteNatural) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      clienteNatural = em.merge(clienteNatural);
      em.getTransaction().commit();
    } catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        Long id = clienteNatural.getId();
        if (findClienteNatural(id) == null) {
          throw new NonexistentEntityException("The clienteNatural with id " + id + " no longer exists.");
        }
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void destroy(Long id) throws NonexistentEntityException {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      ClienteNatural clienteNatural;
      try {
        clienteNatural = em.getReference(ClienteNatural.class, id);
        clienteNatural.getId();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The clienteNatural with id " + id + " no longer exists.", enfe);
      }
      em.remove(clienteNatural);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<ClienteNatural> findClienteNaturalEntities() {
    return findClienteNaturalEntities(true, -1, -1);
  }

  public List<ClienteNatural> findClienteNaturalEntities(int maxResults, int firstResult) {
    return findClienteNaturalEntities(false, maxResults, firstResult);
  }

  private List<ClienteNatural> findClienteNaturalEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(ClienteNatural.class));
      Query q = em.createQuery(cq);
      if (!all) {
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
      }
      return q.getResultList();
    } finally {
      em.close();
    }
  }

  public ClienteNatural findClienteNatural(Long id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(ClienteNatural.class, id);
    } finally {
      em.close();
    }
  }

  public int getClienteNaturalCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<ClienteNatural> rt = cq.from(ClienteNatural.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }

  public ClienteNatural findClienteNaturalForNUI(String nui) {
    EntityManager em = getEntityManager();
    try {
      TypedQuery<ClienteNatural> query = em.createQuery("SELECT c FROM ClienteNatural c WHERE c.cedula = :identidad", ClienteNatural.class);
      query.setParameter("identidad", nui);
      return query.getSingleResult();
    }
    finally {
      em.close();
    }
  }
  
  public Long countClienteNaturalForDirIP(String dirIP) {
    EntityManager em = getEntityManager();
    try {
      Query query = em.createQuery("SELECT COUNT(c) FROM ClienteNatural c WHERE c.ipDirection = :direccionIP", ClienteNatural.class);
      query.setParameter("direccionIP", dirIP);
      return (Long) query.getSingleResult();
    }
    finally {
      em.close();
    }
  }
  
  public Long countClienteNaturalForDirMAC(String dirMAC) {
    EntityManager em = getEntityManager();
    try {
      Query query = em.createQuery("SELECT COUNT(c) FROM ClienteNatural c WHERE c.macDirection = :direccionMAC", ClienteNatural.class);
      query.setParameter("direccionMAC", dirMAC);
      return (Long) query.getSingleResult();
    }
    finally {
      em.close();
    }
  }

}
