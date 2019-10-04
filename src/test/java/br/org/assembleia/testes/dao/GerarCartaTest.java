/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.testes.dao;

import br.org.assembleia.model.CartasModel;
import br.org.assembleia.model.ConfiguracaoModel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class GerarCartaTest {
    
    public static void main(String[] args) {
        
        //CartasModel carta = new CartasModel();
        //carta.criarDocoumentoWord();
        //carta.lerDocumentoWord();
        
        ConfiguracaoModel cfg = new ConfiguracaoModel();
        System.out.println(cfg.diretorio);
    }
}
