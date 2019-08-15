/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.dao;

import br.org.assembleia.conexao.ConexaoJpa;
import br.org.assembleia.model.SaidasModel;
import br.org.assembleia.model.TipoSaidasModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class SaidasDao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    private EntityManagerFactory managerFactory;
    private EntityManager EntityManager;

    /**
     * recupera informações de um determinado registro da tabela de saidas
     * utilizado para preencher formulario de saida para alteração
     *
     * @param id_registro
     * @return REG_SAIDAS_MODEL
     */
    public SaidasModel recuperarRegParaAlteracao(int id_registro) {

        SaidasModel saida = new SaidasModel();

        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            Query query = EntityManager.createQuery("SELECT sd FROM SaidasModel sd where sd.id='" + id_registro + "'", SaidasModel.class);
            saida = (SaidasModel) query.getSingleResult();

            return saida;

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error na tentativa de recuperar informações da tabela Saidas\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            managerFactory.close();
            EntityManager.close();
        }

        return null;
    }

    /**
     * Captura os tipos de saidas que foram cadastrados na table Saidas
     *
     * @return List<TipoSaidasModel>
     */
    public List<TipoSaidasModel> getTipoSaidas() {

        List<TipoSaidasModel> listaSaidas = new ArrayList<>();

        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            Query query = EntityManager.createQuery("FROM TipoSaidasModel tp");
            listaSaidas = query.getResultList();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar recupera a lista de tipos de saidas\n" + e);
        } finally {
            EntityManager.close();
            managerFactory.close();
        }

        return listaSaidas;
    }

    /**
     * Salva um novo registro na tabela de saidas
     *
     * @param saida
     */
    public SaidasModel gravarRegistroSaida(SaidasModel saida) {

        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();

            EntityManager.getTransaction().begin();
            EntityManager.persist(saida);
            EntityManager.getTransaction().commit();

            //System.out.println("ID: " + saida.getIdentificador());
            return saida;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de salvar lancamento de saida\n" + e, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            EntityManager.close();
            managerFactory.close();
        }
        return null;
    }

    /**
     * Recupara uma lista de saidas registradas
     *
     * @param competencia
     * @return SaidasModel
     */
    public List<SaidasModel> getListaSaidas(String competencia) {

        List<SaidasModel> saidas = new ArrayList<>();

        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            Query query = EntityManager.createQuery("SELECT sd FROM SaidasModel sd where sd.competencia='" + competencia + "' AND sd.situacao='A'", SaidasModel.class);
            saidas = query.getResultList();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de recuperar lista de saidas\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            EntityManager.close();
            managerFactory.close();

        }

        return saidas;
    }

    
    /**
     * Atualiza dados de um registro de saida
     * @param registro 
     */
    public int updateRegistroSaida(SaidasModel registro) {

        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            EntityManager.getTransaction().begin();
            EntityManager.merge(registro);
            EntityManager.getTransaction().commit();
           
            return 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de atualizar dados de saidas\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            EntityManager.close();
            managerFactory.close();

        }
        
        return 0;
    }
    
    
    /**
     * Delete registro de saida
     * @param registro
     * @return int
     */
    public int deleteRegistroSaida(SaidasModel registro){
        
        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            EntityManager.getTransaction().begin();
            EntityManager.merge(registro);
            EntityManager.getTransaction().commit();
           
            return 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de excluir dados de saidas\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            EntityManager.close();
            managerFactory.close();

        }
        return 0;        
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
