/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.dao;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Serrano
 * @param <E>
 */
@Local
public interface CargoDLocal<E> {

    public void inserir(E e);

    public void atualizar(E e);

    public void remover(E e);

    public List<E> listar();
}
