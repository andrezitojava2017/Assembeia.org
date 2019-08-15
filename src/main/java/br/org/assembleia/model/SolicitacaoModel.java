/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.dao.SolicitacaoDao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
@Table(name = "tbl_solicitacao")
public class SolicitacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int identificador;

    @Column(name = "data_cadastro")
    private String dataCadastro;

    @Column
    private String competencia;

    @Column(name = "numero")
    private int sequencia;

    @Column
    private String situacao;

    @Column(name = "id_saida")
    private int idSaida;

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getIdSaida() {
        return idSaida;
    }

    public void setIdSaida(int idSaida) {
        this.idSaida = idSaida;
    }

    /**
     * Gera uma nova sequencia numerica para um solicitacao
     *
     * @return SolicitacaoModel
     */
    public SolicitacaoModel gerarNovaSolicitacao() {

        // obj para armazenar o retorno        
        SolicitacaoModel novaSolicitacao = new SolicitacaoModel();

        // recupera a ultima solicitacao
        SolicitacaoModel ultimaSolicitacao = getUltimaSolicitacao();

        // verificacao se o ano do sistema é o mesmo que da solicitacao
        // indicando que faz parte da mesma sequencia do ano
        // ex: se o ano recuperado < que o ano do sistema, entao deverá reiniciar
        // a sequencia de solicitação
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmtCompetencia = DateTimeFormatter.ofPattern("MM/yyyy");

        LocalDate dataSolic = LocalDate.parse(ultimaSolicitacao.getDataCadastro());
        LocalDate dataSistema = LocalDate.now();

        //System.out.println("DATA ATUAL: " + dataSistema.toString());
        //System.out.println("FORMATO COMPETENCIA: " + dataSistema.format(fmtCompetencia));
        if (dataSolic.getYear() == dataSistema.getYear()) {

            int sequencia = ultimaSolicitacao.getSequencia();
            sequencia++;

            novaSolicitacao.setDataCadastro(dataSistema.toString());
            novaSolicitacao.setCompetencia(dataSistema.format(fmtCompetencia));
            novaSolicitacao.setSequencia(sequencia);
            novaSolicitacao.setSituacao("A"); // indica que a solicitacao está com SITUACAO AGUARDANDO PRESTACAO DE CONTAS

            return novaSolicitacao;

        } else {

            int sequencia = 1;
            novaSolicitacao.setDataCadastro(dataSistema.toString());
            novaSolicitacao.setCompetencia(dataSistema.format(fmtCompetencia));
            novaSolicitacao.setSequencia(sequencia);
            novaSolicitacao.setSituacao("A"); // indica que a solicitacao está com SITUACAO AGUARDANDO PRESTACAO DE CONTAS

            return novaSolicitacao;
        }

    }

    /**
     * Grava um objeto tipo solicitacaoModel na base de dados
     *
     * @param solicitacao SolicitacaoModel
     * @return SolicitacaoModel
     */
    public SolicitacaoModel gravarSolicitacao(SolicitacaoModel solicitacao) {

        // gerando o valor sequencial da solicitacao
        SolicitacaoModel novaSolicitacao = gerarNovaSolicitacao();

        // atribuindo valor referente ao ID da saida que esta solicitacao se refere
        novaSolicitacao.setIdSaida(solicitacao.getIdSaida());

        // insercao de valores na base
        SolicitacaoDao dao = new SolicitacaoDao();
        SolicitacaoModel solicit = dao.gerarSolicitacao(novaSolicitacao);

        return solicit;
    }

    /**
     * Captura a ultima solicitacao inserida na base de dados
     *
     * @return SolicitacaoModel
     */
    private SolicitacaoModel getUltimaSolicitacao() {

        SolicitacaoDao dao = new SolicitacaoDao();
        SolicitacaoModel ultimaSolicitacao = dao.getUltimaSolicitacao();

        return ultimaSolicitacao;

    }

    /**
     * Recupera dados de uma determinada solicitacao
     * @return SolicitacaoModel
     */
    public SolicitacaoModel getSolicitacao(int identificador) {

        SolicitacaoDao dao = new SolicitacaoDao();
        SolicitacaoModel Solicitacao = dao.getSolicitacao(identificador);

        return Solicitacao;

    }
    
    
    /**
     * Atualiza uma solicitacao para SITUACAO I - INATIVA
     * @param model
     * @return 
     */
    public int deleteSolicitacaoVinculada(SolicitacaoModel model){
        
        SolicitacaoDao dao = new SolicitacaoDao();
        int retorno = dao.deleteSolicitacao(model);
        return retorno;
        
    }
}
