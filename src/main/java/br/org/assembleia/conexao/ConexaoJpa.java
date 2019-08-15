/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.conexao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author andre
 */
public class ConexaoJpa {
    
    private static EntityManagerFactory emf;
    
    /**
     * Faz a conexao com o persistence unity configurado no XML
     * @param persistenceUnity
     * @return emf - EntityManagerFactory
     */
    public EntityManagerFactory getConexao(String persistenceUnity){
        emf = Persistence.createEntityManagerFactory(persistenceUnity);
        return emf;
    }
    
}
