package com.robinlb.techbit.persistence;

import com.robinlb.techbit.model.ArchivoAdjunto;
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
public class ArchivoAdjuntoJpaController implements Serializable {

  public ArchivoAdjuntoJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(ArchivoAdjunto archivoAdjunto) {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(archivoAdjunto);
      em.getTransaction().commit();
    }
    finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(ArchivoAdjunto archivoAdjunto) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      archivoAdjunto = em.merge(archivoAdjunto);
      em.getTransaction().commit();
    }
    catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        Long id = archivoAdjunto.getFilesId();
        if (findArchivoAdjunto(id) == null) {
          throw new NonexistentEntityException("The archivoAdjunto with id " + id + " no longer exists.");
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
      ArchivoAdjunto archivoAdjunto;
      try {
        archivoAdjunto = em.getReference(ArchivoAdjunto.class, id);
        archivoAdjunto.getFilesId();
      }
      catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The archivoAdjunto with id " + id + " no longer exists.", enfe);
      }
      em.remove(archivoAdjunto);
      em.getTransaction().commit();
    }
    finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<ArchivoAdjunto> findArchivoAdjuntoEntities() {
    return findArchivoAdjuntoEntities(true, -1, -1);
  }

  public List<ArchivoAdjunto> findArchivoAdjuntoEntities(int maxResults, int firstResult) {
    return findArchivoAdjuntoEntities(false, maxResults, firstResult);
  }

  private List<ArchivoAdjunto> findArchivoAdjuntoEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(ArchivoAdjunto.class));
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

  public ArchivoAdjunto findArchivoAdjunto(Long id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(ArchivoAdjunto.class, id);
    }
    finally {
      em.close();
    }
  }

  public int getArchivoAdjuntoCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<ArchivoAdjunto> rt = cq.from(ArchivoAdjunto.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    }
    finally {
      em.close();
    }
  }
  
}
