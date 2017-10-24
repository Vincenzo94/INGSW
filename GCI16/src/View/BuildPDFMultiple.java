/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

/**
 *
 * @author Andrea
 */
public class BuildPDFMultiple extends ViewFrame {
    private final LinkedList<ActionListener> actionListener;
    private final DefaultTableModel tableModelMultipleBill;
    private LinkedList<MouseListener> mouseListener;
    private SwingController controller;
    private SwingViewBuilder factory;
    private final String TMP_DIR = System.getProperty("java.io.tmpdir");
    private final String PATH = TMP_DIR+"/GCI16";


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

        previewPanel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        pdfTable = new javax.swing.JTable();
        previewPDFButton = new javax.swing.JButton();
        sendPDFsButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        closePreviewButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("GCI16 - Build PDF's");
        setAlwaysOnTop(true);
        setExtendedState(6);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        previewPanel.setVisible(false);
        previewPanel.setPreferredSize(new java.awt.Dimension(700, 700));
        previewPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        getContentPane().add(previewPanel, gridBagConstraints);

        pdfTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pdfTable.setModel(tableModelMultipleBill);
        pdfTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pdfTableMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(pdfTable);
        if (pdfTable.getColumnModel().getColumnCount() > 0) {
            pdfTable.getColumnModel().getColumn(0).setHeaderValue("Contract ID");
            pdfTable.getColumnModel().getColumn(1).setHeaderValue("Reference detection");
            pdfTable.getColumnModel().getColumn(2).setHeaderValue("Generated on");
            pdfTable.getColumnModel().getColumn(3).setHeaderValue("Total");
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
        getContentPane().add(scrollPane, gridBagConstraints);

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

        closePreviewButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        closePreviewButton.setText("Close");
        closePreviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closePreviewButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(18, 290, 0, 40);
        getContentPane().add(closePreviewButton, gridBagConstraints);
        closePreviewButton.setVisible(false);

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

    private void pdfTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdfTableMouseClicked
        for(MouseListener m: mouseListener)
            m.mouseClicked(evt);
    }//GEN-LAST:event_pdfTableMouseClicked

    private void closePreviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closePreviewButtonActionPerformed
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }//GEN-LAST:event_closePreviewButtonActionPerformed
    public Integer checkButton(Component j) {
        if(j == backButton) return 1;
        if(j == previewPDFButton) return 2;
        if(j == closePreviewButton) return 4;
        return 3;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton closePreviewButton;
    private javax.swing.JTable pdfTable;
    private javax.swing.JButton previewPDFButton;
    private javax.swing.JPanel previewPanel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton sendPDFsButton;
    // End of variables declaration//GEN-END:variables

    public DefaultTableModel getTableModelMultipleBill() {
        return tableModelMultipleBill;
    }
    public JTable getBillTable() {
        return pdfTable;
    }

    public Integer getSelectedBill() {
        return (Integer)tableModelMultipleBill.getValueAt(pdfTable.getSelectedRow(), 0);
    }

    public void activePreviewButton(boolean b) {
        previewPDFButton.setEnabled(b);
    }

    public void init() {
        controller = new SwingController();
        factory = new SwingViewBuilder(controller);
        previewPanel = factory.buildViewerPanel();
        previewPanel.setVisible(false);
        previewPanel.setPreferredSize(new java.awt.Dimension(700, 700));
        GridBagConstraints gridBagConstraints;
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
        getContentPane().add(previewPanel, gridBagConstraints);
        ComponentKeyBinding.install(controller, previewPanel);
        previewPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("PDF preview"));
        controller.getDocumentViewController().setAnnotationCallback(
            new org.icepdf.ri.common.MyAnnotationCallback(
                controller.getDocumentViewController()));
    }

    public void preview(boolean b) {
        if(b == true){
            String pdfName = "bill_"+tableModelMultipleBill.getValueAt(pdfTable.getSelectedRow(), 0)+".pdf";
            controller.openDocument(PATH+"/"+pdfName);
        }
        scrollPane.setVisible(!b);
        previewPanel.setVisible(b);
        previewPDFButton.setVisible(!b);
        closePreviewButton.setVisible(b);
    }

    
}
