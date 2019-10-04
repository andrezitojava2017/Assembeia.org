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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public void lerDocumentoWord() {
        
        try {
            XWPFDocument read = new XWPFDocument(
                    new FileInputStream(
                            new File(saida)));
            
            XWPFWordExtractor extract = new XWPFWordExtractor(read);
            System.out.println(extract.getText());
            
            String txt = extract.getText();
            String car[] = txt.split(" ");
            
            for (String car1 : car) {
                if ("documento".equalsIgnoreCase(car1)) {
                    System.out.println("PALAVRA CAPTURADA: DOCUMENTO");
                } else {
                    System.out.println("NAO ENCONTRADO");
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CartasModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CartasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
