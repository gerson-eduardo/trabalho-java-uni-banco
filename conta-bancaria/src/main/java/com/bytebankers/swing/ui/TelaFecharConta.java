/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.bytebankers.swing.ui;

import com.bytebankers.swing.ui.telas_mensagem.TelaMensagem;
import com.bytebankers.contabancaria.ex.ErroAoFecharConta;
import com.bytebankers.contabancaria.model.ContaBanco;
import com.bytebankers.swing.http.ClienteHttp;

/**
 *
 * @author sammy
 */
public class TelaFecharConta extends javax.swing.JFrame {
    
    private ContaBanco conta;

    /**
     * Creates new form Depositar
     */
    
    public TelaFecharConta() {
        initComponents();
    }
        
    public TelaFecharConta(ContaBanco conta) {
        this.conta = conta;
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

        jButton1 = new javax.swing.JButton();
        botaoSim = new javax.swing.JButton();
        botaoNao = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botaoSim.setText("Sim");
        botaoSim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharConta(evt);
            }
        });

        botaoNao.setText("Não");
        botaoNao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltar(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel1.setText("Você realmente quer fechar a conta?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(botaoSim, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(botaoNao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSim, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoNao, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(123, 123, 123))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fecharConta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharConta
       try{
           this.conta.fechaConta();
           ClienteHttp.salvarAlteracoes(this.conta);
           this.dispose();
           new TelaLogin().setVisible(true);
       }catch(ErroAoFecharConta e){
           new TelaMensagem(this.conta, "Erro ao fechar conta").setVisible(true);
           this.dispose();

       }
    }//GEN-LAST:event_fecharConta

    private void botaoVoltar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltar
        // TODO add your handling code here:
        new TelaPrincipal(this.conta).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltar

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TelaFecharConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TelaFecharConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TelaFecharConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TelaFecharConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new TelaTransacao().setVisible(true);
////            }
////        });
//        //</editor-fold>
//        //</editor-fold>

//
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFecharConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoNao;
    private javax.swing.JButton botaoSim;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
