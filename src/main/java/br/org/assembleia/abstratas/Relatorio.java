/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.abstratas;

import br.org.assembleia.conexao.ConexaoDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author andre
 */
public abstract class Relatorio {

    protected String caminhoPadrao = "/home/andre/Documentos/assembleia/";
    protected String nomeRelatorio;
    protected Connection con;

    public String getCaminhoPadrao() {
        return caminhoPadrao;
    }

    public void setCaminhoPadrao(String caminhoPadrao) {
        this.caminhoPadrao = caminhoPadrao;
    }

    public String getNomeRelatorio() {
        return nomeRelatorio;
    }

    public void setNomeRelatorio(String nomeRelatorio) {
        this.nomeRelatorio = nomeRelatorio;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * Metodo que ira retornar o caminho completo de um determinado relatorio
     *
     * @param nomeRel String nomeRel representa o nome do relatorio que ira ser
     * utilizado
     * @return caminho String com o caminho completo do relatorio
     */
    public String getCaminhoPadraoRelatorio(String nomeRel) {
        String caminho = "/home/andre/Documentos/assembleia/" + nomeRel + ".jasper";

        return caminho;
    }

    /**
     * Metodo responsavel em gerar relatorios do sistema
     * @param nomeRel - nome do relatorio que sera utilizado
     * @param parametros - parametros que deverão ser utilizados no relatorio
     * @throws java.sql.SQLException
     * @throws net.sf.jasperreports.engine.JRException
     */
    protected void gerarRelatorio(String nomeRel, Map parametros) throws SQLException, JRException {

        String caminho;
        caminho = caminhoPadrao += nomeRel;

        con = ConexaoDB.getconection();
        
        JasperPrint print = JasperFillManager.fillReport(caminho, parametros, con);
        
        JasperViewer tela = new JasperViewer(print, false);
        
        tela.setVisible(true);
        
        con.close();

    }
}
