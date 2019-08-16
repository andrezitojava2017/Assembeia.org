/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.control;

import br.org.assembleia.model.TipoSaidasModel;
import java.util.List;

/**
 *
 * @author andre
 */
public class TipoSaidaController {

    /**
     * Chama metodo para lançar novo registro de TIPO SAIDA
     *
     * @param model
     * @return int
     */
    public int insertTipoSaida(TipoSaidasModel model) {

        TipoSaidasModel tpSaida = new TipoSaidasModel();
        return tpSaida.insertTipoSaida(model);

    }

    /**
     * Captura os tipos de saidas que foram cadastrados na table Saidas
     *
     * @return List<TipoSaidasModel>
     */
    public List<TipoSaidasModel> getListaTiposSaidas() {

        List<TipoSaidasModel> listaSaida;
        TipoSaidasModel model = new TipoSaidasModel();
        return listaSaida = model.getListaTiposSaidas();

    }

    /**
     * Update um registro de Tipos de Saidas
     *
     * @param model
     * @return int
     */
    public int updateTipoSaida(TipoSaidasModel model) {

        TipoSaidasModel saida = new TipoSaidasModel();
        return saida.updateTipoSaida(model);
        
    }
}
