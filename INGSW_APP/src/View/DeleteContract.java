/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Listener;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andrea
 */
public class DeleteContract extends javax.swing.JFrame {
    private List<ActionListener> listener;
    
    public DeleteContract() {
        listener = new LinkedList<>();
        initComponents();
        this.pack();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        yesButton = new javax.swing.JButton();
        noButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Are you sure you want to delete the contract?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(76, 40, 0, 40);
        getContentPane().add(jLabel1, gridBagConstraints);

        yesButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        yesButton.setText("Yes");
        yesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 13, 40);
        getContentPane().add(yesButton, gridBagConstraints);

        noButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        noButton.setText("No");
        noButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 40, 13, 0);
        getContentPane().add(noButton, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void yesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesButtonActionPerformed
        for(ActionListener l: listener)
            l.actionPerformed(evt);
    }//GEN-LAST:event_yesButtonActionPerformed

    private void noButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noButtonActionPerformed
        for(ActionListener l: listener)
            l.actionPerformed(evt);
    }//GEN-LAST:event_noButtonActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton noButton;
    private javax.swing.JButton yesButton;
    // End of variables declaration//GEN-END:variables

    public void addActionListener(Listener listener) {
        this.listener.add(listener);
    }

    public Integer checkButton(Component c) {
        if(c == noButton) return 1;
        return 2;
    }
}
