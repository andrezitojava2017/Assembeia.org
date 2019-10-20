/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.enumerador;

import java.io.File;

/**
 *
 * @author andre
 */
public enum CartasModelo {
    
    RECOMENDACAO("modeloRecomendacao.docx"), VIAGEM("modeloViagem.docx");
    
    private String modelo;
    
    CartasModelo(String modelo){
        this.modelo = File.separator + modelo;
    }
    
    public String getCartaModelo(){
        return this.modelo;
    }
}
