/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.dao;


import br.mackenzie.fci.ec.lp2.model.Cargo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Serrano
 */

public class CargoDAO implements GenericDAO<Cargo> {

    private Cargo cargo = new Cargo();
    @PersistenceContext 
    private EntityManager entityManager;
    List list;

    public EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManager = EntityManagerUtil.getInstance().createEntityManager();
        }

        return entityManager;
    }

    public void inserir(Cargo cargo) {

        EntityTransaction transacao = getEntityManager().getTransaction();
        transacao.begin();
        getEntityManager().persist(cargo);
        transacao.commit();
        newInstance();
        list = null;

        /* EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmpresaJPAPU");
         EntityManager em = factory.createEntityManager();
         em.getTransaction().begin();
         em.persist(cargo);
         em.getTransaction().commit();
         em.close();
         factory.close();
         */
    }

    public void atualizar(Cargo cargo) {

        EntityTransaction transacao = getEntityManager().getTransaction();
        transacao.begin();
        getEntityManager().merge(cargo);
        transacao.commit();
        newInstance();

    }

    public void remover(Cargo cargo) {

        EntityTransaction transacao = getEntityManager().getTransaction();
        transacao.begin();
        getEntityManager().remove(cargo);
        transacao.commit();
        newInstance();
        list = null;

        /*
         EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmpresaJPAPU");
         EntityManager em = factory.createEntityManager();
         em.getTransaction().begin();
         em.remove(cargo);
         em.getTransaction().commit();
         em.close();
         factory.close();
         */
    }

    public List<Cargo> listar() {

        List<Cargo> cargos = new ArrayList<>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmpresaJPAPU");
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        cargos = em.createQuery("SELECT * FROM Cargo").getResultList();
        
        if (list == null) {
            list = getEntityManager().createQuery("SELECT * FROM Cargo").getResultList();
            
        }
        em.close();
        return list;
    }

    public Cargo listarPorId(Cargo cargo) {

        if (cargo.getId_cargo() != null) {
            cargo = getEntityManager().find(Cargo.class, cargo.getId_cargo());
        }

        return cargo;

    }

    public void newInstance() {
        cargo = new Cargo();
    }

}
