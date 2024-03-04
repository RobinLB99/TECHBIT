package com.landv.techbit.persistence;

import com.landv.techbit.models.ClienteEmpresa;
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
public class ClienteEmpresaJpaController implements Serializable {

    public ClienteEmpresaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ClienteEmpresa clienteEmpresa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(clienteEmpresa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ClienteEmpresa clienteEmpresa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            clienteEmpresa = em.merge(clienteEmpresa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = clienteEmpresa.getId();
                if (findClienteEmpresa(id) == null) {
                    throw new NonexistentEntityException("The clienteEmpresa with id " + id + " no longer exists.");
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
            ClienteEmpresa clienteEmpresa;
            try {
                clienteEmpresa = em.getReference(ClienteEmpresa.class, id);
                clienteEmpresa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clienteEmpresa with id " + id + " no longer exists.", enfe);
            }
            em.remove(clienteEmpresa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ClienteEmpresa> findClienteEmpresaEntities() {
        return findClienteEmpresaEntities(true, -1, -1);
    }

    public List<ClienteEmpresa> findClienteEmpresaEntities(int maxResults, int firstResult) {
        return findClienteEmpresaEntities(false, maxResults, firstResult);
    }

    private List<ClienteEmpresa> findClienteEmpresaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ClienteEmpresa.class));
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

    public ClienteEmpresa findClienteEmpresa(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ClienteEmpresa.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteEmpresaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ClienteEmpresa> rt = cq.from(ClienteEmpresa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
