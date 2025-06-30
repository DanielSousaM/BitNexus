/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.CadastrodeplanoController;
import Controller.ClienteController;
import Controller.ConexaoComBancoDados;
import Model.Cadastrodeplano;
import Model.ClienteModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALUNO
 */
public class TelaCadastroDeCliente extends javax.swing.JFrame {
    
    ClienteController controler = new ClienteController();
    CadastrodeplanoController planosController = new CadastrodeplanoController();
    List<Integer> idPlanos = new ArrayList<>();
    /**
     * Creates new form telaCadastro
     */
    int idSelecionado;
    int idPlanoSelecionado;

    public TelaCadastroDeCliente() {
        initComponents();
        listarClientes();
        listarCadastrodeplanoComboBox();

        planosEscolha.addActionListener(e -> {
            int index = planosEscolha.getSelectedIndex();
            if (index >= 0 && index < idPlanos.size()) {
                idPlanoSelecionado = idPlanos.get(index);

            }
        });

        tabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int linhaSelecionada = tabelaCliente.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    nomecliente.setText(tabelaCliente.getValueAt(linhaSelecionada, 0).toString());
                    emailcliente.setText(tabelaCliente.getValueAt(linhaSelecionada, 1).toString());
                    cpfcliente.setText(tabelaCliente.getValueAt(linhaSelecionada, 2).toString());
                    telefonecliente.setText(tabelaCliente.getValueAt(linhaSelecionada, 3).toString());
                    enderecocliente.setText(tabelaCliente.getValueAt(linhaSelecionada, 4).toString());
                    
                    String planotabela = tabelaCliente.getValueAt(linhaSelecionada, 5).toString();
                    planosEscolha.setSelectedItem(planotabela);
                   
                    idSelecionado = Integer.parseInt(tabelaCliente.getValueAt(linhaSelecionada, 6).toString());
                   
                }
            }
        });

        pesquisarcliente.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                pesquisar();
            }

            public void removeUpdate(DocumentEvent e) {
                pesquisar();
            }

            public void changedUpdate(DocumentEvent e) {

                pesquisar();
            }

            public void pesquisar() {
                String textoPesquisarCliente = pesquisarcliente.getText();
                filtrarCliente(textoPesquisarCliente);
            }
        });
    }
    
    public void filtrarCliente(String textoPesquisarCliente) {
        List<ClienteModel> listarCliente = controler.pesquisar(textoPesquisarCliente);
        DefaultTableModel modelo = (DefaultTableModel) tabelaCliente.getModel();
        modelo.setRowCount(0);

        for (ClienteModel c : listarCliente) {
            if (c.getNomeCliente().toLowerCase().contains(textoPesquisarCliente.toLowerCase())
                    || c.getCpfCliente().toLowerCase().contains(textoPesquisarCliente.toLowerCase())) {

                modelo.addRow(new Object[]{
                    c.getNomeCliente(),
                    c.getEmailCliente(),
                    c.getCpfCliente(),
                    c.getTelefoneCliente(),
                    c.getEnderecoCliente(),
                    c.getNomePlano(),
                    c.getIdCLIENTES()
                });
            }
        }
        tabelaCliente.setModel(modelo);
    }

    List<Cadastrodeplano> listarPlanos;
    
     public void listarCadastrodeplanoComboBox() {
        listarPlanos = planosController.listarTodos();
        planosEscolha.removeAllItems();
        for (Cadastrodeplano p : listarPlanos) {
            planosEscolha.addItem(p.getNomePlano());
            idPlanos.add(p.getIdPLANOS());
        }
    }

    private void limparCampos() {
        nomecliente.setText("");
        emailcliente.setText("");
        cpfcliente.setText("");
        telefonecliente.setText("");
        enderecocliente.setText("");
        planosEscolha.setSelectedIndex(0); // ou -1 se quiser nenhum selecionado
    }

    public void listarClientes() {
        List<ClienteModel> listar = controler.listarClientes();
        DefaultTableModel modelo = (DefaultTableModel) tabelaCliente.getModel();
        modelo.setRowCount(0);

        for (ClienteModel c : listar) {
            modelo.addRow(new Object[]{
                c.getNomeCliente(),
                c.getEmailCliente(),
                c.getCpfCliente(),
                c.getTelefoneCliente(),
                c.getEnderecoCliente(),
                c.getNomePlano(),
                c.getIdCLIENTES()
            });
        }
        tabelaCliente.setModel(modelo);
        
        //Oculta a coluna do ID
        tabelaCliente.getColumnModel().getColumn(6).setMinWidth(0);
        tabelaCliente.getColumnModel().getColumn(6).setMaxWidth(0);
        tabelaCliente.getColumnModel().getColumn(6).setMaxWidth(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCadastro1 = new javax.swing.JPanel();
        telefonecliente = new javax.swing.JFormattedTextField();
        nomeCompleto = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoCpf = new javax.swing.JLabel();
        telefone = new javax.swing.JLabel();
        endereço = new javax.swing.JLabel();
        enderecocliente = new javax.swing.JTextField();
        emailcliente = new javax.swing.JTextField();
        nomecliente = new javax.swing.JTextField();
        cadastrarCliente = new javax.swing.JButton();
        cpfcliente = new javax.swing.JFormattedTextField();
        editarCliente = new javax.swing.JButton();
        planoCliente = new javax.swing.JLabel();
        planosEscolha = new javax.swing.JComboBox<>();
        voltarMenu = new javax.swing.JButton();
        pesquisarcliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        butonHome = new javax.swing.JMenu();
        menuinicial = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelCadastro1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        telefonecliente.setBackground(new java.awt.Color(102, 0, 102));
        telefonecliente.setForeground(new java.awt.Color(255, 255, 255));
        try {
            telefonecliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        telefonecliente.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        painelCadastro1.add(telefonecliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 350, 30));

        nomeCompleto.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        nomeCompleto.setForeground(new java.awt.Color(255, 255, 255));
        nomeCompleto.setText("NOME COMPLETO:");
        painelCadastro1.add(nomeCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 150, -1));

        email.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setText("E-MAIL:");
        painelCadastro1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CADASTRO DE CLIENTES");
        painelCadastro1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 250, -1));

        campoCpf.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        campoCpf.setForeground(new java.awt.Color(255, 255, 255));
        campoCpf.setText("CPF:");
        painelCadastro1.add(campoCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        telefone.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        telefone.setForeground(new java.awt.Color(255, 255, 255));
        telefone.setText("TELEFONE:");
        painelCadastro1.add(telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        endereço.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        endereço.setForeground(new java.awt.Color(255, 255, 255));
        endereço.setText("ENDEREÇO:");
        painelCadastro1.add(endereço, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        enderecocliente.setBackground(new java.awt.Color(102, 0, 102));
        enderecocliente.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        enderecocliente.setForeground(new java.awt.Color(255, 255, 255));
        enderecocliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enderecoclienteActionPerformed(evt);
            }
        });
        painelCadastro1.add(enderecocliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 350, 30));

        emailcliente.setBackground(new java.awt.Color(102, 0, 102));
        emailcliente.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        emailcliente.setForeground(new java.awt.Color(255, 255, 255));
        emailcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailclienteActionPerformed(evt);
            }
        });
        painelCadastro1.add(emailcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 350, -1));

        nomecliente.setBackground(new java.awt.Color(102, 0, 102));
        nomecliente.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        nomecliente.setForeground(new java.awt.Color(255, 255, 255));
        painelCadastro1.add(nomecliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 350, -1));

        cadastrarCliente.setBackground(new java.awt.Color(102, 0, 102));
        cadastrarCliente.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cadastrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        cadastrarCliente.setText("CADASTRAR");
        cadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarClienteActionPerformed(evt);
            }
        });
        painelCadastro1.add(cadastrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 700, 130, 30));

        cpfcliente.setBackground(new java.awt.Color(102, 0, 102));
        cpfcliente.setForeground(new java.awt.Color(255, 255, 255));
        try {
            cpfcliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpfcliente.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        painelCadastro1.add(cpfcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 350, 30));

        editarCliente.setBackground(new java.awt.Color(102, 0, 102));
        editarCliente.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        editarCliente.setForeground(new java.awt.Color(255, 255, 255));
        editarCliente.setText("EDITAR");
        editarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarClienteActionPerformed(evt);
            }
        });
        painelCadastro1.add(editarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 700, 120, -1));

        planoCliente.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        planoCliente.setForeground(new java.awt.Color(255, 255, 255));
        planoCliente.setText("PLANOS:");
        painelCadastro1.add(planoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 70, 30));

        planosEscolha.setBackground(new java.awt.Color(102, 0, 102));
        planosEscolha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        planosEscolha.setForeground(new java.awt.Color(255, 255, 255));
        planosEscolha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Planos" }));
        painelCadastro1.add(planosEscolha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 350, -1));

        voltarMenu.setBackground(new java.awt.Color(102, 0, 102));
        voltarMenu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        voltarMenu.setForeground(new java.awt.Color(255, 255, 255));
        voltarMenu.setText("VOLTAR");
        voltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarMenuActionPerformed(evt);
            }
        });
        painelCadastro1.add(voltarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 910, 130, -1));

        pesquisarcliente.setBackground(new java.awt.Color(102, 0, 102));
        pesquisarcliente.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        pesquisarcliente.setForeground(new java.awt.Color(255, 255, 255));
        painelCadastro1.add(pesquisarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 340, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PESQUISAR:");
        painelCadastro1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 100, 40));

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome do Cliente", "Email", "CPF", "Telefone", "Endereço", "Plano", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaCliente.setToolTipText("");
        jScrollPane1.setViewportView(tabelaCliente);

        painelCadastro1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 900, 210));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ALUNO\\Documents\\NetBeansProjects\\ProjetoBitNexus\\src\\main\\java\\img\\Fundo.png")); // NOI18N
        painelCadastro1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 1920, 1160));

        butonHome.setText("HOME");

        menuinicial.setText("MENU INICIAL");
        menuinicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuinicialActionPerformed(evt);
            }
        });
        butonHome.add(menuinicial);

        jMenuBar1.add(butonHome);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCadastro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCadastro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void enderecoclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enderecoclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enderecoclienteActionPerformed

    private void emailclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailclienteActionPerformed

    private void cadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarClienteActionPerformed
        // TODO add your handling code here:
      ClienteModel cliente = new ClienteModel();

        cliente.setNomeCliente(nomecliente.getText());
        cliente.setEmailCliente(emailcliente.getText());
        cliente.setCpfCliente(cpfcliente.getText());
        cliente.setTelefoneCliente(telefonecliente.getText());
        cliente.setEnderecoCliente(enderecocliente.getText());
        cliente.setPLANOS_IdPLANOS(idPlanoSelecionado);

        boolean result = controler.cadastrarCliente(cliente);
        if (result != false) {
            JOptionPane.showMessageDialog(this, "Cadastro de cliente realizado com sucesso");
            listarClientes();
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Falha ao cadastrar");
        }

    }//GEN-LAST:event_cadastrarClienteActionPerformed

    private void voltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarMenuActionPerformed
        // TODO add your handling code here:
        TelaHome voltarMenu = new TelaHome() ;
        voltarMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarMenuActionPerformed

    private void editarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarClienteActionPerformed
        // TODO add your handling code here:
        ClienteModel modelCliente = new ClienteModel();
        modelCliente.setNomeCliente(nomecliente.getText());
        modelCliente.setEmailCliente(emailcliente.getText());
        modelCliente.setCpfCliente(cpfcliente.getText());
        modelCliente.setTelefoneCliente(telefonecliente.getText());
        modelCliente.setEnderecoCliente(enderecocliente.getText());
        modelCliente.setIdCLIENTES(idSelecionado);
        modelCliente.setPLANOS_IdPLANOS(idPlanoSelecionado);
        // chamando o metodo de atualizar e mandando os novos dados 
        if (controler.editarCliente(modelCliente)) {
            JOptionPane.showMessageDialog(null, "Dados atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel atualizar os dados!");
        }
        listarClientes();
    }//GEN-LAST:event_editarClienteActionPerformed

    private void menuinicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuinicialActionPerformed
        // TODO add your handling code here:
        TelaHome menuvoltar = new TelaHome();
        menuvoltar.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuinicialActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroDeCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroDeCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroDeCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroDeCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroDeCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu butonHome;
    private javax.swing.JButton cadastrarCliente;
    private javax.swing.JLabel campoCpf;
    private javax.swing.JFormattedTextField cpfcliente;
    private javax.swing.JButton editarCliente;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailcliente;
    private javax.swing.JTextField enderecocliente;
    private javax.swing.JLabel endereço;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuinicial;
    private javax.swing.JLabel nomeCompleto;
    private javax.swing.JTextField nomecliente;
    private javax.swing.JPanel painelCadastro1;
    private javax.swing.JTextField pesquisarcliente;
    private javax.swing.JLabel planoCliente;
    private javax.swing.JComboBox<String> planosEscolha;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JLabel telefone;
    private javax.swing.JFormattedTextField telefonecliente;
    private javax.swing.JButton voltarMenu;
    // End of variables declaration//GEN-END:variables
}
