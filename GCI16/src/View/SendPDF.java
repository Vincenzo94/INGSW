/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Listener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andrea
 */
public class SendPDF extends javax.swing.JFrame {
    private final List<ActionListener> actionListener;

    /**
     * Creates new form Send
     * @param result
     */
    public SendPDF(String result) {
        actionListener = new LinkedList<>();
        initComponents();
        if(result == null){
            emailImageOK.setVisible(true);
            emailImageNOK.setVisible(false);
            logAddressErrorPanel.setVisible(false);
        }
        else{
            emailImageOK.setVisible(false);
            emailImageNOK.setVisible(true);
            logAddressErrorPanel.setVisible(true);
            messageErrorLabel.setText(result);
        }
        Toolkit tk = Toolkit.getDefaultToolkit();  
        Dimension screenSize = tk.getScreenSize();
        int xSize = ((int) screenSize.getWidth());  
        int ySize = ((int) screenSize.getHeight());  
        this.setSize(xSize,ySize);
            
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        stateLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        addressImage = new javax.swing.JLabel();
        emailImageOK = new javax.swing.JLabel();
        logAddressErrorPanel = new javax.swing.JPanel();
        messageErrorLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        emailImageNOK = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("GCI16 - Send PDF");
        setAlwaysOnTop(true);
        setExtendedState(6);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        stateLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        stateLabel.setText("State:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 40, 0, 0);
        getContentPane().add(stateLabel, gridBagConstraints);

        addressLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        addressLabel.setText("Address");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 0);
        getContentPane().add(addressLabel, gridBagConstraints);

        emailLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        emailLabel.setText("eMail");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 0, 0, 0);
        getContentPane().add(emailLabel, gridBagConstraints);

        addressImage.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        addressImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ok.png"))); // NOI18N
        addressImage.setLabelFor(addressLabel);
        addressImage.setText("        ");
        addressImage.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = -51;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 0, 0);
        getContentPane().add(addressImage, gridBagConstraints);

        emailImageOK.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        emailImageOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ok.png"))); // NOI18N
        emailImageOK.setText("        ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = -51;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 40, 0, 0);
        getContentPane().add(emailImageOK, gridBagConstraints);

        logAddressErrorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Log address' error"));

        messageErrorLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        messageErrorLabel.setText("Message of error");

        javax.swing.GroupLayout logAddressErrorPanelLayout = new javax.swing.GroupLayout(logAddressErrorPanel);
        logAddressErrorPanel.setLayout(logAddressErrorPanelLayout);
        logAddressErrorPanelLayout.setHorizontalGroup(
            logAddressErrorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logAddressErrorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageErrorLabel)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        logAddressErrorPanelLayout.setVerticalGroup(
            logAddressErrorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logAddressErrorPanelLayout.createSequentialGroup()
                .addComponent(messageErrorLabel)
                .addGap(0, 104, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 154;
        gridBagConstraints.ipady = 104;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 40, 12, 40);
        getContentPane().add(logAddressErrorPanel, gridBagConstraints);

        okButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 176, 0, 40);
        getContentPane().add(okButton, gridBagConstraints);

        emailImageNOK.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        emailImageNOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nok.png"))); // NOI18N
        emailImageNOK.setText("        ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = -51;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 40, 0, 0);
        getContentPane().add(emailImageNOK, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_okButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressImage;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel emailImageNOK;
    private javax.swing.JLabel emailImageOK;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel logAddressErrorPanel;
    private javax.swing.JLabel messageErrorLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel stateLabel;
    // End of variables declaration//GEN-END:variables

    public void addActionListener(Listener listener) {
        actionListener.add(listener);
    }
}
