/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ansan
 */
public class Home extends javax.swing.JFrame {
    public DefaultTableModel tableModelRegistryManagement;
    public DefaultTableModel tableModelBillsQueue;
    public DefaultTableModel tableModelInjuctionsQueue;
    public Home() {
        tableModelRegistryManagement = new DefaultTableModel();
        tableModelBillsQueue = new DefaultTableModel();
        tableModelInjuctionsQueue = new DefaultTableModel();
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

        jTabbedPane2 = new javax.swing.JTabbedPane();
        registryManagementPanel = new javax.swing.JPanel();
        taxCLabel = new javax.swing.JLabel();
        telephoneLabel = new javax.swing.JLabel();
        taxCField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        billingAddressValueLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        addressValueLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        telephoneValueLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        alterHolderButton = new javax.swing.JButton();
        emailValueLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        removeButton = new javax.swing.JButton();
        surnameLabel = new javax.swing.JLabel();
        injuctionsButton = new javax.swing.JButton();
        surnameField = new javax.swing.JTextField();
        billsButton = new javax.swing.JButton();
        contractIdLabel = new javax.swing.JLabel();
        billingAddressLabel = new javax.swing.JLabel();
        contractIdField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        injuctionsQueuePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        confirmButtonInjuctions = new javax.swing.JButton();
        billsQueuePanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        summaryBillsPanel = new javax.swing.JPanel();
        rateLabel = new javax.swing.JLabel();
        detectionLabel = new javax.swing.JLabel();
        operatorIdLabel = new javax.swing.JLabel();
        detectionDateLabel = new javax.swing.JLabel();
        dueDateLabel = new javax.swing.JLabel();
        rateValueLabel = new javax.swing.JLabel();
        detetionValueLabel = new javax.swing.JLabel();
        operatorIdValueLabel = new javax.swing.JLabel();
        detectionDateValueLabel = new javax.swing.JLabel();
        dueDateValueLabel = new javax.swing.JLabel();
        totalValueLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        confirmButtonBills = new javax.swing.JButton();
        reportErrorButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        taxCLabel.setText("Tax C./VAT");

        telephoneLabel.setText("Telephone:");

        emailLabel.setText("eMail:");

        searchButton.setText("Search");

        billingAddressValueLabel.setText("via Napoli");

        table.setModel(tableModelRegistryManagement
        );
        jScrollPane1.setViewportView(table);

        addressValueLabel.setText("via Napoli ancora");

        addButton.setText("Add");

        telephoneValueLabel.setText("081 222 32 65");

        nameLabel.setText("Name:");

        alterHolderButton.setText("Alter holder");

        emailValueLabel.setText("emailingsw@gmail.com");

        removeButton.setText("Remove");

        surnameLabel.setText("Surname:");

        injuctionsButton.setText("Injuctions");

        billsButton.setText("Bills");

        contractIdLabel.setText("Contract ID:");

        billingAddressLabel.setText("Billing address:");

        addressLabel.setText("Address:");

        javax.swing.GroupLayout registryManagementPanelLayout = new javax.swing.GroupLayout(registryManagementPanel);
        registryManagementPanel.setLayout(registryManagementPanelLayout);
        registryManagementPanelLayout.setHorizontalGroup(
            registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registryManagementPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, registryManagementPanelLayout.createSequentialGroup()
                            .addComponent(alterHolderButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(removeButton))
                        .addGroup(registryManagementPanelLayout.createSequentialGroup()
                            .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addressLabel)
                                .addComponent(telephoneLabel)
                                .addComponent(emailLabel))
                            .addGap(45, 45, 45)
                            .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(registryManagementPanelLayout.createSequentialGroup()
                                    .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(telephoneValueLabel)
                                        .addComponent(emailValueLabel))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(billsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(addressValueLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(injuctionsButton))
                        .addComponent(addButton, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, registryManagementPanelLayout.createSequentialGroup()
                            .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(14, 14, 14)
                            .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(surnameLabel))
                            .addGap(14, 14, 14)
                            .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(contractIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(contractIdLabel))
                            .addGap(14, 14, 14)
                            .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(taxCLabel)
                                .addGroup(registryManagementPanelLayout.createSequentialGroup()
                                    .addComponent(taxCField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(searchButton)))))
                    .addGroup(registryManagementPanelLayout.createSequentialGroup()
                        .addComponent(billingAddressLabel)
                        .addGap(28, 28, 28)
                        .addComponent(billingAddressValueLabel)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        registryManagementPanelLayout.setVerticalGroup(
            registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registryManagementPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(addButton)
                .addGap(15, 15, 15)
                .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(surnameLabel)
                    .addComponent(contractIdLabel)
                    .addComponent(taxCLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contractIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taxCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alterHolderButton)
                    .addComponent(removeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(registryManagementPanelLayout.createSequentialGroup()
                        .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(billingAddressLabel)
                            .addComponent(billingAddressValueLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLabel)
                            .addComponent(addressValueLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telephoneLabel)
                            .addComponent(telephoneValueLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel)
                            .addComponent(emailValueLabel))
                        .addGap(5, 5, 5))
                    .addGroup(registryManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(injuctionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(billsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Registry management", registryManagementPanel);

        table1.setModel(tableModelInjuctionsQueue);
        jScrollPane2.setViewportView(table1);

        deleteButton.setText("Delete");

        confirmButtonInjuctions.setText("Confirm");

        javax.swing.GroupLayout injuctionsQueuePanelLayout = new javax.swing.GroupLayout(injuctionsQueuePanel);
        injuctionsQueuePanel.setLayout(injuctionsQueuePanelLayout);
        injuctionsQueuePanelLayout.setHorizontalGroup(
            injuctionsQueuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(injuctionsQueuePanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(injuctionsQueuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(injuctionsQueuePanelLayout.createSequentialGroup()
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmButtonInjuctions)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        injuctionsQueuePanelLayout.setVerticalGroup(
            injuctionsQueuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(injuctionsQueuePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(injuctionsQueuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(confirmButtonInjuctions))
                .addGap(20, 20, 20))
        );

        jTabbedPane2.addTab("Injuctions queue", injuctionsQueuePanel);

        jTable1.setModel(tableModelBillsQueue);
        jScrollPane3.setViewportView(jTable1);

        summaryBillsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Summary bills"));

        rateLabel.setText("Rate (€ x m^3):");

        detectionLabel.setText("Detection:");

        operatorIdLabel.setText("Operator ID:");

        detectionDateLabel.setText("Detection date:");

        dueDateLabel.setText("Due date:");

        rateValueLabel.setText("5,00");

        detetionValueLabel.setText("100");

        operatorIdValueLabel.setText("12345");

        detectionDateValueLabel.setText("01/01/2018");

        dueDateValueLabel.setText("01/01/2018");

        totalValueLabel.setText("5,00");

        totalLabel.setText("Total:");

        javax.swing.GroupLayout summaryBillsPanelLayout = new javax.swing.GroupLayout(summaryBillsPanel);
        summaryBillsPanel.setLayout(summaryBillsPanelLayout);
        summaryBillsPanelLayout.setHorizontalGroup(
            summaryBillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryBillsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(summaryBillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rateLabel)
                    .addComponent(detectionLabel)
                    .addComponent(operatorIdLabel)
                    .addGroup(summaryBillsPanelLayout.createSequentialGroup()
                        .addGroup(summaryBillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(detectionDateLabel)
                            .addComponent(dueDateLabel))
                        .addGap(18, 18, 18)
                        .addGroup(summaryBillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(operatorIdValueLabel)
                            .addComponent(detectionDateValueLabel)
                            .addComponent(detetionValueLabel)
                            .addComponent(rateValueLabel)
                            .addComponent(dueDateValueLabel)
                            .addComponent(totalValueLabel)))
                    .addComponent(totalLabel))
                .addContainerGap(386, Short.MAX_VALUE))
        );
        summaryBillsPanelLayout.setVerticalGroup(
            summaryBillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summaryBillsPanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(summaryBillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rateLabel)
                    .addComponent(rateValueLabel))
                .addGap(6, 6, 6)
                .addGroup(summaryBillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel)
                    .addComponent(totalValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(summaryBillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detectionLabel)
                    .addComponent(detetionValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(summaryBillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(operatorIdLabel)
                    .addComponent(operatorIdValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(summaryBillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detectionDateLabel)
                    .addComponent(detectionDateValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(summaryBillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dueDateLabel)
                    .addComponent(dueDateValueLabel)))
        );

        confirmButtonBills.setText("Confirm");

        reportErrorButton.setText("Report error");

        javax.swing.GroupLayout billsQueuePanelLayout = new javax.swing.GroupLayout(billsQueuePanel);
        billsQueuePanel.setLayout(billsQueuePanelLayout);
        billsQueuePanelLayout.setHorizontalGroup(
            billsQueuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billsQueuePanelLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(billsQueuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(billsQueuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3)
                        .addComponent(summaryBillsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(billsQueuePanelLayout.createSequentialGroup()
                        .addComponent(reportErrorButton)
                        .addGap(48, 48, 48)
                        .addComponent(confirmButtonBills)))
                .addGap(24, 24, 24))
        );
        billsQueuePanelLayout.setVerticalGroup(
            billsQueuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billsQueuePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(summaryBillsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(billsQueuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButtonBills)
                    .addComponent(reportErrorButton))
                .addGap(20, 20, 20))
        );

        jTabbedPane2.addTab("Bills queue", billsQueuePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel addressValueLabel;
    private javax.swing.JButton alterHolderButton;
    private javax.swing.JLabel billingAddressLabel;
    private javax.swing.JLabel billingAddressValueLabel;
    private javax.swing.JButton billsButton;
    private javax.swing.JPanel billsQueuePanel;
    private javax.swing.JButton confirmButtonBills;
    private javax.swing.JButton confirmButtonInjuctions;
    private javax.swing.JTextField contractIdField;
    private javax.swing.JLabel contractIdLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel detectionDateLabel;
    private javax.swing.JLabel detectionDateValueLabel;
    private javax.swing.JLabel detectionLabel;
    private javax.swing.JLabel detetionValueLabel;
    private javax.swing.JLabel dueDateLabel;
    private javax.swing.JLabel dueDateValueLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailValueLabel;
    private javax.swing.JButton injuctionsButton;
    private javax.swing.JPanel injuctionsQueuePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel operatorIdLabel;
    private javax.swing.JLabel operatorIdValueLabel;
    private javax.swing.JLabel rateLabel;
    private javax.swing.JLabel rateValueLabel;
    private javax.swing.JPanel registryManagementPanel;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton reportErrorButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel summaryBillsPanel;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    private javax.swing.JTextField taxCField;
    private javax.swing.JLabel taxCLabel;
    private javax.swing.JLabel telephoneLabel;
    private javax.swing.JLabel telephoneValueLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalValueLabel;
    // End of variables declaration//GEN-END:variables
}