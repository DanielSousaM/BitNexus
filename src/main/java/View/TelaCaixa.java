/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.CadastrodeplanoController;
import Controller.ClienteController;
import Controller.CodigoCaixaController;
import Controller.MonitoramentoController;
import Model.CadastroDeFuncionarioModel;
import Model.Cadastrodeplano;
import Model.ClienteModel;
import Model.CodigoCaixaModel;
import Model.MonitoramentoModel;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALUNO
 */
public class TelaCaixa extends javax.swing.JFrame {

    MonitoramentoController maquinasController = new MonitoramentoController();
    ClienteController clientesControler = new ClienteController();
    CodigoCaixaController caixaController = new CodigoCaixaController();
    CadastrodeplanoController planosController = new CadastrodeplanoController();
    private String dataAtual;
    private String horaAtual;
    private int idSelecionado;
    private int idClienteSelecionado;
    private int idMaquinaSelecionado;
    private int idPlanoSelecionado;

    // lista para guardar os ids
    List<Integer> idClientes = new ArrayList<>();

    List<Integer> idMaquinas = new ArrayList<>();

    List<Integer> idPlanos = new ArrayList<>();
    List<Double> valorPlanos = new ArrayList<>();
    double valorP = 0;

    public TelaCaixa() {
        initComponents();
        listarCaixaNaTabela();
        listarCaixa();
        listarClienteComboBox();
        listarMaquinasComboBox();
        listarCadastrodeplanoComboBox();

        nomeClientes.addActionListener(e
                -> {
            int index = nomeClientes.getSelectedIndex();
            if (index >= 0 && index < idClientes.size()) {
                idClienteSelecionado = idClientes.get(index);
            }
        }
        );

        selecionarMaquina.addActionListener(e
                -> {
            int index = selecionarMaquina.getSelectedIndex();
            if (index >= 0 && index < idMaquinas.size()) {
                idMaquinaSelecionado = idMaquinas.get(index);
            }
        }
        );

        planoEscolhido.addActionListener(e
                -> {
            int index = planoEscolhido.getSelectedIndex();
            if (index >= 0 && index < idPlanos.size() && index < valorPlanos.size()) {
                idPlanoSelecionado = idPlanos.get(index);
                valorP = valorPlanos.get(index);
                valorPagamento.setText(String.format("%.2f", valorP));
            }
        }
        );

        tabelaCaixa.addMouseListener(
                new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt
            ) {
                int linhaSelecionada = tabelaCaixa.getSelectedRow();

                if (linhaSelecionada >= 0) {
                    String cliente = tabelaCaixa.getValueAt(linhaSelecionada, 0).toString();
                    nomeClientes.setSelectedItem(cliente);

                    String tipoServico = tabelaCaixa.getValueAt(linhaSelecionada, 1).toString();
                    selecionarTipoDeServico.setSelectedItem(tipoServico);

                    String valor = tabelaCaixa.getValueAt(linhaSelecionada, 2).toString();
                    valorPagamento.setText(valor);

                    String formaDePagamento = tabelaCaixa.getValueAt(linhaSelecionada, 3).toString();
                    formaPagamento.setSelectedItem(formaDePagamento);

                    String maquina = tabelaCaixa.getValueAt(linhaSelecionada, 4).toString();
                    selecionarMaquina.setSelectedItem(maquina);

                    String data = tabelaCaixa.getValueAt(linhaSelecionada, 5).toString();
                    // Se você tiver um campo para a data, coloque aqui: campoData.setText(data);

                    String hora = tabelaCaixa.getValueAt(linhaSelecionada, 6).toString();
                    // Se tiver campo de hora: campoHora.setText(hora);

                    idSelecionado = Integer.parseInt(tabelaCaixa.getValueAt(linhaSelecionada, 7).toString());
                }
            }
        }
        );

        campoPesquisarCaixa.getDocument()
                .addDocumentListener(new javax.swing.event.DocumentListener() {

                    public void insertUpdate(javax.swing.event.DocumentEvent e) {
                        pesquisar();
                    }

                    public void removeUpdate(javax.swing.event.DocumentEvent e) {
                        pesquisar();
                    }

                    public void changedUpdate(javax.swing.event.DocumentEvent e) {
                        pesquisar();
                    }

                    public void pesquisar() {
                        String textoPesquisaCaixa = campoPesquisarCaixa.getText();
                        filtrarCaixa(textoPesquisaCaixa);

                    }
                });
    } // fim do construtor

    List<ClienteModel> listaClientes;

    public void listarClienteComboBox() {
        listaClientes = clientesControler.listarClientes();
        nomeClientes.removeAllItems();
        for (ClienteModel p : listaClientes) {
            nomeClientes.addItem(p.getNomeCliente());
            idClientes.add(p.getIdCLIENTES());
        }

    }

    List<MonitoramentoModel> listarMaquinas;

    public void listarMaquinasComboBox() {
        listarMaquinas = maquinasController.listarMaquinas();
        selecionarMaquina.removeAllItems();
        for (MonitoramentoModel p : listarMaquinas) {
            selecionarMaquina.addItem(p.getNomeMaquina());
            idMaquinas.add(p.getIdMAQUINAS());
        }

    }

    List<Cadastrodeplano> listarPlanos;

    public void listarCadastrodeplanoComboBox() {
        listarPlanos = planosController.listarTodos();
        planoEscolhido.removeAllItems();
        for (Cadastrodeplano p : listarPlanos) {
            planoEscolhido.addItem(p.getNomePlano());
            idPlanos.add(p.getIdPLANOS());
            valorPlanos.add(p.getValorPlano());
        }

    }

    private void listarCaixaNaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaCaixa.getModel();
        modelo.setRowCount(0); // limpa a tabela

        CodigoCaixaController controller = new CodigoCaixaController();
        List<CodigoCaixaModel> lista = controller.listarCaixa();

        for (CodigoCaixaModel caixa : lista) {
            modelo.addRow(new Object[]{
                caixa.getNomeCliente(),
                caixa.getTipoServico(),
                caixa.getValor(),
                caixa.getFormadepagamento(),
                caixa.getNomeMaquina(),
                caixa.getDataUso(),
                caixa.getTempo()
            });
        }
    }

    public void limparCampos() {
        nomeClientes.setSelectedIndex(0);
        selecionarTipoDeServico.setSelectedIndex(0);
        selecionarMaquina.setSelectedIndex(0);
        valorPagamento.setText("");
        formaPagamento.setSelectedIndex(0);
        idSelecionado = -1;

        campoPesquisarCaixa.setText("");

        // Limpa seleção da tabela, se quiser
        tabelaCaixa.clearSelection();
    }

    public void filtrarCaixa(String campoPesquisarCaixa) {
        List<CodigoCaixaModel> listarCaixa = caixaController.pesquisarCaixa(campoPesquisarCaixa);
        DefaultTableModel modelo = (DefaultTableModel) tabelaCaixa.getModel();
        modelo.setRowCount(0);

        for (CodigoCaixaModel ccm : listarCaixa) {
            if (ccm.getNomeCliente().toLowerCase().contains(campoPesquisarCaixa.toLowerCase())
                    || ccm.getNomeMaquina().toLowerCase().contains(campoPesquisarCaixa.toLowerCase())) {

                modelo.addRow(new Object[]{
                    ccm.getNomeCliente(),
                    ccm.getTipoServico(),
                    ccm.getValor(),
                    ccm.getFormadepagamento(),
                    ccm.getNomeMaquina(),
                    ccm.getDataUso(),
                    ccm.getTempo()

                });
            }
        }
        tabelaCaixa.setModel(modelo);
    }

    public void listarCaixa() {
        List<CodigoCaixaModel> listarCaixa = caixaController.listarCaixa();
        DefaultTableModel modelo = (DefaultTableModel) tabelaCaixa.getModel();
        modelo.setRowCount(0);

        for (CodigoCaixaModel ccm : listarCaixa) {
            modelo.addRow(new Object[]{
                ccm.getNomeCliente(),
                ccm.getTipoServico(),
                ccm.getValor(),
                ccm.getFormadepagamento(),
                ccm.getNomeMaquina(),
                ccm.getDataUso(),
                ccm.getTempo(),
                ccm.getIdCAIXA()
            });
        }
        tabelaCaixa.setModel(modelo);

        //Oculta a coluna do ID
        tabelaCaixa.getColumnModel().getColumn(7).setMinWidth(0);
        tabelaCaixa.getColumnModel().getColumn(7).setMaxWidth(0);
        tabelaCaixa.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCaixa = new javax.swing.JPanel();
        labelCaixa = new javax.swing.JLabel();
        rotuloDoCliente = new javax.swing.JLabel();
        selecionarMaquina = new javax.swing.JComboBox<>();
        maquinas = new javax.swing.JLabel();
        formaDoPagamento = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoPesquisarCaixa = new javax.swing.JTextField();
        nomeClientes = new javax.swing.JComboBox<>();
        valorPagamento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        mesaDeMaquinas = new javax.swing.JScrollPane();
        tabelaCaixa = new javax.swing.JTable();
        tipoDeServicos = new javax.swing.JLabel();
        selecionarTipoDeServico = new javax.swing.JComboBox<>();
        formaPagamento = new javax.swing.JComboBox<>();
        valor = new javax.swing.JLabel();
        planoEscolhido = new javax.swing.JComboBox<>();
        botaoLigar = new javax.swing.JToggleButton();
        voltarMenu = new javax.swing.JButton();
        botaoRelatorio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        botaoHome = new javax.swing.JMenu();
        menuinicial = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle Financeiro");

        painelCaixa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelCaixa.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        labelCaixa.setForeground(new java.awt.Color(255, 255, 255));
        labelCaixa.setText("CAIXA");
        painelCaixa.add(labelCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 100, -1));

        rotuloDoCliente.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rotuloDoCliente.setForeground(new java.awt.Color(255, 255, 255));
        rotuloDoCliente.setText("NOME DO CLIENTE: ");
        painelCaixa.add(rotuloDoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 160, 30));

        selecionarMaquina.setBackground(new java.awt.Color(102, 0, 102));
        selecionarMaquina.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        selecionarMaquina.setForeground(new java.awt.Color(255, 255, 255));
        selecionarMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionarMaquinaActionPerformed(evt);
            }
        });
        painelCaixa.add(selecionarMaquina, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 350, 30));

        maquinas.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        maquinas.setForeground(new java.awt.Color(255, 255, 255));
        maquinas.setText("MÁQUINA: ");
        painelCaixa.add(maquinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 100, -1));

        formaDoPagamento.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        formaDoPagamento.setForeground(new java.awt.Color(255, 255, 255));
        formaDoPagamento.setText("FORMA DE PAGAMENTO: ");
        painelCaixa.add(formaDoPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 200, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PESQUISAR:");
        painelCaixa.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        campoPesquisarCaixa.setBackground(new java.awt.Color(102, 0, 102));
        campoPesquisarCaixa.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        campoPesquisarCaixa.setForeground(new java.awt.Color(255, 255, 255));
        painelCaixa.add(campoPesquisarCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 340, -1));

        nomeClientes.setBackground(new java.awt.Color(102, 0, 102));
        nomeClientes.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        nomeClientes.setForeground(new java.awt.Color(255, 255, 255));
        painelCaixa.add(nomeClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 290, -1));

        valorPagamento.setBackground(new java.awt.Color(102, 0, 102));
        valorPagamento.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        valorPagamento.setForeground(new java.awt.Color(255, 255, 255));
        painelCaixa.add(valorPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 120, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("=");
        painelCaixa.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, -1));

        tabelaCaixa.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tabelaCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome do Cliente", "Tipo de Serviço", "Valor", "Forma de Pagamento", "Máquina", "Data", "Hora", "ID"
            }
        ));
        mesaDeMaquinas.setViewportView(tabelaCaixa);

        painelCaixa.add(mesaDeMaquinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 1020, 310));

        tipoDeServicos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tipoDeServicos.setForeground(new java.awt.Color(255, 255, 255));
        tipoDeServicos.setText("TIPO DE SERVIÇO:");
        painelCaixa.add(tipoDeServicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 170, 40));

        selecionarTipoDeServico.setBackground(new java.awt.Color(102, 0, 102));
        selecionarTipoDeServico.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        selecionarTipoDeServico.setForeground(new java.awt.Color(255, 255, 255));
        selecionarTipoDeServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Bonificação", "Plano\t\t\t", "Teste" }));
        selecionarTipoDeServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionarTipoDeServicoActionPerformed(evt);
            }
        });
        painelCaixa.add(selecionarTipoDeServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 300, 30));

        formaPagamento.setBackground(new java.awt.Color(102, 0, 102));
        formaPagamento.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        formaPagamento.setForeground(new java.awt.Color(255, 255, 255));
        formaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pix", "Cartão", "Dinheiro" }));
        painelCaixa.add(formaPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 240, 30));

        valor.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        valor.setForeground(new java.awt.Color(255, 255, 255));
        valor.setText("VALOR: ");
        painelCaixa.add(valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 60, -1));

        planoEscolhido.setBackground(new java.awt.Color(102, 0, 102));
        planoEscolhido.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        planoEscolhido.setForeground(new java.awt.Color(255, 255, 255));
        planoEscolhido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Planos" }));
        planoEscolhido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planoEscolhidoActionPerformed(evt);
            }
        });
        painelCaixa.add(planoEscolhido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 230, 30));

        botaoLigar.setBackground(new java.awt.Color(102, 0, 102));
        botaoLigar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        botaoLigar.setForeground(new java.awt.Color(255, 255, 255));
        botaoLigar.setText("LIGAR MÁQUINA");
        botaoLigar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLigarActionPerformed(evt);
            }
        });
        painelCaixa.add(botaoLigar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 710, -1, -1));

        voltarMenu.setBackground(new java.awt.Color(102, 0, 102));
        voltarMenu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        voltarMenu.setForeground(new java.awt.Color(255, 255, 255));
        voltarMenu.setText("VOLTAR");
        voltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarMenuActionPerformed(evt);
            }
        });
        painelCaixa.add(voltarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 910, 120, -1));

        botaoRelatorio.setBackground(new java.awt.Color(102, 0, 102));
        botaoRelatorio.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        botaoRelatorio.setForeground(new java.awt.Color(255, 255, 255));
        botaoRelatorio.setText("GERA RELATÓRIO");
        painelCaixa.add(botaoRelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 710, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ALUNO\\Documents\\NetBeansProjects\\ProjetoBitNexus\\src\\main\\java\\img\\Fundo.png")); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jLabel1.setName(""); // NOI18N
        painelCaixa.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -140, 1920, 1350));

        botaoHome.setText("HOME");

        menuinicial.setText("MENU INICIAL");
        menuinicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuinicialActionPerformed(evt);
            }
        });
        botaoHome.add(menuinicial);

        menu.add(botaoHome);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 1076, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void selecionarMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionarMaquinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selecionarMaquinaActionPerformed

    private void planoEscolhidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planoEscolhidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_planoEscolhidoActionPerformed

    private void botaoLigarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLigarActionPerformed
        // TODO add your handling code here:
        try {
            CodigoCaixaModel caixa = new CodigoCaixaModel();

            // Dados básicos da tela
            caixa.setTipoServico(selecionarTipoDeServico.getSelectedItem().toString());
            caixa.setValor(valorP);
            caixa.setFormadepagamento(formaPagamento.getSelectedItem().toString());

            // Data atual
           
           

            // Tempo fixo, ou você pode capturar isso de outro campo
            // Data atual
            java.time.LocalDateTime agora = java.time.LocalDateTime.now();
            java.time.format.DateTimeFormatter formato = java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss");
            java.time.format.DateTimeFormatter data = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataHora = agora.format(formato);
            String dataa = agora.format(data);

            // Tempo fixo, ou você pode capturar isso de outro campo
            caixa.setTempo(dataHora); // Exemplo: 1 hora
             caixa.setDataUso(dataa);
           

            // Captura dos IDs das foreign keys (simulação — você precisa adaptar com busca real)
            caixa.setClientes_idclientes(idClienteSelecionado);
            caixa.setMaquinas_idmaquinas(idMaquinaSelecionado);
            caixa.setPlanos_idplanos(idPlanoSelecionado);
            caixa.setFuncionarios_idfuncionarios(1);

            // Enviar para o controller
            CodigoCaixaController controller = new CodigoCaixaController();
            boolean sucesso = controller.cadastrarCaixa(caixa);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Registro inserido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao inserir no banco de dados.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }

        limparCampos();
        listarCaixa();
    }//GEN-LAST:event_botaoLigarActionPerformed

    private void selecionarTipoDeServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionarTipoDeServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selecionarTipoDeServicoActionPerformed

    private void voltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarMenuActionPerformed
        // TODO add your handling code here:
        TelaHome voltarMenu = new TelaHome();
        voltarMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarMenuActionPerformed

    private void menuinicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuinicialActionPerformed
        // TODO add your handling code here:
        TelaHome menuvoltar = new TelaHome();
        menuvoltar.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuinicialActionPerformed

    private void planoEscolhidoMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        int index = nomeClientes.getSelectedIndex();
        idPlanoSelecionado = idPlanos.get(index + 1);
        double valor = valorPlanos.get(index + 1);
        valorPagamento.setText(String.format("%.2f", valor));

    }

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>s
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu botaoHome;
    private javax.swing.JToggleButton botaoLigar;
    private javax.swing.JButton botaoRelatorio;
    private javax.swing.JTextField campoPesquisarCaixa;
    private javax.swing.JLabel formaDoPagamento;
    private javax.swing.JComboBox<String> formaPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelCaixa;
    private javax.swing.JLabel maquinas;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem menuinicial;
    private javax.swing.JScrollPane mesaDeMaquinas;
    private javax.swing.JComboBox<String> nomeClientes;
    private javax.swing.JPanel painelCaixa;
    private javax.swing.JComboBox<String> planoEscolhido;
    private javax.swing.JLabel rotuloDoCliente;
    private javax.swing.JComboBox<String> selecionarMaquina;
    private javax.swing.JComboBox<String> selecionarTipoDeServico;
    private javax.swing.JTable tabelaCaixa;
    private javax.swing.JLabel tipoDeServicos;
    private javax.swing.JLabel valor;
    private javax.swing.JTextField valorPagamento;
    private javax.swing.JButton voltarMenu;
    // End of variables declaration//GEN-END:variables
}
