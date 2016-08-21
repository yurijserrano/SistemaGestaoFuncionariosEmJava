/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Serrano
 */
public class EntityManagerUtil {

    private static final EntityManagerUtil instance = new EntityManagerUtil();
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmpresaEJBPU");

    private EntityManagerUtil() {
    }

    public static EntityManagerUtil getInstance() {
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return factory;
    }

     public EntityManager createEntityManager() {
    return factory.createEntityManager();
  }
    
}
