/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.abstratas.TiposModel;
import br.org.assembleia.dao.EntradasDao;
import br.org.assembleia.dao.TipoEntradasDao;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "tbl_tipo_entradas")
public class TipoEntradaModel extends TiposModel {

    /**
     * Construtor vazio
     */
    public TipoEntradaModel() {
    }
    

     /**
     * captura dados da tabela de tipos de entradas tipos: Dizimo, Ofertas,
     * coleta CIBE, etc...
     *
     * @return List<TiposModel>
     */
    public List<TipoEntradaModel> getListaTiposEntradas() {
        
        TipoEntradasDao dao = new TipoEntradasDao();
        List<TipoEntradaModel> lista = dao.getListaTipos();
        return lista;
        
    }
    
    /**
     * Chama o metodo da classe DAO para inserção de novo registro do TIPO ENTRADA
     * @param model
     * @return int
     */
    public int insertTipoEntrada(TipoEntradaModel model){
        
        TipoEntradasDao dao = new TipoEntradasDao();
        return dao.insertTipoEntrada(model);
        
    }
    
}
