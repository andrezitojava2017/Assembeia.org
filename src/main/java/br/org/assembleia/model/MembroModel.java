/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.dao.MembroDao;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "tbl_membro")
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class MembroModel extends PessoasModel {

    public MembroModel() {
    }



    @Column(name = "data_admissao")
    private String dataPosse;

    @Column(name = "data_demissao")
    private String dataDemissao;


    @Column(name = "id_cargo")
    private int idCargo;


    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }


    public String getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(String dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

//    public String getCargo() {
//        return cargo;
//    }
//
//    public void setCargo(String cargo) {
//        this.cargo = cargo;
//    }

    public String getDataPosse() {
        return dataPosse;
    }

    public void setDataPosse(String dataPosse) {
        this.dataPosse = dataPosse;
    }

    /**
     * Chamada para o metodo DAO que faz gravação dos dados do novo membro
     *
     * @param model
     * @return MembroModel
     */
    public MembroModel insertMembro(MembroModel model) {

        MembroDao dao = new MembroDao();
        return dao.insertMembro(model);

    }

    /**
     * Chamada para o metodo DAO que recupera uma lista de membros cadastrados
     *
     * @return List<MembroModel>
     */
    public List<MembroModel> getListaMembro() {

        MembroDao dao = new MembroDao();
        return dao.getListaMembro();

    }
}
