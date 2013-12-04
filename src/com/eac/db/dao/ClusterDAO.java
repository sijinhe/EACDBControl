/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eac.db.dao;

import com.eac.db.entity.Cluster;
import com.eac.db.manager.DBManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Sijin
 */
public class ClusterDAO extends DBManager {

    public ClusterDAO() {
        super();

    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Cluster fetch(Cluster input) {

        Cluster cluster = null;
        try {
            em = getEntityManager();
            cluster = em.find(Cluster.class, input.getIdCluster());

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return cluster;
        }
    }

    public List<Cluster> fetchClusters() {
        List<Cluster> results = null;
        try {
            em = getEntityManager();
            Query query = em.createQuery("from Cluster");
            results = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return results;
        }
    }

    public boolean modify(Cluster input) {

        boolean isModify = false;

        try {
            em = getEntityManager();
            Cluster cluster = em.find(Cluster.class, input.getIdCluster());
            cluster.setIdCluster(input.getIdCluster());
            cluster.setPrivateIp(input.getPrivateIp());
            cluster.setPrivatePort(input.getPrivatePort());
            cluster.setPublicIp(input.getPublicIp());
            cluster.setPublicPort(input.getPublicPort());
            cluster.setStatus(input.getStatus());
            cluster.setHomePath(input.getHomePath());
            cluster.setType(input.getType());

            EntityTransaction et = em.getTransaction();
            et.begin();

            em.persist(cluster);

            em.flush();
            em.clear();
            et.commit();

            isModify = true;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return isModify;

        }

    }

    public boolean create(Cluster input) {

        boolean isCreate = false;

        try {
            em = getEntityManager();
            Cluster cluster = input;
            EntityTransaction et = em.getTransaction();
            et.begin();

            em.persist(cluster);

            em.flush();
            em.clear();
            et.commit();

            isCreate = true;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return isCreate;
        }

    }

    public boolean delete(Cluster input) {

        boolean isDelete = false;
        try {
            em = getEntityManager();
            Cluster cluster = (Cluster) em.find(Cluster.class, input.getIdCluster());
            EntityTransaction et = em.getTransaction();
            et.begin();

            em.remove(cluster);

            em.flush();
            em.clear();
            et.commit();
            isDelete = true;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return isDelete;
        }
    }
}
