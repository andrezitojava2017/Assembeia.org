/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.testes.dao;

import br.org.assembleia.model.CartasModel;
import br.org.assembleia.model.ConfiguracaoModel;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class GerarCartaTest {

    public static void main(String[] args) {


        ConfiguracaoModel cfg = new ConfiguracaoModel();
        System.out.println("caminho documento: " + cfg.diretorio);

        CartasModel carta = new CartasModel();

        JFileChooser buscar = new JFileChooser();
        int showOpenDialog = buscar.showOpenDialog(null);

        if (showOpenDialog == 0) {
            File doc = buscar.getSelectedFile();
            if(doc.exists()){
//                String textoDoc = carta.lerDocumento(doc);
//                String vetor[] = textoDoc.split("\n");
//                
//                for (int i = 0; i < vetor.length; i++) {
//                    System.out.println(vetor[i]);
//                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Error - Arquivo não encontrato!!");
            }
        }

    }
}
