/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.testes.dao;

import br.org.assembleia.model.DizimoModel;
import br.org.assembleia.model.EntradasModel;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author andre
 */
public class DizimoTest {
    
    public static void main(String[] args) {
        
        EntradasModel md = new EntradasModel();
        try {
            System.out.println(md.formatarValores("12.50"));
        } catch (ParseException ex) {
            Logger.getLogger(DizimoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
