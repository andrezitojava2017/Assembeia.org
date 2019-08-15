/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.dao;

import br.org.assembleia.conexao.ConexaoDB;
import br.org.assembleia.abstratas.TiposModel;
import br.org.assembleia.model.TipoEntradaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class tipo_entrada_dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    /**
     * Recupera o ID de um determinado tipo de entrada
     *
     * @param tipoSelecionado
     * @return int id_tipo_entrada
     */
    public int capturarIdTipoEntrada(String tipoSelecionado) {

        int id_tipo_entrada = 0;

        try {
            String sql = "select id from assembleia.tbl_tipo_entradas"
                    + " where descricao_tipo= '" + tipoSelecionado + "'";

            con = br.org.assembleia.conexao.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                id_tipo_entrada = rs.getInt(1);
//                System.out.println(id_tipo_entrada);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de ler dados da tabela tipo de entrada\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            br.org.assembleia.conexao.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return id_tipo_entrada;
    }

    
    /**
     * Mtodo que captura a descrição de um tipo de entrada
     * utilizado para prencher formulario para alterações de registro de entrada
     * @param id_tipo_entrada
     * @return String tipo_entrada
     */
    public String capturarDescricaoTipoEntrada(int id_tipo_entrada) {

        String tipo_entrada = null;

        try {
            String sql = "select descricao_tipo from assembleia.tbl_tipo_entradas"
                    + " where id= '" + id_tipo_entrada + "'";

            con = ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                tipo_entrada = rs.getString(1);
//                System.out.println("Dao: " + tipo_entrada);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de ler dados da tabela tipo de entrada\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConexaoDB.fecharConexao(con, stm, rs);
        }

        return tipo_entrada;
    }

    /**
     * faz a inserção de novo tipo de entrada
     *
     * @param descricao
     */
    public void inserirNovoTipoEntrada(String descricao) {

        try {

            String sql = "insert into assembleia.tbl_tipo_entradas(descricao_tipo_entrada) value(?)";
            con = br.org.assembleia.conexao.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            stm.setString(1, descricao);

            int opt = stm.executeUpdate();

            if (opt != 0) {
                JOptionPane.showMessageDialog(null, "Novo tipo salvo com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de inserir novo tipo\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            br.org.assembleia.conexao.ConexaoDB.fecharConexao(con, stm);
        }
    }
    
    
    /**
     * Recupera uma lista de tpos cadastrados na tabela de entrada
     * @return List<tipo_entrada_model>
     */
    public List<TiposModel> recuperarListaTiposEntradas(){
        
        List<TiposModel> tiposEntrada = new ArrayList<>();
        try {
            String sql = "select * from assembleia.tbl_tipo_entradas";
            con = br.org.assembleia.conexao.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            
            while(rs.next()){
                
                TiposModel entradas = new TipoEntradaModel();
                entradas.setId(rs.getInt("id"));
                entradas.setDescricao(rs.getString("descricao_tipo_entrada"));
                
                tiposEntrada.add(entradas);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de ler dados da tabela tipos de entradas\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } finally{
            br.org.assembleia.conexao.ConexaoDB.fecharConexao(con, stm, rs);
        }
        
        return tiposEntrada;
    }
    
    /**
     * Atualiza um determinado registro de tipo de entrada
     * @param entrada TiposModel
     */
    public void atualizarTipoEntrdada(TiposModel entrada){
        try {
            String sql = "update assembleia.tbl_tipo_entradas set descricao_tipo_entrada=? where id=" + entrada.getId();
            con = br.org.assembleia.conexao.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            
            stm.setString(1, entrada.getDescricao());
            int ret = stm.executeUpdate();
            
            if(ret != 0){
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso! :)", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de atualizar informações\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } finally{
            br.org.assembleia.conexao.ConexaoDB.fecharConexao(con, stm);
        }
    }
}
