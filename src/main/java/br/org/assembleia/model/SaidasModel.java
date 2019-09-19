/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.abstratas.Registro;
import br.org.assembleia.dao.SaidasDao;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
@Entity
@Table(name = "tbl_saidas")
public class SaidasModel extends Registro {

    @Column(name = "tipo_saida")
    private String tipo_saida;

    @Column(name = "id_credor")
    private int idCredor;

    public int getIdCredor() {
        return idCredor;
    }

    public void setIdCredor(int idCredor) {
        this.idCredor = idCredor;
    }

    public String getTipo_saida() {
        return tipo_saida;
    }

    public void setTipo_saida(String tipo_saida) {
        this.tipo_saida = tipo_saida;
    }

    
        /**
     * Formata o valor informado para o padrao aceito pelo mysql
     *
     * @param valor
     * @return String
     */
    private String formatarValores(String valor) throws ParseException {

        DecimalFormat fr = new DecimalFormat("###,##0.00");
        fr.setCurrency(Currency.getInstance(new Locale("pt", "BR")));

        return fr.parse(valor).toString();
    }
    
    /**
     * Grava um registro de saida
     *
     * @param model
     * @return SaidasModel
     */
    public SaidasModel gravarSaida(SaidasModel model) {

        // formatar a data padrao yyyy-MM-dd
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ld = LocalDate.parse(model.getData(), fmt);

        model.setData(ld.toString());

        SaidasDao dao = new SaidasDao();
        SaidasModel retorno = dao.gravarRegistroSaida(model);
        return retorno;

    }

    /**
     * Recupera um determinado registro de saida para alteração
     *
     * @param identificador
     * @return SaidasModel
     */
    public SaidasModel getSaida(int identificador) {

        SaidasDao dao = new SaidasDao();
        SaidasModel saida = dao.recuperarRegParaAlteracao(identificador);

        return saida;

    }

    /**
     * Recupera uma lista de saidas
     *
     * @param competencia
     * @return SaidasModel
     */
    public List<SaidasModel> getListaSaidas(String competencia) {

        SaidasDao dao = new SaidasDao();
        List<SaidasModel> saidas = dao.getListaSaidas(competencia);

        return saidas;
    }

    /**
     * Atualiza dados de um registro de saida
     *
     * @param registro
     */
    public int updateRegistroSaida(SaidasModel registro) {
        int retorno = 0;
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(registro.data, format);
            
            registro.setData(data.toString());            
            registro.setValor(formatarValores(registro.getValor()));
            
            SaidasDao dao = new SaidasDao();
            retorno = dao.updateRegistroSaida(registro);
            

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar formatar valores para formato do banco de dados");
        }            
        return retorno;
    }

    /**
     * Delete registro de saida
     *
     * @param registro
     * @return int
     */
    public int deleteRegistroSaida(SaidasModel registro) {
        
        SaidasDao dao = new SaidasDao();
        int retorno = dao.deleteRegistroSaida(registro);

        return retorno;
    }

}
