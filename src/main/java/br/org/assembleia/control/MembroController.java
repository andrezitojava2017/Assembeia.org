/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.control;

import br.org.assembleia.dao.MembroDao;
import br.org.assembleia.model.MembroModel;
import java.util.List;

/**
 *
 * @author andre
 */
public class MembroController {

    /**
     * Chamada para o metodo DAO que faz gravação dos dados do novo membro
     * @param model
     * @return MembroModel
     */
    public MembroModel insertMembro(MembroModel model) {

        MembroModel membro = new MembroModel();
        return membro.insertMembro(model);

    }
    
    /**
     * Chamada para o metodo DAO que recupera uma lista de membros cadastrados
     * @return List<MembroModel>
     */
    public List<MembroModel> getListaMembro() {

        MembroModel membro = new MembroModel();
        return membro.getListaMembro();
        
    }
    
    /**
     * Recupera informações de um determinado membro
     * @param idMembro
     * @return MembroModel
     */
    public MembroModel getMembro(int idMembro){
        MembroModel md = new MembroModel().getMembro(idMembro);
        return md;
    }
}
