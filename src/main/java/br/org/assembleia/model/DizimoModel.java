/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.abstratas.Registro;
import br.org.assembleia.dao.DizimoDao;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
@Entity
@Table(name = "tbl_dizimos")
public class DizimoModel extends Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int identificador;

    @Column(name = "id_membro_responsavel")
    private int idMembroReceptor;

    @Column(name = "id_membro_dizimista")
    private int idDizimista;

    @Column(name = "id_entrada")
    private int idEntrada;

    /**
     * Construtor
     */
    public DizimoModel() {

    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getIdMembroReceptor() {
        return idMembroReceptor;
    }

    public void setIdMembroReceptor(int idMembroReceptor) {
        this.idMembroReceptor = idMembroReceptor;
    }

    public int getIdDizimista() {
        return idDizimista;
    }

    public void setIdDizimista(int idDizimista) {
        this.idDizimista = idDizimista;
    }

    /**
     * Formata a data em um padrao aceito pelo banco mysql
     *
     * @param data
     * @return String
     */
    private String formatarDatasGravacao(String data) {

        DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dta = LocalDate.parse(data, frmt);

        return dta.toString();
    }

    /**
     * Formata os valores para o padrao BR
     *
     * @param valor
     * @return String
     * @throws ParseException
     */
    public String formatarValores(double valor) {

        String retorno = null;
        try {
            DecimalFormat fr = new DecimalFormat("###,##0.00");
            fr.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            retorno = fr.format(valor).toString();
            System.out.println(retorno);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Opss...erro ao tentar formatador valores recuperados");
        }

        return retorno;
    }

    
    
    /**
     * Formata o valor informado para o padrao aceito pelo mysql
     *
     * @param valor
     * @return String
     */
    public String formatarValoresMysql(String valor) throws ParseException {

        DecimalFormat fr = new DecimalFormat("###,##0.00");
        fr.setCurrency(Currency.getInstance(new Locale("pt", "BR")));

        return fr.parse(valor).toString();
    }
    
    /**
     * Formata a data para exibicao na view
     *
     * @param data
     * @return String
     */
    private String exibirDataFormatada(String data) {

        LocalDate dta = LocalDate.parse(data);
        DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return frmt.format(dta).toString();
    }

    /**
     * Insert de registro na tabel especiica de DIZIMOS
     *
     * @param registro
     * @return
     */
    public DizimoModel insertRegistroDizimo(DizimoModel registro) {

        DizimoDao dao = new DizimoDao();
        return dao.insertRegistroDizimo(registro);

    }

    /**
     * Recupera uma lista de registros de dizimos por competencia
     *
     * @param competencia
     * @return List<DizimoModel>
     */
    public List<DizimoModel> getListaRegistroDizimo(String competencia) {

        List<DizimoModel> lista = new DizimoDao().getListaDizimos(competencia);

        // iremos formatar a data para exibir na view no padrao dd/MM/yyyy
        for (DizimoModel dzM : lista) {
            dzM.setData(exibirDataFormatada(dzM.getData()));
            //dzM.setValor(formatarValores(Double.parseDouble(dzM.getValor())));
        }

        return lista;
    }
    
    /**
     * Atualiza registro de entrada de dizimo
     * @param registro 
     */
    public void updateRegistroDizimo(DizimoModel registro){
        
        DizimoDao dao = new DizimoDao();
        try {
            
            registro.setValor(formatarValoresMysql(registro.getValor()));
            registro.setData(formatarDatasGravacao(registro.getData()));
            
            dao.updateRegistroDizimo(registro);
            
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar converter valor para padrao Mysql");
        }
        
    }
}
