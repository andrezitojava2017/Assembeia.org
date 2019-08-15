/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.testes.dao;

import br.org.assembleia.dao.SaidasDao;
import br.org.assembleia.model.SaidasModel;

/**
 *
 * @author andre
 */
public class SaidasTeste {
    
    public static void main(String[] args) {
        
        SaidasModel model= new SaidasModel();
        
        model.setData("03/08/2019");
        
        model.updateRegistroSaida(model);
        
    }
}
