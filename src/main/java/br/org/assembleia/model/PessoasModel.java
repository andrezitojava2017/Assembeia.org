/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.dao.PessoasDao;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
@Table(name = "tbl_pessoas")
public class PessoasModel implements Serializable {

    public PessoasModel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_pessoa;

 
     @Column
    private String nome;
    
    @Column
    protected String identidade;
    
    @Column
    protected String cpf;
    
    @Column
    protected String data_cadastro;
    
    @Column
    protected String naturalidade;

    @Column
    protected String nacionalidade;
    
    @Column(name="data_nascimento")
    protected String dataNascimento;
    
    @Column(name="genero")
    protected String sexo;
    
    @Column(name = "estado_civil")
    protected String estadoCivil;
    
    @Column
    protected String conjuge;
    
    @Column(name = "data_casamento")
    protected String dataCasamento;
    
    @Column
    protected String escolaridade;
    
    @Column(name = "nome_pai")
    protected String nomePai;
    
    @Column(name = "nome_mae")
    protected String nomeMae;
    
    @Column(name = "data_batismo")
    protected String dataBatismo;
    
    @Column
    protected String situacao;
    
    @Column
    protected String endereco;
    
    @Column
    protected String numero;
    
    @Column
    protected String bairro;
    
    @Column
    protected String cidadeEndereco;
    
    @Column
    protected String estadoEndereco;
    
    @Column
    protected String celular;
    
    @Column
    protected String telefone;
    
    @Column
    protected String email;

    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidadeEndereco;
    }

    public void setCidade(String cidade) {
        this.cidadeEndereco = cidade;
    }

    public String getEstadoEndereco() {
        return estadoEndereco;
    }

    public void setEstadoEndereco(String estadoEndereco) {
        this.estadoEndereco = estadoEndereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
    
    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }
    public String getDataBatismo() {
        return dataBatismo;
    }

    public void setDataBatismo(String dataBatismo) {
        this.dataBatismo = dataBatismo;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getConjuge() {
        return conjuge;
    }

    public void setConjuge(String conjuge) {
        this.conjuge = conjuge;
    }

    public String getDataCasamento() {
        return dataCasamento;
    }

    public void setDataCasamento(String dataCasamento) {
        this.dataCasamento = dataCasamento;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }


    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }
    
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
     *
     * @param data
     * @return String
     */
    private String formatarDataPadraoExibicao(String data) {
        DateTimeFormatter frm = DateTimeFormatter.ofPattern("ddMMyyyy");
        return frm.format(LocalDate.parse(data));
    }
}
