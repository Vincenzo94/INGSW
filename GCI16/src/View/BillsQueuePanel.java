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
public class BillsQueuePanel extends View {

    private final DefaultTableModel tableModelBillsQueue;
    private final LinkedList<MouseListener> mouseListener;
    private final LinkedList<ActionListener> actionListener;
    
    
    /**
     * Creates new form NewJPanel
     */
    public BillsQueuePanel() {
            tableModelBillsQueue = new DefaultTableModel(){
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 1:
                        return Date.class;
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
                return y==4;
            }
        };
        mouseListener = new LinkedList<>();
        actionListener = new LinkedList<>();
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

        jScrollPane3 = new javax.swing.JScrollPane();
        billsTable = new javax.swing.JTable();
        reportErrorButton = new javax.swing.JButton();
        summaryBillsPanel = new javax.swing.JPanel();
        selectedBillsValueLabel = new javax.swing.JLabel();
        selectedBillsLabel = new javax.swing.JLabel();
        summaryBillPanel = new javax.swing.JPanel();
        rateLabel = new javax.swing.JLabel();
        detectionLabel = new javax.swing.JLabel();
        operatorIdLabel = new javax.swing.JLabel();
        detectionDateLabel = new javax.swing.JLabel();
        dueDateLabel = new javax.swing.JLabel();
        rateValueLabel = new javax.swing.JLabel();
        detectionValueLabel = new javax.swing.JLabel();
        operatorIdValueLabel = new javax.swing.JLabel();
        detectionDateValueLabel = new javax.swing.JLabel();
        dueDateValueLabel = new javax.swing.JLabel();
        totalValueLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        selectAllButton = new javax.swing.JButton();
        billConfirmButton = new javax.swing.JButton();
        deselectAllButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        billsTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        billsTable.setModel(tableModelBillsQueue);
        billsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billsTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(billsTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 588;
        gridBagConstraints.ipady = 161;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 40, 0, 40);
        add(jScrollPane3, gridBagConstraints);

        reportErrorButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        reportErrorButton.setText("Report error");
        reportErrorButton.setVisible(false);
        reportErrorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportErrorButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 240);
        add(reportErrorButton, gridBagConstraints);

        summaryBillsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Summary bills"));
        summaryBillsPanel.setEnabled(false);
        summaryBillsPanel.setFont(new java.awt.Font("Dialog", 0, 18));

        selectedBillsValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        selectedBillsValueLabel.setText("0");

        selectedBillsLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        selectedBillsLabel.setText("Selected: ");

        javax.swing.GroupLayout summaryBillsPanelLayout = new javax.swing.GroupLayout(summaryBillsPanel);
        summaryBillsPanel.setLayout(summaryBillsPanelLayout);
        summaryBillsPanelLayout.setHorizontalGroup(
            summaryBillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryBillsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectedBillsLabel)
                .addGap(37, 37, 37)
                .addComponent(selectedBillsValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        summaryBillsPanelLayout.setVerticalGroup(
            summaryBillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryBillsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(summaryBillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectedBillsLabel)
                    .addComponent(selectedBillsValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 588;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 0, 40);
        add(summaryBillsPanel, gridBagConstraints);

        summaryBillPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Summary bills"));
        summaryBillPanel.setEnabled(false);
        summaryBillPanel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        rateLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        rateLabel.setText("Rate (€ x m^3):");

        detectionLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        detectionLabel.setText("Detection:");

        operatorIdLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        operatorIdLabel.setText("Operator ID:");

        detectionDateLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        detectionDateLabel.setText("Detection date:");

        dueDateLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        dueDateLabel.setText("Due date:");

        rateValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        detectionValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        operatorIdValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        detectionDateValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        dueDateValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        totalValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        totalLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        totalLabel.setText("Total:");

        javax.swing.GroupLayout summaryBillPanelLayout = new javax.swing.GroupLayout(summaryBillPanel);
        summaryBillPanel.setLayout(summaryBillPanelLayout);
        summaryBillPanelLayout.setHorizontalGroup(
            summaryBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryBillPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(summaryBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rateLabel)
                    .addComponent(detectionLabel)
                    .addComponent(operatorIdLabel)
                    .addGroup(summaryBillPanelLayout.createSequentialGroup()
                        .addGroup(summaryBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(detectionDateLabel)
                            .addComponent(dueDateLabel))
                        .addGap(18, 18, 18)
                        .addGroup(summaryBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(operatorIdValueLabel)
                            .addComponent(detectionDateValueLabel)
                            .addComponent(detectionValueLabel)
                            .addComponent(rateValueLabel)
                            .addComponent(dueDateValueLabel)
                            .addComponent(totalValueLabel)))
                    .addComponent(totalLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        summaryBillPanelLayout.setVerticalGroup(
            summaryBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryBillPanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(summaryBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rateLabel)
                    .addComponent(rateValueLabel))
                .addGap(6, 6, 6)
                .addGroup(summaryBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel)
                    .addComponent(totalValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(summaryBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detectionLabel)
                    .addComponent(detectionValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(summaryBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(operatorIdLabel)
                    .addComponent(operatorIdValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(summaryBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detectionDateLabel)
                    .addComponent(detectionDateValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(summaryBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dueDateLabel)
                    .addComponent(dueDateValueLabel)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 588;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 0, 40);
        add(summaryBillPanel, gridBagConstraints);

        selectAllButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        selectAllButton.setText("Select all");
        selectAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 40);
        add(selectAllButton, gridBagConstraints);

        billConfirmButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        billConfirmButton.setText("Confirm");
        billConfirmButton.setEnabled(false);
        billConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billConfirmButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 40);
        add(billConfirmButton, gridBagConstraints);

        deselectAllButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        deselectAllButton.setText("Deselect all");
        deselectAllButton.setEnabled(false);
        deselectAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deselectAllButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 240);
        add(deselectAllButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void billsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billsTableMouseClicked
        for(MouseListener m: mouseListener)
            m.mouseClicked(evt);
    }//GEN-LAST:event_billsTableMouseClicked

    private void selectAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_selectAllButtonActionPerformed

    private void billConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billConfirmButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_billConfirmButtonActionPerformed

    private void deselectAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deselectAllButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_deselectAllButtonActionPerformed

    private void reportErrorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportErrorButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_reportErrorButtonActionPerformed

    public void addActionListener(ActionListener a){
        actionListener.add(a);
    }
    
    @Override
    public void addMouseListener(MouseListener a){
        mouseListener.add(a);
    }
        
    
    public List<Integer> getSelectedBill(){
        List<Integer> l = new LinkedList<>();
        for(Integer i = 0; i < tableModelBillsQueue.getRowCount(); i++)
            if((Boolean)tableModelBillsQueue.getValueAt(i,4) == true)
                l.add(i);
        return l;
    }
    public void setTax(Float tax){
        rateValueLabel.setText(tax.toString());
    }
    public void setTotal(Float total){
        totalValueLabel.setText(total.toString());
    }
    public void setDetection(Float detection){
        detectionValueLabel.setText(detection.toString());
    }
    public void setDetector(Integer detector){
        operatorIdValueLabel.setText(detector.toString());
    }
    public void setDetectionDate(Date date){
        detectionDateValueLabel.setText(date.toString());
    }
    public void setDeadline(Date date){
        dueDateValueLabel.setText(date.toString());
    }
    public void activeBillConfirm(Boolean state){
        billConfirmButton.setEnabled(state);
    }
    public void activeBillReportError(Boolean state) {
        reportErrorButton.setVisible(state);
    }
    public void setMultipleSelection(Boolean state){
        summaryBillPanel.setVisible(!state);
        summaryBillsPanel.setVisible(state);
    }
    public void setSelectedBills(Integer size) {
        selectedBillsValueLabel.setText(size.toString());
    }
    public void setSelectAllButton(boolean state) {
        selectAllButton.setEnabled(state);
        deselectAllButton.setEnabled(!state);
    }
    public JTable getBillTable() {
        return billsTable;
    }
    public DefaultTableModel getTableModelBillsQueue(){
        return tableModelBillsQueue;
    }

    public int checkButton(Component c){
        if(c == selectAllButton)  return 1;
        if(c == deselectAllButton) return 2;
        if(c == billConfirmButton) return 3;
        if(c == reportErrorButton) return 4;
        return 0;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton billConfirmButton;
    private javax.swing.JTable billsTable;
    private javax.swing.JButton deselectAllButton;
    private javax.swing.JLabel detectionDateLabel;
    private javax.swing.JLabel detectionDateValueLabel;
    private javax.swing.JLabel detectionLabel;
    private javax.swing.JLabel detectionValueLabel;
    private javax.swing.JLabel dueDateLabel;
    private javax.swing.JLabel dueDateValueLabel;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel operatorIdLabel;
    private javax.swing.JLabel operatorIdValueLabel;
    private javax.swing.JLabel rateLabel;
    private javax.swing.JLabel rateValueLabel;
    private javax.swing.JButton reportErrorButton;
    private javax.swing.JButton selectAllButton;
    private javax.swing.JLabel selectedBillsLabel;
    private javax.swing.JLabel selectedBillsValueLabel;
    private javax.swing.JPanel summaryBillPanel;
    private javax.swing.JPanel summaryBillsPanel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalValueLabel;
    // End of variables declaration//GEN-END:variables
}
