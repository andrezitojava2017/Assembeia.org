/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.dao;

import br.org.assembleia.conexao.ConexaoJpa;
import br.org.assembleia.model.MembroModel;
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
public class MembroDao {

    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    /**
     * Faz a inserção de um novo membro a tabela de membros
     *
     * @param model
     * @return MembroModel
     */
    public MembroModel insertMembro(MembroModel model) {

        MembroModel getMembro = null;

        try {
            managerFactory = new ConexaoJpa().getConexao("assembleia");
            entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(model);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar dados do novo membro\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
            managerFactory.close();

        }
        return getMembro;
    }

    public List<MembroModel> getListaMembro() {

        List<MembroModel> lista = new ArrayList<>();;

        try {
            managerFactory = new ConexaoJpa().getConexao("assembleia");
            entityManager = managerFactory.createEntityManager();
            Query query = entityManager.createQuery("FROM MembroModel mm", MembroModel.class);
            lista = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar recuperar lista de membros\n" + e, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
//            entityManager.close();
            //          managerFactory.close();
            System.out.println(lista.size());
        }
        return lista;
    }
}
