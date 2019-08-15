/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.abstratas.Pessoas;
import br.org.assembleia.dao.PessoasDao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "tbl_pessoas")
public class PessoasModel extends Pessoas {

    /**
     * Recupera dados de uma determinada pessoa
     *
     * @param identificador
     * @return PessoasModel
     */
    public PessoasModel getPessoa(int identificador) {

        PessoasModel pessoa = new PessoasModel();
        PessoasDao dao = new PessoasDao();

        pessoa = dao.getPessoa(identificador);
        
        /* formatamos o a data nascimento para exibicao no formulario */
        pessoa.setDataNascimento(formatarDataPadraoExibicao(pessoa.getDataNascimento()));
        
        return pessoa;

    }

    /**
     * Recupera uma lista de pessoas cadastradas
     *
     * @return List<PessoasModel>
     */
    public List<PessoasModel> getListaPessoas() {

        PessoasDao dao = new PessoasDao();
        List<PessoasModel> lista = dao.getListaPessoas();

        return lista;
    }

    /**
     * Modifica a coluna situacao para I- INATIVO
     *
     * @param pessoas
     * @return int
     */
    public int deletePessoas(PessoasModel pessoas) {

        PessoasDao dao = new PessoasDao();
        return dao.deletePessoa(pessoas);

    }

    /**
     * Faz a inserção de uma pessoa na base de dados
     *
     * @param model
     * @return PessoasModel
     */
    public PessoasModel insertPessoasModel(PessoasModel model) {
        
        PessoasDao dao = new PessoasDao();
        PessoasModel get;

        if (model.getSexo().equals("MASCULINO")) {
            model.setSexo("M");
        } else {
            model.setSexo("F");
        }
        
        /* formata DN para o padrao de banco de dados */
        model.setDataNascimento(formatarDataPadraoBancoDados(model.getDataNascimento()));

        /* faz inserção na base */
        get = dao.insertPessoaModel(model);

        return get;
    }

    /**
     * Atualiza dados de um cadastro de pessoa
     *
     * @param model
     * @return PessoasModel
     */
    public int updatePessoa(PessoasModel model) {

        /* formatando a data para o padrao yyyy-MM-dd */
        model.setDataNascimento(formatarDataPadraoBancoDados(model.getDataNascimento()));

        
        String replac[] = {"(", ")", "-"};

        /* Laco para retirar os () e - */
        for (String replac1 : replac) {
            model.setCelular(model.getCelular().replace(replac1, ""));
            model.setTelefone(model.getTelefone().replace(replac1, ""));
        }
        
        /* Definindo genero */
        if (model.getSexo().equalsIgnoreCase("Masculino")) {
            model.setSexo("M");
        } else {
            model.setSexo("F");
        }

        /* atualizando dados */
        PessoasDao dao = new PessoasDao();
        int getUpdate = dao.updatePessoa(model);

        return getUpdate;
    }

    /**
     * Formata a data para o padrao aceito pelo banco de dados- yyyy-MM-dd
     *
     * @param data
     * @return String
     */
    private String formatarDataPadraoBancoDados(String data) {

        DateTimeFormatter frm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, frm).toString();
    }
    
    
    /**
     * Formata a data para o padrao de exibicao no formulario- dd/MM/yyyy
     * @param data
     * @return String
     */
    private String formatarDataPadraoExibicao(String data){
        DateTimeFormatter frm = DateTimeFormatter.ofPattern("ddMMyyyy");
        return frm.format(LocalDate.parse(data));
    }
}
