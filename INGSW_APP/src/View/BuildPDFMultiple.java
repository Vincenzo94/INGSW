/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrea
 */
public class BuildPDFMultiple extends javax.swing.JFrame {
    private final LinkedList<ActionListener> actionListener;
    private DefaultTableModel tableModelMultipleBill;
    private LinkedList<MouseListener> mouseListener;


    /**
     * Creates new form BuildPDFMultiple
     */
    public BuildPDFMultiple() {
        actionListener= new LinkedList<>();
        mouseListener = new LinkedList<>();
        tableModelMultipleBill = new DefaultTableModel(){
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 1:
                        return Integer.class;
                    case 2:
                        return Date.class;
                    case 3:
                        return Float.class;
                    default:
                        return Boolean.class;
                }
            }
            @Override
            public boolean isCellEditable(int x,int y){
                return false;
            }
        };
        initComponents();
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        previewPDFButton = new javax.swing.JButton();
        sendPDFsButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("INGSW_GR12 - Build PDF's");
        setAlwaysOnTop(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jTable1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTable1.setModel(tableModelMultipleBill);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Contract ID");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Reference detection");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Generated on");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Total");
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 511;
        gridBagConstraints.ipady = 112;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 0, 40);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        previewPDFButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        previewPDFButton.setText("Preview PDF");
        previewPDFButton.setEnabled(false);
        previewPDFButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewPDFButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(18, 290, 0, 40);
        getContentPane().add(previewPDFButton, gridBagConstraints);

        sendPDFsButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        sendPDFsButton.setText("Send PDFs");
        sendPDFsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendPDFsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(36, 290, 20, 40);
        getContentPane().add(sendPDFsButton, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(36, 40, 20, 0);
        getContentPane().add(backButton, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void addActionListener(ActionListener a){
        actionListener.add(a);
    }
    @Override
    public void addMouseListener(MouseListener m){
        mouseListener.add(m);
    }
    private void previewPDFButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewPDFButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);            
    }//GEN-LAST:event_previewPDFButtonActionPerformed

    private void sendPDFsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendPDFsButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);            
    }//GEN-LAST:event_sendPDFsButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);            
    }//GEN-LAST:event_backButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        for(MouseListener m: mouseListener)
            m.mouseClicked(evt);
    }//GEN-LAST:event_jTable1MouseClicked
    public Integer checkButton(Component j) {
        if(j == backButton) return 1;
        if(j == previewPDFButton) return 2;
        return 3;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton previewPDFButton;
    private javax.swing.JButton sendPDFsButton;
    // End of variables declaration//GEN-END:variables

    public DefaultTableModel getTableModelMultipleBill() {
        return tableModelMultipleBill;
    }
    public JTable getBillTable() {
        return jTable1;
    }

    public Integer getSelectedBill() {
        return (Integer)tableModelMultipleBill.getValueAt(jTable1.getSelectedRow(), 0);
    }

    public void activePreviewButton(boolean b) {
        previewPDFButton.setEnabled(b);
    }

    
}
