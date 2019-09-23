/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.abstratas.Registro;
import br.org.assembleia.dao.EntradasDao;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
@Entity
@Table(name = "tbl_entrada")
public class EntradasModel extends Registro {

    @Column(name = "tipo_entrada")
    private String tipo_entrada;

    /**
     * Metodo construtor vazio
     */
    public EntradasModel() {
    }

    public String getTipo_entrada() {
        return tipo_entrada;
    }

    public void setTipo_entrada(String tipo_entrada) {
        this.tipo_entrada = tipo_entrada;
    }

    /**
     * Formata o valor informado para o padrao aceito pelo mysql
     *
     * @param valor
     * @return String
     */
    public String formatarValores(String valor) throws ParseException {

        DecimalFormat fr = new DecimalFormat("###,##0.00");
        fr.setCurrency(Currency.getInstance(new Locale("pt", "BR")));

        return fr.parse(valor).toString();
    }

    /**
     * Faz a inserção da entrada na base de dados
     *
     * @param entrada EntradasModel
     * @return identificador - ID deste lançamento
     */
    public int GravarRegistroEntrada(EntradasModel entrada) {
        
        try {
            // formatar a data padrao yyyy-MM-dd
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate ld = LocalDate.parse(entrada.getData(), fmt);

            // setendo data no formato aceito pelo mysql
            entrada.setData(ld.toString());
            entrada.setValor(formatarValores(entrada.getValor()));
            
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar converter valor para ser inserido na base de dados\n" + ex);
        }

        EntradasDao dao = new EntradasDao();
        int identificador = dao.gravarRegistroEntrada(entrada);

        return identificador;
    }

    /**
     * Recupera um determinado registro da tabela de entradas,podendo ser
     * atualizados
     *
     * @param identificador id a ser recuperado
     * @return entrada - EntradasModel
     */
    public EntradasModel recuperarRegistroEntrada(int identificador) {

        EntradasModel entrada = null;

        EntradasDao dao = new EntradasDao();
        entrada = dao.capturarRegParaAlteracao(identificador);

        return entrada;

    }

    /**
     * Recupera os registros de entradas de uma determinada competencia
     * informada pelo usuario
     *
     * @param competencia
     * @return Lis<EntradaModel> model
     */
    public List<EntradasModel> recuperarListaRegistrosEntradas(String competencia) {

        List<EntradasModel> model = null;

        EntradasDao dao = new EntradasDao();
        model = dao.capturarRegistrosEntradas(competencia);

        return model;

    }

    /**
     * Atualiza um lançamento/registro de entrada
     *
     * @param entrada
     */
    public int atualizarRegistroEntrada(EntradasModel entrada) {

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");  // formato que esta vindo a data
        LocalDate dat = LocalDate.parse(entrada.getData(), f); // aqui o parse transforma no padrao yyyy-MM-dd
        entrada.setData(dat.toString());
        EntradasDao dao = new EntradasDao();
        int retorno = dao.atualizarRegEntrada(entrada);
        return retorno;
    }

    /**
     * Exclui registro de entrada pelo id fornecido
     *
     * @param model
     */
    public void deletarRegistroEntrada(EntradasModel model) {
        EntradasDao dao = new EntradasDao();
        dao.deletarRegEntrada(model);
    }
}
