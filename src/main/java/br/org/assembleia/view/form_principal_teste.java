/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.view;

import br.org.assembleia.control.MembroController;
import br.org.assembleia.control.ModeloCartasController;
import br.org.assembleia.enumerador.CartasModelo;
import br.org.assembleia.enumerador.DiretorioPadrao;
import br.org.assembleia.model.ConfiguracaoModel;
import br.org.assembleia.model.MembroModel;
import br.org.assembleia.model.PessoasModel;
import br.org.assembleia.model.TipoRegistro;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

/**
 *
 * @author Andre
 */
public class form_principal_teste extends javax.swing.JFrame {

    /**
     * Creates new form form_principal
     */
    public form_principal_teste() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btn_alterar_modulo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        menuSuporte = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle Financeiro");
        setExtendedState(6);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setFont(new java.awt.Font("Miriam", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-verificar-todos-os-48.png"))); // NOI18N
        jButton2.setText("Nova entrada");
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setFont(new java.awt.Font("Miriam", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-fluxo-de-caixa-48.png"))); // NOI18N
        jButton3.setText("Nova Saida");
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setFont(new java.awt.Font("Miriam", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-tarefa-de-grupo-48.png"))); // NOI18N
        jButton4.setText("Cadastrar pessoas");
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusPainted(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        btn_alterar_modulo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btn_alterar_modulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-fechar-janela-48.png"))); // NOI18N
        btn_alterar_modulo.setText("Altear Modulo");
        btn_alterar_modulo.setFocusable(false);
        btn_alterar_modulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_alterar_modulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_alterar_modulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterar_moduloActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_alterar_modulo);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel6.setText("Desenvolvidor por: Jederson André");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel4.setText("Igreja Assembléia de Deus Madureira");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(280, 280, 280))
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 589, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("Cadastro");
        jMenu1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-sala-de-reuniões-25.png"))); // NOI18N
        jMenu3.setText("Pessoas");
        jMenu3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jMenuItem6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem6.setText("Novo cad. pessoa");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem7.setText("Localizar pessoa");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenu1.add(jMenu3);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-grupos-de-usuários-25.png"))); // NOI18N
        jMenu10.setText("Membro");
        jMenu10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jMenuItem12.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem12.setText("Cadastrar membro");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem12);

        jMenu1.add(jMenu10);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-perguntas-frequentes-25.png"))); // NOI18N
        jMenu4.setText("Cadastro de tipos");
        jMenu4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jMenuItem8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem8.setText("Tipos entrada ou saidas");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenu1.add(jMenu4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Lançamentos");
        jMenu2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-dinheiro-na-mão-25.png"))); // NOI18N
        jMenuItem4.setText("Nova Entrada");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-restituição-25.png"))); // NOI18N
        jMenuItem5.setText("Nova Saida");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-orçamento-25.png"))); // NOI18N
        jMenu5.setText("Dizimos");
        jMenu5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem2.setText("Entrada de Dizimo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenu2.add(jMenu5);

        jMenuItem15.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-arquivo-de-fichas-25.png"))); // NOI18N
        jMenuItem15.setText("Solicitaçao");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem15);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Relatorios");
        jMenu6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-razão-geral-25.png"))); // NOI18N
        jMenu7.setText("Entradas");
        jMenu7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jMenuItem9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem9.setText("Entrada mensal");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem9);

        jMenu6.add(jMenu7);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-poupança-25.png"))); // NOI18N
        jMenu8.setText("Saidas");
        jMenu8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jMenuItem10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem10.setText("Saida mensal");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem10);

        jMenu6.add(jMenu8);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-livro-razão-25.png"))); // NOI18N
        jMenu9.setText("Dizimos");
        jMenu9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jMenuItem11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem11.setText("Dizimo mensal");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem11);

        jMenu6.add(jMenu9);

        jMenu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-cardápio-25.png"))); // NOI18N
        jMenu11.setText("Outros");
        jMenu11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem3.setText("Membros ativos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem3);

        jMenuItem13.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem13.setText("Carterinhas");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem13);

        jMenuItem14.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem14.setText("Carta recomendacao");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem14);

        jMenu6.add(jMenu11);

        jMenuBar1.add(jMenu6);

        menuSuporte.setText("Suporte");
        menuSuporte.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jMenuItem1.setText("Caminhos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuSuporte.add(jMenuItem1);

        jMenuBar1.add(menuSuporte);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        form_cad_entrada form = new form_cad_entrada(this, false);
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        form_cad_pessoas form = new form_cad_pessoas();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        form_localizar_pessoas localizar = new form_localizar_pessoas(this, false);
        localizar.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        form_cad_tipos tipos = new form_cad_tipos(this, false);
        tipos.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        form_entrada_dizimo dizimo = new form_entrada_dizimo(this, false);
        dizimo.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        form_cad_saida saida = new form_cad_saida(this, true);
        saida.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        form_imprimir_relatorios rel = new form_imprimir_relatorios(this, false, TipoRegistro.TIPO_ENTRADA);

        rel.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        form_imprimir_relatorios rel = new form_imprimir_relatorios(this, false, TipoRegistro.TIPO_SAIDA);
        rel.setVisible(true);

    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        form_imprimir_relatorios rel = new form_imprimir_relatorios(this, false, TipoRegistro.TIPO_DIZIMO);
        rel.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // chamando formulario de cadastro de pessoas
        form_cad_pessoas pessoas = new form_cad_pessoas();
        pessoas.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        form_cad_saida form = new form_cad_saida(this, false);
        form.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // chamando tela para cadastro de novo lancamento de entradas
        form_cad_entrada form = new form_cad_entrada(this, false);
        form.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_alterar_moduloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterar_moduloActionPerformed
        // TODO add your handling code here:
        form_modulos modulo = new form_modulos();
        modulo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_alterar_moduloActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed

        form_cad_membro view = new form_cad_membro();
        view.setVisible(true);

    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Diretorios padrões:\n"
                + "Modelo cartas: " + DiretorioPadrao.SUB_DIR_CARTAS.getDiretorioPadrao() + "\n"
                + "Relatorios: " + DiretorioPadrao.SUB_DIR_RELATORIO.getDiretorioPadrao() + "\n"
                + "Cartas emitidas: " + DiretorioPadrao.SUB_DIR_EMISSAO_CARTA.getDiretorioPadrao());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        MembroController relatorio = new MembroController();
        relatorio.gerarRelatorioMembrosAtivos();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:

        form_localizar_pessoas membro = new form_localizar_pessoas(this, true, "M");
        membro.setVisible(true);

        if (membro.getMembro != null) {
            MembroController control = new MembroController();
            control.gerarCarteiraMembro(membro.getMembro.getId());
        } else {
            JOptionPane.showMessageDialog(this, "Atenção nenhum membro foi selecionado");
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        ModeloCartasController ctrlCartas = new ModeloCartasController();

        File doc = new File(DiretorioPadrao.SUB_DIR_CARTAS.getDiretorioPadrao()
                + CartasModelo.RECOMENDACAO.getCartaModelo());

        if (doc.exists()) {

            form_localizar_pessoas localizar = new form_localizar_pessoas(this, true);
            localizar.setVisible(true);

            if (localizar.getPessoa != null) {

                XWPFWordExtractor conteudoExtraido = ctrlCartas.carregarModeloCarta(doc);
                
                PessoasModel mdl = localizar.getPessoa;

                ModeloCartasController ctrl = new ModeloCartasController();
                boolean resultadoCarta = ctrl.gerarDocCartaRecomendacao(conteudoExtraido, mdl);

                if (resultadoCarta) {
                    JOptionPane.showMessageDialog(this, "Parabens...O documento foi gerado com sucesso!");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error - Arquivo não encontrato!!");
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        
       form_solicitacao view = new form_solicitacao(this, true);
       view.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem15ActionPerformed

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
            java.util.logging.Logger.getLogger(form_principal_teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_principal_teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_principal_teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_principal_teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_principal_teste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alterar_modulo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu menuSuporte;
    // End of variables declaration//GEN-END:variables
}
