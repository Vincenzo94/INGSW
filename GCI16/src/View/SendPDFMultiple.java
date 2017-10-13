/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Listener;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrea
 */
public class SendPDFMultiple extends ViewFrame {
    String error;
    private final List<ActionListener> actionListener;
    DefaultTableModel model;

    public SendPDFMultiple(Map<Integer,String> contracts) {
        model = new DefaultTableModel(){
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    default:
                        return Boolean.class;
                }
            }
            @Override
            public boolean isCellEditable(int x,int y){
                return false;
            }
        };
        model.setRowCount(0);
        String[] columns = {"Contract ID", "Address", "eMail"};
        model.setColumnIdentifiers(columns);
        for(Integer c: contracts.keySet()){
            Boolean res = contracts.get(c)==null;
            if(!res)
                error=error+contracts.get(c)+"\n";
            model.addRow(new Object[]{c, true, res});
        }
        initComponents();
        if(error==null){
            messagePanel.setVisible(false);
        }
        else{
            messagePanel.setVisible(true);
            messageTextValue.setText(error);
        }
        actionListener = new LinkedList<>();
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        stateLabel = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        messagePanel = new javax.swing.JPanel();
        messageTextValue = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("GCI16 - Send PDF's");
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(0, 23, 0, 0));
        setMinimumSize(new java.awt.Dimension(616, 281));
        setPreferredSize(new java.awt.Dimension(618, 234));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        stateLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        stateLabel.setText("State:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 0, 0);
        getContentPane().add(stateLabel, gridBagConstraints);

        jTable1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTable1.setModel(model);
        jTable1.setMaximumSize(new java.awt.Dimension(200, 100));
        jTable1.setPreferredSize(new java.awt.Dimension(340, 140));
        scrollPane.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 353;
        gridBagConstraints.ipady = 81;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 40, 0, 40);
        getContentPane().add(scrollPane, gridBagConstraints);

        messagePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Log address' error"));
        messagePanel.setMaximumSize(new java.awt.Dimension(300, 150));
        messagePanel.setPreferredSize(new java.awt.Dimension(279, 139));

        messageTextValue.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        messageTextValue.setText("Message of error");

        javax.swing.GroupLayout messagePanelLayout = new javax.swing.GroupLayout(messagePanel);
        messagePanel.setLayout(messagePanelLayout);
        messagePanelLayout.setHorizontalGroup(
            messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageTextValue)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        messagePanelLayout.setVerticalGroup(
            messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messagePanelLayout.createSequentialGroup()
                .addComponent(messageTextValue)
                .addGap(0, 92, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 169;
        gridBagConstraints.ipady = 92;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 40, 0, 40);
        getContentPane().add(messagePanel, gridBagConstraints);

        okButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 20, 40);
        getContentPane().add(okButton, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        for(ActionListener listener: actionListener)
            listener.actionPerformed(evt);
    }//GEN-LAST:event_okButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel messagePanel;
    private javax.swing.JLabel messageTextValue;
    private javax.swing.JButton okButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel stateLabel;
    // End of variables declaration//GEN-END:variables

    public void addActionListener(Listener listener) {
        actionListener.add(listener);
    }
}
