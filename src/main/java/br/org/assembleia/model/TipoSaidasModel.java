/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.abstratas.TiposModel;
import br.org.assembleia.dao.SaidasDao;
import br.org.assembleia.dao.TipoSaidaDao;
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

    /**
     * Chama metodo para lançar novo registro de TIPO SAIDA
     *
     * @param model
     * @return int
     */
    public int insertTipoSaida(TipoSaidasModel model) {

        TipoSaidaDao dao = new TipoSaidaDao();
        return dao.insertTipoSaida(model);

    }

    /**
     * Update um registro de Tipos de Saidas
     *
     * @param model
     * @return int
     */
    public int updateTipoSaida(TipoSaidasModel model) {

        TipoSaidaDao dao = new TipoSaidaDao();
        return dao.updateTipoSaida(model);

    }

}
