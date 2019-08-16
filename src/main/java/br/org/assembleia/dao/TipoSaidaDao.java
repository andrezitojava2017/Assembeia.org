/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.dao;

import br.org.assembleia.conexao.ConexaoJpa;
import br.org.assembleia.model.TipoSaidasModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class TipoSaidaDao {
    
    private EntityManager entityManager;
    private EntityManagerFactory managerFactory;
    
    /**
     * Realiza a inserção de registro do TIPO SAIDAS
     * @param model
     * @return int
     */
    public int insertTipoSaida(TipoSaidasModel model){
        
        try {
            
            managerFactory = new ConexaoJpa().getConexao("assembleia");
            entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(model);
            entityManager.getTransaction().commit();
            
            return 0;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir novo registro\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            entityManager.close();
            managerFactory.close();
        }
        
        return 1;
    }
    
}
