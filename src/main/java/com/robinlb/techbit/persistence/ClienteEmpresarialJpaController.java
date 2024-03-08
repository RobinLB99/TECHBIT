package com.robinlb.techbit.persistence;

import com.robinlb.techbit.model.ClienteEmpresarial;
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
public class ClienteEmpresarialJpaController implements Serializable {

    public ClienteEmpresarialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ClienteEmpresarial clienteEmpresarial) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(clienteEmpresarial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ClienteEmpresarial clienteEmpresarial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            clienteEmpresarial = em.merge(clienteEmpresarial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = clienteEmpresarial.getClienteEId();
                if (findClienteEmpresarial(id) == null) {
                    throw new NonexistentEntityException("The clienteEmpresarial with id " + id + " no longer exists.");
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
            ClienteEmpresarial clienteEmpresarial;
            try {
                clienteEmpresarial = em.getReference(ClienteEmpresarial.class, id);
                clienteEmpresarial.getClienteEId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clienteEmpresarial with id " + id + " no longer exists.", enfe);
            }
            em.remove(clienteEmpresarial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ClienteEmpresarial> findClienteEmpresarialEntities() {
        return findClienteEmpresarialEntities(true, -1, -1);
    }

    public List<ClienteEmpresarial> findClienteEmpresarialEntities(int maxResults, int firstResult) {
        return findClienteEmpresarialEntities(false, maxResults, firstResult);
    }

    private List<ClienteEmpresarial> findClienteEmpresarialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ClienteEmpresarial.class));
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

    public ClienteEmpresarial findClienteEmpresarial(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ClienteEmpresarial.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteEmpresarialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ClienteEmpresarial> rt = cq.from(ClienteEmpresarial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
