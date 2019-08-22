/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.testes.dao;

import br.org.assembleia.dao.MembroDao;
import br.org.assembleia.model.MembroModel;

/**
 *
 * @author andre
 */
public class MembroTest {
    
    public static void main(String[] args) {
        
        MembroModel membro = new MembroModel();
        membro.setId_pessoa(1);
        //membro.setIdCargo(1);
        membro.setDataPosse("2019-08-20");
        membro.setSituacao("A");
        
        MembroDao dao = new MembroDao();
        MembroModel insertMembro = dao.insertMembro(membro);
        
    }
    
}
