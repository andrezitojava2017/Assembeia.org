/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.view;

import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author andre
 */
public class form_modulos extends javax.swing.JFrame {

    /**
     * Creates new form form_modulos
     */
    public form_modulos() {
        initComponents();

    }

    public form_modulos(String permissao) {
        initComponents();

        switch (permissao) {

            case "F": /* F= FINANCEIRO */

                /* remove o evento click do modulo MEMBROS*/
                MouseListener financeiro[] = moduloMembros.getMouseListeners();
                moduloMembros.removeMouseListener(financeiro[0]);
                break;
            case "M": /* M= MEMBROS*/

                /* remove o evento click do modulo FINANCEIRO*/
                MouseListener membro[] = moduloFinanceiro.getMouseListeners();
                moduloFinanceiro.removeMouseListener(membro[0]);
                break;
            default:
                break;
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

        jLabel1 = new javax.swing.JLabel();
        moduloFinanceiro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        moduloMembros = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Igreja Assembleia de Deus Madureira");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Escolha um modulo:");

        moduloFinanceiro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        moduloFinanceiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moduloFinanceiroMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                moduloFinanceiroMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                moduloFinanceiroMouseEntered(evt);
            }
        });

        jLabel2.setText("Financeiro");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-painel-de-controle-96.png"))); // NOI18N

        javax.swing.GroupLayout moduloFinanceiroLayout = new javax.swing.GroupLayout(moduloFinanceiro);
        moduloFinanceiro.setLayout(moduloFinanceiroLayout);
        moduloFinanceiroLayout.setHorizontalGroup(
            moduloFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduloFinanceiroLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(moduloFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(moduloFinanceiroLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        moduloFinanceiroLayout.setVerticalGroup(
            moduloFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moduloFinanceiroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        moduloMembros.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        moduloMembros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                moduloMembrosMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                moduloMembrosMouseEntered(evt);
            }
        });

        jLabel3.setText("Membros");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-teste-passado-96.png"))); // NOI18N

        javax.swing.GroupLayout moduloMembrosLayout = new javax.swing.GroupLayout(moduloMembros);
        moduloMembros.setLayout(moduloMembrosLayout);
        moduloMembrosLayout.setHorizontalGroup(
            moduloMembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduloMembrosLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(moduloMembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(moduloMembrosLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        moduloMembrosLayout.setVerticalGroup(
            moduloMembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moduloMembrosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(moduloFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(moduloMembros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(moduloFinanceiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(moduloMembros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void moduloFinanceiroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moduloFinanceiroMouseEntered
        // TODO add your handling code here:
        Cursor c = new Cursor(Cursor.HAND_CURSOR);
        this.setCursor(c);
    }//GEN-LAST:event_moduloFinanceiroMouseEntered

    private void moduloFinanceiroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moduloFinanceiroMouseExited
        // TODO add your handling code here:
        Cursor c = new Cursor(Cursor.DEFAULT_CURSOR);
        this.setCursor(c);
    }//GEN-LAST:event_moduloFinanceiroMouseExited

    private void moduloMembrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moduloMembrosMouseEntered
        // TODO add your handling code here:
        Cursor c = new Cursor(Cursor.HAND_CURSOR);
        this.setCursor(c);
    }//GEN-LAST:event_moduloMembrosMouseEntered

    private void moduloMembrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moduloMembrosMouseExited
        // TODO add your handling code here:
        Cursor c = new Cursor(Cursor.DEFAULT_CURSOR);
        this.setCursor(c);
    }//GEN-LAST:event_moduloMembrosMouseExited

    private void moduloFinanceiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moduloFinanceiroMouseClicked
        // TODO add your handling code here:
        form_principal_teste view = new form_principal_teste();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_moduloFinanceiroMouseClicked

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
            java.util.logging.Logger.getLogger(form_modulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_modulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_modulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_modulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_modulos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel moduloFinanceiro;
    private javax.swing.JPanel moduloMembros;
    // End of variables declaration//GEN-END:variables
}
