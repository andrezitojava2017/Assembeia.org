/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.control;

import br.org.assembleia.dao.DizimoDao;
import br.org.assembleia.model.DizimoModel;
import java.util.List;

/**
 *
 * @author Andre
 */
public class DizimoController {

/**
 * Insert de novo registro de DIZIMO  na tabela especifica
 * @param registro
 * @return DizimoModel 
 */
    public DizimoModel insertRegistroDizimo(DizimoModel registro) {

        DizimoModel model = new DizimoModel();
        return model.insertRegistroDizimo(registro);
    }

    /**
     * Recupera uma lista de competencias ja lançadas na base de dados
     * @return List<> dizimos_model
     */
    public List<DizimoModel> recuperarCompetenciasDizimos() {

        return null;
    }

    /**
     * Recupera uma lista de todos os lançamentos registrados na tabela de
     * dizimos
     *
     * @return dizimos List<Dizimos_model>
     */
    public List<DizimoModel> recuperarLancamentosDizimos() {

        return null;
    }

    /**
     * Recupera um registro da tabela de dizimos para alteração
     *
     * @param id_registro
     * @return dizimo
     */
    public DizimoModel recuperarRegistroParaAlterar(int id_registro) {

        return null;
    }

    /**
     * Faz a atualização de um registro da tabela de dizimos
     *
     * @param registro DizimoModel
     */
    public void atualizarRegistroDizimo(DizimoModel registro) {

    }
}
