/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eac.db.dao;

import com.eac.db.entity.Server;
import com.eac.db.entity.Storage;
import com.eac.db.manager.DBManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Sijin
 */
public class StorageDAO extends DBManager {

    public StorageDAO() {
        super();

    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Storage fetch(Storage input) {

        Storage store = null;

        try {
            em = emf.createEntityManager();
            store = em.find(Storage.class, input.getIdStorage());

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return store;
        }
    }

    public List<Storage> fetchRunningMySQLNode() {

        List<Storage> results = null;
        try {
            em = getEntityManager();
            Query query = em.createQuery("FROM Storage where type='MYSQL_NODE' AND status='RUNNING'");
            results = query.getResultList();
            em.clear();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return results;
        }
    }

    public List<Storage> fetchStorages() {

        List<Storage> results = null;

        try {
            em = emf.createEntityManager();
            Query query = em.createQuery("from Storage");
            results = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return results;
        }
    }

    public boolean modify(Storage input) {

        boolean isModify = false;

        try {
            em = getEntityManager();
            Storage store = em.find(Storage.class, input.getIdStorage());
            store.setIdStorage(input.getIdStorage());
            store.setPrivateIp(input.getPrivateIp());
            store.setPrivatePort(input.getPrivatePort());
            store.setPublicIp(input.getPublicIp());
            store.setPublicPort(input.getPublicPort());
            store.setStatus(input.getStatus());
            store.setType(input.getType());

            EntityTransaction et = em.getTransaction();
            et.begin();

            em.persist(store);

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

    public boolean create(Storage input) {

        boolean isCreate = false;

        try {
            em = getEntityManager();
            Storage store = input;
            EntityTransaction et = em.getTransaction();
            et.begin();

            em.persist(store);

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

    public boolean delete(Storage input) {

        boolean isDelete = false;

        try {
            em = getEntityManager();
            Storage store = (Storage) em.find(Storage.class, input.getIdStorage());
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(store);
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

    public static void main(String[] args){
        StorageDAO sdao = new StorageDAO();

        System.out.println(sdao.fetchRunningMySQLNode());
    }
}
