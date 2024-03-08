/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.robinlb.techbit.persistence;

import com.robinlb.techbit.model.SolucionRespuesta;
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
public class SolucionRespuestaJpaController implements Serializable {

    public SolucionRespuestaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SolucionRespuesta solucionRespuesta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(solucionRespuesta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SolucionRespuesta solucionRespuesta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            solucionRespuesta = em.merge(solucionRespuesta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = solucionRespuesta.getResSolId();
                if (findSolucionRespuesta(id) == null) {
                    throw new NonexistentEntityException("The solucionRespuesta with id " + id + " no longer exists.");
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
            SolucionRespuesta solucionRespuesta;
            try {
                solucionRespuesta = em.getReference(SolucionRespuesta.class, id);
                solucionRespuesta.getResSolId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The solucionRespuesta with id " + id + " no longer exists.", enfe);
            }
            em.remove(solucionRespuesta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SolucionRespuesta> findSolucionRespuestaEntities() {
        return findSolucionRespuestaEntities(true, -1, -1);
    }

    public List<SolucionRespuesta> findSolucionRespuestaEntities(int maxResults, int firstResult) {
        return findSolucionRespuestaEntities(false, maxResults, firstResult);
    }

    private List<SolucionRespuesta> findSolucionRespuestaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SolucionRespuesta.class));
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

    public SolucionRespuesta findSolucionRespuesta(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SolucionRespuesta.class, id);
        } finally {
            em.close();
        }
    }

    public int getSolucionRespuestaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SolucionRespuesta> rt = cq.from(SolucionRespuesta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
