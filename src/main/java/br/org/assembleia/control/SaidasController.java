/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.control;

import br.org.assembleia.dao.SaidasDao;
import br.org.assembleia.model.SaidasModel;
import br.org.assembleia.model.TipoSaidasModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andre
 */
public class SaidasController {

    /**
     * Captura os tipos de saidas que foram cadastrados na table Saidas
     *
     * @return List<TipoSaidasModel>
     */
    public List<TipoSaidasModel> getListaTipoSaida() {
        List<TipoSaidasModel> listaSaida = new ArrayList<>();
        SaidasDao dao = new SaidasDao();
        listaSaida = dao.getTipoSaidas();
        return listaSaida;
    }

    /**
     * Grava um novo registro de sauda na base de dados
     *
     * @param saida
     */
    public SaidasModel gravarSaida(SaidasModel saida) {

        SaidasModel model = new SaidasModel();
        SaidasModel retorno = model.gravarSaida(saida);

        return retorno;
    }

    /**
     * recupera informações de todos os registros lançados na competencia
     * informada no parametro
     *
     * @param competencia
     * @return List<SaidasModel>
     */
    public List<SaidasModel> getListaSaidas(String competencia) {

        SaidasModel model = new SaidasModel();
        List<SaidasModel> regSaidas = model.getListaSaidas(competencia);

        return regSaidas;
    }

    /**
     * Recupera as informações de um determinado registro da tabela de SAIDAS
     * utilizado para preencher o formulario saida, para possivel alterações
     *
     * @param id_reg_saida
     * @return SaidasModel
     */
    public SaidasModel capturarRegistroSaida(int id_reg_saida) {

        SaidasModel model = new SaidasModel();
        SaidasModel registro = model.getSaida(id_reg_saida);

        return registro;
    }

    /**
     * Atualiza dados de um registro de saida
     *
     * @param registro
     */
    public int updateRegistroSaida(SaidasModel registro) {

        SaidasModel model = new SaidasModel();
        int retorno = model.updateRegistroSaida(registro);

        return retorno;
    }

    /**
     * Delete registro de saida
     *
     * @param registro
     * @return int
     */
    public int deleteRegistroSaida(SaidasModel registro) {

        SaidasModel model = new SaidasModel();
        return model.deleteRegistroSaida(registro);

    }

}
