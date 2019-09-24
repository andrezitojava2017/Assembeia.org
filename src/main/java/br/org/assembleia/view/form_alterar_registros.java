/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.view;

import br.org.assembleia.control.SaidasController;
import br.org.assembleia.control.registro_entrada_control;
import br.org.assembleia.dao.EntradasDao;
import br.org.assembleia.model.TipoRegistro;
import br.org.assembleia.model.EntradasModel;
import br.org.assembleia.model.SaidasModel;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andre
 */
public class form_alterar_registros extends javax.swing.JDialog {

    /**
     * atributo para manter dados capturas da tabela entrada, para preenchimento
     * de campos do formulario assim evitamos uma nova leitura de informaçoes ao
     * banco
     */
    public List<EntradasModel> regEntradas;
    public List<SaidasModel> regSaidas;
    public EntradasModel entradaSelec = null;
    public SaidasModel saidaSelec = null;
    private static TipoRegistro tpRegistro;

    // atributo que ira armazenar o id selecionado na tabela, indicndo qual registro sera alterado
    int cod_reg = 0;

    /**
     * Creates new form form_alterar_reg_entrada
     */
    public form_alterar_registros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        group.add(radio_entrada);
        group.add(radio_saida);
    }

    public form_alterar_registros(java.awt.Frame parent, boolean modal, TipoRegistro tpRegistro) {
        super(parent, modal);
        initComponents();
        group.add(radio_entrada);
        group.add(radio_saida);
        verificarTipoRegistro(tpRegistro);
    }

    /**
     * Habilita os radiosbox Entrada ou Saida
     *
     * @param tpRegistro
     */
    private void verificarTipoRegistro(TipoRegistro tpRegistro) {

        form_alterar_registros.tpRegistro = tpRegistro;

        if (tpRegistro == TipoRegistro.TIPO_ENTRADA) {
            radio_entrada.setEnabled(true);
        } else if (tpRegistro == TipoRegistro.TIPO_SAIDA) {
            radio_saida.setEnabled(true);
        }
    }

    /**
     * Metodo que faz o preenchimento da tabela com as informações recuperadas
     * da tabela ENTRADAS
     *
     */
    private void preencherTabelaRegEntradas(String competencia) {

        registro_entrada_control control = new registro_entrada_control();
        this.regEntradas = control.recuperarListaRegistroEntrada(competencia);

        DefaultTableModel tabela = (DefaultTableModel) tbl_registros.getModel();
        tabela.setNumRows(0);

        for (EntradasModel reg : regEntradas) {

            tabela.addRow(new Object[]{
                reg.getIdentificador(),
                formatarData(reg.getData()),
                reg.getCompetencia(),
                formatarValor(Double.parseDouble(reg.getValor()))

            });

        }
    }

    /**
     * Metodo que faz o preenchimento da tabela com as informações recuperadas
     * da tabela SAIDAS
     *
     */
    private void preencherTabelaRegSaidas(String competencia) {

        SaidasController recuperarReg = new SaidasController();
        this.regSaidas = recuperarReg.getListaSaidas(competencia);

        DefaultTableModel tabela = (DefaultTableModel) tbl_registros.getModel();
        tabela.setNumRows(0);

        for (SaidasModel reg : regSaidas) {

            tabela.addRow(new Object[]{reg.getIdentificador(),
                formatarData(reg.getData()),
                reg.getCompetencia(),
                formatarValor(Double.parseDouble(reg.getValor()))
            });

        }
    }

    /**
     * Metodo para formatar valores doubles no formato BR
     *
     * @param valor
     * @return String valorFormatado
     */
    private String formatarValor(double valor) {
        String valorFormatado = null;
        DecimalFormat format = new DecimalFormat("###,##0.00");
        format.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
        valorFormatado = format.format(valor);
//        System.out.println(valorFormatado);
        return valorFormatado;
    }

    /**
     * Metodo que formata a data no padrão dd/MM/yyyy
     *
     * @param data
     * @return String dat
     */
    private String formatarData(String data) {

        String dataRegistro = null;

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dat = LocalDate.parse(data);

        dataRegistro = format.format(dat);
//        System.out.println(dataRegistro);

        return dataRegistro;
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
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        radio_entrada = new javax.swing.JRadioButton();
        radio_saida = new javax.swing.JRadioButton();
        campo_competencia = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_registros = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea_descricao = new javax.swing.JTextArea();
        btn_alterar_reg = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Localizar registros");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel1.setText("Informe mes/ano:");

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel2.setText("Qual lançamento?");

        radio_entrada.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        radio_entrada.setText("Entradas");
        radio_entrada.setEnabled(false);
        radio_entrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radio_entradaMouseClicked(evt);
            }
        });

        radio_saida.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        radio_saida.setText("Saidas");
        radio_saida.setEnabled(false);
        radio_saida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radio_saidaMouseClicked(evt);
            }
        });

        try {
            campo_competencia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radio_saida)
                    .addComponent(radio_entrada)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(campo_competencia, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radio_entrada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radio_saida)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campo_competencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jButton1.setText("Carregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_registros.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        tbl_registros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Data lancameto", "Competencia", "Valor R$"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_registros.setOpaque(false);
        tbl_registros.setShowVerticalLines(false);
        tbl_registros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_registrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_registros);
        if (tbl_registros.getColumnModel().getColumnCount() > 0) {
            tbl_registros.getColumnModel().getColumn(0).setMinWidth(30);
            tbl_registros.getColumnModel().getColumn(0).setMaxWidth(60);
            tbl_registros.getColumnModel().getColumn(1).setMinWidth(80);
            tbl_registros.getColumnModel().getColumn(1).setMaxWidth(120);
            tbl_registros.getColumnModel().getColumn(2).setMinWidth(80);
            tbl_registros.getColumnModel().getColumn(2).setMaxWidth(120);
            tbl_registros.getColumnModel().getColumn(3).setMinWidth(80);
            tbl_registros.getColumnModel().getColumn(3).setMaxWidth(120);
        }

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição:"));

        textArea_descricao.setColumns(20);
        textArea_descricao.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        textArea_descricao.setRows(5);
        jScrollPane2.setViewportView(textArea_descricao);

        btn_alterar_reg.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        btn_alterar_reg.setText("Alterar este registro");
        btn_alterar_reg.setEnabled(false);
        btn_alterar_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterar_regActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_alterar_reg)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_alterar_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (!campo_competencia.isValid()) {
            JOptionPane.showMessageDialog(null, "Campo invalido");
        } else {

            if (radio_entrada.isSelected()) {

                // preenche a tabela conforme competencia selecionada no combo
                preencherTabelaRegEntradas(campo_competencia.getText());

            } else if (radio_saida.isSelected()) {

                // preenche a tabela conforme competencia selecionada no combo
                preencherTabelaRegSaidas(campo_competencia.getText());

            } else {
                JOptionPane.showMessageDialog(this, "Atenção: selecione uma das opções\nEntrada ou Saida  :(", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radio_entradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radio_entradaMouseClicked

        /**
         * // remove todos itens da lista combo_competencias.removeAllItems();
         *
         * // habilita combobox com as competencias da tabela Entradas
         * combo_competencias.setEnabled(true);
         *
         * // captura as competencias lançadas na tabela ENTRADA entradas_dao
         * dao = new entradas_dao(); List<EntradasModel> registros =
         * dao.recuperaCompetenciasTabelaEntrada();
         *
         * // preenche o combo for (EntradasModel registro : registros) {
         * combo_competencias.addItem(registro); }
         *
         * // foca no combo combo_competencias.requestFocus();
         */
    }//GEN-LAST:event_radio_entradaMouseClicked

    private void tbl_registrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_registrosMouseClicked

        // capturar o id referente ao lançamento na tabela selecionada
        int linha = tbl_registros.getSelectedRow();
        int codSelec = Integer.parseInt(tbl_registros.getValueAt(linha, 0).toString());

        if (radio_entrada.isSelected()) {

            // capturando informações que já estão na lista pré carregada
            for (EntradasModel regEntrada : regEntradas) {

                if (regEntrada.getIdentificador() == codSelec) {
                    textArea_descricao.setText(regEntrada.getDescricao() + "\n");
                    btn_alterar_reg.setEnabled(true);
                }

            }

        } else if (radio_saida.isSelected()) {

            for (SaidasModel saidas : regSaidas) {

                // capturando informações que já estão na lista pré carregada
                if (saidas.getIdentificador() == codSelec) {
                    textArea_descricao.setText(saidas.getDescricao());
                    btn_alterar_reg.setEnabled(true);
                }
            }

        }
    }//GEN-LAST:event_tbl_registrosMouseClicked

    private void btn_alterar_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterar_regActionPerformed

        int row = tbl_registros.getSelectedRow();

        //atribuindo valor, esse é o id do registro selecionado para possivel alteração
        // this.cod_reg = valor;
        if (this.tpRegistro == TipoRegistro.TIPO_ENTRADA) {

            this.entradaSelec = regEntradas.get(row);
            dispose();
            
        } else if (this.tpRegistro == TipoRegistro.TIPO_SAIDA) {
            
            this.saidaSelec = regSaidas.get(row);
            dispose();
        }
    }//GEN-LAST:event_btn_alterar_regActionPerformed

    private void radio_saidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radio_saidaMouseClicked
        /*
        // remove todos itens da lista
        combo_competencias.removeAllItems();

        // habilita combobox com as competencias da tabela Entradas
        combo_competencias.setEnabled(true);

        // captura as competencias lançadas na tabela ENTRADA
        SaidasController saidas = new SaidasController();
        List<SaidasModel> registros = saidas.capturarCompetenciasTabSaida();

        // preenche o combo
        for (SaidasModel registro : registros) {
            //combo_competencias.addItem(registro.getCompetencia());
        }

        // foca no combo
        combo_competencias.requestFocus();
         */
    }//GEN-LAST:event_radio_saidaMouseClicked

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
            java.util.logging.Logger.getLogger(form_alterar_registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_alterar_registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_alterar_registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_alterar_registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                form_alterar_registros dialog = new form_alterar_registros(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_alterar_reg;
    private javax.swing.JFormattedTextField campo_competencia;
    private javax.swing.ButtonGroup group;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radio_entrada;
    private javax.swing.JRadioButton radio_saida;
    private javax.swing.JTable tbl_registros;
    private javax.swing.JTextArea textArea_descricao;
    // End of variables declaration//GEN-END:variables
}
