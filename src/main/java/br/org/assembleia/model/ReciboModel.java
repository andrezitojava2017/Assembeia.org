/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.dao.Recibo_Dao;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "tbl_recibos")
public class ReciboModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idRecibo;

    @Column(name = "data_recibo")
    private String data;

    @Column(name = "ano_recibo")
    private String anoRecibo;

    @Column(name = "sequencia_recibo")
    private int sequencia;

    /**
     * Construtor vazio
     */
    public ReciboModel() {

    }

    public int getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(int idRecibo) {
        this.idRecibo = idRecibo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAnoRecibo() {
        return anoRecibo;
    }

    public void setAnoRecibo(String anoRecibo) {
        this.anoRecibo = anoRecibo;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    /**
     * Recupera o ultimo registro de recibo inserido na base
     *
     * @return recibo ReciboModel
     */
    public ReciboModel recuperarUltimoRecibo() {

        ReciboModel recibo = null;

        Recibo_Dao dao = new Recibo_Dao();

        recibo = dao.recuperarUlitmoIdRecibo();

        return recibo;
    }

    /**
     * Este metodo ira verificar o ano do ultimo recibo, caso o ano do ultimo
     * recibo seja maior que o ano recuperado do sistema, indica que a sequencia
     * de recibos deverá reiniciar Ex: ultimo registro: ano = 2019, recibo = 100
     * se ano do sistema for maior que 2019, o valor do recibo sera 01 senao o
     * valor do recibo sera 101
     *
     * @return recibo ReciboModel
     */
    private ReciboModel gerarNovaSequencia(ReciboModel recibo) {

        ReciboModel numRecibo = new ReciboModel();

        LocalDate data = LocalDate.now();
        int anoSistema = data.getYear();
        int anoRecuperado = Integer.parseInt(recibo.getAnoRecibo());

        if (anoSistema > anoRecuperado) {
            numRecibo.setAnoRecibo(String.valueOf(anoSistema));
            numRecibo.setSequencia(1);
            return numRecibo;
        }

        numRecibo.setData(data.toString());
        numRecibo.setAnoRecibo(recibo.getAnoRecibo());
        int novaSequencia = recibo.getSequencia();
        novaSequencia++;
        numRecibo.setSequencia(novaSequencia);

        return numRecibo;
    }

    /**
     * Gera uma nova sequencia de recibo
     *
     * @return ReciboModel novaSequencia
     */
    public ReciboModel gerarNovoRecibo() {

        ReciboModel UltimoRecibo = recuperarUltimoRecibo();
        ReciboModel NovaSequencia = gerarNovaSequencia(UltimoRecibo);

        return NovaSequencia;
    }

    /**
     * Faz inserção de novo recibo na base de dados
     *
     * @param novo ReciboModel dados do novo recibo gerado
     * @return recibo ReciboModel com as informações de ID gerado
     */
    public ReciboModel salvarNovoRecibo(ReciboModel novo) {

        ReciboModel recibo = null;

        Recibo_Dao dao = new Recibo_Dao();
        recibo = dao.inserirNovoRecibo(novo);

        return recibo;

    }
    
    
    /**
     * Recupera dados de um determinado recibo
     * @param identificador
     * @return ReciboModel
     */
    public ReciboModel getRecibo(int identificador){
        
        Recibo_Dao dao = new Recibo_Dao();
        ReciboModel model = dao.getRecibo(identificador);
        
        return model;
        
    }
}
