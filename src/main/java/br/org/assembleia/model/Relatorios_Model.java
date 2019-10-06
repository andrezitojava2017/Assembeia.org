/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.abstratas.Relatorio;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author andre
 */
public class Relatorios_Model extends Relatorio {

    /**
     * Faz a impressao do relatorio de entradas mensal
     *
     * @param compet
     * @throws net.sf.jasperreports.engine.JRException
     * @throws java.sql.SQLException
     */
    public void relatorioMensalEntradas(String compet) throws JRException, SQLException {

        // passando nome do relatorio que sera utilizado, para o metodo que
        // contem o local padrao de relatorios
        String nomeRel = "Rel_Entradas_Mensais";
        Map parametro = new HashMap();
        parametro.put("competencia", compet);

        // metodo que ira gerar o relatorio
        gerarRelatorio(nomeRel, parametro);

    }
    
    /**
     * Faz a impressao do relatorio de saidas mensal
     * @param compet
     * @throws SQLException
     * @throws JRException 
     */
    public void relatorioMensalSaidas(String compet) throws SQLException, JRException{
        
        String nomeRel = "Rel_Saidas_Mensais";
        Map parametro = new HashMap();
        parametro.put("competencia", compet);
        
        gerarRelatorio(nomeRel, parametro);
        
    }
    
    /**
     * Gera o relatorio com registros de dizimos por pessoa
     * @param compet
     * @throws SQLException
     * @throws JRException 
     */
    public void relatorioMensalDizimos(String compet) throws SQLException, JRException{
        
        String nomeRel = "RelDizimosPorPessoa";
        Map parametros = new HashMap();
        parametros.put("competencia", compet);
        gerarRelatorio(nomeRel, parametros);
    }
    
    /**
     * Gera o relatorio com dados dos membros que estão ativos no sistema
     * @throws SQLException
     * @throws JRException 
     */
    public void relatorioMembrosAtivos() throws SQLException, JRException{
        
        String nomeRel = "Rel_Membros_Ativos";
        gerarRelatorio(nomeRel);
        
    }
    
    /**
     * Gera uma carteirinha de identificação de membros
     * @param idMembro
     * @throws SQLException
     * @throws JRException 
     */
    public void gerarCarteirasMembro(int idMembro) throws SQLException, JRException{
        
        String nomeRel = "Carteirinha_Membro";
        Map parametro = new HashMap();
        parametro.put("idMembro", idMembro);
        gerarRelatorio(nomeRel, parametro);
        
    }
}
