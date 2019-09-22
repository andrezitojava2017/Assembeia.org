/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.assembleia.view;

import br.org.assembleia.control.DizimoController;
import br.org.assembleia.control.Recibo_Control;
import br.org.assembleia.control.registro_entrada_control;
import br.org.assembleia.model.DizimoModel;
import br.org.assembleia.model.EntradasModel;
import br.org.assembleia.model.MembroModel;
import br.org.assembleia.model.PessoasModel;
import br.org.assembleia.model.ReciboModel;
import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author Andre
 */
public class form_entrada_dizimo extends javax.swing.JDialog {

    //private int id_pessoa_selecionada = 0;
    private int id_registro_dizimo = 0;
    private PessoasModel membroDizimista = null;
    private MembroModel membroReceptor = null;
    private int idRecibo = 0;

    /**
     * Creates new form form_entrada_dizimo
     */
    public form_entrada_dizimo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregarInformacoes();
    }

    /**
     * Verifica se os campos obrigatorios estão preenchidos
     */
    private boolean verificarCamposObrigatorios(Component[] componentes) {

        boolean camposPreenchidos = false;

        // agora percorremos o vetor
        for (int i = 0; i < componentes.length; i++) {
            // capturamos o componente da posicao indicada
            Component component = componentes[i];
            // verificamos se o componente é uma instancia de jtextfiel
            if (component instanceof JTextField) {
                //verificamos se o campo esta vazio
                if (((JTextField) component).getText().isEmpty()) {
                    // campo vazio... alteramos suas propriedades
                    ((JTextField) component).setBorder(new LineBorder(Color.red, 1));
                    camposPreenchidos = false;

                } else {
                    // campo preenchido...
                    ((JTextField) component).setBorder(new LineBorder(Color.black));
                    camposPreenchidos = true;
                }
            } // jtextfield

        }
        return camposPreenchidos;
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
     * preenche campos referente a pessoa que esta dizimando
     *
     * @param id_pessoa
     */
    private void preencherCamposPessoasDizimista(PessoasModel get) {

        // PessoasController controller = new PessoasController();
        //this.getPessoa = controller.getPessoa(this.id_pessoa_selecionada);
        campo_nome_membro_dizimista.setText(get.getNome());
        campo_doc_membro_dizimista.setText(get.getCpf());
        this.membroDizimista = get;

    }

    /**
     * Preenche campos do responsavel que esta recebendo os valores
     */
    private void preencherCamposMembroResponsavel(MembroModel get) {

        // PessoasController controller = new PessoasController();
        //this.getPessoa = controller.getPessoa(this.id_pessoa_selecionada);
        campo_nome_resp_receber.setText(get.getNome());
        campo_doc_resp_receber.setText(get.getCpf());
        this.membroReceptor = get;

    }

    /**
     * Carrega informações de data e competencia
     */
    private void carregarInformacoes() {

        LocalDate data = LocalDate.now();

        campo_data_lancamento.setText(data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        campo_competencia.setText(data.format(DateTimeFormatter.ofPattern("MM/yyyy")));

    }

    /**
     * Preenche os campos corretamente, com dados de um registro recuperado do
     * banco de dados
     *
     * @param id_registro
     */
    private void preencherCamposRegistroParaAlterar(int id_registro) {
        /*
        dizimo_control control = new dizimo_control();
        DizimoModel dizimo = control.recuperarRegistroParaAlterar(id_registro);
        campo_competencia.setText(dizimo.getCompetencia());
        campo_data_lancamento.setText(formatarDataCampo(dizimo.getData()));
        campo_valor_dizimo.setText(formatarValorCampo(dizimo.getValor()));
        campo_num_recibo.setText(String.valueOf(dizimo.getRecibo()));

        this.id_pessoa_selecionada = dizimo.getPessoa().getId_pessoa(); // id da pessoa 
        preencherCamposPessoasEmpresa(dizimo.getPessoa().getId_pessoa());
         */
    }

    /**
     * Formata a data no padrão dd/MM/yyyy
     *
     * @param dat
     * @return String
     */
    private String formatarDataCampo(String dat) {
        // formatação de data
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dat);
        String datFormat = format.format(data);
        return datFormat;
    }

    /**
     * Formata o valor dizimado em string no padrao R$1.234,12
     *
     * @param valorDizimo
     * @return String
     */
    private String formatarValorCampo(double valorDizimo) {
        // formatação correta dos valores
        DecimalFormat decim = new DecimalFormat("###,##0.00");
        String valorFormt = decim.format(valorDizimo);
        return valorFormt;
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
        campos_dizimo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campo_data_lancamento = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        campo_competencia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campo_valor_dizimo = new javax.swing.JFormattedTextField();
        lbl_recibo = new javax.swing.JLabel();
        campos_dizimista = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        campo_nome_membro_dizimista = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campo_doc_membro_dizimista = new javax.swing.JTextField();
        btn_localizar_membro_dizimista = new javax.swing.JButton();
        campos_membros = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        campo_nome_resp_receber = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        campo_doc_resp_receber = new javax.swing.JTextField();
        btn_localizar_resp_receber = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btn_salvar = new javax.swing.JButton();
        btn_novo_lancamento = new javax.swing.JButton();
        btn_atualizar = new javax.swing.JButton();
        btn_deletar = new javax.swing.JButton();
        btn_localizar_registro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lançamento entrada de dizimo");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-adicionar-banco-de-dados-96.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        campos_dizimo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel2.setText("Data lançamento:");

        campo_data_lancamento.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        campo_data_lancamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campo_data_lancamentoKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel3.setText("Competencia:");

        campo_competencia.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        campo_competencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campo_competenciaKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel4.setText("Recibo");

        jLabel5.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel5.setText("Valor dizimado:");

        campo_valor_dizimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        campo_valor_dizimo.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        campo_valor_dizimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campo_valor_dizimoKeyPressed(evt);
            }
        });

        lbl_recibo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_recibo.setForeground(new java.awt.Color(153, 0, 0));
        lbl_recibo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_recibo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout campos_dizimoLayout = new javax.swing.GroupLayout(campos_dizimo);
        campos_dizimo.setLayout(campos_dizimoLayout);
        campos_dizimoLayout.setHorizontalGroup(
            campos_dizimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(campos_dizimoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(campos_dizimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(campos_dizimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campo_data_lancamento, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(campo_competencia))
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addGap(22, 22, 22)
                .addComponent(campo_valor_dizimo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(campos_dizimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(campos_dizimoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(campos_dizimoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_recibo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        campos_dizimoLayout.setVerticalGroup(
            campos_dizimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(campos_dizimoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(campos_dizimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(campos_dizimoLayout.createSequentialGroup()
                        .addGroup(campos_dizimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campo_data_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(campo_valor_dizimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(campos_dizimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(campo_competencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(campos_dizimoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_recibo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        campos_dizimista.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel6.setText("Membro dizimista:");

        campo_nome_membro_dizimista.setEditable(false);
        campo_nome_membro_dizimista.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        campo_nome_membro_dizimista.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel7.setText("Documento:");

        campo_doc_membro_dizimista.setEditable(false);
        campo_doc_membro_dizimista.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        campo_doc_membro_dizimista.setEnabled(false);

        btn_localizar_membro_dizimista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-pesquisar-mais-18.png"))); // NOI18N
        btn_localizar_membro_dizimista.setToolTipText("Localizar um dizimista");
        btn_localizar_membro_dizimista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_localizar_membro_dizimistaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout campos_dizimistaLayout = new javax.swing.GroupLayout(campos_dizimista);
        campos_dizimista.setLayout(campos_dizimistaLayout);
        campos_dizimistaLayout.setHorizontalGroup(
            campos_dizimistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(campos_dizimistaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(campos_dizimistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_nome_membro_dizimista)
                    .addGroup(campos_dizimistaLayout.createSequentialGroup()
                        .addGroup(campos_dizimistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(campos_dizimistaLayout.createSequentialGroup()
                                .addGroup(campos_dizimistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(campo_doc_membro_dizimista, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_localizar_membro_dizimista, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        campos_dizimistaLayout.setVerticalGroup(
            campos_dizimistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(campos_dizimistaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_nome_membro_dizimista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(campos_dizimistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(campos_dizimistaLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campo_doc_membro_dizimista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_localizar_membro_dizimista))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        campos_membros.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel8.setText("Responsavel pelo recebimento:");

        campo_nome_resp_receber.setEditable(false);
        campo_nome_resp_receber.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        campo_nome_resp_receber.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel9.setText("Documento:");

        campo_doc_resp_receber.setEditable(false);
        campo_doc_resp_receber.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        campo_doc_resp_receber.setEnabled(false);

        btn_localizar_resp_receber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-pesquisar-mais-18.png"))); // NOI18N
        btn_localizar_resp_receber.setToolTipText("Localizar um dizimista");
        btn_localizar_resp_receber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_localizar_resp_receberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout campos_membrosLayout = new javax.swing.GroupLayout(campos_membros);
        campos_membros.setLayout(campos_membrosLayout);
        campos_membrosLayout.setHorizontalGroup(
            campos_membrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(campos_membrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(campos_membrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_nome_resp_receber)
                    .addGroup(campos_membrosLayout.createSequentialGroup()
                        .addGroup(campos_membrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(campos_membrosLayout.createSequentialGroup()
                                .addGroup(campos_membrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(campo_doc_resp_receber, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_localizar_resp_receber, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        campos_membrosLayout.setVerticalGroup(
            campos_membrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(campos_membrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_nome_resp_receber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(campos_membrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(campos_membrosLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campo_doc_resp_receber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_localizar_resp_receber))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);

        btn_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-salvar-e-fechar-48.png"))); // NOI18N
        btn_salvar.setToolTipText("Salvar lançamento");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_salvar);

        btn_novo_lancamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-reiniciar-48.png"))); // NOI18N
        btn_novo_lancamento.setToolTipText("Novo lançamento");
        jToolBar1.add(btn_novo_lancamento);

        btn_atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-design-48.png"))); // NOI18N
        btn_atualizar.setToolTipText("Atualizar dados");
        btn_atualizar.setEnabled(false);
        btn_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_atualizar);

        btn_deletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-lixo-48.png"))); // NOI18N
        btn_deletar.setToolTipText("Excluir registro");
        btn_deletar.setEnabled(false);
        jToolBar1.add(btn_deletar);

        btn_localizar_registro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/org/assembleia/imagens/icons8-pesquisa-paga-48.png"))); // NOI18N
        btn_localizar_registro.setToolTipText("Buscar registro");
        btn_localizar_registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_localizar_registroActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_localizar_registro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campos_dizimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campos_dizimista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campos_membros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 158, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campos_dizimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campos_dizimista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campos_membros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        // verificamos se os campos obrigatorios foram preenchidos
//        Component[] pessoas = campos_dizimista.getComponents();
//        Component[] dizimos = campos_dizimo.getComponents();

        if (verificarCamposObrigatorios(campos_dizimista.getComponents()) && verificarCamposObrigatorios(campos_membros.getComponents())) {
            if (verificarCamposObrigatorios(campos_dizimo.getComponents())) {

                // geração do recibo
                Recibo_Control recibo = new Recibo_Control();
                ReciboModel reciboModel = recibo.gravarRecibo();

                // caso nao tenha sido gerado o recibo, não sera feito a gravação
                if (reciboModel == null) {

                    JOptionPane.showMessageDialog(null, "Ops... não foi possivel gerar um recibo para este registro!");

                } else {

                    EntradasModel entrada = new EntradasModel();
                    entrada.setData(campo_data_lancamento.getText());
                    entrada.setCompetencia(campo_competencia.getText());
                    entrada.setDescricao("Registro de entrada referente dizimos");
                    entrada.setSituacao("A");
                    entrada.setTipo_entrada("Dizimo");
                    entrada.setValor(campo_valor_dizimo.getText());
                    entrada.setTipo_entrada("Dizimo");

                    // setando o valor do ID do recibo para este lançamento de entrada
                    entrada.setRecibo(reciboModel.getIdRecibo());

                    // atributo que ira disponibilizar para impressao o recibo
                    idRecibo = reciboModel.getIdRecibo();

                    // inserindo novas informações na tabela entradas
                    registro_entrada_control novoLancamento = new registro_entrada_control();
                    int idEntrada = novoLancamento.inserirNovoRegEntrada(entrada);

                    // ativa o botao para imprimir o recibo
                    if (idEntrada != 0) {

                        // realiza inserção de dados na tabela especifica de dizimos
                        DizimoModel dizimo = new DizimoModel();
                        dizimo.setCompetencia(campo_competencia.getText());
                        dizimo.setData(entrada.getData());
                        dizimo.setDescricao("Registro de entrada referente dizimos");
                        dizimo.setIdDizimista(this.membroDizimista.getId_pessoa());
                        dizimo.setIdMembroReceptor(this.membroReceptor.getId_pessoa());
                        dizimo.setRecibo(idRecibo);
                        dizimo.setSituacao("A");
                        dizimo.setValor(entrada.getValor());
                        dizimo.setIdEntrada(idEntrada);

                        DizimoController controller = new DizimoController();
                        dizimo = controller.insertRegistroDizimo(dizimo);

                        if (dizimo.getIdentificador() != 0) {

                            JOptionPane.showMessageDialog(null, "Registro efetuado com sucesso!!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                            lbl_recibo.setText(reciboModel.getAnoRecibo() + "-" + reciboModel.getSequencia());
                        }
                    }

                }

            } else {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatorios referente ao dizimo :)", "Mensagem", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatorios referente a pessoa :)", "Mensagem", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_localizar_membro_dizimistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_localizar_membro_dizimistaActionPerformed
        form_localizar_pessoas localizar = new form_localizar_pessoas(null, true);
        localizar.setVisible(true);

        if (localizar.getPessoa != null) {

            // this.id_pessoa_selecionada = localizar.codigo_pessoa;
            preencherCamposPessoasDizimista(localizar.getPessoa);

        } else {

            JOptionPane.showMessageDialog(this, "Ops...nenhuma pessoa selecionada, verifique", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_btn_localizar_membro_dizimistaActionPerformed

    private void btn_localizar_registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_localizar_registroActionPerformed
        // localizar registro para alteração
        form_localizar_dizimos localizar = new form_localizar_dizimos(null, true);
        localizar.setVisible(true);

        if (localizar.cod_reg != 0) {
            preencherCamposRegistroParaAlterar(localizar.cod_reg);
            this.id_registro_dizimo = localizar.cod_reg;

            // Desativando botoes
            btn_novo_lancamento.setEnabled(false);
            btn_salvar.setEnabled(false);

            // ativando btn de exclusao
            btn_deletar.setEnabled(true);
            btn_atualizar.setEnabled(true);
        }
    }//GEN-LAST:event_btn_localizar_registroActionPerformed

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizarActionPerformed
        // verificamos se os campos obrigatorios foram preenchidos
        Component[] pessoas = campos_dizimista.getComponents();
        Component[] dizimos = campos_dizimo.getComponents();

        if (verificarCamposObrigatorios(pessoas)) {
            if (verificarCamposObrigatorios(dizimos)) {
                /*
                DizimoModel lanc_dizimo = new DizimoModel();
                MembroModel pessoa = new MembroModel();
                lanc_dizimo.setCompetencia(campo_competencia.getText());
                lanc_dizimo.setData(campo_data_lancamento.getText());
                lanc_dizimo.setId_dizimo(this.id_registro_dizimo);
                lanc_dizimo.setValor(convertValorInfo(campo_valor_dizimo.getText()));
                lanc_dizimo.setRecibo(Integer.parseInt(campo_num_recibo.getText()));
                pessoa.setId_pessoa(this.id_pessoa_selecionada);
                lanc_dizimo.setPessoa(pessoa);

                // chamando metodo que ira fazer a atualização na base de dados
                dizimo_control control = new dizimo_control();
                control.atualizarRegistroDizimo(lanc_dizimo);
                 */
            } else {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatorios referente ao dizimo :)", "Mensagem", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatorios referente a pessoa :)", "Mensagem", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btn_atualizarActionPerformed

    private void campo_data_lancamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_data_lancamentoKeyPressed
        // capturando o evento ENTER
        if (evt.getKeyCode() == evt.VK_ENTER) {
            campo_valor_dizimo.requestFocus();
        }
    }//GEN-LAST:event_campo_data_lancamentoKeyPressed

    private void campo_competenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_competenciaKeyPressed

    }//GEN-LAST:event_campo_competenciaKeyPressed

    private void campo_valor_dizimoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_valor_dizimoKeyPressed
        // capturando o evento ENTER
        if (evt.getKeyCode() == evt.VK_ENTER) {
            btn_localizar_membro_dizimista.requestFocus();
        }
    }//GEN-LAST:event_campo_valor_dizimoKeyPressed

    private void btn_localizar_resp_receberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_localizar_resp_receberActionPerformed

        form_localizar_pessoas localizar = new form_localizar_pessoas(null, true, "membro");
        localizar.setVisible(true);

        if (localizar.getMembro != null) {

            // this.id_pessoa_selecionada = localizar.codigo_pessoa;
            preencherCamposMembroResponsavel(localizar.getMembro);

        } else {

            JOptionPane.showMessageDialog(this, "Ops...nenhum membro foi selecionado, verifique", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_btn_localizar_resp_receberActionPerformed

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
            java.util.logging.Logger.getLogger(form_entrada_dizimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_entrada_dizimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_entrada_dizimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_entrada_dizimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                form_entrada_dizimo dialog = new form_entrada_dizimo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_atualizar;
    private javax.swing.JButton btn_deletar;
    private javax.swing.JButton btn_localizar_membro_dizimista;
    private javax.swing.JButton btn_localizar_registro;
    private javax.swing.JButton btn_localizar_resp_receber;
    private javax.swing.JButton btn_novo_lancamento;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JTextField campo_competencia;
    private javax.swing.JFormattedTextField campo_data_lancamento;
    private javax.swing.JTextField campo_doc_membro_dizimista;
    private javax.swing.JTextField campo_doc_resp_receber;
    private javax.swing.JTextField campo_nome_membro_dizimista;
    private javax.swing.JTextField campo_nome_resp_receber;
    private javax.swing.JFormattedTextField campo_valor_dizimo;
    private javax.swing.JPanel campos_dizimista;
    private javax.swing.JPanel campos_dizimo;
    private javax.swing.JPanel campos_membros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbl_recibo;
    // End of variables declaration//GEN-END:variables
}
