/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.view;

import br.org.assembleia.control.dizimo_control;
import br.org.assembleia.control.SaidasController;
import br.org.assembleia.control.registro_entrada_control;
import br.org.assembleia.dao.EntradasDao;
import br.org.assembleia.model.DizimoModel;
import br.org.assembleia.model.TipoRegistro;
import br.org.assembleia.model.SaidasModel;
import java.util.List;

/**
 *
 * @author Andre
 */
public class form_imprimir_relatorios extends javax.swing.JDialog {

    private String optRelatorio;

    /**
     * Creates new form form_imprimir_relatorios
     */
    public form_imprimir_relatorios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        group.add(radioDizimo);
        group.add(radioEntrada);
        group.add(radioSaida);
        this.optRelatorio = optRelatorio;
    }

    public form_imprimir_relatorios(java.awt.Frame parent, boolean modal, TipoRegistro optRelatorio) {
        super(parent, modal);
        initComponents();
        group.add(radioDizimo);
        group.add(radioEntrada);
        group.add(radioSaida);
        this.optRelatorio = optRelatorio.toString();
       // System.out.println(this.optRelatorio);
        habilitarRadios();
    }

    /**
     * Habilita os radios buttons conforme o formulario que chamou a tela de
     * impressão
     */
    private void habilitarRadios() {

        //verificamos a string passada no construtor para habilitarmos os radio necessarios
        switch (optRelatorio) {

            case "TIPO_ENTRADA":
                radioEntrada.setEnabled(true);
                carregarCompetenciasTblEntradas(); // preenche o combo com as competencias
                radioEntrada.setSelected(true);
                break;

            case "TIPO_SAIDA":
                radioSaida.setEnabled(true);
                carregarCompetenciasTblSaidas();
                radioSaida.setSelected(true);
                break;

            case "TIPO_DIZIMO":
                radioDizimo.setEnabled(true);
                carregarCompetenciasTblDizimo();
                radioDizimo.setSelected(true);
                break;
        }

    }

    /**
     * Faz o preenchimento do comboCompetencias com registros recuperados da
     * base de dados da tabela entrada
     */
    private void carregarCompetenciasTblEntradas() {
/*
        registro_entrada_control control = new registro_entrada_control();
//        List<String> competencias = control.recuperarCompetenciasEntrada();

        //limpando o comboCompetencias
        comboCompetencias.removeAllItems();

        //preenchendo o combo
        for (String competencia : competencias) {
            comboCompetencias.addItem(competencia);
        }
*/
    }

    /**
     * Faz o preenchimento do combo com registros recuperados da base de dados
     * da tabela de saidas
     */
    private void carregarCompetenciasTblSaidas() {
       /*
        SaidasController control = new SaidasController();
        List<SaidasModel> competencias = control.

        //limpando comboCompetencias
        comboCompetencias.removeAllItems();

        //preenche o combo
        for (SaidasModel competencia : competencias) {
//            comboCompetencias.addItem(competencia.getCompetencia());
        }
        */
    }

    /**
     * Faz o preenchimento do comboCompetencias com registro recuperado da base
     * de dados da tabela de dizimos
     */
    private void carregarCompetenciasTblDizimo() {
//        dizimo_control control = new dizimo_control();
//        List<DizimoModel> competencias = control.recuperarCompetenciasDizimos();
//
//        //limpa combo competencias
//        comboCompetencias.removeAllItems();
//
//        //preenche o combo
//        for (DizimoModel competencia : competencias) {
//            comboCompetencias.addItem(competencia.getCompetencia());
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campo_competencia = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        radioEntrada = new javax.swing.JRadioButton();
        radioSaida = new javax.swing.JRadioButton();
        radioDizimo = new javax.swing.JRadioButton();
        btn_imprimir = new javax.swing.JButton();
        brn_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Imprimir Relatorio");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("DejaVu Sans Light", 0, 14)); // NOI18N
        jLabel1.setText("Competencia desejada:");

        try {
            campo_competencia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(campo_competencia, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_competencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("DejaVu Sans Light", 0, 14)); // NOI18N
        jLabel2.setText("Tipo de lançamento:");

        radioEntrada.setText("Entradas");
        radioEntrada.setEnabled(false);

        radioSaida.setText("Saidas");
        radioSaida.setEnabled(false);

        radioDizimo.setText("Dizimos");
        radioDizimo.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(radioEntrada)
                        .addGap(18, 18, 18)
                        .addComponent(radioSaida)
                        .addGap(18, 18, 18)
                        .addComponent(radioDizimo))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel2)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioEntrada)
                    .addComponent(radioSaida)
                    .addComponent(radioDizimo))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        btn_imprimir.setText("Imprimir");
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });

        brn_cancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btn_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(brn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_imprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(brn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        if(radioEntrada.isSelected()){
            registro_entrada_control control = new registro_entrada_control();
           // System.out.println("ITEM SELECIONADO: " + comboCompetencias.getSelectedItem().toString());
            control.abrirRelatorioEntradasMensais(campo_competencia.getText());
            
        }
    }//GEN-LAST:event_btn_imprimirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(form_imprimir_relatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_imprimir_relatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_imprimir_relatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_imprimir_relatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                form_imprimir_relatorios dialog = new form_imprimir_relatorios(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brn_cancelar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JFormattedTextField campo_competencia;
    private javax.swing.ButtonGroup group;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton radioDizimo;
    private javax.swing.JRadioButton radioEntrada;
    private javax.swing.JRadioButton radioSaida;
    // End of variables declaration//GEN-END:variables
}
