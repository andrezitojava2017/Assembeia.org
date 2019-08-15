/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.abstratas.Registro;
import br.org.assembleia.dao.EntradasDao;
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
@Table(name = "tbl_entrada")
public class EntradasModel extends Registro {

    @Column(name = "tipo_entrada")
    private String tipo_entrada;
    

    /**
     * Metodo construtor vazio
     */
    public EntradasModel() {
    }

    public String getTipo_entrada() {
        return tipo_entrada;
    }

    public void setTipo_entrada(String tipo_entrada) {
        this.tipo_entrada = tipo_entrada;
    }
    
    
    /**
     * Faz a inserção da entrada na base de dados
     * @param entrada EntradasModel
     * @return identificador - ID deste lançamento
     */
    public int GravarRegistroEntrada(EntradasModel entrada){
        
        // formatar a data padrao yyyy-MM-dd
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ld = LocalDate.parse(entrada.getData(), fmt);
        
        // setendo data no formato aceito pelo mysql
        entrada.setData(ld.toString());
        
        EntradasDao dao = new EntradasDao();
        int identificador = dao.gravarRegistroEntrada(entrada);
        
        return identificador;
    }
    
    
    /**
     * Recupera um determinado registro da tabela de entradas,podendo ser 
     * atualizados
     * @param identificador id a ser recuperado
     * @return entrada - EntradasModel
     */
    public EntradasModel recuperarRegistroEntrada(int identificador){
        
        EntradasModel entrada = null;
        
        EntradasDao dao = new EntradasDao();
        entrada = dao.capturarRegParaAlteracao(identificador);
        
        return entrada;
        
    }
    
    
    /**
     * Recupera os registros de entradas de uma determinada competencia
     * informada pelo usuario
     * @param competencia
     * @return Lis<EntradaModel> model
     */
    public List<EntradasModel> recuperarListaRegistrosEntradas(String competencia){
        
        List<EntradasModel> model = null;
        
        EntradasDao dao = new EntradasDao();
        model = dao.capturarRegistrosEntradas(competencia);
        
        return model;
        
    }

    /**
     * Atualiza um lançamento/registro de entrada
     * @param entrada 
     */
    public int atualizarRegistroEntrada(EntradasModel entrada){
        
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");  // formato que esta vindo a data
        LocalDate dat = LocalDate.parse(entrada.getData(), f); // aqui o parse transforma no padrao yyyy-MM-dd
        entrada.setData(dat.toString());
        EntradasDao dao = new EntradasDao();
        int retorno = dao.atualizarRegEntrada(entrada);
        return retorno;
    }
    
    
    /**
     * Exclui registro de entrada pelo id fornecido
     * @param model 
     */
    public void deletarRegistroEntrada(EntradasModel model){
        EntradasDao dao = new EntradasDao();
        dao.deletarRegEntrada(model);
    }
}
