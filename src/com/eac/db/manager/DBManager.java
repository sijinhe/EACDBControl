/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eac.db.manager;

import com.eac.db.dao.ContainerDAO;
import java.util.HashMap;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Sijin
 */
public class DBManager {

    public static EntityManagerFactory emf;
    public EntityManager em;

    public DBManager() {

        try {
            HashMap<String, String> map = new HashMap();

            if (emf == null) {
                map.put("hibernate.connection.username", "sijin");
                map.put("hibernate.connection.password", "sijinsijin");
                emf = javax.persistence.Persistence.createEntityManagerFactory("EACDBControlPU", map);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public DBManager(String DBURL, String DBUser, String DBpwd) {

        try {
            HashMap<String, String> map = new HashMap();
            map.put("hibernate.connection.url", DBURL);
            map.put("hibernate.connection.username", DBUser);
            map.put("hibernate.connection.password", DBpwd);
            if (emf == null) {
                emf = javax.persistence.Persistence.createEntityManagerFactory("EACDBControlPU", map);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws NamingException {


        ContainerDAO cdao = new ContainerDAO();

        cdao.fetchEACsByLogin("sijinsiin");

    }
}
