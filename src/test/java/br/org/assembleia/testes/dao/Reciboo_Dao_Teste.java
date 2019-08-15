/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.testes.dao;

import br.org.assembleia.control.Recibo_Control;
import br.org.assembleia.dao.Recibo_Dao;
import br.org.assembleia.model.ReciboModel;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author andre
 */
public class Reciboo_Dao_Teste {

    public static void main(String[] args) {

        Recibo_Dao dao = new Recibo_Dao();
        ReciboModel recibo = dao.recuperarUlitmoIdRecibo();
        
        Recibo_Control rc = new Recibo_Control();
        ReciboModel novo = rc.gravarRecibo();

        System.out.println("ID: " + novo.getIdRecibo() + " - ANO-SEQUENCIA: " + novo.getAnoRecibo() + "-" + novo.getSequencia());

    }

}
