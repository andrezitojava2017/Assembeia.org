/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.dao.MembroDao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author andre
 */
public class MembroModel extends PessoasModel {

    public MembroModel() {
    }

    private int id;

    private String dataPosse;

    private String dataDemissao;

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



    public int getId() {

        return id;

    }

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Formata datas para o padrao aceito pelo MYSQL
     *
     * @param membro
     * @return
     */
    private String formatarDataMysql(MembroModel membro) {

        DateTimeFormatter frm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(membro.getDataPosse(), frm);

        return date.toString();

    }
    
    /**
     * Formata a data para ser exibido na view
     * @param data
     * @return String
     */
    private String formatarDataView(String data){
        
        DateTimeFormatter frm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dat = LocalDate.parse(data);
//        System.out.println(frm.format(dat));
        return frm.format(dat);
    }
    
    /**
     * Chamada para o metodo DAO que faz gravação dos dados do novo membro
     *
     * @param model
     * @return MembroModel
     */
    public int insertMembro(MembroModel model) {
        MembroDao dao = new MembroDao();

        model.setDataPosse(
                //formata a data
                formatarDataMysql(model)
        );
        return dao.insertMembro(model);
    }

    /**
     * Chamada para o metodo DAO que recupera uma lista de membros cadastrados
     *
     * @return List<MembroModel>
     */
    public List<MembroModel> getListaMembro() {

        MembroDao dao = new MembroDao();
//        return dao.getListaMembro();
        List<MembroModel> membro = dao.getListaMembro();
        
        // iremos formatar a data para ser exibida na view, se necessário
        for (int i = 0; i < membro.size(); i++) {
            String data = formatarDataView(
                            membro.get(i).getDataPosse());
            membro.get(i).setDataPosse(data);
        }
        return membro;
    }

    /**
     * Recupera informações de um determinado membro
     *
     * @param idMembro
     * @return MembroModel
     */
    public MembroModel getMembro(int idMembro) {
        MembroDao md = new MembroDao();
        MembroModel membro = md.getMembro(idMembro);
        return membro;
    }
    
    /**
     * Desativa um membro do cadastro
     * @param membro 
     */
    public int desativarMembro(MembroModel membro){
        
        MembroDao dao = new MembroDao();
        membro.setDataPosse(formatarDataMysql(membro));
        return dao.desativarMembro(membro);
        
    }
    
    /**
     * Autalizar cadastro de membro
     * @param membro
     * @return int
     */
    public int updateMembro(MembroModel membro){
                
        MembroDao dao = new MembroDao();
        membro.setDataPosse(formatarDataMysql(membro));
        return dao.updateMembro(membro);
    }
}
