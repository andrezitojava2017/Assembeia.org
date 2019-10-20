/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.enumerador;

import java.io.File;

/**
 *
 * @author andre
 */
public enum DiretorioPadrao {

    SUB_DIR_RELATORIO("relatorios"), SUB_DIR_CARTAS("modeloCartas"), SUB_DIR_EMISSAO_CARTA("cartaRecomendacao");

    // captura o local padrao do usuario
    private final String diretorioUsuario = System.getProperty("user.home")
            + File.separator
            + "assembleia"
            + File.separator;

    private String caminhoPadrao = diretorioUsuario;

    DiretorioPadrao(String caminho) {
        this.caminhoPadrao += caminho;
    }

    public String getDiretorioPadrao() {
        return this.caminhoPadrao;
    }

}
