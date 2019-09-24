/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.testes.dao;

import br.org.assembleia.dao.SaidasDao;
import br.org.assembleia.model.SaidasModel;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class SaidasTeste {
    
    public static void main(String[] args) {
        try {
            DecimalFormat fr = new DecimalFormat("###,##0.00");
            fr.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            
            System.out.println(fr.parse("30000,25").toString());
        } catch (ParseException ex) {
            Logger.getLogger(SaidasTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
