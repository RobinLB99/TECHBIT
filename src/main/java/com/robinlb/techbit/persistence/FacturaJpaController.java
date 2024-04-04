package com.robinlb.techbit.persistence;

import com.robinlb.techbit.model.Factura;
import com.robinlb.techbit.persistence.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author Robin
 */
public class FacturaJpaController implements Serializable {

  public FacturaJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(Factura factura) {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(factura);
      em.getTransaction().commit();
    }
    finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(Factura factura) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      factura = em.merge(factura);
      em.getTransaction().commit();
    }
    catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        Long id = factura.getFacturaId();
        if (findFactura(id) == null) {
          throw new NonexistentEntityException("The factura with id " + id + " no longer exists.");
        }
      }
      throw ex;
    }
    finally {
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
      Factura factura;
      try {
        factura = em.getReference(Factura.class, id);
        factura.getFacturaId();
      }
      catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The factura with id " + id + " no longer exists.", enfe);
      }
      em.remove(factura);
      em.getTransaction().commit();
    }
    finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<Factura> findFacturaEntities() {
    return findFacturaEntities(true, -1, -1);
  }

  public List<Factura> findFacturaEntities(int maxResults, int firstResult) {
    return findFacturaEntities(false, maxResults, firstResult);
  }

  private List<Factura> findFacturaEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Factura.class));
      Query q = em.createQuery(cq);
      if (!all) {
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
      }
      return q.getResultList();
    }
    finally {
      em.close();
    }
  }

  public Factura findFactura(Long id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(Factura.class, id);
    }
    finally {
      em.close();
    }
  }

  public int getFacturaCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Factura> rt = cq.from(Factura.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    }
    finally {
      em.close();
    }
  }
  
}
