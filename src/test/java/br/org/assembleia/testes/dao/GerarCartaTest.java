/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.testes.dao;

import br.org.assembleia.enumerador.CartasModelo;
import br.org.assembleia.enumerador.DiretorioPadrao;
import br.org.assembleia.model.CartasModel;
import br.org.assembleia.model.ConfiguracaoModel;
import br.org.assembleia.model.MembroModel;
import br.org.assembleia.model.PessoasModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class GerarCartaTest {

    public static void main(String[] args) {

        PessoasModel membro = new PessoasModel();
        membro.setDataBatismo("1990-08-30");
        DateTimeFormatter frm = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy");
        LocalDate dta = LocalDate.parse(membro.getDataBatismo());
        
        System.out.println(frm.format(dta));
    }
}
