/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.dao;

import br.org.assembleia.conexao.ConexaoJpa;
import br.org.assembleia.model.UsuarioModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author andre
 */
public class UsuarioDao {

    private EntityManagerFactory managerFactory;
    private EntityManager EntityManager;

    /**
     * Retorna um usuario cadastrado na base de dados
     *
     * @param model
     * @return UsuarioModel
     */
    public UsuarioModel logarUsuario(UsuarioModel model) {

        UsuarioModel getUsuario = null;

        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            Query query = EntityManager.createQuery("FROM UsuarioModel us where us.nomeUsuario='" + model.getNomeUsuario() + "' AND us.senhaUsuario='"
                    + model.getSenhaUsuario() + "'", UsuarioModel.class);
            getUsuario = (UsuarioModel) query.getSingleResult();

        } catch (Exception e) {
            
            EntityManager.close();
            managerFactory.close();
        }
        
        return getUsuario;
    }
}
