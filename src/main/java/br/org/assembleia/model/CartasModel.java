/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author andre
 */
public class CartasModel {

    public static String titulo = "TITULO PRINCIPAL DO DOCUMENTO";
    public static String subtitulo = "SUBITITULO DO DOCUMENTO";
    public static String paragrafo1 = "Primeiro paragrafo do documento P01";
    public static String paragrafo2 = "Segundo paragrafo do documento P02";
    public static String paragrafo3 = "Terceiro paragrafo do documento P03";
    public static String saida = "arquivo.docx";
    private static String pastaModeloCartas = "modeloCartas";

    public void criarDocoumentoWord() throws IOException {

        // cria o documento
        XWPFDocument document = new XWPFDocument();

        // cria paragrafo e formata
        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER); // define o alinahemnto do paragrafo

        //formata o estilo associado ao pagrafo
        XWPFRun titleRun = title.createRun();
        titleRun.setText(titulo);
        titleRun.setColor("009933");
        titleRun.setBold(true);
        titleRun.setFontFamily("Courier");
        titleRun.setFontSize(30);

        // cria um subtitulo
        XWPFParagraph subtitle = document.createParagraph();
        subtitle.setAlignment(ParagraphAlignment.CENTER);

        // formata o subtitulo
        XWPFRun subtitleRun = subtitle.createRun();
        subtitleRun.setText(subtitulo);
        subtitleRun.setColor("0000FF");
        subtitleRun.setFontSize(18);
        subtitleRun.setTextPosition(18);
        subtitleRun.setUnderline(UnderlinePatterns.DOT_DOT_DASH);

        try (FileOutputStream outs = new FileOutputStream(saida)) {
            document.write(outs);

        } catch (Exception ex) {
            Logger.getLogger(CartasModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            document.close();
        }
    }

    public void gerarDocCartaRecomendacao(XWPFWordExtractor extract, MembroModel membro) throws FileNotFoundException, IOException {

        // arquivo com o caminho a ser salvo
        FileOutputStream novoArquivo = new FileOutputStream(ConfiguracaoModel.diretorio
                + File.separator
                + "cartaRecomendacao"
                + File.separator
                + membro.getNome() + ".docx");

        // texto extratido do documento
        String textoDoc = extract.getText();

        // agora e realizado a troca de conteudo
        String replace = textoDoc.replace("<cidadeDestino>", "cidade destino");
        replace = replace.replace("<nomeMembro>", "JEDERSON ANDRE");
        replace = replace.replace("<dataBatismo>", "01/01/1990");
        replace = replace.replace("<estadoCivil>", "SOLTEIRO");
        replace = replace.replace("<identidade>", "1635210-6");

        String linhas[] = replace.split("\n");
        /*
            for (int i = 0; i < vet.length; i++) {
                System.out.println(vet[i]);
            }
         */
        // cria o documento
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph conteudoPrincipal = document.createParagraph();

        for (int i = 0; i < linhas.length; i++) {
            // cria paragrafo e formata
            XWPFParagraph novoConteudo = document.createParagraph();

            //title.setAlignment(ParagraphAlignment.LEFT); 
            //formata o estilo associado ao pagrafo
            XWPFRun conteudoRun = novoConteudo.createRun();
            conteudoRun.setText(linhas[i]);
            conteudoPrincipal.addRun(conteudoRun);
        }
        
        document.write(novoArquivo);

    }

    /**
     * Recupera o conteudo do documento fornecido no parametro, assim e possivel
     * a leitura para gerar um novo documento com os dados do membro etc;
     *
     * @param doc
     * @return XWPFWordExtractor
     */
    public XWPFWordExtractor lerDocumento(File caminho) throws IOException {

        XWPFWordExtractor extract = null;

        XWPFDocument read;
        read = new XWPFDocument(
                new FileInputStream(caminho));

        extract = new XWPFWordExtractor(read);

        return extract;
    }
}
