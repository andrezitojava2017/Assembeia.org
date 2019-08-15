/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.dao;

import br.org.assembleia.abstratas.Pessoas;
import br.org.assembleia.conexao.ConexaoJpa;
import br.org.assembleia.model.PessoasModel;
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
public class PessoasDao extends Pessoas {

    private EntityManagerFactory managerFactory;
    private EntityManager EntityManager;

    /**
     * Recupera dados de um determinada Pessoa
     *
     * @param identificador
     * @return PessoasModel
     */
    public PessoasModel getPessoa(int identificador) {

        PessoasModel model = new PessoasModel();

        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            model = EntityManager.find(PessoasModel.class, identificador);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar recuperar dados da pessoa vinculada\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            EntityManager.close();
            managerFactory.close();
        }

        return model;

    }

    /**
     * Recupera uma lista de pessoas cadastradas
     *
     * @return List<PessoasModel>
     */
    public List<PessoasModel> getListaPessoas() {

        List<PessoasModel> lista = new ArrayList<>();

        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            Query query = EntityManager.createQuery("SELECT pm FROM PessoasModel pm where pm.situacao='A'", PessoasModel.class);
            lista = query.getResultList();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao tentar recuperar lista de pessoas\n" + e, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {

            EntityManager.close();
            managerFactory.close();
        }

        return lista;
    }

    /**
     * Modifica a coluna situacao para I- INATIVO
     * @param model
     * @return int
     */
    public int deletePessoa(PessoasModel model) {

        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            EntityManager.getTransaction().begin();
            EntityManager.merge(model);
            EntityManager.getTransaction().commit();
            
            return 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar recuperar dados da pessoa vinculada\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            EntityManager.close();
            managerFactory.close();
        }
        
        return 0;
    }
    
    /**
     * Faz a inserção de uma pessoa na base de dados
     * @param model
     * @return PessoasModel
     */
    public PessoasModel insertPessoaModel(PessoasModel model){
        
        
        try {
            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            EntityManager.getTransaction().begin();
            EntityManager.persist(model);
            EntityManager.getTransaction().commit();
            
            return model;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gravar dados desta pessoa\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally{
            
            EntityManager.close();
            managerFactory.close();
            
        }
        
        return null;
    }
    
    
    /**
     * Atualizada dados de um determinado cadastro
     * @param model
     * @return int
     */
    public int updatePessoa(PessoasModel model){
        
        try {
            
            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            EntityManager.getTransaction().begin();
            EntityManager.merge(model);
            EntityManager.getTransaction().commit();
            
            return 0;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar dados da pessoa\n" + e, "Error", JOptionPane.ERROR_MESSAGE);

        } finally{
            EntityManager.close();
            managerFactory.close();
        }
         return 1;
    }
}
