/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.dao;

import br.org.assembleia.conexao.ConexaoJpa;
import br.org.assembleia.model.EntradasModel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class EntradasDao {


    private EntityManagerFactory managerFactory;
    private EntityManager EntityManager;

    /**
     * Insere novo registro de entradas na base de dados
     *
     * @param model EntradasModel
     * @return 
     */
    public int gravarRegistroEntrada(EntradasModel model) {

        managerFactory = new ConexaoJpa().getConexao("assembleia");
        EntityManager = managerFactory.createEntityManager();
        try {

            EntityManager.getTransaction().begin();
            EntityManager.persist(model);
            EntityManager.getTransaction().commit();
            //System.out.println("ID RECUPERADO: " + model.getIdentificador());

        } catch (Exception e) {
            e.printStackTrace();
            EntityManager.getTransaction().rollback();
        } finally {

            if (model.getIdentificador() != 0) {
                return model.getIdentificador();
            }
            EntityManager.close();
            managerFactory.close();
        }
        return 0;

    }

//    /**
//     * captura dados da tabela de tipos de entradas tipos: Dizimo, Ofertas,
//     * coleta CIBE, etc...
//     *
//     * @return List<TiposModel>
//     */
//    public List<TipoEntradaModel> carregaTpEntrada() {
//
//        List<TipoEntradaModel> lista = new ArrayList<>();
//
//        try {
//
//            managerFactory = new ConexaoJpa().getConexao("assembleia");
//            EntityManager = managerFactory.createEntityManager();
//            Query query = EntityManager.createQuery("FROM TipoEntradaModel tp");
//            lista = query.getResultList();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro na tentativa de recuperar os TIPOS de Registros\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
//        } finally {
//            EntityManager.close();
//            managerFactory.close();
//        }
//
//        return lista;
//    }

   

   
    /**
     * recupera lancamentos da tabela entrada, para preencher formulario de
     * alteração
     *
     * @param competencia
     * @return List<reg_entradas_model>
     */
    public List<EntradasModel> capturarRegistrosEntradas(String competencia) {

        List<EntradasModel> registros = new ArrayList<>();

        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            Query query = EntityManager.createQuery("SELECT em FROM EntradasModel em where em.competencia='" + competencia + "' AND em.situacao='A'", EntradasModel.class);
            registros = query.getResultList();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de recuperar os registros da competencia informada!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            EntityManager.close();
            managerFactory.close();
        }

        return registros;
    }

    /**
     * Metodo que recupera as informações de um determinado registro de Entrada
     * Utilizado para preencher o formulario quando solicitado para alteração
     *
     * @param id_selecionado
     * @return Object reg_entrada_model
     */
    public EntradasModel capturarRegParaAlteracao(int id_selecionado) {

        EntradasModel registro = new EntradasModel();

        try {

            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            registro = EntityManager.find(EntradasModel.class, id_selecionado);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na tentativa de recuperar registros selecionado\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            EntityManager.close();
            managerFactory.close();
        }

        return registro;
    }

    /**
     * Metodo de atualização de um determinado registro da tabela de entrada
     *
     * @param entrada
     * @param tipo_entrada
     */
    public int atualizarRegEntrada(EntradasModel entrada) {

        int retorno = 0;
        try {
            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();

            EntityManager.getTransaction().begin();
            EntityManager.merge(entrada);
            EntityManager.getTransaction().commit();

            return retorno = 1;

        } catch (Exception ex) {
            EntityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ops...erro na tentativa de atualização de registro\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            EntityManager.close();
            managerFactory.close();
        }

        return retorno;

    }

    /**
     * metodo para deletar registros da tabela de entrada
     *
     * @param id_registro
     */
    public void deletarRegEntrada(EntradasModel model) {

        try {
            
            managerFactory = new ConexaoJpa().getConexao("assembleia");
            EntityManager = managerFactory.createEntityManager();
            EntityManager.getTransaction().begin();
            EntityManager.merge(model);
            EntityManager.getTransaction().commit();
            

        } catch (Exception ex) {
            EntityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ops...erro na tentativa de deletar registro\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            EntityManager.close();
            managerFactory.close();
        }

    }

}
