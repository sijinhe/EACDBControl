/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eac.db.dao;

import com.eac.db.entity.Server;
import com.eac.db.entity.ServerHasContainer;
import com.eac.db.entity.ServerHasContainerPK;
import com.eac.db.manager.DBManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Sijin
 */
public class ServerDAO extends DBManager {

    public ServerDAO() {
        super();

    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Server fetch(Server input) {

        Server server = null;

        try {
            em = emf.createEntityManager();
            server = em.find(Server.class, input.getIdServer());

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return server;
        }
    }

    public List<Server> fetchServers() {

        List<Server> results = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery("from Server");
            results = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return results;
        }
    }

    public List<Server> fetchServersByClusterId(String clusterid) {

        List<Server> results = null;
        try {
            em = getEntityManager();
            Query query = em.createQuery("FROM Server where cluster_idCluster='" + clusterid + "'");
            results = query.getResultList();
            em.clear();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            em.close();
            return results;

        }
    }

    public boolean modify(Server input) {

        boolean isModify = false;

        try {
            em = getEntityManager();
            Server cat = em.find(Server.class, input.getIdServer());
            cat.setIp(input.getIp());
            cat.setPort(input.getPort());
            cat.setServerHasContainerCollection(input.getServerHasContainerCollection());
            cat.setStatus(input.getStatus());
            cat.setType(input.getType());

            EntityTransaction et = em.getTransaction();
            et.begin();

            em.persist(cat);

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

    public boolean createServerContainerRelation(String serverId, String containerId) {

        boolean isCreate = false;

        try {
            em = getEntityManager();
            ServerHasContainerPK spk = new ServerHasContainerPK(serverId, containerId);

            ServerHasContainer shc = new ServerHasContainer(spk);

            EntityTransaction et = em.getTransaction();

            et.begin();

            em.persist(shc);

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

    public boolean deleteServerContainerRelation(ServerHasContainerPK input) {

        boolean isDelete = false;
        try {
            em = getEntityManager();
            ServerHasContainer shc = (ServerHasContainer) em.find(ServerHasContainer.class, input);
            EntityTransaction et = em.getTransaction();
            et.begin();

            em.remove(shc);

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

    public List<ServerHasContainer> fetchServersContainerRelation() {

        List<ServerHasContainer> results = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery("from ServerHasContainer");
            results = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return results;
        }
    }


    public List<ServerHasContainer> fetchServersContainerRelationByContainerId(String id) {

        List<ServerHasContainer> results = null;
        try {
            em = getEntityManager();
            Query query = em.createQuery("FROM ServerHasContainer where container_idContainer='" + id + "'");
            results = query.getResultList();
            em.clear();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            em.close();
            return results;

        }
    }

    public boolean create(Server input) {

        boolean isCreate = false;

        try {
            em = getEntityManager();
            Server server = input;
            EntityTransaction et = em.getTransaction();
            et.begin();

            em.persist(server);

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

    public boolean delete(Server input) {

        boolean isDelete = false;
        try {
            em = getEntityManager();
            Server server = (Server) em.find(Server.class, input.getIdServer());
            EntityTransaction et = em.getTransaction();
            et.begin();

            em.remove(server);

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
