/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.dao;

import br.org.assembleia.model.DizimoModel;
import br.org.assembleia.model.MembroModel;
import br.org.assembleia.abstratas.Pessoas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class dizimos_dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    /**
     * faz lançamento de dizimo na tabela DIZIMOS
     *
     * @param dizimos
     */
    public void novoLancamentoDizimo(DizimoModel dizimos) {

        try {

            String sql = "insert into assembleia.tbl_dizimos("
                    + "data_dizimo, "
                    + "descricao_dizimo, "
                    + "id_pessoas, "
                    + "valor_dizimo, "
                    + "competencia_dizimo,"
                    + "recibo_dizimo) "
                    + "value(?,?,?,?,?,?)";

            LocalDate data;
            DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            con = br.org.assembleia.conexao.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            data = LocalDate.parse(dizimos.getData(), formatar);// posicao 0 indica DATA lançamento

            stm.setString(1, String.valueOf(data));
            stm.setString(2, dizimos.getDescricao()); // posicao 1 indica DESCRIÇÃO do conteudo
            stm.setInt(3, dizimos.getPessoa().getId_pessoa());
            stm.setDouble(4, dizimos.getValor());
            stm.setString(5, dizimos.getCompetencia());
            stm.setInt(6, dizimos.getRecibo());

            int opt = stm.executeUpdate();

            if (opt != 0) {
                JOptionPane.showMessageDialog(null, "Lançamento de dizimo salvo com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de lançamento de dizimo\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            br.org.assembleia.conexao.ConexaoDB.fecharConexao(con, stm);
        }

    }

    /**
     * Recupera lançamentos da tabela de dizimos
     *
     * @return dizimos List<dizimos_model>
     */
    public List<DizimoModel> carregarRegistrosEntradaDizimo() {

        List<DizimoModel> dizimos = new ArrayList<>();

        try {
            String sql = "select * from assembleia.tbl_dizimos";
            con = br.org.assembleia.conexao.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {

                DizimoModel dizimo = new DizimoModel();
                dizimo.setId_dizimo(rs.getInt("id"));
                dizimo.setData(rs.getString("data_dizimo"));
                dizimo.setDescricao(rs.getString("descricao_dizimo"));
                dizimo.setValor(rs.getDouble("valor_dizimo"));
                dizimo.setCompetencia(rs.getString("competencia_dizimo"));
                MembroModel pessoa = new MembroModel();
                pessoa.setId_pessoa(rs.getInt("id_pessoas"));
                dizimo.setPessoa(pessoa);

                dizimos.add(dizimo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de capturar dados da tabela de dizimos\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            br.org.assembleia.conexao.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return dizimos;
    }

    /**
     * Recupera uma lista de competencias lançadas na tabela de dizimos
     *
     * @return
     */
    public List<DizimoModel> carregarCompetenciasDizimos() {

        List<DizimoModel> dizimos = new ArrayList<>();

        try {
            String sql = "select competencia_dizimo from assembleia.tbl_dizimos group by competencia_dizimo";
            con = br.org.assembleia.conexao.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {

                DizimoModel dizimo = new DizimoModel();
                dizimo.setCompetencia(rs.getString("competencia_dizimo"));
                dizimos.add(dizimo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de capturar competencias da tabela de dizimos\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            br.org.assembleia.conexao.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return dizimos;
    }

    /**
     * Recupera um registro da tabela dizimos, para alteração
     *
     * @param id_registro
     * @return dizimo
     */
    public DizimoModel carregarRegistrosEntradaDizimo(int id_registro) {

        DizimoModel dizimo = new DizimoModel();

        try {
            String sql = "select * from assembleia.tbl_dizimos where id=" + id_registro;
            con = br.org.assembleia.conexao.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {

                dizimo.setId_dizimo(rs.getInt("id"));
                dizimo.setData(rs.getString("data_dizimo"));
                dizimo.setDescricao(rs.getString("descricao_dizimo"));
                dizimo.setValor(rs.getDouble("valor_dizimo"));
                dizimo.setCompetencia(rs.getString("competencia_dizimo"));
                dizimo.setRecibo(rs.getInt("recibo_dizimo"));
                MembroModel pessoa = new MembroModel();
                pessoa.setId_pessoa(rs.getInt("id_pessoas"));
                dizimo.setPessoa(pessoa);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de capturar dados da tabela de dizimos\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            br.org.assembleia.conexao.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return dizimo;
    }

    /**
     * Faz a atualização de um determinado registro da tabela de dizimos
     *
     * @param registro DizimoModel
     */
    public void atualizarDadosRegistroDizimo(DizimoModel registro) {
        try {
            String sql = "update assembleia.tbl_dizimos set "
                    + "data_dizimo=?, "
                    + "descricao_dizimo=?, "
                    + "id_pessoas=?, "
                    + "valor_dizimo=?, "
                    + "competencia_dizimo=?,"
                    + "recibo_dizimo=?,"
                    + "descricao_dizimo=? "
                    + "where id=" + registro.getId_dizimo();
            con = br.org.assembleia.conexao.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);

            // formata a data com padrão aceitavel pelo Mysql: yyyy-MM-dd
            LocalDate data = LocalDate.parse(registro.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            stm.setString(1, String.valueOf(data));
            stm.setString(2, registro.getDescricao());
            stm.setInt(3, registro.getPessoa().getId_pessoa());
            stm.setDouble(4, registro.getValor());
            stm.setString(5, registro.getCompetencia());
            stm.setInt(6, registro.getRecibo());
            stm.setString(7, registro.getDescricao());
            int retorno = stm.executeUpdate();

            if (retorno != 0) {
                JOptionPane.showMessageDialog(null, "Parabens...os dados foram atualizados com sucesso! :)", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de atualizar registro\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            br.org.assembleia.conexao.ConexaoDB.fecharConexao(con, stm);
        }

    }

}
