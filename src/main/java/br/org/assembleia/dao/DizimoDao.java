/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.dao;

import br.org.assembleia.conexao.ConexaoJpa;
import br.org.assembleia.model.DizimoModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
     * @param registro 
     * @return  DizimoModel
     */
    public DizimoModel insertRegistroDizimo(DizimoModel registro) {

        try {
            managerFactory = new ConexaoJpa().getConexao("assembleia");
            entityManager = managerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(registro);
            entityManager.getTransaction().commit();
            System.out.println("ID OBJETO CRIADO: " + registro.getIdentificador());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir registro de Dizimo\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            entityManager.close();
            managerFactory.close();
        }
        
        return registro;

    }

}
