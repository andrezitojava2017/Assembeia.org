/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.dao.UsuarioDao;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "tbl_usuario")
public class UsuarioModel {

    @Id
    @Column(name = "id")
    private int identificador;

    @Column(name = "usuario")
    private String nomeUsuario;

    @Column(name = "password")
    private String senhaUsuario;

    @Column(name = "permissao")
    private String permissao;

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    /**
     * Retorna um usuario cadastrado na base de dados
     * @param model
     * @return UsuarioModel
     */
    public UsuarioModel logarUsuario(UsuarioModel model) {

        UsuarioDao dao = new UsuarioDao();
        return dao.logarUsuario(model);

    }
}
