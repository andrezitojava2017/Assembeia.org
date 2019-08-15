/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.abstratas.Registro;
import br.org.assembleia.dao.SaidasDao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Andre
 */
@Entity
@Table(name = "tbl_saidas")
public class SaidasModel extends Registro {

    @Column(name = "tipo_saida")
    private String tipo_saida;

    @Column(name = "id_credor")
    private int idCredor;

    public int getIdCredor() {
        return idCredor;
    }

    public void setIdCredor(int idCredor) {
        this.idCredor = idCredor;
    }

    public String getTipo_saida() {
        return tipo_saida;
    }

    public void setTipo_saida(String tipo_saida) {
        this.tipo_saida = tipo_saida;
    }

    /**
     * Grava um registro de saida
     *
     * @param model
     * @return SaidasModel
     */
    public SaidasModel gravarSaida(SaidasModel model) {

        // formatar a data padrao yyyy-MM-dd
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ld = LocalDate.parse(model.getData(), fmt);

        model.setData(ld.toString());

        SaidasDao dao = new SaidasDao();
        SaidasModel retorno = dao.gravarRegistroSaida(model);
        return retorno;

    }

    /**
     * Recupera um determinado registro de saida para alteração
     *
     * @param identificador
     * @return SaidasModel
     */
    public SaidasModel getSaida(int identificador) {

        SaidasDao dao = new SaidasDao();
        SaidasModel saida = dao.recuperarRegParaAlteracao(identificador);

        return saida;

    }

    /**
     * Recupera uma lista de saidas
     *
     * @param competencia
     * @return SaidasModel
     */
    public List<SaidasModel> getListaSaidas(String competencia) {

        SaidasDao dao = new SaidasDao();
        List<SaidasModel> saidas = dao.getListaSaidas(competencia);

        return saidas;
    }

    /**
     * Atualiza dados de um registro de saida
     *
     * @param registro
     */
    public int updateRegistroSaida(SaidasModel registro) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(registro.data, format);

        registro.setData(data.toString());

        SaidasDao dao = new SaidasDao();
        int retorno = dao.updateRegistroSaida(registro);

        return retorno;
    }

    /**
     * Delete registro de saida
     *
     * @param registro
     * @return int
     */
    public int deleteRegistroSaida(SaidasModel registro) {
        
        SaidasDao dao = new SaidasDao();
        int retorno = dao.deleteRegistroSaida(registro);

        return retorno;
    }

}
