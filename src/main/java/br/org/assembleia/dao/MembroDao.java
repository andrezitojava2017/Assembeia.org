/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.dao;

import br.org.assembleia.conexao.ConexaoDB;
import br.org.assembleia.conexao.ConexaoJpa;
import br.org.assembleia.model.MembroModel;
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
    public int insertMembro(MembroModel model) {

        int ret = 0;
        String sql = "INSERT INTO assembleia.tbl_membro (data_admissao,id_cargo, id_pessoa) VALUES (?,?,?)";
        Connection con = null;
        PreparedStatement stm = null;

        try {

            con = new ConexaoDB().getconection();
            stm = con.prepareCall(sql);

            stm.setString(1, model.getDataPosse());
            stm.setInt(2, model.getIdCargo());
            stm.setInt(3, model.getId_pessoa());

            return ret = stm.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar dados do novo membro\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            ConexaoDB.fecharConexao(con, stm);

        }
        return ret;
    }

    /**
     * Recupera lista de membros ativos
     *
     * @return List<MembroModel>
     */
    public List<MembroModel> getListaMembro() {

        List<MembroModel> lista = new ArrayList<>();

        //String sql = "select data_admissao, data_demissao, id_cargo, nome_cargo, id_pessoa, nome from assembleia.tbl_membro";
        String sql = "select tbl_membro.id, tbl_membro.id_pessoa, tbl_membro.data_admissao, tbl_membro.id_cargo, tbl_pessoas.nome, tbl_pessoas.cpf from tbl_membro "
                + "inner join tbl_pessoas "
                + "on tbl_pessoas.id = tbl_membro.id_pessoa where(tbl_membro.situacao='A')";

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {

            con = new ConexaoDB().getconection();
            stm = con.prepareStatement(sql);

            rs = stm.executeQuery();

            while (rs.next()) {

                MembroModel membro = new MembroModel();
                membro.setId(rs.getInt("id"));
                membro.setDataPosse(rs.getString("data_admissao"));
//                membro.setDataDemissao(rs.getString("data_demissao"));
                membro.setIdCargo(rs.getInt("id_cargo"));
                membro.setId_pessoa(rs.getInt("id_pessoa"));
                membro.setNome(rs.getString("nome"));
                membro.setCpf(rs.getString("cpf"));

                lista.add(membro);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar recuperar lista de membros\n" + e, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            ConexaoDB.fecharConexao(con, stm);
        }
        return lista;
    }

    /**
     * Recupera informações de um determinado membro
     *
     * @param idMembro
     * @return MembroModel
     */
    public MembroModel getMembro(int idMembro) {
        MembroModel membro = null;
        try {
            managerFactory = new ConexaoJpa().getConexao("assembleia");
            entityManager = managerFactory.createEntityManager();
            membro = entityManager.find(MembroModel.class, idMembro);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar recuperar lista de membros\n" + e, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            entityManager.close();
            managerFactory.close();
        }
        return membro;
    }

    /**
     * Desativa um cadastro de membro
     *
     * @param membro
     */
    public int desativarMembro(MembroModel membro) {

        String sql = "UPDATE assembleia.tbl_membro SET data_admissao = ?, data_demissao=?, id_cargo=?, id_pessoa=?, situacao=? WHERE (id ='" + membro.getId() + "')";
        int retorno = 0;
        Connection con = null;
        PreparedStatement stm = null;

        try {

            con = ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            stm.setString(1, membro.getDataPosse());
            stm.setString(2, membro.getDataDemissao());
            stm.setInt(3, membro.getIdCargo());
            stm.setInt(4, membro.getId_pessoa());
            stm.setString(5, membro.getSituacao());
            retorno = stm.executeUpdate();
            System.out.println(retorno);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar desativar membro selecionado\n" + e, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            ConexaoDB.fecharConexao(con, stm);
        }
        return retorno;
    }

    /**
     * Atualizada um cadastro de membro
     *
     * @param membro
     */
    public int updateMembro(MembroModel membro) {

        String sql = "UPDATE assembleia.tbl_membro SET data_admissao = ?, id_cargo=?, id_pessoa=?, situacao=? WHERE (id ='" + membro.getId() + "')";
        int retorno = 0;
        Connection con = null;
        PreparedStatement stm = null;

        try {

            con = ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            stm.setString(1, membro.getDataPosse());
            stm.setInt(2, membro.getIdCargo());
            stm.setInt(3, membro.getId_pessoa());
            stm.setString(4, membro.getSituacao());
            retorno = stm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar membro selecionado\n" + e, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            ConexaoDB.fecharConexao(con, stm);
        }
        return retorno;
    }

}
