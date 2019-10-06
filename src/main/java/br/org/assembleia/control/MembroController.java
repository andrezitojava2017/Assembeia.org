/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.control;

import br.org.assembleia.dao.MembroDao;
import br.org.assembleia.model.MembroModel;
import br.org.assembleia.model.Relatorios_Model;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author andre
 */
public class MembroController {

    /**
     * Chamada para o metodo DAO que faz gravação dos dados do novo membro
     *
     * @param model
     * @return MembroModel
     */
    public int insertMembro(MembroModel model) {

        MembroModel membro = new MembroModel();
        return membro.insertMembro(model);

    }

    /**
     * Chamada para o metodo DAO que recupera uma lista de membros cadastrados
     *
     * @return List<MembroModel>
     */
    public List<MembroModel> getListaMembro() {

        MembroModel membro = new MembroModel();
        return membro.getListaMembro();

    }

    /**
     * Recupera informações de um determinado membro
     *
     * @param idMembro
     * @return MembroModel
     */
    public MembroModel getMembro(int idMembro) {
        MembroModel md = new MembroModel().getMembro(idMembro);
        return md;
    }

    /**
     * Desativa cadastro de membro
     * @param membro
     * @return 
     */
    public int desativarMembro(MembroModel membro) {
        MembroModel mdl = new MembroModel();
        return mdl.desativarMembro(membro);
    }

    /**
     * Atualizar cadastro de membro
     * @param membro
     * @return 
     */
    public int updateMembro(MembroModel membro) {
        MembroModel mdl = new MembroModel();
        return mdl.updateMembro(membro);
    }
    
    /**
     * Gera relatorio com informações de membros ativos no sistema
     */
    public void gerarRelatorioMembrosAtivos(){
        try {
            Relatorios_Model model = new Relatorios_Model();
            model.relatorioMembrosAtivos();
        } catch (SQLException | JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar relatorio com membros ativos\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Gera carteirinha de identificação de membro ativos
     * @param idMembro 
     */
    public void gerarCarteiraMembro(int idMembro){
        
        try {
            Relatorios_Model model = new Relatorios_Model();
            model.gerarCarteirasMembro(idMembro);
        } catch (SQLException | JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar carteirinha do membro selecionado\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
