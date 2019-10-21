/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.dao;

import br.org.assembleia.conexao.ConexaoDB;
import br.org.assembleia.conexao.ConexaoJpa;
import br.org.assembleia.model.SaidasModel;
import br.org.assembleia.model.SolicitacaoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class SolicitacaoDao {

    private EntityManagerFactory managerFactory;
    private EntityManager EntityManager;

    /**
     * Grava valores referete a nova solicitação
     *
     * @param solicitacao
     * @return
     */
    public SolicitacaoModel gerarSolicitacao(SolicitacaoModel solicitacao) {

        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            EntityManager.getTransaction().begin();
            EntityManager.persist(solicitacao);
            EntityManager.getTransaction().commit();

            return solicitacao;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gravar NOVA SOLICITAÇÃO\n" + e);
        } finally {
            EntityManager.close();
            managerFactory.close();
        }

        return null;
    }

    /**
     * Recupera a ultima solicitação salva no base de dados
     *
     * @return SolicitacaoModel
     */
    public SolicitacaoModel getUltimaSolicitacao() {

        SolicitacaoModel solicitacao = null;

        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            Query query = EntityManager.createQuery("select sl from SolicitacaoModel as sl order by id desc");
            solicitacao = (SolicitacaoModel) query.setMaxResults(1).getSingleResult();

            return solicitacao;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gravar NOVA SOLICITAÇÃO\n" + e);
        } finally {
            EntityManager.close();
            managerFactory.close();
        }

        return null;
    }

    /**
     * Recupera dados de uma solicitacao da base de dados
     *
     * @param identificador
     * @return SolicitacaoModel
     */
    public SolicitacaoModel getSolicitacao(int identificador) {

        SolicitacaoModel solicitacao = null;

        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            Query query = EntityManager.createQuery("SELECT sl FROM SolicitacaoModel sl where sl.idSaida='" + identificador + "'", SolicitacaoModel.class);
            solicitacao = (SolicitacaoModel) query.getSingleResult();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar recuperar dados da solicitação\n" + e);
        } finally {
            EntityManager.close();
            managerFactory.close();
        }

        return solicitacao;
    }

    /**
     * Deleta registro de solicitacao
     *
     * @param solicitacao
     * @return
     */
    public int deleteSolicitacao(SolicitacaoModel solicitacao) {

        int retorno = 0;

        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            EntityManager.getTransaction().begin();
            EntityManager.merge(solicitacao);
            EntityManager.getTransaction().commit();
            retorno = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar deletar SOLICITAÇÃO vinculada a registro de saida\n" + e);
        } finally {
            EntityManager.close();
            managerFactory.close();
        }

        return retorno;

    }

    /**
     * Recupera uma lista de solicitações gravadas na base
     *
     * @param competencia
     * @return List<SolicitacaoModel>
     */
    public List<SolicitacaoModel> getListaSolicitacao(String competencia) {

        List<SolicitacaoModel> lista = null;

        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            Query query = EntityManager.createQuery("SELECT sl FROM SolicitacaoModel sl where sl.competencia='" + competencia + "'", SolicitacaoModel.class);
            lista = query.getResultList();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar recuperar lista de solicitação\n" + e);
        } finally {
            EntityManager.close();
            managerFactory.close();
        }

        return lista;
    }

//    public List<SolicitacaoModel> getListaSolicitacaoDetalhada(String competencia) {
//
//        List<SolicitacaoModel> lista = new ArrayList<>();
//
//        String sql = "select sl.id, sl.competencia, sl.numero, sl.situacao, sl.id_saida "
//                + "from tbl_solicitacao as sl "
//                + "where sl.competencia ='" + competencia + "'";
//        
//        Connection con;
//        PreparedStatement stm;
//        ResultSet rs;
//
//        try {
//
//            con = new ConexaoDB().getconection();
//            stm = con.prepareStatement(sql);
//            rs = stm.executeQuery();
//            
//            
//            while(rs.next()){
//                
//                SolicitacaoModel sl = new SolicitacaoModel();
//                
//                sl.setIdentificador(rs.getInt("id"));
//                sl.setCompetencia(rs.getString("competencia"));
//                sl.setSequencia(rs.getInt("numero"));
//                sl.setSituacao(rs.getString("situacao"));
//                sl.setIdSaida(rs.getInt("id_saida"));
//                
//                lista.add(sl);
//            }
//
//        } catch (Exception e) {
//        }
//        return lista;
//    }
}
