/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.MonitoramentoController;
import Model.MonitoramentoModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALUNO
 */
public class TelaMonitoramento extends javax.swing.JFrame {
    
    MonitoramentoController controller = new MonitoramentoController();
    /**
     * Creates new form TelaMonitoramento
     */
    public TelaMonitoramento() {
        initComponents();
        //listarMonitoramentoTabela();
    }
    
    public void listarMonitoramentoTabela(){
        //jogando a lista do controller em uma variavel
        List<MonitoramentoModel> listaMaquinas = controller.listarMaquinas();
        // criando modelo padrao de tabela
        DefaultTableModel modelo = new DefaultTableModel();
                                                  // (DefaultTableModel) 
                                                  // tabelamonitoramento.getModel();
         //limpando as linhas da tabela
         //modelo.setRowCount(0);
        //jogar as informaçoes dentro da tabela modelo
        for(MonitoramentoModel m : listaMaquinas){
        
             modelo.addRow(new Object[]{
             
             m.getNomeMaquina(),
             m.getTipoMaquina()
             });
        }
        //tabelaMonitoramento.setModel(modelo); captura o modelo da tabela
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaPC1 = new javax.swing.JPanel();
        pc1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        telaPlay2 = new javax.swing.JPanel();
        play2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        telaPlay3 = new javax.swing.JPanel();
        play3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        telaPlay1 = new javax.swing.JPanel();
        play1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        telaPC3 = new javax.swing.JPanel();
        pc3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        telaSimulador1 = new javax.swing.JPanel();
        simulador1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        telaSimulador2 = new javax.swing.JPanel();
        simulador2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        telaSimulador3 = new javax.swing.JPanel();
        simulador3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        telaPC2 = new javax.swing.JPanel();
        pc2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        gerarrelatorio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        telaPC1.setBackground(new java.awt.Color(204, 204, 204));

        pc1.setText("PC 1 ");

        javax.swing.GroupLayout telaPC1Layout = new javax.swing.GroupLayout(telaPC1);
        telaPC1.setLayout(telaPC1Layout);
        telaPC1Layout.setHorizontalGroup(
            telaPC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaPC1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pc1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        telaPC1Layout.setVerticalGroup(
            telaPC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaPC1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaPC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(pc1)
                    .addComponent(jLabel13))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        getContentPane().add(telaPC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 140, -1));

        telaPlay2.setBackground(new java.awt.Color(204, 204, 204));

        play2.setText("PLAY 2");

        javax.swing.GroupLayout telaPlay2Layout = new javax.swing.GroupLayout(telaPlay2);
        telaPlay2.setLayout(telaPlay2Layout);
        telaPlay2Layout.setHorizontalGroup(
            telaPlay2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaPlay2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(play2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        telaPlay2Layout.setVerticalGroup(
            telaPlay2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaPlay2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaPlay2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel20)
                    .addComponent(play2))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        getContentPane().add(telaPlay2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 140, 100));

        telaPlay3.setBackground(new java.awt.Color(204, 204, 204));

        play3.setText("PLAY 3");

        javax.swing.GroupLayout telaPlay3Layout = new javax.swing.GroupLayout(telaPlay3);
        telaPlay3.setLayout(telaPlay3Layout);
        telaPlay3Layout.setHorizontalGroup(
            telaPlay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaPlay3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(play3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        telaPlay3Layout.setVerticalGroup(
            telaPlay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaPlay3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaPlay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel21)
                    .addComponent(play3))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        getContentPane().add(telaPlay3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 130, -1));

        telaPlay1.setBackground(new java.awt.Color(204, 204, 204));

        play1.setText("PLAY 1");

        javax.swing.GroupLayout telaPlay1Layout = new javax.swing.GroupLayout(telaPlay1);
        telaPlay1.setLayout(telaPlay1Layout);
        telaPlay1Layout.setHorizontalGroup(
            telaPlay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaPlay1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(play1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );
        telaPlay1Layout.setVerticalGroup(
            telaPlay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaPlay1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaPlay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(play1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        getContentPane().add(telaPlay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 140, -1));

        telaPC3.setBackground(new java.awt.Color(204, 204, 204));

        pc3.setText("PC 3");

        javax.swing.GroupLayout telaPC3Layout = new javax.swing.GroupLayout(telaPC3);
        telaPC3.setLayout(telaPC3Layout);
        telaPC3Layout.setHorizontalGroup(
            telaPC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaPC3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pc3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        telaPC3Layout.setVerticalGroup(
            telaPC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaPC3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaPC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15)
                    .addComponent(pc3))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        getContentPane().add(telaPC3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 130, -1));

        telaSimulador1.setBackground(new java.awt.Color(204, 204, 204));

        simulador1.setText("SIMULADOR 1");

        javax.swing.GroupLayout telaSimulador1Layout = new javax.swing.GroupLayout(telaSimulador1);
        telaSimulador1.setLayout(telaSimulador1Layout);
        telaSimulador1Layout.setHorizontalGroup(
            telaSimulador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaSimulador1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simulador1)
                .addGap(18, 18, 18))
        );
        telaSimulador1Layout.setVerticalGroup(
            telaSimulador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaSimulador1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaSimulador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel16)
                    .addComponent(simulador1))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        getContentPane().add(telaSimulador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 140, -1));

        telaSimulador2.setBackground(new java.awt.Color(204, 204, 204));

        simulador2.setText("SIMULADOR 2");

        javax.swing.GroupLayout telaSimulador2Layout = new javax.swing.GroupLayout(telaSimulador2);
        telaSimulador2.setLayout(telaSimulador2Layout);
        telaSimulador2Layout.setHorizontalGroup(
            telaSimulador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaSimulador2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simulador2)
                .addGap(23, 23, 23))
        );
        telaSimulador2Layout.setVerticalGroup(
            telaSimulador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaSimulador2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaSimulador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel17)
                    .addComponent(simulador2))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        getContentPane().add(telaSimulador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 140, -1));

        telaSimulador3.setBackground(new java.awt.Color(204, 204, 204));

        simulador3.setText("SIMULADOR 3");

        javax.swing.GroupLayout telaSimulador3Layout = new javax.swing.GroupLayout(telaSimulador3);
        telaSimulador3.setLayout(telaSimulador3Layout);
        telaSimulador3Layout.setHorizontalGroup(
            telaSimulador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaSimulador3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simulador3)
                .addGap(18, 18, 18))
        );
        telaSimulador3Layout.setVerticalGroup(
            telaSimulador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaSimulador3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaSimulador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel18)
                    .addComponent(simulador3))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        getContentPane().add(telaSimulador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 130, -1));

        telaPC2.setBackground(new java.awt.Color(204, 204, 204));

        pc2.setText("PC 2");

        javax.swing.GroupLayout telaPC2Layout = new javax.swing.GroupLayout(telaPC2);
        telaPC2.setLayout(telaPC2Layout);
        telaPC2Layout.setHorizontalGroup(
            telaPC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaPC2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(31, 31, 31)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pc2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        telaPC2Layout.setVerticalGroup(
            telaPC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaPC2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaPC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel8)
                    .addComponent(pc2))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        getContentPane().add(telaPC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 140, 100));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("MONITORAMENTO DE EQUIPAMENTOS");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 25, 280, 33));

        gerarrelatorio.setBackground(new java.awt.Color(51, 0, 51));
        gerarrelatorio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gerarrelatorio.setForeground(new java.awt.Color(255, 255, 255));
        gerarrelatorio.setText("GERAR RELATORIO");
        getContentPane().add(gerarrelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 460, 160, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\ProjetoBitNexus\\src\\main\\java\\img\\Cadastro (2).png")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TelaMonitoramento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMonitoramento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMonitoramento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMonitoramento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() { 
            public void run() {
                new TelaMonitoramento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gerarrelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel pc1;
    private javax.swing.JLabel pc2;
    private javax.swing.JLabel pc3;
    private javax.swing.JLabel play1;
    private javax.swing.JLabel play2;
    private javax.swing.JLabel play3;
    private javax.swing.JLabel simulador1;
    private javax.swing.JLabel simulador2;
    private javax.swing.JLabel simulador3;
    private javax.swing.JPanel telaPC1;
    private javax.swing.JPanel telaPC2;
    private javax.swing.JPanel telaPC3;
    private javax.swing.JPanel telaPlay1;
    private javax.swing.JPanel telaPlay2;
    private javax.swing.JPanel telaPlay3;
    private javax.swing.JPanel telaSimulador1;
    private javax.swing.JPanel telaSimulador2;
    private javax.swing.JPanel telaSimulador3;
    // End of variables declaration//GEN-END:variables
}