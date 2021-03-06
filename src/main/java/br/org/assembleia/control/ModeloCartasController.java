/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.control;

import br.org.assembleia.model.CartasModel;
import br.org.assembleia.model.MembroModel;
import br.org.assembleia.model.PessoasModel;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

/**
 *
 * @author andre
 */
public class ModeloCartasController {

    /**
     * Carrega o documento e extrai o conteudo do arquivo selecionado
     * @param documento 
     * @return  XWPFWordExtractor
     */
    public XWPFWordExtractor carregarModeloCarta(File documento) {

        XWPFWordExtractor extract = null;
        try {
            
            CartasModel mdl = new CartasModel();
            extract = mdl.lerDocumento(documento);
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Atenção - Erro ao tentar ler documento\n" + ex);
        }

        return extract;
    }

    
    /**
     * Metodo para gerar uma carta de recomendação apartir de modelo especifico
     * @param membro 
     * @return  boolean
     */
    public boolean gerarDocCartaRecomendacao(XWPFWordExtractor conteudoExtraido, PessoasModel membro){
        try {
            
            CartasModel cartaRecomendacao = new CartasModel();
            cartaRecomendacao.gerarDocCartaRecomendacao(conteudoExtraido, membro);
            return true;
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Algo deu errado, um erro foi recuperado no sistema\n" + ex);
            return false;
        }
    }
}
