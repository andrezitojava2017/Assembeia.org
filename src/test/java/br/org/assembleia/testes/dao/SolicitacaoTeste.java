/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.testes.dao;

import br.org.assembleia.dao.SolicitacaoDao;
import br.org.assembleia.model.SolicitacaoModel;

/**
 *
 * @author andre
 */
public class SolicitacaoTeste {
    
    public static void main(String[] args) {
        
        
        SolicitacaoDao dao = new SolicitacaoDao();
        SolicitacaoModel model = new SolicitacaoModel().gerarNovaSolicitacao();
        
    }
    
}
