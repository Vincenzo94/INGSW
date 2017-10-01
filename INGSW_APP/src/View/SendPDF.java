/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Andrea
 */
public class SendPDF extends javax.swing.JFrame {

    /**
     * Creates new form Send
     */
    public SendPDF() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        stateLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        addressImage = new javax.swing.JLabel();
        emailImage = new javax.swing.JLabel();
        logAddressErrorPanel = new javax.swing.JPanel();
        messageErrorLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("INGSW_GR12 - Send PDF");
        setAlwaysOnTop(true);
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
        addressImage.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = -51;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 0, 0);
        getContentPane().add(addressImage, gridBagConstraints);

        emailImage.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        emailImage.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = -51;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 40, 0, 0);
        getContentPane().add(emailImage, gridBagConstraints);

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 176, 0, 40);
        getContentPane().add(okButton, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressImage;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel emailImage;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel logAddressErrorPanel;
    private javax.swing.JLabel messageErrorLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel stateLabel;
    // End of variables declaration//GEN-END:variables
}
