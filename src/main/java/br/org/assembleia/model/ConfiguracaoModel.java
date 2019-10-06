/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Esta classe e responsavel em ler dados externos de configurações como:
 * Localizacao do arquivos modelos de cartas Localizacao dos relatorios
 * Localizacao de imagens para relatorios e arquivos de cartas
 *
 * @author andre
 */
public class ConfiguracaoModel {

    public static String diretorio;

    /**
     * Construtor que ira inicializar o caminho dos relatorios e dos modelos de
     * cartas
     */
    public ConfiguracaoModel() {
        this.diretorio = setCaminhoRelatorio();
    }

    /**
     * Define o caminho do diretorio ond estara localizado
     * os relatorio e os modelos de cartas
     * @return String
     */
    private String setCaminhoRelatorio() {

        // caminho do arquivo
        String localArqConfig = System.getProperty("user.home") + File.separator + "assembleia" + File.separator;

        Path pth = Paths.get(localArqConfig);

        // verifica se o arquivo existe, caso nao existir exibe uma msge
        File arquivo = pth.toFile();
        
        if (arquivo.isDirectory()) {

            return pth.toString();
        } else {

            return null;
        }
    }

}
