/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.dao.CargosDao;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "tbl_cargos")
public class CargosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int identificador;

    @Column(name = "nome_cargo")
    private String cargo;

    /**
     * Construct vazio
     */
    public CargosModel() {

    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Recupera uma lista de cargos ativos
     *
     * @return List<CargosModel>
     */
    public List<CargosModel> getListaCargos() {

        CargosDao dao = new CargosDao();
        return dao.getListaCargos();

    }

    /**
     * Criação de novo cargos
     *
     * @param cargo
     */
    public CargosModel insertCargo(CargosModel cargo) {

        CargosDao dao = new CargosDao();
        return dao.insertCargo(cargo);

    }

}
