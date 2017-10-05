/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Bill_MYSQL;
import DAO.Contract_MYSQL;
import DAO.DAO_Contract;
import DAO.DAO_Document;
import Model.Bill;
import Model.Contract;
import Model.EMailSender;
import Model.Operator;
import Model.PDFMaker;
import View.BuildPDF;
import View.BuildPDFMultiple;
import View.SendPDF;
import View.SendPDFMultiple;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
    private final Map<Bill,Contract>  bills;
    private final Bill bill;
    private  BillsQueue_Controller billsQueueController;
    private  BillsHistory_Controller billsController;
    private final BuildPDF view;
    private final BuildPDFMultiple views;
    private SendPDF sendPDFview;
    Contract contract;
    private DefaultTableModel tableModelMultipleBill = null;
    private DefaultTableCellRenderer defaultRender = null;
    private Database_Controller dbController;
    private SendPDFMultiple sendPDFviewMultiple;
    private Operator operator;

    
    public ConfirmBill_Controller(LinkedList<Bill> l,BillsQueue_Controller main){
        bills= new HashMap<>();
        views=new BuildPDFMultiple();
        view=null;
        bill=null;
        this.billsQueueController = main;
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
        }
        DAO_Contract daoContract = new Contract_MYSQL(dbController);
        for(Bill b: l){
            Contract tmp = daoContract.getContract(b.getContractID());
            bills.put(b, tmp);
        }
        PDFMaker.createPDF(bills);
        initMultiSelect();
    }
    
    public ConfirmBill_Controller(Bill b,BillsQueue_Controller main){
        bill=b;
        bills=null;
        this.billsQueueController = main;
        try {
            dbController = Database_Controller.getDbManager();
        } catch (SQLException ex) {
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
    public ConfirmBill_Controller(Bill b,BillsHistory_Controller main){
        bill=b;
        bills=null;
        this.billsController = main;
        try {
            dbController = Database_Controller.getDbManager();
        } catch (SQLException ex) {
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
                if(billsQueueController!=null)
                    billsQueueController.back(); 
                else
                    billsController.back();
                break;
            } 
            case 2: previewPressed(); break;
            case 3: sendClicked(); break;
            case 4: closePreviewPressed(); break;
        }
    }

    private void sendClicked() {
        DAO_Document daoDocument = new Bill_MYSQL(dbController);
        String result;
        Map<Integer,String> results;
        if(view!=null){
            result = EMailSender.sendEmail(contract, Bill.class);
            view.dispose();
            sendPDFview = new SendPDF(result);
            sendPDFview.setVisible(true);
            sendPDFview.addActionListener(new Listener(this){
                @Override
                public void actionPerformed(ActionEvent e) {
                ConfirmBill_Controller c = (ConfirmBill_Controller)controller;
                c.okClicked();
                }
            });
            Log_Controller.writeLog(" send the bill "+bill.getId()+" to "+contract.getName()+" "+contract.getSurname()+" with ID "+contract.getId()+" at the address: "+contract.getEmailAddress(),ConfirmBill_Controller.class);
            bill.setState("Issued");
            daoDocument.setState(bill);
        }
        else{
            results = EMailSender.sendEmail(bills, Bill.class);
            views.dispose();
            sendPDFviewMultiple = new SendPDFMultiple(results);
            sendPDFviewMultiple.setVisible(true);
            sendPDFviewMultiple.addActionListener(new Listener(this){
                @Override
                public void actionPerformed(ActionEvent e) {
                ConfirmBill_Controller c = (ConfirmBill_Controller)controller;
                c.okClicked();
                }
            });
            for(Bill b:bills.keySet()){
                Log_Controller.writeLog(" send the bill "+b.getId()+" to contract: "+bills.get(b).getName()+" "+bills.get(b).getSurname()+" with ID "+b.getContractID()+" at the address: "+bills.get(b).getEmailAddress(),ConfirmBill_Controller.class);
                b.setState("Issued");
                daoDocument.setState(b);
            }
        }
        
        
    }

    private void previewPressed() {
        views.preview(true);
    }

    private void okClicked(){
        if(views != null){
            sendPDFviewMultiple.dispose();
        }
        else{
            sendPDFview.dispose();
            view.dispose();
        }
        if(billsQueueController!=null)
            billsQueueController.back(); 
        else
            billsController.back();
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
        for(Bill temp : bills.keySet()){
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

    private void closePreviewPressed() {
        views.preview(false);
    }


}
