/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.control;

import br.org.assembleia.dao.tipo_saidas_dao;
import br.org.assembleia.model.TipoSaidasModel;
import java.util.List;

/**
 *
 * @author Andre
 */
public class tipo_saidas_control {

    /**
     * recupera o id de um determinado tipo de saida cadastrada
     *
     * @param descricao
     * @return id_saida
     */
    public int recuperaIdTipoSaida(String descricao) {

        tipo_saidas_dao dao = new tipo_saidas_dao();
        int id_saida = dao.capturarIdTipoSaida(descricao);

        return id_saida;
    }

    /**
     * Recupera lista de saidas pré cadastradas
     *
     * @return List<tipo_saidas_model>
     */
    public List<TipoSaidasModel> recuperaListaTipoSaidas() {

        TipoSaidasModel model = new TipoSaidasModel();
        List<TipoSaidasModel> saida = model.getListaTiposSaidas();

        return saida;

    }

    /**
     * inseri novo tipo de saidas na tabela de saidas
     * @param descricaoNovoTipo
     */
    public void inserirNovoTipoSaida(String descricaoNovoTipo) {

        tipo_saidas_dao dao = new tipo_saidas_dao();
        dao.inserirNovoTipoSaida(descricaoNovoTipo);
    }
    
    /**
     * recupera a descrição de um tipo de saida, cadasrado na tabela de saidas
     * utilizado para preencher o formulario de saida para alteração
     * @param id_tp_saida
     * @return tpSaida
     */
    public String recuperarTipoSaida(int id_tp_saida){
        
        tipo_saidas_dao dao = new tipo_saidas_dao();
        String tpSaida = dao.capturarTipoSaidaCadastrado(id_tp_saida);
        return tpSaida;
    }
    
    /**
     * Atualiza dados de um registro da tabela Saida
     * @param tipo_saida_model tipo 
     */
    public void atualizarTipoSaida(TipoSaidasModel tipo){
        tipo_saidas_dao dao = new tipo_saidas_dao();
        dao.atualizarTipo(tipo);
        
    }

}
