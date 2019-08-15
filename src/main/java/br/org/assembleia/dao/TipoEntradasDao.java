/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.dao;

import br.org.assembleia.conexao.ConexaoDB;
import br.org.assembleia.conexao.ConexaoJpa;
import br.org.assembleia.model.TipoEntradaModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class TipoEntradasDao {

    private EntityManager entityManager;
    private EntityManagerFactory managerFactory;

    
    /**
     * Recupera uma lista de TIPOS de ENTRADAS cadastradas
     * @return List<TipoEntradaModel>
     */
    public List<TipoEntradaModel> getListaTipos() {
        
        List<TipoEntradaModel> getLista = null;
        
        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            entityManager = managerFactory.createEntityManager();
            Query query = entityManager.createQuery("from tp TipoEntradaModel tp", TipoEntradaModel.class);
            getLista = query.getResultList();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de recuperar os TIPOS de Registros\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            entityManager.close();
            managerFactory.close();
        }

        return getLista;
    }

}
