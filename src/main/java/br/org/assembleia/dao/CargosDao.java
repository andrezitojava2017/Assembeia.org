/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.dao;

import br.org.assembleia.conexao.ConexaoJpa;
import br.org.assembleia.model.CargosModel;
import br.org.assembleia.model.DizimoModel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class CargosDao {

    private EntityManager entityManager = null;
    private EntityManagerFactory managerFactory = null;

    /**
     * criação de novo cargos
     * @param cargo 
     */
    public CargosModel insertCargo(CargosModel cargo) {
        
        try {
            managerFactory = new ConexaoJpa().getConexao("assembleia");
            entityManager = managerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(cargo);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir um novo cargo a tabela\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            entityManager.close();
            managerFactory.close();
        }
        
        return cargo;
    }
    
    
    /**
     * Gera uma lista com os cargos cadastrados
     * @return List<CargosModel>
     */
    public List<CargosModel> getListaCargos(){
        
        List<CargosModel>lista = new ArrayList<>();
        
          try {
            managerFactory = new ConexaoJpa().getConexao("assembleia");
            entityManager = managerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT cm from CargosModel as cm", CargosModel.class);
            lista = query.getResultList();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar recuperar lista de cargos\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            entityManager.close();
            managerFactory.close();
        }

        return lista;
        
    }
    

    
}
