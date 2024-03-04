package com.landv.techbit.persistence;

import com.landv.techbit.models.ClientePersona;
import com.landv.techbit.persistence.exceptions.NonexistentEntityException;
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
public class ClientePersonaJpaController implements Serializable {

    public ClientePersonaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ClientePersona clientePersona) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(clientePersona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ClientePersona clientePersona) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            clientePersona = em.merge(clientePersona);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = clientePersona.getId();
                if (findClientePersona(id) == null) {
                    throw new NonexistentEntityException("The clientePersona with id " + id + " no longer exists.");
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
            ClientePersona clientePersona;
            try {
                clientePersona = em.getReference(ClientePersona.class, id);
                clientePersona.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clientePersona with id " + id + " no longer exists.", enfe);
            }
            em.remove(clientePersona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ClientePersona> findClientePersonaEntities() {
        return findClientePersonaEntities(true, -1, -1);
    }

    public List<ClientePersona> findClientePersonaEntities(int maxResults, int firstResult) {
        return findClientePersonaEntities(false, maxResults, firstResult);
    }

    private List<ClientePersona> findClientePersonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ClientePersona.class));
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

    public ClientePersona findClientePersona(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ClientePersona.class, id);
        } finally {
            em.close();
        }
    }

    public int getClientePersonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ClientePersona> rt = cq.from(ClientePersona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
