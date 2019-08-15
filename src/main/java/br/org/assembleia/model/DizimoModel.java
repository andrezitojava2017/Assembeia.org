/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.abstratas.Pessoas;
import br.org.assembleia.abstratas.Registro;

/**
 *
 * @author Andre
 */
public class DizimoModel extends Registro{
    
    private Pessoas pessoa;
    private int id_dizimo;

    public int getId_dizimo() {
        return id_dizimo;
    }

    public void setId_dizimo(int id_dizimo) {
        this.id_dizimo = id_dizimo;
    }

    public Pessoas getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }
}
