/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.testes.dao;

import br.org.assembleia.dao.SolicitacaoDao;
import br.org.assembleia.model.SolicitacaoModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


/**
 *
 * @author andre
 */
public class SaidasTeste {
    
    public static void main(String[] args) {
//        SaidasModel mdl = new SaidasModel();
//        System.out.println(mdl.formatarValores("0,12"));
        

        DateTimeFormatter frm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dta = LocalDate.parse("1990-07-31");
        System.out.println(frm.format(dta));
    }
}
