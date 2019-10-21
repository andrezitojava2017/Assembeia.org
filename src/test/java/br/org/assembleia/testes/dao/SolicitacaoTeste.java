/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.testes.dao;

import br.org.assembleia.abstratas.Relatorio;
import br.org.assembleia.dao.SolicitacaoDao;
import br.org.assembleia.enumerador.DiretorioPadrao;
import br.org.assembleia.model.SolicitacaoModel;
import java.io.File;

/**
 *
 * @author andre
 */
public class SolicitacaoTeste {
    
    public static void main(String[] args) {
        
        
        String d = DiretorioPadrao.SUB_DIR_RELATORIO.getDiretorioPadrao() + File.separator + "tete" + ".jasper";
        
        System.out.println(d);
    }
    
}
