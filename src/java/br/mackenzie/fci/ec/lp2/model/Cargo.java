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
import javax.persistence.Table;

/**
 *
 * @author Serrano
 */
@Entity
@Table(schema="EMPRESA")
public class Cargo implements Serializable {

    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private Long id_cargo;
    private String nome;

    public Cargo() {
    }

   

    public Cargo(Long codigo, String nome) {
        this.id_cargo = codigo;
        this.nome = nome;
    }
    
    public Cargo(Long codigo)
    {
        this.id_cargo =codigo;
    }

   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Long id_cargo) {
        this.id_cargo = id_cargo;
    }

   
}
