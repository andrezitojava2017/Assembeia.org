/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.dao;

import br.org.assembleia.conexao.ConexaoJpa;
import br.org.assembleia.model.ReciboModel;
import br.org.assembleia.model.SaidasModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class Recibo_Dao {

    private EntityManagerFactory managerFactory;
    private EntityManager EntityManager;

    /**
     * Recupera o ultimo ID do recibo gerado na base de dados
     *
     * @return int ultimoRecibo
     */
    public ReciboModel recuperarUlitmoIdRecibo() {

        ReciboModel recibo = null;

        try {
            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            Query query = EntityManager.createQuery("select rcb from ReciboModel as rcb order by id desc");

            // recuepera somente um unico registro da tabela, e retornar uma lista
            recibo = (ReciboModel) query.setMaxResults(1).getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar recuperar o ultimo recibo\n" + e, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {

            EntityManager.close();
            managerFactory.close();

        }
        return recibo;
    }

    /**
     * Faz a inserção de novo recibo para um registro de entrada/saida
     *
     * @param novo
     * @return
     */
    public ReciboModel inserirNovoRecibo(ReciboModel novo) {

        ReciboModel recibo = null;
        managerFactory = new ConexaoJpa().getConexao("assembleia");
        EntityManager = managerFactory.createEntityManager();

        try {

            EntityManager.getTransaction().begin();
            EntityManager.persist(novo);
            EntityManager.getTransaction().commit();

            // apos inserção, iremos recuperar os dados do recibo
            recibo = new ReciboModel();
            recibo.setAnoRecibo(novo.getAnoRecibo());
            recibo.setIdRecibo(novo.getIdRecibo());
            recibo.setSequencia(novo.getSequencia());

        } catch (Exception e) {
            EntityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error ao tentar inserir registro de recibo\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            EntityManager.close();
            managerFactory.close();
        }

        return recibo;
    }

    
    /**
     * Recupera dados de um determinado recibo
     * @param identificador
     * @return ReciboModel
     */
    public ReciboModel getRecibo(int identificador) {

        ReciboModel recibo = new ReciboModel();

        try {
            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            recibo = EntityManager.find(ReciboModel.class, identificador);

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ao tentar recuperar registro de recibo\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            EntityManager.close();
            managerFactory.close();
        }
        
        return recibo;
    }

}
