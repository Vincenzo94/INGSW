/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrea
 */
public class RegistryPanel extends javax.swing.JPanel {

    private DefaultTableModel tableModelRegistryManagement;
    private LinkedList<MouseListener> mouseListener;
    private LinkedList<ActionListener> actionListener;
    
    /**
     * Creates new form RegistryPanel
     */
    public RegistryPanel() {
        tableModelRegistryManagement = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int x,int y){
                return false;
            }
        };
        mouseListener = new LinkedList<>();
        actionListener = new LinkedList<>();
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();  
        Dimension screenSize = tk.getScreenSize();
        int xSize = ((int) screenSize.getWidth());  
        int ySize = ((int) screenSize.getHeight());  
        this.setSize(xSize,ySize);
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

        taxCLabel = new javax.swing.JLabel();
        taxCField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        alterHolderButton = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        removeContractButton = new javax.swing.JButton();
        surnameLabel = new javax.swing.JLabel();
        injuctionsButton = new javax.swing.JButton();
        surnameField = new javax.swing.JTextField();
        billsButton = new javax.swing.JButton();
        contractIdLabel = new javax.swing.JLabel();
        contractIdField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        billingAddressLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        telephoneLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        billingAddressValueLabel = new javax.swing.JLabel();
        addressValueLabel = new javax.swing.JLabel();
        telephoneValueLabel = new javax.swing.JLabel();
        emailValueLabel = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        taxCLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        taxCLabel.setText("Tax C./VAT");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 40, 0, 0);
        add(taxCLabel, gridBagConstraints);

        taxCField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 92;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 40, 0, 80);
        add(taxCField, gridBagConstraints);

        searchButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 40);
        add(searchButton, gridBagConstraints);

        table.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        table.setModel(tableModelRegistryManagement
        );
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 525;
        gridBagConstraints.ipady = 88;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 0, 40);
        add(jScrollPane1, gridBagConstraints);

        addButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 40, 0, 0);
        add(addButton, gridBagConstraints);

        nameLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        nameLabel.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 40, 0, 0);
        add(nameLabel, gridBagConstraints);

        alterHolderButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        alterHolderButton.setText("Alter holder");
        alterHolderButton.setEnabled(false);
        alterHolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterHolderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 13, 0);
        add(alterHolderButton, gridBagConstraints);

        nameField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 92;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 40, 0, 80);
        add(nameField, gridBagConstraints);

        removeContractButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        removeContractButton.setText("Remove");
        removeContractButton.setEnabled(false);
        removeContractButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeContractButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 13, 40);
        add(removeContractButton, gridBagConstraints);

        surnameLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        surnameLabel.setText("Surname:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 40, 0, 0);
        add(surnameLabel, gridBagConstraints);

        injuctionsButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        injuctionsButton.setText("Injuctions");
        injuctionsButton.setEnabled(false);
        injuctionsButton.setRolloverEnabled(false);
        injuctionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                injuctionsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 180);
        add(injuctionsButton, gridBagConstraints);

        surnameField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 92;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 40, 0, 80);
        add(surnameField, gridBagConstraints);

        billsButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        billsButton.setText("Bills");
        billsButton.setEnabled(false);
        billsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 37;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 40);
        add(billsButton, gridBagConstraints);

        contractIdLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        contractIdLabel.setText("Contract ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 40, 0, 0);
        add(contractIdLabel, gridBagConstraints);

        contractIdField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 92;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 40, 0, 80);
        add(contractIdField, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Summary contract"));

        billingAddressLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        billingAddressLabel.setText("Billing address:");

        addressLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        addressLabel.setText("Address:");

        telephoneLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        telephoneLabel.setText("Telephone:");

        emailLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        emailLabel.setText("eMail:");

        billingAddressValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        billingAddressValueLabel.setText("       ");

        addressValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        addressValueLabel.setText("      ");

        telephoneValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        telephoneValueLabel.setText("       ");

        emailValueLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        emailValueLabel.setText("       ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(billingAddressLabel)
                    .addComponent(addressLabel)
                    .addComponent(telephoneLabel)
                    .addComponent(emailLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(telephoneValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(addressValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(billingAddressValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(billingAddressLabel)
                    .addComponent(billingAddressValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(addressValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephoneLabel)
                    .addComponent(telephoneValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailValueLabel))
                .addGap(6, 6, 6))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 0, 0);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        for(MouseListener m: mouseListener)
            m.mouseClicked(evt);
    }//GEN-LAST:event_tableMouseClicked

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed

    }//GEN-LAST:event_tableKeyPressed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_addButtonActionPerformed

    private void alterHolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterHolderButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_alterHolderButtonActionPerformed

    private void removeContractButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeContractButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_removeContractButtonActionPerformed

    private void injuctionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_injuctionsButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_injuctionsButtonActionPerformed

    private void billsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billsButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_billsButtonActionPerformed

    @Override
    public void addMouseListener(MouseListener m){
        mouseListener.add(m);
    }
    public void addActionListener(ActionListener a){
        actionListener.add(a);
    }
    
    public void activeContractButtons(){
        alterHolderButton.setEnabled(true);
        removeContractButton.setEnabled(true);
        billsButton.setEnabled(true);
        injuctionsButton.setEnabled(true);
    }
    public void setBillingAddress(String s){
        billingAddressValueLabel.setText(s);
    }
    public void setAddress(String s){
        addressValueLabel.setText(s);
    }
    public void setTelephone(String s){
        telephoneValueLabel.setText(s);
    }
    public void setEmail(String s){
        emailValueLabel.setText(s);
    }
    public Integer getSelectedContract(){
        return table.getSelectedRow();
    }
    
    public String getNameSearch(){
        return nameField.getText();
    }
    
    public String getSurnameSearch(){
        return surnameField.getText();
    }
    
    public String getTaxSearch(){
        return taxCField.getText();
    }
    
    public String getIdSearch(){
        return contractIdField.getText();
    }
    
        public DefaultTableModel getTableModelRegistryManagement(){
        return tableModelRegistryManagement;
    }
        
        
        public int checkButton(Component c){
           if(c == searchButton) return 1;
           if(c == alterHolderButton) return 2;
           if(c == addButton) return 3;
           if(c == removeContractButton) return 4;
           if(c == billsButton) return 5;
           if(c == injuctionsButton) return 6;
           return 0;
   }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel addressValueLabel;
    private javax.swing.JButton alterHolderButton;
    private javax.swing.JLabel billingAddressLabel;
    private javax.swing.JLabel billingAddressValueLabel;
    private javax.swing.JButton billsButton;
    private javax.swing.JTextField contractIdField;
    private javax.swing.JLabel contractIdLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailValueLabel;
    private javax.swing.JButton injuctionsButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton removeContractButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTable table;
    private javax.swing.JTextField taxCField;
    private javax.swing.JLabel taxCLabel;
    private javax.swing.JLabel telephoneLabel;
    private javax.swing.JLabel telephoneValueLabel;
    // End of variables declaration//GEN-END:variables
}
