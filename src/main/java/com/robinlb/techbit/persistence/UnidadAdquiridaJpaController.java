/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.robinlb.techbit.persistence;

import com.robinlb.techbit.model.UnidadAdquirida;
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
public class UnidadAdquiridaJpaController implements Serializable {

    public UnidadAdquiridaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UnidadAdquirida unidadAdquirida) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(unidadAdquirida);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UnidadAdquirida unidadAdquirida) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            unidadAdquirida = em.merge(unidadAdquirida);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = unidadAdquirida.getUnidadId();
                if (findUnidadAdquirida(id) == null) {
                    throw new NonexistentEntityException("The unidadAdquirida with id " + id + " no longer exists.");
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
            UnidadAdquirida unidadAdquirida;
            try {
                unidadAdquirida = em.getReference(UnidadAdquirida.class, id);
                unidadAdquirida.getUnidadId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The unidadAdquirida with id " + id + " no longer exists.", enfe);
            }
            em.remove(unidadAdquirida);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UnidadAdquirida> findUnidadAdquiridaEntities() {
        return findUnidadAdquiridaEntities(true, -1, -1);
    }

    public List<UnidadAdquirida> findUnidadAdquiridaEntities(int maxResults, int firstResult) {
        return findUnidadAdquiridaEntities(false, maxResults, firstResult);
    }

    private List<UnidadAdquirida> findUnidadAdquiridaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UnidadAdquirida.class));
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

    public UnidadAdquirida findUnidadAdquirida(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UnidadAdquirida.class, id);
        } finally {
            em.close();
        }
    }

    public int getUnidadAdquiridaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UnidadAdquirida> rt = cq.from(UnidadAdquirida.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
