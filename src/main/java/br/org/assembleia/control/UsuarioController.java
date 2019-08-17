/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.control;

import br.org.assembleia.dao.UsuarioDao;
import br.org.assembleia.model.UsuarioModel;

/**
 *
 * @author andre
 */
public class UsuarioController {

    /**
     * Retorna um usuario cadastrado na base de dados
     *
     * @param model
     * @return UsuarioModel
     */
    public UsuarioModel logarUsuario(UsuarioModel model) {

        UsuarioModel usuario = new UsuarioModel();
        return usuario.logarUsuario(model);

    }
}
