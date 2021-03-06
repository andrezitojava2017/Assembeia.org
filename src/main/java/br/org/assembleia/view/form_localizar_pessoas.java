/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.view;

import br.org.assembleia.control.MembroController;
import br.org.assembleia.control.PessoasController;
import br.org.assembleia.model.MembroModel;
import br.org.assembleia.model.PessoasModel;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andre
 */
public class form_localizar_pessoas extends javax.swing.JDialog {

    List<PessoasModel> getListaPessoas = null;
    List<MembroModel> getListaMembro = null;
    public PessoasModel getPessoa = null;
    public MembroModel getMembro = null;

    /**
     * Creates new form form_localizar_pessoas
     */
    public form_localizar_pessoas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        group_tipo.add(jCheckBox1);
    }

    /**
     * Construtor para carregar a lista de membros cadastrados na base
     * @param parent
     * @param modal
     * @param membro 
     */
    public form_localizar_pessoas(java.awt.Frame parent, boolean modal, String membro) {
        super(parent, modal);
        initComponents();
        carregarListaMembros();
    }

    /**
     * Retorna uma lista de membros cadastrados na base de dados para
     * preenchimento da tabela
     */
    private void carregarListaMembros() {

        DefaultTableModel tabela = (DefaultTableModel) tabela_credores.getModel();
        tabela.setNumRows(0);

        MembroController controller = new MembroController();
        this.getListaMembro = controller.getListaMembro();

        if (getListaMembro.isEmpty()) {

            lblMensagem.setText("Não foi localizado nenhuma membro..."); // msg caso lista esteja vazia

        } else {

            for (MembroModel object : getListaMembro) {

                tabela.addRow(new Object[]{
                    object.getId(),
                    object.getNome(),
                    object.getCpf()
                });

            }
        }

    }

    /**
     * carrega informaçõe somente de pessoas fiscias
     */
    private void preencherTabelaPessoaFisica() {

        DefaultTableModel tabela = (DefaultTableModel) tabela_credores.getModel();
        tabela.setNumRows(0);

        PessoasController control = new PessoasController();
        this.getListaPessoas = control.getListaPessoas();

        if (getListaPessoas.isEmpty() || getListaPessoas == null) {

            lblMensagem.setText("Não foi localizado nenhuma pessoa..."); // msg caso lista esteja vazia

        } else {

            for (PessoasModel object : getListaPessoas) {

                tabela.addRow(new Object[]{
                    object.getId_pessoa(),
                    object.getNome(),
                    object.getCpf()
                });

            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group_tipo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_credores = new javax.swing.JTable();
        btn_selecionar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        lblMensagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Localizar");

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-procurar-usuário-masculino-50.png"))); // NOI18N
        jLabel1.setText("Localizar Pessoas");

        jSeparator1.setBackground(new java.awt.Color(51, 0, 255));

        tabela_credores.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabela_credores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Nome", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_credores.setShowVerticalLines(false);
        tabela_credores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_credoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_credores);
        if (tabela_credores.getColumnModel().getColumnCount() > 0) {
            tabela_credores.getColumnModel().getColumn(0).setMinWidth(40);
            tabela_credores.getColumnModel().getColumn(0).setMaxWidth(80);
            tabela_credores.getColumnModel().getColumn(1).setMinWidth(120);
            tabela_credores.getColumnModel().getColumn(1).setMaxWidth(250);
            tabela_credores.getColumnModel().getColumn(2).setMinWidth(120);
            tabela_credores.getColumnModel().getColumn(2).setMaxWidth(250);
        }

        btn_selecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-localização-do-usuário-48.png"))); // NOI18N
        btn_selecionar.setEnabled(false);
        btn_selecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selecionarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Localizar:"));

        jCheckBox1.setText("CPF");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jCheckBox1)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        lblMensagem.setForeground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(125, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_selecionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_selecionar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Localizar:");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_selecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selecionarActionPerformed
        //recuperando codigo do credor

        int linha = tabela_credores.getSelectedRow();

        //System.out.println("lista pessoas: " + getListaPessoas.size());
        //System.out.println("lista membros: " + getListaMembro.size());

        if (this.getListaMembro != null) {
            this.getMembro = this.getListaMembro.get(linha);
            dispose();
            
        } else if (this.getListaPessoas!= null) {
            
            this.getPessoa = this.getListaPessoas.get(linha);
            dispose();
        }

    }//GEN-LAST:event_btn_selecionarActionPerformed

    private void tabela_credoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_credoresMouseClicked
        // ativa o botao selecionar
        btn_selecionar.setEnabled(true);
    }//GEN-LAST:event_tabela_credoresMouseClicked

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        preencherTabelaPessoaFisica();
        //tipo_cpf_cnpj = tipo_pessoas.CPF; // indicamos que foi feito uma busca por CPF
    }//GEN-LAST:event_jCheckBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_selecionar;
    private javax.swing.ButtonGroup group_tipo;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JTable tabela_credores;
    // End of variables declaration//GEN-END:variables
}
