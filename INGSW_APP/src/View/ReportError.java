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
public class ReportError extends javax.swing.JFrame {

    /**
     * Creates new form ReportError
     */
    public ReportError() {
        initComponents();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        summaryPanel = new javax.swing.JPanel();
        rateLabel = new javax.swing.JLabel();
        rateValueLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        totalValueLabel = new javax.swing.JLabel();
        detectionLabel = new javax.swing.JLabel();
        detectionValueLabel = new javax.swing.JLabel();
        operatorIDValueLabel = new javax.swing.JLabel();
        operatorIDLabel = new javax.swing.JLabel();
        detectionDateValueLabel = new javax.swing.JLabel();
        detectionDateLabel = new javax.swing.JLabel();
        dueDateLabel = new javax.swing.JLabel();
        dueDateValueLabel = new javax.swing.JLabel();
        reportLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportTextArea = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        summaryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Summary"));

        rateLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        rateLabel.setText("Rate (€ x m^3):");

        rateValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        rateValueLabel.setText("value");

        totalLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        totalLabel.setText("Total (€):");

        totalValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        totalValueLabel.setText("value");

        detectionLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        detectionLabel.setText("Detection (m^3):");

        detectionValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        detectionValueLabel.setText("value");

        operatorIDValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        operatorIDValueLabel.setText("value");

        operatorIDLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        operatorIDLabel.setText("Operator ID:");

        detectionDateValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        detectionDateValueLabel.setText("value");

        detectionDateLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        detectionDateLabel.setText("Detection date:");

        dueDateLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        dueDateLabel.setText("Due date:");

        dueDateValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        dueDateValueLabel.setText("value");

        javax.swing.GroupLayout summaryPanelLayout = new javax.swing.GroupLayout(summaryPanel);
        summaryPanel.setLayout(summaryPanelLayout);
        summaryPanelLayout.setHorizontalGroup(
            summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(summaryPanelLayout.createSequentialGroup()
                        .addComponent(dueDateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dueDateValueLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, summaryPanelLayout.createSequentialGroup()
                        .addComponent(detectionDateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(detectionDateValueLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, summaryPanelLayout.createSequentialGroup()
                        .addComponent(operatorIDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(operatorIDValueLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, summaryPanelLayout.createSequentialGroup()
                        .addComponent(detectionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(detectionValueLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, summaryPanelLayout.createSequentialGroup()
                        .addComponent(totalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalValueLabel))
                    .addGroup(summaryPanelLayout.createSequentialGroup()
                        .addComponent(rateLabel)
                        .addGap(48, 48, 48)
                        .addComponent(rateValueLabel)))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        summaryPanelLayout.setVerticalGroup(
            summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryPanelLayout.createSequentialGroup()
                .addGroup(summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rateLabel)
                    .addComponent(rateValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel)
                    .addComponent(totalValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detectionLabel)
                    .addComponent(detectionValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(operatorIDLabel)
                    .addComponent(operatorIDValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detectionDateLabel)
                    .addComponent(detectionDateValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(summaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dueDateLabel)
                    .addComponent(dueDateValueLabel)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 0, 40);
        jPanel1.add(summaryPanel, gridBagConstraints);

        reportLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        reportLabel.setText("Report's specifications:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 0, 40);
        jPanel1.add(reportLabel, gridBagConstraints);

        reportTextArea.setColumns(20);
        reportTextArea.setRows(5);
        jScrollPane1.setViewportView(reportTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 56;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 40, 0, 40);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        sendButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        sendButton.setText("Send");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 40);
        jPanel1.add(sendButton, gridBagConstraints);

        cancelButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cancelButton.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 12, 0);
        jPanel1.add(cancelButton, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel detectionDateLabel;
    private javax.swing.JLabel detectionDateValueLabel;
    private javax.swing.JLabel detectionLabel;
    private javax.swing.JLabel detectionValueLabel;
    private javax.swing.JLabel dueDateLabel;
    private javax.swing.JLabel dueDateValueLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel operatorIDLabel;
    private javax.swing.JLabel operatorIDValueLabel;
    private javax.swing.JLabel rateLabel;
    private javax.swing.JLabel rateValueLabel;
    private javax.swing.JLabel reportLabel;
    private javax.swing.JTextArea reportTextArea;
    private javax.swing.JButton sendButton;
    private javax.swing.JPanel summaryPanel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalValueLabel;
    // End of variables declaration//GEN-END:variables
}
