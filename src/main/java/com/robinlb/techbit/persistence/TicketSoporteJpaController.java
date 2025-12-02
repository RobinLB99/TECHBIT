package com.robinlb.techbit.persistence;

import com.robinlb.techbit.model.ClienteNatural;
import com.robinlb.techbit.model.TicketSoporte;
import com.robinlb.techbit.persistence.exceptions.NonexistentEntityException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author Robin
 */
public class TicketSoporteJpaController implements Serializable {

  public TicketSoporteJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(TicketSoporte ticketSoporte) {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(ticketSoporte);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(TicketSoporte ticketSoporte) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      ticketSoporte = em.merge(ticketSoporte);
      em.getTransaction().commit();
    } catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        Long id = ticketSoporte.getTicketId();
        if (findTicketSoporte(id) == null) {
          throw new NonexistentEntityException("The ticketSoporte with id " + id + " no longer exists.");
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
      TicketSoporte ticketSoporte;
      try {
        ticketSoporte = em.getReference(TicketSoporte.class, id);
        ticketSoporte.getTicketId();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The ticketSoporte with id " + id + " no longer exists.", enfe);
      }
      em.remove(ticketSoporte);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<TicketSoporte> findTicketSoporteEntities() {
    return findTicketSoporteEntities(true, -1, -1);
  }

  public List<TicketSoporte> findTicketSoporteEntities(int maxResults, int firstResult) {
    return findTicketSoporteEntities(false, maxResults, firstResult);
  }

  private List<TicketSoporte> findTicketSoporteEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(TicketSoporte.class));
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

  public TicketSoporte findTicketSoporte(Long id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(TicketSoporte.class, id);
    } finally {
      em.close();
    }
  }

  public TicketSoporte findTicketSoporteByClienteNatural(ClienteNatural usuarioFinal) {
    EntityManager em = getEntityManager();
    try {
      Query query = em.createQuery("SELECT t FROM TicketSoporte t WHERE t.clienteNatural = :usuarioFinal");
      query.setParameter("usuarioFinal", usuarioFinal);
      return (TicketSoporte) query.getSingleResult();
    } finally {
      em.close();
    }
  }

  public List<TicketSoporte> findTicketSoporteListNoAsignados() {
    EntityManager em = getEntityManager();
    try {
      Query query = em.createQuery(
        "SELECT t FROM TicketSoporte t WHERE t.usuario IS NULL AND t.estado = 'Activo'"
      );
      return (List<TicketSoporte>) query.getResultList();
    } finally {
      em.close();
    }
  }

  public int getTicketSoporteCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<TicketSoporte> rt = cq.from(TicketSoporte.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }

}
