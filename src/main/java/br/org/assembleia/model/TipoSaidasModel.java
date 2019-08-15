/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.abstratas.TiposModel;
import br.org.assembleia.dao.SaidasDao;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Andre
 */
@Entity
@Table(name = "tbl_tipo_saidas")
public class TipoSaidasModel extends TiposModel {

    public TipoSaidasModel() {

    }

    /**
     * Captura os tipos de saidas que foram cadastrados na table Saidas
     *
     * @return List<TipoSaidasModel>
     */
    public List<TipoSaidasModel> getListaTiposSaidas() {
        List<TipoSaidasModel> listaSaida;
        SaidasDao dao = new SaidasDao();
        listaSaida = dao.getTipoSaidas();

        return listaSaida;
    }

}
