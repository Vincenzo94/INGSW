/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Bill;
import Model.Document;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

/**
 *
 * @author ansan
 */
public class BuildPDF extends javax.swing.JFrame {
    private String filePath;
    private SwingController controller;
    private SwingViewBuilder factory;
    private final List<ActionListener> actionListener;
    private final String TMP_DIR = System.getProperty("java.io.tmpdir");
    private final String PATH = TMP_DIR+"/GCI16";
    public BuildPDF() {
        initComponents();
        actionListener = new LinkedList<>();
        Toolkit tk = Toolkit.getDefaultToolkit();  
        Dimension screenSize = tk.getScreenSize();
        int xSize = ((int) screenSize.getWidth());  
        int ySize = ((int) screenSize.getHeight());  
        this.setSize(xSize,ySize);
        init();
    }
    public void setPDF(Document doc){
        if(doc instanceof Bill)
            this.filePath = PATH+"/bill_"+doc.getContractID()+".pdf";
        else
            this.filePath = PATH+"/injuction_"+doc.getContractID()+".pdf";
        controller.openDocument(filePath);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        sendPDFButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("GCI16 - PDF");
        setAlwaysOnTop(true);
        setExtendedState(6);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());
        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        sendPDFButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        sendPDFButton.setText("Send PDF");
        sendPDFButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendPDFButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(36, 290, 20, 40);
        getContentPane().add(sendPDFButton, gridBagConstraints);

        cancelButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(36, 40, 20, 0);
        getContentPane().add(cancelButton, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void sendPDFButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendPDFButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_sendPDFButtonActionPerformed

    public void addActionListener(ActionListener a){
        actionListener.add(a);
    }
    public Integer checkButton(Component j) {
        if(j == sendPDFButton)
            return 3;
        else
            return 1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton sendPDFButton;
    // End of variables declaration//GEN-END:variables

    private void init() {
        controller = new SwingController();
        factory = new SwingViewBuilder(controller);
        jPanel1 = factory.buildViewerPanel();
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 700));
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
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
        getContentPane().add(jPanel1, gridBagConstraints);
        ComponentKeyBinding.install(controller, jPanel1);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("PDF preview"));
        controller.getDocumentViewController().setAnnotationCallback(
            new org.icepdf.ri.common.MyAnnotationCallback(
                controller.getDocumentViewController()));
    }
}
