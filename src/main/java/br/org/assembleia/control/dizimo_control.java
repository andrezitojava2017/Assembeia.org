/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.control;

import br.org.assembleia.dao.dizimos_dao;
import br.org.assembleia.model.DizimoModel;
import java.util.List;

/**
 *
 * @author Andre
 */
public class dizimo_control {

    /**
     * Inserção de lancamento de dizimos
     *
     * @param dizimos
     */
    public void inserirLancDizimos(DizimoModel dizimos) {

        dizimos_dao dao = new dizimos_dao();
        dao.novoLancamentoDizimo(dizimos);
    }

    /**
     * Recupera uma lista de competencias ja lançadas na base de dados
     * @return List<> dizimos_model
     */
    public List<DizimoModel> recuperarCompetenciasDizimos() {

        dizimos_dao dao = new dizimos_dao();
        List<DizimoModel> dizimos = dao.carregarCompetenciasDizimos();
        return dizimos;
    }

    /**
     * Recupera uma lista de todos os lançamentos registrados na tabela de
     * dizimos
     *
     * @return dizimos List<Dizimos_model>
     */
    public List<DizimoModel> recuperarLancamentosDizimos() {

        dizimos_dao dao = new dizimos_dao();
        List<DizimoModel> dizimos = dao.carregarRegistrosEntradaDizimo();
        return dizimos;
    }

    /**
     * Recupera um registro da tabela de dizimos para alteração
     *
     * @param id_registro
     * @return dizimo
     */
    public DizimoModel recuperarRegistroParaAlterar(int id_registro) {
        dizimos_dao dao = new dizimos_dao();
        DizimoModel dizimos = dao.carregarRegistrosEntradaDizimo(id_registro);
        return dizimos;
    }

    /**
     * Faz a atualização de um registro da tabela de dizimos
     *
     * @param registro DizimoModel
     */
    public void atualizarRegistroDizimo(DizimoModel registro) {
        dizimos_dao dao = new dizimos_dao();
        dao.atualizarDadosRegistroDizimo(registro);
    }
}
