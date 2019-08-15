/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.control;

import br.org.assembleia.model.PessoasModel;
import java.util.List;

/**
 *
 * @author andre
 */
public class PessoasController {

    /**
     * Recupera dados de uma determinada pessoa
     *
     * @param identificador
     * @return PessoasModel
     */
    public PessoasModel getPessoa(int identificador) {

        PessoasModel model = new PessoasModel();
        model = model.getPessoa(identificador);

        return model;
    }

    /**
     * Recupera uma lista de pessoas cadastradas
     *
     * @return List<PessoasModel>
     */
    public List<PessoasModel> getListaPessoas() {

        PessoasModel model = new PessoasModel();
        List<PessoasModel> lista = model.getListaPessoas();

        return lista;
    }

    /**
     * Modifica a coluna situacao para I- INATIVO
     *
     * @param pessoas
     * @return int
     */
    public int deletePessoa(PessoasModel pessoas) {

        PessoasModel model = new PessoasModel();
        return model.deletePessoas(pessoas);

    }

    /**
     * Faz a inserção de uma pessoa na base de dados
     *
     * @param model
     * @return PessoasModel
     */
    public PessoasModel insertPessoasModel(PessoasModel model) {
        PessoasModel get = new PessoasModel();
        return get.insertPessoasModel(model);

    }

    /**
     * Atualiza dados de um cadastro de pessoa
     *
     * @param model
     * @return int
     */
    public int updatePessoa(PessoasModel model) {

        PessoasModel update = new PessoasModel();
        int getUpdate = update.updatePessoa(model);
        return getUpdate;
    }
}
