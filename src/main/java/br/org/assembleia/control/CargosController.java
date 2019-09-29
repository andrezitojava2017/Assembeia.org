/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.control;

import br.org.assembleia.model.CargosModel;
import java.util.List;

/**
 *
 * @author andre
 */
public class CargosController {

    /**
     * Recupera lista de cargos
     *
     * @return List<CargosModel>
     */
    public List<CargosModel> getListaCargos() {

        CargosModel model = new CargosModel();
        return model.getListaCargos();

    }

    /**
     * criação de novo cargos
     *
     * @param cargo
     */
    public CargosModel insertCargo(CargosModel cargo) {
        CargosModel model = new CargosModel();
        return model.insertCargo(cargo);
    }

}
