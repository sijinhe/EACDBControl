/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eac.db.dao;

import com.eac.db.entity.History;
import com.eac.db.manager.DBManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Sijin
 */
public class HistoryDAO extends DBManager{

    public HistoryDAO(){
        super();
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public History fetch(History input) {

        History cluster = null;
        try {
            em = getEntityManager();
            cluster = em.find(History.class, input.getIdhistory());

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return cluster;
        }
    }

    public List<History> fetchHistory() {
        List<History> results = null;
        try {
            em = getEntityManager();
            Query query = em.createQuery("from History");
            results = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return results;
        }
    }

    public boolean modify(History input) {

        boolean isModify = false;

        try {
            em = getEntityManager();
            History history = em.find(History.class, input.getIdhistory());
            history.setCpuTimeSum(input.getCpuTimeSum());
            history.setDurationsSquareSum(input.getDurationsSquareSum());
            history.setDurationsSum(input.getDurationsSum());
            history.setHits(input.getHits());
            history.setIdhistory(input.getIdhistory());
            history.setResponseSizesSum(input.getResponseSizesSum());
            history.setSystemErrors(input.getSystemErrors());
            history.setTimestamp(input.getTimestamp());
            history.setIdContainer(input.getIdContainer());
            history.setIdServer(input.getIdServer());
            history.setMaxmemory(input.getMaxmemory());
            history.setUsedmemory(input.getUsedmemory());

            EntityTransaction et = em.getTransaction();
            et.begin();

            em.persist(history);

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

    public boolean create(History input) {

        boolean isCreate = false;

        try {
            em = getEntityManager();
            History cluster = input;
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

    public boolean delete(History input) {

        boolean isDelete = false;
        try {
            em = getEntityManager();
            History cluster = (History) em.find(History.class, input.getIdhistory());
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

    public List<History> getHistoryList(String containerid) {

        List<History> results = null;
        try {
            em = getEntityManager();
            Query query = em.createQuery("FROM History where idcontainer='" + containerid + "'");
            results = query.getResultList();
            em.clear();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return results;
        }

    }


    public static void main(String[] args){
        HistoryDAO hdao = new HistoryDAO();

        List<History> list = hdao.getHistoryList("61e87356-a151-491c-9a0f-f887a810d28d");
        System.out.println(list.size());

    }
    
}
