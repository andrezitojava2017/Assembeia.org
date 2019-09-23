/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.dao;

import br.org.assembleia.conexao.ConexaoJpa;
import br.org.assembleia.model.DizimoModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class DizimoDao {

    private EntityManager entityManager = null;
    private EntityManagerFactory managerFactory = null;

    /**
     * Insert de registro na tabela especifica de DIZIMOS
     *
     * @param registro
     * @return DizimoModel
     */
    public DizimoModel insertRegistroDizimo(DizimoModel registro) {

        try {
            managerFactory = new ConexaoJpa().getConexao("assembleia");
            entityManager = managerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(registro);
            entityManager.getTransaction().commit();
//            System.out.println("ID OBJETO CRIADO: " + registro.getIdentificador());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir registro de Dizimo\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            entityManager.close();
            managerFactory.close();
        }

        return registro;

    }

    /**
     * Recupera uma lista de registros referente a tabela de dizimo
     * por competencia
     * @param competencia
     * @return List<DizimoModel>
     */
    public List<DizimoModel> getListaDizimos(String competencia) {

        List<DizimoModel> lista = null;

        try {
            managerFactory = new ConexaoJpa().getConexao("assembleia");
            entityManager = managerFactory.createEntityManager();
            Query query = entityManager.createQuery("SELECT dz from DizimoModel dz where dz.competencia='" + competencia + "' AND dz.situacao='A'", DizimoModel.class);
            lista = query.getResultList();

        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Erro na tentativa de recuperar os registros da competencia informada!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            entityManager.close();
            managerFactory.close();
        }

        return lista;
    }
    
    /**
     * Atualiza registro de dizimo
     * @param registro 
     */
    public void updateRegistroDizimo(DizimoModel registro){
        
         try {
            managerFactory = new ConexaoJpa().getConexao("assembleia");
            entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(registro);
            entityManager.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Registro atualizado com sucesso!!");
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Erro na tentativa de atualizar os registro informado!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            entityManager.close();
            managerFactory.close();
        }
        
    }

}
