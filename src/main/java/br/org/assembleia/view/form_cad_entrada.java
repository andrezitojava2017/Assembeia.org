/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.view;

import br.org.assembleia.control.Recibo_Control;
import br.org.assembleia.control.registro_entrada_control;
import br.org.assembleia.model.ReciboModel;
import br.org.assembleia.model.TipoRegistro;
import br.org.assembleia.model.EntradasModel;
import br.org.assembleia.model.TipoEntradaModel;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class form_cad_entrada extends javax.swing.JDialog {

    // atributo que aramazenara o id do registro que sera alterado
    private int id_registro_alterar;
    private int idRecibo;
    private static EntradasModel registro = new EntradasModel();
    

    /**
     * Creates new form form_cad_entrada
     */
    public form_cad_entrada(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregarInfo();
    }

    /**
     * Limpar campos
     */
    private void limparCampos() {

        campo_valor_entrada.setText("");
        area_descricao.setText("");
        combo_tipo_entrada.setSelectedItem("");

    }

    /**
     * metodo criado para tratar os valores corretamente
     *
     * @param valor_entrada
     */
    private double convertValorInfo(String valor_entrada) {

        // transfroma em vetor
        IntStream s = valor_entrada.chars();
        double valor = 0;

        // verifica a qtd de posiçoes... indica numeros com casas de milhares
        if (s.count() > 6) {
            String n = valor_entrada.replace(".", "");
            String b = n.replace(",", ".");

            valor = Double.parseDouble(b);
//            System.out.println(valor);

        } else {

            // valores com casas abaixo de milhares
            String n = valor_entrada.replace(",", ".");
            valor = Double.parseDouble(n);
//            System.out.println(n);
        }

        return valor;
    }

    /**
     * carrega informações principais do formulario de entrada
     */
    private void carregarInfo() {
        //carregando a data atual
        LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        campo_data_lancamento.setText(formato.format(data));

        //captura o mes e preenche o campo competencia
        LocalDate dat = LocalDate.now();
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("MM/yyyy");
        campo_competencia.setText(dat.format(formatar));

        // carrega os tipos de entradas cadastrados
        registro_entrada_control entrada = new registro_entrada_control();
        List<TipoEntradaModel> tipos = entrada.getListaTipoEntrada();

        // se a lista estiverr vazia é exibido a msg de alerta
        if (tipos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel recuparar os TIPOS ENTRADAS\n"
                    + "Realize o cadastro de tipos de entradas", "Atenção", JOptionPane.ERROR_MESSAGE);
            btn_salvar_lancamento.setEnabled(false);
        } else {

            // preenche o combo com os dados capturados da tabela tipo de saidas
            for (TipoEntradaModel tipo : tipos) {

                combo_tipo_entrada.addItem(tipo.getDescricao());

            }
        }

    }

    /**
     * Preenche os campos com os dados retornados da base de dados
     * @param id_registro_selec 
     */
    private void preencherRegistroParaAlteracao(int id_registro_selec) {

        // instanciando objeto necessários
        registro_entrada_control alterarEntrada = new registro_entrada_control();
        registro = alterarEntrada.recuperarInfoRegistroParaAlterar(id_registro_selec);

        // formatação de data
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse((CharSequence) registro.getData());

        // formatação correta dos valores
        DecimalFormat decim = new DecimalFormat("###,##0.00");

        // preechimeno de campos
        campo_data_lancamento.setText(format.format(data));
        campo_competencia.setText(registro.getCompetencia());
        campo_valor_entrada.setText(decim.format(registro.getValor()));
        combo_tipo_entrada.setSelectedItem(registro.getTipo_entrada());
        area_descricao.setText(registro.getDescricao());
        
        // atribui valor ao atributo global idRecibo, para que possa 
        // ser atribuido na hora de atualizar o registro
        //this.idRecibo = registro.getRecibo();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area_descricao = new javax.swing.JTextArea();
        btn_salvar_lancamento = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        combo_tipo_entrada = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        campo_data_lancamento = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campo_valor_entrada = new javax.swing.JFormattedTextField();
        campo_competencia = new javax.swing.JTextField();
        lbl_titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_limpar_campos = new javax.swing.JButton();
        btn_buscar_reg_alterar = new javax.swing.JButton();
        btn_salvar_alteracao = new javax.swing.JButton();
        btn_excluir_registro = new javax.swing.JButton();
        btn_imprimir_recibo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de novas entradas");
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Breve descrição"));

        jLabel4.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel4.setText("Descrição:");

        area_descricao.setColumns(20);
        area_descricao.setLineWrap(true);
        area_descricao.setRows(10);
        jScrollPane1.setViewportView(area_descricao);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btn_salvar_lancamento.setFont(new java.awt.Font("Miriam", 1, 14)); // NOI18N
        btn_salvar_lancamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-guardar-todos-48.png"))); // NOI18N
        btn_salvar_lancamento.setToolTipText("Salvar lancamento");
        btn_salvar_lancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvar_lancamentoActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Informações"));

        jLabel1.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel1.setText("Tipo de entrada:");

        combo_tipo_entrada.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        combo_tipo_entrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_tipo_entradaKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel2.setText("Data lançamento:");

        campo_data_lancamento.setEditable(false);
        try {
            campo_data_lancamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campo_data_lancamento.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        campo_data_lancamento.setOpaque(false);
        campo_data_lancamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campo_data_lancamentoKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel3.setText("Competencia:");

        jLabel5.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel5.setText("Valor de entradaR$:");

        campo_valor_entrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        campo_valor_entrada.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        campo_valor_entrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campo_valor_entradaKeyPressed(evt);
            }
        });

        campo_competencia.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        campo_competencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campo_competenciaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_data_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_competencia, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(combo_tipo_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campo_valor_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campo_data_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(combo_tipo_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(campo_valor_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(campo_competencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_titulo.setFont(new java.awt.Font("Dotum", 1, 24)); // NOI18N
        lbl_titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-adicionar-banco-de-dados-96.png"))); // NOI18N
        lbl_titulo.setText("Registrar novas entradas");

        btn_limpar_campos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-vassoura-48.png"))); // NOI18N
        btn_limpar_campos.setToolTipText("Limpar");
        btn_limpar_campos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpar_camposActionPerformed(evt);
            }
        });

        btn_buscar_reg_alterar.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        btn_buscar_reg_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-design-48.png"))); // NOI18N
        btn_buscar_reg_alterar.setToolTipText("Alterar registro");
        btn_buscar_reg_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_reg_alterarActionPerformed(evt);
            }
        });

        btn_salvar_alteracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-salvar-como-48.png"))); // NOI18N
        btn_salvar_alteracao.setToolTipText("Salvar alterações deste registro");
        btn_salvar_alteracao.setEnabled(false);
        btn_salvar_alteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvar_alteracaoActionPerformed(evt);
            }
        });

        btn_excluir_registro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-lixo-48.png"))); // NOI18N
        btn_excluir_registro.setToolTipText("Exluir este registro");
        btn_excluir_registro.setEnabled(false);
        btn_excluir_registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluir_registroActionPerformed(evt);
            }
        });

        btn_imprimir_recibo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-impressão-48.png"))); // NOI18N
        btn_imprimir_recibo.setToolTipText("Imprimir recibo");
        btn_imprimir_recibo.setEnabled(false);
        btn_imprimir_recibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimir_reciboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_salvar_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_limpar_campos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_salvar_alteracao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_excluir_registro)
                .addGap(18, 18, 18)
                .addComponent(btn_buscar_reg_alterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_imprimir_recibo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_titulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbl_titulo)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_limpar_campos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_salvar_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_buscar_reg_alterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_excluir_registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_salvar_lancamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btn_imprimir_recibo))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(691, 618));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salvar_lancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvar_lancamentoActionPerformed
        int opt = JOptionPane.showConfirmDialog(this, "Salvar as informações no banco de dados?");

        if (opt == 0) {

            // salvando informações
            if (campo_competencia.getText().isEmpty() || campo_valor_entrada.getText().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Preencha todos os campos");

            } else {

                EntradasModel entrada = new EntradasModel();
                entrada.setData(campo_data_lancamento.getText());
                entrada.setCompetencia(campo_competencia.getText());
                entrada.setTipo_entrada(combo_tipo_entrada.getSelectedItem().toString());
                entrada.setDescricao(area_descricao.getText());
                entrada.setSituacao("A");

                // tratando o valor informado pelo usuario, para evitar erros a inserção
                double valorEntrada = convertValorInfo(campo_valor_entrada.getText());
                entrada.setValor(valorEntrada);

                // Aqui iremos gerar a sequencia para o recibo, e salvar na base de dados
                Recibo_Control reciboControl = new Recibo_Control();
                ReciboModel novoReciboGerado = reciboControl.gravarRecibo();

                // caso nao tenha sido gerado o recibo, não sera feito a gravação
                if (novoReciboGerado == null) {

                    JOptionPane.showMessageDialog(null, "Ops... não foi possivel gerar um recibo para este registro!");

                } else {

                    // setando o valor do ID do recibo para este lançamento de entrada
                    entrada.setRecibo(novoReciboGerado.getIdRecibo());

                    // atributo que ira disponibilizar para impressao o recibo
                    idRecibo = novoReciboGerado.getIdRecibo();

                    // inserindo novas informações na tabela entradas
                    registro_entrada_control novoLancamento = new registro_entrada_control();
                    int idEntrada = novoLancamento.inserirNovoRegEntrada(entrada);

                    // ativa o botao para imprimir o recibo
                    if (idEntrada != 0) {
                        JOptionPane.showMessageDialog(null, "Registro efetuado com sucesso!!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                        btn_imprimir_recibo.setEnabled(true);
                    }

                }

            }
        } else {

        }

    }//GEN-LAST:event_btn_salvar_lancamentoActionPerformed

    private void btn_limpar_camposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpar_camposActionPerformed
        // limpar campos
        limparCampos();
        if (btn_excluir_registro.isEnabled() && btn_salvar_alteracao.isEnabled()) {
            // desativa os botoes de exclusão e atualização
            btn_excluir_registro.setEnabled(false);
            btn_salvar_alteracao.setEnabled(false);
            btn_imprimir_recibo.setEnabled(false);
        }
    }//GEN-LAST:event_btn_limpar_camposActionPerformed

    private void campo_data_lancamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_data_lancamentoKeyPressed
        // troca de foco ao pressionar ENTER
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            combo_tipo_entrada.requestFocus();
        }
    }//GEN-LAST:event_campo_data_lancamentoKeyPressed

    private void combo_tipo_entradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_tipo_entradaKeyPressed
        // troca de foco ao pressionar ENTER
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            campo_competencia.requestFocus();
        }
    }//GEN-LAST:event_combo_tipo_entradaKeyPressed

    private void campo_valor_entradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_valor_entradaKeyPressed
        // troca de foco ao pressionar ENTER
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            area_descricao.requestFocus();
        }
    }//GEN-LAST:event_campo_valor_entradaKeyPressed

    private void btn_buscar_reg_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_reg_alterarActionPerformed

        form_alterar_registros reg = new form_alterar_registros(null, true, TipoRegistro.TIPO_ENTRADA);
        reg.setVisible(true);

        if (reg.cod_reg != 0) {

            preencherRegistroParaAlteracao(reg.cod_reg);
            btn_salvar_lancamento.setEnabled(false); // desativa btn salvar novo lancamento
            btn_salvar_alteracao.setEnabled(true); // ativa o btn de salvar atualização
            btn_excluir_registro.setEnabled(true); // ativa o btn de exclusão
            lbl_titulo.setText("Alteração de registros");
            lbl_titulo.setForeground(Color.red);

            // definindo id do registro que sera feito o update
            this.id_registro_alterar = reg.cod_reg;

        } else {
            JOptionPane.showMessageDialog(this, "Nenhum registro foi selecionado", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
            btn_excluir_registro.setEnabled(false);
        }

    }//GEN-LAST:event_btn_buscar_reg_alterarActionPerformed

    private void btn_excluir_registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluir_registroActionPerformed

        int opt = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir essse registro?", "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION);

        if (opt == 0) {

            registro_entrada_control deletar = new registro_entrada_control();
            
            //muda a situação para INATIVO
            registro.setSituacao("I");
            deletar.deletarRegEntrada(registro);
            limparCampos();
            
            if(btn_imprimir_recibo.getModel().isEnabled() || btn_salvar_alteracao.getModel().isEnabled()){
               
                btn_salvar_alteracao.setEnabled(false);
                btn_imprimir_recibo.setEnabled(false);
            }

        } else {
            btn_buscar_reg_alterar.requestFocus();
        }
    }//GEN-LAST:event_btn_excluir_registroActionPerformed

    private void btn_salvar_alteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvar_alteracaoActionPerformed

        if (campo_competencia.getText().isEmpty() || campo_data_lancamento.getText().isEmpty() || campo_valor_entrada.getText().isEmpty() || area_descricao.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Ops... verifique se todos os campos estão devidamente preenchidos", "Alerta", JOptionPane.INFORMATION_MESSAGE);

        } else {

            int rtr = JOptionPane.showConfirmDialog(this, "Confirma a atuaização deste registro?", "Continuar...", JOptionPane.YES_NO_CANCEL_OPTION);

            if (rtr == 0) {

                //registro = new EntradasModel();
                
                //registro.setRecibo(this.idRecibo);
                registro.setCompetencia(campo_competencia.getText());
                registro.setTipo_entrada(combo_tipo_entrada.getSelectedItem().toString());
                registro.setData(campo_data_lancamento.getText());
                registro.setDescricao(area_descricao.getText());
                //registro.setIdentificador(this.id_registro_alterar);

                String valor = campo_valor_entrada.getText();
                registro.setValor(convertValorInfo(valor));

                // passando objetos para metodo resposanvel em atualizar o registro na base de dados
                registro_entrada_control atualizar = new registro_entrada_control();
                int retorno = atualizar.atualizarRegEntrada(registro);
                
                if(retorno != 0){
                    JOptionPane.showMessageDialog(null, "Parabens...registro foi atualizado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }

            } else {

                // nenhuma ação
            }

        }

    }//GEN-LAST:event_btn_salvar_alteracaoActionPerformed

    private void campo_competenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_competenciaKeyPressed
        // capturando o evento ENTER
        if (evt.getKeyCode() == evt.VK_ENTER) {
            campo_valor_entrada.requestFocus();
        }
    }//GEN-LAST:event_campo_competenciaKeyPressed

    private void btn_imprimir_reciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimir_reciboActionPerformed
        // TODO add your handling code here:

        System.out.println("ID DO RECIBO: " + this.idRecibo);
    }//GEN-LAST:event_btn_imprimir_reciboActionPerformed

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
            java.util.logging.Logger.getLogger(form_cad_entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_cad_entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_cad_entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_cad_entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                form_cad_entrada dialog = new form_cad_entrada(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextArea area_descricao;
    private javax.swing.JButton btn_buscar_reg_alterar;
    private javax.swing.JButton btn_excluir_registro;
    private javax.swing.JButton btn_imprimir_recibo;
    private javax.swing.JButton btn_limpar_campos;
    private javax.swing.JButton btn_salvar_alteracao;
    private javax.swing.JButton btn_salvar_lancamento;
    private javax.swing.JTextField campo_competencia;
    private javax.swing.JFormattedTextField campo_data_lancamento;
    private javax.swing.JFormattedTextField campo_valor_entrada;
    private javax.swing.JComboBox<String> combo_tipo_entrada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_titulo;
    // End of variables declaration//GEN-END:variables
}
