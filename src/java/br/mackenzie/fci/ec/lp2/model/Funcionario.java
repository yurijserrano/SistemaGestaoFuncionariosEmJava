/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Serrano
 */
@Entity
@Table(schema="EMPRESA")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private Long id_funcionario;
    private String nome;
    @JoinColumn(name="id_cargo")
    private Cargo cargo;

    public Funcionario() {
    }

    public Funcionario(Long codigo, String nome, Cargo cargo) {
        this.id_funcionario = codigo;
        this.nome = nome;
        this.cargo = cargo;
    }

    public Long getCodigo() {
        return id_funcionario;
    }

    public void setCodigo(Long codigo) {
        this.id_funcionario = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
