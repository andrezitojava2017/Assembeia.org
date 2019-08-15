/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andre
 */
public class alterar_reg_entrada_dao {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    public List<String> recuperarLancEntrada() {
        String d;
        List<String> lista = new ArrayList<>();
        
        try {
            String sql = "select descricao_entrada from assembleia.tbl_entrada";
            con = br.org.assembleia.conexao.ConexaoDB.getconection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                d = rs.getString("descricao_entrada");
//                System.out.println(d);
                lista.add(d);

            }

        } catch (SQLException ex) {
            Logger.getLogger(alterar_reg_entrada_dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            br.org.assembleia.conexao.ConexaoDB.fecharConexao(con, stm, rs);
        }

        return lista;
    }
}
