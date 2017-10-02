/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Contract_MYSQL;
import DAO.DAO_Contract;
import Model.Bill;
import Model.Contract;
import Model.EMailSender;
import Model.PDFMaker;
import View.BuildPDF;
import View.BuildPDFMultiple;
import View.SendPDF;
import View.SendPDFMultiple;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Andrea
 */
public class ConfirmBill_Controller implements Controller{
    private final LinkedList<Bill> bills;
    private final Bill bill;
    private final BillsQueue_Controller controller;
    private final BuildPDF view;
    private final BuildPDFMultiple views;
    private SendPDF sendPDFview;
    Contract contract;
    List<Contract> contracts;
    private DefaultTableModel tableModelMultipleBill = null;
    private DefaultTableCellRenderer defaultRender = null;
    private Database_Controller dbController;
    private SendPDFMultiple sendPDFviewMultiple;


    
    public ConfirmBill_Controller(LinkedList<Bill> l,BillsQueue_Controller main){
        bills=l;
        views=new BuildPDFMultiple();
        view=null;
        bill=null;
        this.controller = main;
        views.setVisible(true);
        views.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfirmBill_Controller c = (ConfirmBill_Controller)controller;
                c.buttonCliked(e);            
            }
        });
        views.addMouseListener(new Listener(this){
            @Override
            public void mouseClicked(MouseEvent e){
                ConfirmBill_Controller c = (ConfirmBill_Controller)controller;
                c.tableClicked(e);
            }
        });
        defaultRender = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object
                value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
        };
        try {
            dbController = Database_Controller.getDbManager();
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmBill_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        DAO_Contract daoContract = new Contract_MYSQL(dbController);
        for(Bill b: l){
            Contract tmp = daoContract.getContract(b.getContractID());
            contracts.add(tmp);
        }
        PDFMaker.createPDF(contracts,null);
        initMultiSelect();
    }
    
    public ConfirmBill_Controller(Bill b,BillsQueue_Controller main){
        bill=b;
        bills=null;
        this.main = main;
        Database_Controller dbController = null;
        try {
            dbController = Database_Controller.getDbManager();
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmBill_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        DAO_Contract daoContract = new Contract_MYSQL(dbController);
        contract = daoContract.getContract(b.getContractID());
        PDFMaker.createPDF(contract, b,null);
        view= new BuildPDF(b);
        view.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfirmBill_Controller c = (ConfirmBill_Controller)controller;
                c.buttonCliked(e);            
            }
        });
        views=null;
        view.setVisible(true);
        
    }

    private void buttonCliked(ActionEvent e) {
        Component j = (Component)e.getSource();
        Integer i;
        if(view != null)
            i = view.checkButton(j);
        else
            i = views.checkButton(j);
        switch(i){
            case 1:{
                if(view!=null)
                    view.dispose();
                else
                    views.dispose();
                main.back(); 
                break;
            } 
            case 2: previewPressed(); break;
            case 3: sendClicked(); break;
        }
    }

    private void sendClicked() {
        String result;
        Map<Integer,String> results;
        if(view!=null){
            result = EMailSender.sendEmail(contract);
            view.dispose();
            sendPDFview = new SendPDF(result);
            sendPDFview.show();
            sendPDFview.addActionListener(new Listener(this){
                @Override
                public void actionPerformed(ActionEvent e) {
                ConfirmBill_Controller c = (ConfirmBill_Controller)controller;
                c.okClicked();
                }
            });
        }
        else{
            results = EMailSender.sendEmail(contracts);
            views.dispose();
            sendPDFviewMultiple = new SendPDFMultiple(results);
            sendPDFviewMultiple.show();
            sendPDFviewMultiple.addActionListener(new Listener(this){
                @Override
                public void actionPerformed(ActionEvent e) {
                ConfirmBill_Controller c = (ConfirmBill_Controller)controller;
                c.okClicked();
                }
            });
        }
        
    }

    private void previewPressed() {
        
    }

    private void okClicked(){
        sendPDFview.dispose();
        if(views != null){
            views.show();
        }
        else
            main.back(); 
    }

    private void setDefaultRender(JTable billTable) {
        TableColumnModel tableModel = billTable.getColumnModel();
        TableColumn tableColumn;
        Integer columns = billTable.getColumnCount();
        for(Integer i = 0; i < columns; i++){
            tableColumn = tableModel.getColumn(i);
            tableColumn.setCellRenderer(defaultRender);
        }    
    }

    private void initMultiSelect() {
        tableModelMultipleBill = views.getTableModelMultipleBill();
        tableModelMultipleBill.setRowCount(0);
        String[] columns = {"Contract ID", "Reference detection", "Generated on", "Total"};
        tableModelMultipleBill.setColumnIdentifiers(columns);
        setDefaultRender(views.getBillTable());
        for(Bill temp : bills){
            Object[] row = {temp.getContractID(), temp.getDetectionDate(), temp.getGeneratedDate(), temp.getTotal()};
            tableModelMultipleBill.addRow(row);
        }
    }

    private void tableClicked(MouseEvent e) {
        if(views.getSelectedBill()!=null)
            views.activePreviewButton(true);
        else
            views.activePreviewButton(false);
    }


}
