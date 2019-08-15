/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.control;

import br.org.assembleia.model.SolicitacaoModel;

/**
 *
 * @author andre
 */
public class SolicitacaoController {

    /**
     * Gera uma nova solicitacao vincualada a um registro de saida
     *
     * @param solicitacao
     * @return SolicitacaoModel
     */
    public SolicitacaoModel gerarNovaSolicitacao(SolicitacaoModel solicitacao) {

        SolicitacaoModel model = new SolicitacaoModel();
        model = model.gravarSolicitacao(solicitacao);

        return model;

    }

    /**
     * Recupera dados de uma determinada solicitacao
     *
     * @param identificador
     * @return SolicitacaoModel
     */
    public SolicitacaoModel getSolicitacao(int identificador) {

        SolicitacaoModel model = new SolicitacaoModel();
        model = model.getSolicitacao(identificador);

        return model;

    }

    /**
     * Atualiza uma solicitacao para SITUACAO I - INATIVA
     *
     * @param solicitacao
     * @return
     */
    public int deletarSolicitacaoVinculada(SolicitacaoModel solicitacao) {
        SolicitacaoModel model = new SolicitacaoModel();
        int retorno = model.deleteSolicitacaoVinculada(solicitacao);

        return retorno;
    }

}
