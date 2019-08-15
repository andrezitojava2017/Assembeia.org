/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.testes.dao;

import br.org.assembleia.dao.EntradasDao;
import br.org.assembleia.model.EntradasModel;
import br.org.assembleia.model.TipoEntradaModel;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class EntradaTeste {
    
    public static void main(String[] args) {
        
        EntradasModel entrada = new EntradasModel();
        entrada.setData("27/07/2019");
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dat = LocalDate.parse(entrada.getData(), f);
        
        entrada.setData(dat.toString());
        
        System.out.println("DAta: " + entrada.getData());
        
    }
}
