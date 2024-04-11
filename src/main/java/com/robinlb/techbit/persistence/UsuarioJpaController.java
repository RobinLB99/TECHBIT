package com.robinlb.techbit.persistence;

import com.robinlb.techbit.model.Usuario;
import com.robinlb.techbit.persistence.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Robin
 */
public class UsuarioJpaController implements Serializable {

  public UsuarioJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(Usuario usuario) {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(usuario);
      em.getTransaction().commit();
    }
    finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      usuario = em.merge(usuario);
      em.getTransaction().commit();
    }
    catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        Long id = usuario.getUsuarioId();
        if (findUsuario(id) == null) {
          throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
      Usuario usuario;
      try {
        usuario = em.getReference(Usuario.class, id);
        usuario.getUsuarioId();
      }
      catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
      }
      em.remove(usuario);
      em.getTransaction().commit();
    }
    finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<Usuario> findUsuarioEntities() {
    return findUsuarioEntities(true, -1, -1);
  }

  public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
    return findUsuarioEntities(false, maxResults, firstResult);
  }

  private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Usuario.class));
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

  public Usuario findUsuario(Long id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(Usuario.class, id);
    }
    finally {
      em.close();
    }
  }

  public Usuario findUsuarioForUsername(String username) {
    EntityManager em = getEntityManager();
    try {
      TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :username", Usuario.class);
      query.setParameter("username", username);
      return query.getSingleResult();
    }
    finally {
      em.close();
    }
  }
  
  public Usuario findUsuarioClienteNaturalForUsername(String username) {
    EntityManager em = getEntityManager();
    try {
      TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :username AND u.clienteNatural IS NOT NULL", Usuario.class);
      query.setParameter("username", username);
      return query.getSingleResult();
    }
    finally {
      em.close();
    }
  }

  public int getUsuarioCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Usuario> rt = cq.from(Usuario.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    }
    finally {
      em.close();
    }
  }

  public Long getUserCount() {
    EntityManager em = getEntityManager();
    Long count = 0L;

    try {
      em.getTransaction().begin();

      Query query = em.createQuery("SELECT COUNT(u) FROM Usuario u");
      count = (Long) query.getSingleResult();

      em.getTransaction().commit();
    }
    catch (Exception ex) {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      ex.printStackTrace();
    }
    finally {
      em.close();
    }

    return count;
  }
  
  public Long getUserClientCount() {
    EntityManager em = getEntityManager();
    Long count = 0L;

    try {
      em.getTransaction().begin();

      Query query = em.createQuery("SELECT COUNT(u) FROM Usuario u WHERE Usuario u.clienteNatural != null");
      count = (Long) query.getSingleResult();

      em.getTransaction().commit();
    }
    catch (Exception ex) {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      ex.printStackTrace();
    }
    finally {
      em.close();
    }

    return count;
  }

}
