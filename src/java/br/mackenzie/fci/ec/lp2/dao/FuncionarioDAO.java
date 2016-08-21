/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.dao;


import br.mackenzie.fci.ec.lp2.model.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Serrano
 */

public class FuncionarioDAO implements GenericDAO<Funcionario> {

 


    private Funcionario funcionario = new Funcionario();
    @PersistenceContext 
    private EntityManager entityManager;
    List list;

    public EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManager = EntityManagerUtil.getInstance().createEntityManager();
        }

        return entityManager;
    }

    public void inserir(Funcionario funcionario) {

        EntityTransaction transacao = getEntityManager().getTransaction();
        transacao.begin();
        getEntityManager().persist(funcionario);
        transacao.commit();
        newInstance();
        list = null;

    }

    public void atualizar(Funcionario funcionario) {

        EntityTransaction transacao = getEntityManager().getTransaction();
        transacao.begin();
        getEntityManager().merge(funcionario);
        transacao.commit();
        newInstance();
    }

    public void remover(Funcionario funcionario) {

        EntityTransaction transacao = getEntityManager().getTransaction();
        transacao.begin();
        getEntityManager().remove(funcionario);
        transacao.commit();
        newInstance();
        list = null;

    }

    public List<Funcionario> listar() {
        if (list == null) {
            list = getEntityManager().createQuery("SELECT * FROM Funcionario").getResultList();
        }
        return list;

    }

    public Funcionario listarPorId(Funcionario funcionario) {
       
        
       if (funcionario.getCodigo() != null) {
            funcionario = getEntityManager().find(Funcionario.class, funcionario.getCodigo());
        }

        
        return funcionario;
    }

    public void newInstance() {
        funcionario = new Funcionario();
    }

}
