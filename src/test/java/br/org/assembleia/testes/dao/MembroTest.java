/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.testes.dao;

import br.org.assembleia.dao.MembroDao;
import br.org.assembleia.model.MembroModel;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author andre
 */
public class MembroTest {
    
    public static void main(String[] args) {
        
        MembroModel membro = new MembroModel();
//        membro.setId_pessoa(1);
//        membro.setIdCargo(1);
//        membro.setDataPosse("2019-08-27");
//        
//        MembroDao dao = new MembroDao();
//        int insertMembro = dao.insertMembro(membro);
//        System.out.println(insertMembro);

//        MembroDao dao = new MembroDao();
//        List<MembroModel> listaMembro = dao.getListaMembro();
//        for (MembroModel mdl : listaMembro) {
//            System.out.println(mdl.getId() + " " + mdl.getNome() + " " + mdl.getDataPosse());
//        }

////membro.formatarDataView("2019-09-27");
//
//        LocalDate dat = LocalDate.now();
//        System.out.println(dat.toString());

MembroDao dao = new MembroDao();
        MembroModel membro1 = dao.getMembro(4);
        
        System.out.println(membro1.getNome());
        System.out.println(membro1.getId_pessoa());
        
    }
    
}
