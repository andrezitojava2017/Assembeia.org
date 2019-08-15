/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.control;

import br.org.assembleia.model.ReciboModel;

/**
 *
 * @author andre
 */
public class Recibo_Control {

    
    
    /**
     * Faz a inserção de nova sequencia de recibo para um registro de entrada/saida
     * 
     * @return reciboGerado ReciboModel com o ID do ultimo recibo
     */
    public ReciboModel gravarRecibo() {

        ReciboModel model = new ReciboModel();
        ReciboModel NovoRecibo = model.gerarNovoRecibo();

        ReciboModel reciboGerado = model.salvarNovoRecibo(NovoRecibo);

        return reciboGerado;
    }
    
    
    /**
     * Recupera dados de um determinado recibo
     * @param identificador
     * @return ReciboModel
     */
    public ReciboModel getRecibo(int identificador){
         ReciboModel model = new ReciboModel();
         return model.getRecibo(identificador);        
        
    }

}
