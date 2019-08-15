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
        String nomeRel = "Rel_Entradas_Mensais.jasper";
        Map parametro = new HashMap();
        parametro.put("competencia", compet);

        // metodo que ira gerar o relatorio
        gerarRelatorio(nomeRel, parametro);

    }
}
