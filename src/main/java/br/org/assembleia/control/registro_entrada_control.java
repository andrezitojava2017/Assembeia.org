/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.control;

import br.org.assembleia.dao.EntradasDao;
import br.org.assembleia.model.EntradasModel;
import br.org.assembleia.model.Relatorios_Model;
import br.org.assembleia.model.TipoEntradaModel;
import java.sql.SQLException;

import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Andre
 */
public class registro_entrada_control {

    /**
     * captura a lista de tipos de entradas
     *
     * @return List<TiposModel> lista
     */
    public List<TipoEntradaModel> preencheComboTipoEntrada() {
        List<TipoEntradaModel> lista;

        TipoEntradaModel tpEntrada = new TipoEntradaModel();
        lista = tpEntrada.getListaTiposEntradas();

        return lista;
    }

    /**
     * Faz a inserir de novos valores a tabela de entradas
     *
     * @param entrada
     * @return identificador - ID entrada
     */
    public int inserirNovoRegEntrada(EntradasModel entrada) {

        EntradasModel model = new EntradasModel();
        int identificador = model.GravarRegistroEntrada(entrada);

        return identificador;

    }

    /**
     * Recupera registros da tabela entrada para preenchimento do formulario
     * para alterações
     *
     * @return List<>()
     */
    public List<EntradasModel> recuperarRegistrosEntradas(String competencia) {

        EntradasDao dao = new EntradasDao();
        //List<EntradasModel> registros = dao.capturarRegistrosEntradas(competencia);
        List<EntradasModel> registros = new EntradasModel().recuperarListaRegistrosEntradas(competencia);
        return registros;
    }

    /**
     * captura informações de um determinado registro da tabela entradas metodo
     * solicitao para alteração de informações do registro
     *
     * @param id_selecionado
     * @return
     */
    public EntradasModel recuperarInfoRegistroParaAlterar(int id_selecionado) {

        EntradasModel model = new EntradasModel();
        return model.recuperarRegistroEntrada(id_selecionado);

    }

    /**
     * metodo que faz a atualização de determinado registro da tabela entrada
     *
     * @param entrada EntradasModel
     */
    public int atualizarRegEntrada(EntradasModel entrada) {

        EntradasModel model = new EntradasModel();
        int retorno = model.atualizarRegistroEntrada(entrada);
        return retorno;

    }

    /**
     * deleta um determinado registro da tabela de entradas pelo ID
     *
     * @param entrada
     */
    public void deletarRegEntrada(EntradasModel entrada) {

        EntradasModel model = new EntradasModel();
        model.deletarRegistroEntrada(entrada);

    }

    /**
     * Recupera todos os registros lançados em um determinada competencia
     *
     * @param competencia
     * @return List<EntradasModel>
     */
    public List<EntradasModel> recuperarListaRegistroEntrada(String competencia) {

        EntradasModel model = new EntradasModel();
        List<EntradasModel> lista = model.recuperarListaRegistrosEntradas(competencia);
        return lista;
    }

    /**
     * Abre o relatorio mensal de entradas
     *
     * @param competencia
     */
    public void abrirRelatorioEntradasMensais(String competencia) {

        try {
            Relatorios_Model rel = new Relatorios_Model();
            rel.relatorioMensalEntradas(competencia);
        } catch (JRException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Atenção não foi possivel gerar o relatorio de entradas\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
