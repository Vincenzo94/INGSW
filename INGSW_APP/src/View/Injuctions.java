/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.LinkedList;

/**
 *
 * @author Andrea
 */
public class Injuctions extends javax.swing.JFrame {

    private final LinkedList<ActionListener> actionListener;
    private final LinkedList<MouseListener> mouseListener;
    /**
     * Creates new form Injuctions
     */
    public Injuctions() {
        actionListener = new LinkedList<>();
        mouseListener = new LinkedList<>();
        initComponents();
    }

    @Override
    public void addMouseListener (MouseListener a){
        mouseListener.add(a);
    }
    
    public void addActionListener(ActionListener listener) {
        actionListener.add(listener);
    }
    
    public int checkButton(Component c){
        if(c == buildPDFButton) return 1;
        if(c == backButton) return 2;
        return 0;
    }
    
    public void enableBuildPDFButton(boolean state){
        buildPDFButton.setEnabled(state);
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        summaryPanel = new javax.swing.JPanel();
        billsPeriodLabel = new javax.swing.JLabel();
        billsPeriodValueLabel = new javax.swing.JLabel();
        billsDueValueLabel = new javax.swing.JLabel();
        billsDueLabel = new javax.swing.JLabel();
        detectionLabel = new javax.swing.JLabel();
        detectionValueLabel = new javax.swing.JLabel();
        paymentLabel = new javax.swing.JLabel();
        paymentValueLabel = new javax.swing.JLabel();
        buildPDFButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("INGSW_GR12 - Injuctions");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jTable1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Injuction number", "Bill ID", "State"
            }
        ){
            @Override
            public boolean isCellEditable(int x,int y){
                return false;
            }
        });
        jTable1.setPreferredSize(new java.awt.Dimension(225, 500));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 0, 40);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        summaryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Summary"));

        billsPeriodLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        billsPeriodLabel.setText("Bill's period of reference:");

        billsPeriodValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        billsPeriodValueLabel.setText("value");

        billsDueValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        billsDueValueLabel.setText("value");

        billsDueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        billsDueLabel.setText("Bill's due date:");

        detectionLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        detectionLabel.setText("Detection date:");

        detectionValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        detectionValueLabel.setText("value");

        paymentLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        paymentLabel.setText("Payment date:");

        paymentValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        paymentValueLabel.setText("value");

        javax.swing.GroupLayout summaryPanelLayout = new javax.swing.GroupLayout(summaryPanel);
        summaryPanel.setLayout(summaryPanelLayout);
        summaryPanelLayout.setHorizontalGroup(
            summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(summaryPanelLayout.createSequentialGroup()
                        .addComponent(paymentLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(paymentValueLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, summaryPanelLayout.createSequentialGroup()
                        .addComponent(detectionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(detectionValueLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, summaryPanelLayout.createSequentialGroup()
                        .addComponent(billsDueLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(billsDueValueLabel))
                    .addGroup(summaryPanelLayout.createSequentialGroup()
                        .addComponent(billsPeriodLabel)
                        .addGap(29, 29, 29)
                        .addComponent(billsPeriodValueLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        summaryPanelLayout.setVerticalGroup(
            summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryPanelLayout.createSequentialGroup()
                .addGroup(summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(billsPeriodLabel)
                    .addComponent(billsPeriodValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(billsDueLabel)
                    .addComponent(billsDueValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detectionLabel)
                    .addComponent(detectionValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentLabel)
                    .addComponent(paymentValueLabel)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 40, 0, 40);
        jPanel1.add(summaryPanel, gridBagConstraints);

        buildPDFButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buildPDFButton.setText("Build PDF");
        buildPDFButton.setEnabled(false);
        buildPDFButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildPDFButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 40);
        jPanel1.add(buildPDFButton, gridBagConstraints);

        backButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 12, 0);
        jPanel1.add(backButton, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buildPDFButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildPDFButtonActionPerformed
        for(ActionListener a : actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_buildPDFButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        for(ActionListener a : actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_backButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        for(MouseListener a: mouseListener)
            a.mouseClicked(evt);
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel billsDueLabel;
    private javax.swing.JLabel billsDueValueLabel;
    private javax.swing.JLabel billsPeriodLabel;
    private javax.swing.JLabel billsPeriodValueLabel;
    private javax.swing.JButton buildPDFButton;
    private javax.swing.JLabel detectionLabel;
    private javax.swing.JLabel detectionValueLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel paymentLabel;
    private javax.swing.JLabel paymentValueLabel;
    private javax.swing.JPanel summaryPanel;
    // End of variables declaration//GEN-END:variables
}
