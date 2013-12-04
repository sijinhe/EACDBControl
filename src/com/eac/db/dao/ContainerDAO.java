/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eac.db.dao;

import com.eac.db.entity.Container;
import com.eac.db.manager.DBManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Sijin
 */
public class ContainerDAO extends DBManager {

    public ContainerDAO() {
        super();

    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean checkContainerName(String containerName) {

        boolean isExist = false;

        try {
            em = getEntityManager();

            Query query = em.createQuery("FROM Container where containerName='" + containerName + "'");
            List<Container> containerList = query.getResultList();

           // em.flush();
            em.clear();


            if (!containerList.isEmpty()) {

                isExist = true;
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return isExist;
        }
    }

    public boolean checkdbName(String name) {

        boolean isExist = false;

        try {
            em = getEntityManager();

            Query query = em.createQuery("FROM Container where dbPassword='" + name + "'");
            List<Container> containerList = query.getResultList();

         //   em.flush();
            em.clear();


            if (!containerList.isEmpty()) {

                isExist = true;
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return isExist;
        }
    }

    public Container fetch(Container input) {

        Container container = null;

        try {
            em = getEntityManager();
            container = em.find(Container.class, input.getIdContainer());

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            em.close();
            return container;
        }
    }

    public List<Container> fetchContainers() {

        List<Container> results = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery("from Container");
            results = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return results;
        }
    }

    public List<Container> fetchEACsByLogin(String login) {

        List<Container> results = null;
        try {
            em = getEntityManager();
            Query query = em.createQuery("FROM Container where login='" + login + "'");
            results = query.getResultList();
            em.clear();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return results;
        }
    }

    public boolean modify(Container input) {

        boolean isModify = false;

        try {
            em = getEntityManager();
            Container container = em.find(Container.class, input.getIdContainer());
            container.setAppName(input.getAppName());
            container.setAppStatus(input.getAppStatus());
            container.setContainerName(input.getContainerName());
            container.setDbName(input.getDbName());
            container.setDbStatus(input.getDbStatus());
            container.setInstanceNo(input.getInstanceNo());
            container.setHitRate(input.getHitRate());
            container.setLogin(input.getLogin());
            container.setMaxConnection(input.getMaxConnection());
            container.setUpload(input.getUpload());
            container.setCluster(input.getCluster());
            container.setStorage(input.getStorage());
            container.setDbPassword(input.getDbPassword());

            EntityTransaction et = em.getTransaction();
            et.begin();

            em.persist(container);

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

    public boolean create(Container input) {

        boolean isCreate = false;

        try {
            em = getEntityManager();
            Container container = input;
            EntityTransaction et = em.getTransaction();
            et.begin();

            em.persist(container);

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

    public boolean delete(Container input) {

        boolean isDelete =false;

        try {
            em = getEntityManager();
            Container container = (Container) em.find(Container.class, input.getIdContainer());
            EntityTransaction et = em.getTransaction();
            et.begin();

            em.remove(container);

            em.flush();

            et.commit();
            em.clear();
            isDelete = true;
            
        } catch (Exception e) {
            e.printStackTrace();
          
        } finally {

            em.close();
            return isDelete;
        }
    }
}
