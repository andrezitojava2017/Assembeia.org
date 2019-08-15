/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.abstratas.Pessoas;
import java.util.Date;

/**
 *
 * @author andre
 */
public class MembroModel extends Pessoas{
    
    private String cargo;
    private Date dataPosse;
    private Date dataDemissao;
    private String situacao;


    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getDataPosse() {
        return dataPosse;
    }

    public void setDataPosse(Date dataPosse) {
        this.dataPosse = dataPosse;
    }
    
}
