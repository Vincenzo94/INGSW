/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Listener;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrea
 */
public class Bills extends javax.swing.JFrame {

    private DefaultTableModel billModel;

    /**
     * Creates new form Bills
     */
    public Bills() {
        billModel  = new DefaultTableModel(){
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    default:
                        return Date.class;
                }
            }
            @Override
            public boolean isCellEditable(int x,int y){
                return false;
            }
        };
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        consuptionDataPanel = new javax.swing.JPanel();
        taxLabel = new javax.swing.JLabel();
        taxValueLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        totalValueLabel = new javax.swing.JLabel();
        detectionLabel = new javax.swing.JLabel();
        detectionValueLabel = new javax.swing.JLabel();
        operatorIDLabel = new javax.swing.JLabel();
        operatorIDValueLabel = new javax.swing.JLabel();
        detectionDateLabel = new javax.swing.JLabel();
        datectionDateValueLabel = new javax.swing.JLabel();
        reportErrorButton = new javax.swing.JButton();
        buildPDFButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("INGSW_GR12 - Bills");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jTable1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTable1.setModel(billModel);
        jTable1.setMinimumSize(new java.awt.Dimension(160, 160));
        jTable1.setPreferredSize(new java.awt.Dimension(160, 500));
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
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 0, 40);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        consuptionDataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Consuption data"));

        taxLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        taxLabel.setText("Tax (€ x m^3):");

        taxValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        taxValueLabel.setText("value");

        totalLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        totalLabel.setText("Total (€):");

        totalValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        totalValueLabel.setText("value");

        detectionLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        detectionLabel.setText("Detection (m^3):");

        detectionValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        detectionValueLabel.setText("value");

        operatorIDLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        operatorIDLabel.setText("Operator ID:");

        operatorIDValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        operatorIDValueLabel.setText("value");

        detectionDateLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        detectionDateLabel.setText("Detection date:");

        datectionDateValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        datectionDateValueLabel.setText("value");

        javax.swing.GroupLayout consuptionDataPanelLayout = new javax.swing.GroupLayout(consuptionDataPanel);
        consuptionDataPanel.setLayout(consuptionDataPanelLayout);
        consuptionDataPanelLayout.setHorizontalGroup(
            consuptionDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consuptionDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(consuptionDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(consuptionDataPanelLayout.createSequentialGroup()
                        .addComponent(detectionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(detectionValueLabel))
                    .addGroup(consuptionDataPanelLayout.createSequentialGroup()
                        .addComponent(operatorIDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(operatorIDValueLabel))
                    .addGroup(consuptionDataPanelLayout.createSequentialGroup()
                        .addComponent(detectionDateLabel)
                        .addGap(31, 31, 31)
                        .addComponent(datectionDateValueLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consuptionDataPanelLayout.createSequentialGroup()
                        .addComponent(totalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalValueLabel))
                    .addGroup(consuptionDataPanelLayout.createSequentialGroup()
                        .addComponent(taxLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(taxValueLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        consuptionDataPanelLayout.setVerticalGroup(
            consuptionDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consuptionDataPanelLayout.createSequentialGroup()
                .addGroup(consuptionDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taxLabel)
                    .addComponent(taxValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(consuptionDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel)
                    .addComponent(totalValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(consuptionDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detectionLabel)
                    .addComponent(detectionValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(consuptionDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(operatorIDLabel)
                    .addComponent(operatorIDValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(consuptionDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detectionDateLabel)
                    .addComponent(datectionDateValueLabel)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 161;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 0, 40);
        jPanel1.add(consuptionDataPanel, gridBagConstraints);

        reportErrorButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        reportErrorButton.setText("Report error");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 40);
        jPanel1.add(reportErrorButton, gridBagConstraints);

        buildPDFButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buildPDFButton.setText("Build PDF");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 40);
        jPanel1.add(buildPDFButton, gridBagConstraints);

        backButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        backButton.setText("Back");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 12, 0);
        jPanel1.add(backButton, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton buildPDFButton;
    private javax.swing.JPanel consuptionDataPanel;
    private javax.swing.JLabel datectionDateValueLabel;
    private javax.swing.JLabel detectionDateLabel;
    private javax.swing.JLabel detectionLabel;
    private javax.swing.JLabel detectionValueLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel operatorIDLabel;
    private javax.swing.JLabel operatorIDValueLabel;
    private javax.swing.JButton reportErrorButton;
    private javax.swing.JLabel taxLabel;
    private javax.swing.JLabel taxValueLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalValueLabel;
    // End of variables declaration//GEN-END:variables

    public void addActionListener(Listener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
