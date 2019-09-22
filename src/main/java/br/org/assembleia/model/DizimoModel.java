/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.model;

import br.org.assembleia.abstratas.Registro;
import br.org.assembleia.dao.DizimoDao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Andre
 */
@Entity
@Table(name = "tbl_dizimos")
public class DizimoModel extends Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int identificador;

    @Column(name = "id_membro_responsavel")
    private int idMembroReceptor;

    @Column(name = "id_membro_dizimista")
    private int idDizimista;

    @Column(name = "id_entrada")
    private int idEntrada;


    /**
     * Construtor
     */
    public DizimoModel() {

    }


    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getIdMembroReceptor() {
        return idMembroReceptor;
    }

    public void setIdMembroReceptor(int idMembroReceptor) {
        this.idMembroReceptor = idMembroReceptor;
    }

    public int getIdDizimista() {
        return idDizimista;
    }

    public void setIdDizimista(int idDizimista) {
        this.idDizimista = idDizimista;
    }

    /**
     * Formata a data em um padrao aceito pelo banco mysql
     *
     * @param data
     * @return String
     */
    private String formatarDatas(String data) {

        DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dta = LocalDate.parse(data, frmt);

        return dta.toString();
    }

    
    /**
     * Insert de registro na tabel especiica de DIZIMOS
     * @param registro
     * @return 
     */
    public DizimoModel insertRegistroDizimo(DizimoModel registro) {

        DizimoDao dao = new DizimoDao();
        return dao.insertRegistroDizimo(registro);
        
    }
}
