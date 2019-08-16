/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.control;

import br.org.assembleia.dao.TipoEntradasDao;
import br.org.assembleia.model.TipoEntradaModel;

/**
 *
 * @author andre
 */
public class TipoEntradaController {

    /**
     * Chama o metodo da classe DAO para inserção de novo registro do TIPO
     * ENTRADA
     * @param model
     * @return int
     */
    public int insertTipoEntrada(TipoEntradaModel model) {

        TipoEntradaModel entrada = new TipoEntradaModel();
        return entrada.insertTipoEntrada(model);

    }

    /**
     * chama o metodo da classe DAO para atualizar um registro de TIPO ENTRADA
     *
     * @param model
     * @return int
     */
    public int updateTipoEntrada(TipoEntradaModel model) {

        TipoEntradaModel dao = new TipoEntradaModel();
        return dao.updateTipoEntrada(model);

    }
}
