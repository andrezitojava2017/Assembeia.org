/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.testes.dao;

import br.org.assembleia.dao.DizimoDao;
import br.org.assembleia.model.DizimoModel;
import java.time.LocalDate;
import org.exolab.castor.types.DateTime;

/**
 *
 * @author andre
 */
public class DizimoTest {
    
    public static void main(String[] args) {
        
        DizimoModel model = new DizimoModel();
        
        LocalDate dta = LocalDate.now();
        
        model.setIdDizimista(2);
        model.setIdEntrada(43);
        model.setIdMembroReceptor(1);
        model.setData(dta.toString());
        model.setCompetencia("09/2019");
        model.setDescricao("Teste de inserção");
        model.setRecibo(69);
        model.setSituacao("A");
        
        
        DizimoDao dao = new DizimoDao();
        dao.insertRegistroDizimo(model);
        
        
    }
    
}
