/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author ALUNO
 */
public class TelaEsqueceuSenha extends javax.swing.JFrame {

    /**
     * Creates new form TelaEsqueciSenha
     */
    public TelaEsqueceuSenha() {
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

        painelEsqueciSenha = new javax.swing.JPanel();
        emailEsqueciSenha = new javax.swing.JLabel();
        novaSenha = new javax.swing.JLabel();
        repitaSenha = new javax.swing.JLabel();
        novasenha = new javax.swing.JPasswordField();
        redefinirSenha = new javax.swing.JButton();
        voltaTelaLogin = new javax.swing.JButton();
        tituloEsqueciSenha = new javax.swing.JLabel();
        novasenhaR = new javax.swing.JPasswordField();
        campoEsqueciSenhaCpf = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelEsqueciSenha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailEsqueciSenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        emailEsqueciSenha.setForeground(new java.awt.Color(255, 255, 255));
        emailEsqueciSenha.setText("CPF:");
        painelEsqueciSenha.add(emailEsqueciSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        novaSenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        novaSenha.setForeground(new java.awt.Color(255, 255, 255));
        novaSenha.setText("NOVA SENHA:");
        painelEsqueciSenha.add(novaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        repitaSenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        repitaSenha.setForeground(new java.awt.Color(255, 255, 255));
        repitaSenha.setText("REPITA A SENHA:");
        painelEsqueciSenha.add(repitaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        novasenha.setBackground(new java.awt.Color(102, 0, 102));
        novasenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        novasenha.setForeground(new java.awt.Color(255, 255, 255));
        novasenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novasenhaActionPerformed(evt);
            }
        });
        painelEsqueciSenha.add(novasenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 350, -1));

        redefinirSenha.setBackground(new java.awt.Color(102, 0, 102));
        redefinirSenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        redefinirSenha.setForeground(new java.awt.Color(255, 255, 255));
        redefinirSenha.setText("REDEFINIR");
        redefinirSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                redefinirSenhaMouseClicked(evt);
            }
        });
        painelEsqueciSenha.add(redefinirSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, -1, -1));

        voltaTelaLogin.setBackground(new java.awt.Color(102, 0, 102));
        voltaTelaLogin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        voltaTelaLogin.setForeground(new java.awt.Color(255, 255, 255));
        voltaTelaLogin.setText("VOLTAR");
        voltaTelaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltaTelaLoginActionPerformed(evt);
            }
        });
        painelEsqueciSenha.add(voltaTelaLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        tituloEsqueciSenha.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tituloEsqueciSenha.setForeground(new java.awt.Color(255, 255, 255));
        tituloEsqueciSenha.setText("Redefiniçao de Senha");
        painelEsqueciSenha.add(tituloEsqueciSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        novasenhaR.setBackground(new java.awt.Color(102, 0, 102));
        novasenhaR.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        novasenhaR.setForeground(new java.awt.Color(255, 255, 255));
        novasenhaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novasenhaRActionPerformed(evt);
            }
        });
        painelEsqueciSenha.add(novasenhaR, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 350, -1));

        campoEsqueciSenhaCpf.setBackground(new java.awt.Color(102, 0, 102));
        campoEsqueciSenhaCpf.setForeground(new java.awt.Color(255, 255, 255));
        try {
            campoEsqueciSenhaCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        painelEsqueciSenha.add(campoEsqueciSenhaCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 350, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\ProjetoBitNexus\\src\\main\\java\\img\\Cadastro (2).png")); // NOI18N
        painelEsqueciSenha.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelEsqueciSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelEsqueciSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void novasenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novasenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_novasenhaActionPerformed

    private void voltaTelaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltaTelaLoginActionPerformed
        // TODO add your handling code here:
        TelaLogin loginls= new TelaLogin();
        loginls.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_voltaTelaLoginActionPerformed

    private void redefinirSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redefinirSenhaMouseClicked
        // TODO add your handling code here:
        TelaLogin logints= new TelaLogin();
        logints.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_redefinirSenhaMouseClicked

    private void novasenhaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novasenhaRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_novasenhaRActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEsqueceuSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEsqueceuSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEsqueceuSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEsqueceuSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEsqueceuSenha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField campoEsqueciSenhaCpf;
    private javax.swing.JLabel emailEsqueciSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel novaSenha;
    private javax.swing.JPasswordField novasenha;
    private javax.swing.JPasswordField novasenhaR;
    private javax.swing.JPanel painelEsqueciSenha;
    private javax.swing.JButton redefinirSenha;
    private javax.swing.JLabel repitaSenha;
    private javax.swing.JLabel tituloEsqueciSenha;
    private javax.swing.JButton voltaTelaLogin;
    // End of variables declaration//GEN-END:variables
}
