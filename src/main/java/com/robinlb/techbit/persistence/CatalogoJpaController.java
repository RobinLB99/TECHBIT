package com.robinlb.techbit.persistence;

import com.robinlb.techbit.model.Catalogo;
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
public class CatalogoJpaController implements Serializable {

  public CatalogoJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(Catalogo catalogo) {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(catalogo);
      em.getTransaction().commit();
    }
    finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(Catalogo catalogo) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      catalogo = em.merge(catalogo);
      em.getTransaction().commit();
    }
    catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        Long id = catalogo.getCatalogoId();
        if (findCatalogo(id) == null) {
          throw new NonexistentEntityException("The catalogo with id " + id + " no longer exists.");
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
      Catalogo catalogo;
      try {
        catalogo = em.getReference(Catalogo.class, id);
        catalogo.getCatalogoId();
      }
      catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The catalogo with id " + id + " no longer exists.", enfe);
      }
      em.remove(catalogo);
      em.getTransaction().commit();
    }
    finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<Catalogo> findCatalogoEntities() {
    return findCatalogoEntities(true, -1, -1);
  }

  public List<Catalogo> findCatalogoEntities(int maxResults, int firstResult) {
    return findCatalogoEntities(false, maxResults, firstResult);
  }

  private List<Catalogo> findCatalogoEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Catalogo.class));
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

  public Catalogo findCatalogo(Long id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(Catalogo.class, id);
    }
    finally {
      em.close();
    }
  }

  public int getCatalogoCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Catalogo> rt = cq.from(Catalogo.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    }
    finally {
      em.close();
    }
  }
  
}
