/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andrea
 */
public class AlterHolder extends javax.swing.JFrame {

    private final List<ActionListener> actionListener;
    public AlterHolder(){
        actionListener = new LinkedList<>();
        initComponents();
        this.pack();
    }

    public void addActionListener(ActionListener a){
        actionListener.add(a);
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
        registryPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        surnameField = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        taxCLabel = new javax.swing.JLabel();
        taxCField = new javax.swing.JTextField();
        telephoneField = new javax.swing.JTextField();
        telephoneLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        alterRegistryButton = new javax.swing.JButton();
        mobileLabel = new javax.swing.JLabel();
        mobileField = new javax.swing.JTextField();
        billAddress = new javax.swing.JPanel();
        streetField = new javax.swing.JTextField();
        streetLabel = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        numberLabel = new javax.swing.JLabel();
        numberField = new javax.swing.JTextField();
        districtLabel = new javax.swing.JLabel();
        districtField = new javax.swing.JTextField();
        postalCodeLabel = new javax.swing.JLabel();
        postalCodeField = new javax.swing.JTextField();
        alterBillAddressButton = new javax.swing.JButton();
        address = new javax.swing.JPanel();
        city2Field = new javax.swing.JTextField();
        district2Label = new javax.swing.JLabel();
        postalCode2Label = new javax.swing.JLabel();
        district2Field = new javax.swing.JTextField();
        street2Label = new javax.swing.JLabel();
        street2Field = new javax.swing.JTextField();
        number2Label = new javax.swing.JLabel();
        postalCode2Field = new javax.swing.JTextField();
        number2Field = new javax.swing.JTextField();
        alterAddressButton = new javax.swing.JButton();
        city2Label = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        registryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Registry"));
        registryPanel.setLayout(new java.awt.GridBagLayout());

        nameLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        nameLabel.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 17, 0, 0);
        registryPanel.add(nameLabel, gridBagConstraints);

        nameField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 289;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 17, 0, 17);
        registryPanel.add(nameField, gridBagConstraints);

        surnameField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 289;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 17, 0, 17);
        registryPanel.add(surnameField, gridBagConstraints);

        surnameLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        surnameLabel.setText("Surname:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 17, 0, 0);
        registryPanel.add(surnameLabel, gridBagConstraints);

        taxCLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        taxCLabel.setText("Tax C./VAT:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 17, 0, 0);
        registryPanel.add(taxCLabel, gridBagConstraints);

        taxCField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 289;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 17, 0, 17);
        registryPanel.add(taxCField, gridBagConstraints);

        telephoneField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 122;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 17, 0, 0);
        registryPanel.add(telephoneField, gridBagConstraints);

        telephoneLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        telephoneLabel.setText("Phone:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 17, 0, 0);
        registryPanel.add(telephoneLabel, gridBagConstraints);

        emailField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 289;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 17, 0, 17);
        registryPanel.add(emailField, gridBagConstraints);

        emailLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        emailLabel.setText("eMail:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 17, 0, 0);
        registryPanel.add(emailLabel, gridBagConstraints);

        alterRegistryButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        alterRegistryButton.setText("Alter");
        alterRegistryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterRegistryButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 90, 17, 17);
        registryPanel.add(alterRegistryButton, gridBagConstraints);

        mobileLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        mobileLabel.setText("Mobile:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 41, 0, 0);
        registryPanel.add(mobileLabel, gridBagConstraints);

        mobileField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 122;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 41, 0, 17);
        registryPanel.add(mobileField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 0, 0);
        jPanel1.add(registryPanel, gridBagConstraints);

        billAddress.setBorder(javax.swing.BorderFactory.createTitledBorder("Bill address"));
        billAddress.setLayout(new java.awt.GridBagLayout());

        streetField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 246;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 17, 0, 0);
        billAddress.add(streetField, gridBagConstraints);

        streetLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        streetLabel.setText("Street:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 17, 0, 0);
        billAddress.add(streetLabel, gridBagConstraints);

        cityField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 246;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 17, 0, 0);
        billAddress.add(cityField, gridBagConstraints);

        cityLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cityLabel.setText("City:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 17, 0, 0);
        billAddress.add(cityLabel, gridBagConstraints);

        numberLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        numberLabel.setText("Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 20, 0, 0);
        billAddress.add(numberLabel, gridBagConstraints);

        numberField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 20, 0, 0);
        billAddress.add(numberField, gridBagConstraints);

        districtLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        districtLabel.setText("District:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 20, 0, 0);
        billAddress.add(districtLabel, gridBagConstraints);

        districtField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 139;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 20, 0, 0);
        billAddress.add(districtField, gridBagConstraints);

        postalCodeLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        postalCodeLabel.setText("Postal code:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 0, 0, 0);
        billAddress.add(postalCodeLabel, gridBagConstraints);

        postalCodeField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 128;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 17);
        billAddress.add(postalCodeField, gridBagConstraints);

        alterBillAddressButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        alterBillAddressButton.setText("Alter");
        alterBillAddressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterBillAddressButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 17, 17);
        billAddress.add(alterBillAddressButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 40);
        jPanel1.add(billAddress, gridBagConstraints);

        address.setBorder(javax.swing.BorderFactory.createTitledBorder("Address"));
        address.setLayout(new java.awt.GridBagLayout());

        city2Field.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 246;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 17, 0, 0);
        address.add(city2Field, gridBagConstraints);

        district2Label.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        district2Label.setText("District:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 20, 0, 0);
        address.add(district2Label, gridBagConstraints);

        postalCode2Label.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        postalCode2Label.setText("Postal code:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 0, 0, 0);
        address.add(postalCode2Label, gridBagConstraints);

        district2Field.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 139;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 20, 0, 0);
        address.add(district2Field, gridBagConstraints);

        street2Label.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        street2Label.setText("Street:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 17, 0, 0);
        address.add(street2Label, gridBagConstraints);

        street2Field.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 246;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 17, 0, 0);
        address.add(street2Field, gridBagConstraints);

        number2Label.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        number2Label.setText("Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 20, 0, 0);
        address.add(number2Label, gridBagConstraints);

        postalCode2Field.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 128;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 17);
        address.add(postalCode2Field, gridBagConstraints);

        number2Field.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 68;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 20, 0, 0);
        address.add(number2Field, gridBagConstraints);

        alterAddressButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        alterAddressButton.setText("Alter");
        alterAddressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterAddressButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(18, 35, 17, 17);
        address.add(alterAddressButton, gridBagConstraints);

        city2Label.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        city2Label.setText("City:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 17, 0, 0);
        address.add(city2Label, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 40);
        jPanel1.add(address, gridBagConstraints);

        backButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 40, 12, 0);
        jPanel1.add(backButton, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alterBillAddressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterBillAddressButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_alterBillAddressButtonActionPerformed

    private void alterRegistryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterRegistryButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_alterRegistryButtonActionPerformed

    private void alterAddressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterAddressButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_alterAddressButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_backButtonActionPerformed

    public Integer checkButton(Component c) {
        if(c == alterRegistryButton) return 1;
        if(c == alterBillAddressButton) return 2;
        if(c == alterAddressButton) return 3;
        return 0;
    }
    
    public String getCity1(){
        return cityField.getText();
    }
    public String getCity2(){
        return city2Field.getText();
    }
    public String getDistrict1(){
        return districtField.getText();
    }
    public String getDistrict2(){
        return district2Field.getText();
    }
    public String getEmail(){
        return emailField.getText();
    }
    public String getPersonName(){
        return nameField.getText();
    }
    public String getSurname(){
        return surnameField.getText();
    }
    public String getPhone(){
        return telephoneField.getText();
    }
    public String getMobile(){
        return mobileField.getText();
    }
    public Integer getNumber1(){
        return Integer.valueOf(numberField.getText());
    }
    public Integer getNumber2(){
        return Integer.valueOf(number2Field.getText());
    }
    public String getZip1(){
        return postalCodeField.getText();
    }
    public String getZip2(){
        return postalCode2Field.getText();
    }
    public String getStreet1(){
        return streetField.getText();
    }
    public String getStreet2(){
        return street2Field.getText();
    }
    public String getTaxC(){
        return taxCField.getText();
    }
    public void setCity1(String t){
        cityField.setText(t);
    }
    public void setCity2(String t){
        city2Field.setText(t);
    }
    public void setDistrict1(String t){
        districtField.setText(t);
    }
    public void setDistrict2(String t){
        district2Field.setText(t);
    }
    public void setEmail(String t){
        emailField.setText(t);
    }
    public void setPersonName(String t){
        nameField.setText(t);
    }
    public void setSurname(String t){
        surnameField.setText(t);
    }
    public void setPhone(String t){
        telephoneField.setText(t);
    }
    public void setMobile(String t){
        mobileField.setText(t);
    }
    public void setNumber1(Integer t){
        numberField.setText(t.toString());
    }
    public void setNumber2(Integer t){
        number2Field.setText(t.toString());
    }
    public void setZip1(String t){
        postalCodeField.setText(t);
    }
    public void setZip2(String t){
        postalCode2Field.setText(t);
    }
    public void setStreet1(String t){
        streetField.setText(t);
    }
    public void setStreet2(String t){
        street2Field.setText(t);
    }
    public void setTaxC(String t){
        taxCField.setText(t);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel address;
    private javax.swing.JButton alterAddressButton;
    private javax.swing.JButton alterBillAddressButton;
    private javax.swing.JButton alterRegistryButton;
    private javax.swing.JButton backButton;
    private javax.swing.JPanel billAddress;
    private javax.swing.JTextField city2Field;
    private javax.swing.JLabel city2Label;
    private javax.swing.JTextField cityField;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField district2Field;
    private javax.swing.JLabel district2Label;
    private javax.swing.JTextField districtField;
    private javax.swing.JLabel districtLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mobileField;
    private javax.swing.JLabel mobileLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField number2Field;
    private javax.swing.JLabel number2Label;
    private javax.swing.JTextField numberField;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JTextField postalCode2Field;
    private javax.swing.JLabel postalCode2Label;
    private javax.swing.JTextField postalCodeField;
    private javax.swing.JLabel postalCodeLabel;
    private javax.swing.JPanel registryPanel;
    private javax.swing.JTextField street2Field;
    private javax.swing.JLabel street2Label;
    private javax.swing.JTextField streetField;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField taxCField;
    private javax.swing.JLabel taxCLabel;
    private javax.swing.JTextField telephoneField;
    private javax.swing.JLabel telephoneLabel;
    // End of variables declaration//GEN-END:variables

    
}
