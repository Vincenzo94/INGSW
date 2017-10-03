/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Bill_MYSQL;
import DAO.DAO_Document;
import Model.Bill;
import Model.Operator;
import View.BillsQueuePanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Andrea
 */
public class BillsQueue_Controller implements Controller{
    
    private final BillsQueuePanel actual;
    private DefaultTableModel tableModelBillsQueue = null;
    private final DefaultTableCellRenderer defaultRender;
    private final Database_Controller dbManager;
    private List<Bill> bills;
    private Operator operator;
    private Controller current;

    public BillsQueue_Controller(Database_Controller dbManager, Operator o, Component panel) {
        this.dbManager=dbManager;
        this.operator=o;
        actual = (BillsQueuePanel)panel;
        bills = new ArrayList<>();
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
        
        actual.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e){
                BillsQueue_Controller c = (BillsQueue_Controller)controller;
                c.buttonClicked((Component)e.getSource());
            }
        });
        
        actual.addMouseListener(new Listener(this){
            @Override
            public void mouseClicked(MouseEvent e){
                BillsQueue_Controller co = (BillsQueue_Controller)controller;
                co.tableClicked();
            }
        });
        initBillsQueue();
        updateBillsQueue();
    }
    
    JPanel getPanel(){
        return actual;
    }
    
    
    private void tableClicked(){
        List<Integer> bill = actual.getSelectedBill();
            if(bill.size() ==  1){
                actual.setMultipleSelection(false);
                Bill temp = bills.get(bill.get(0));
                actual.setTax(temp.getTax());
                actual.setTotal(temp.getTotal());
                actual.setDetection(temp.getDetectionValue());
                actual.setDetector(temp.getDetector());
                actual.setDetectionDate(temp.getDetectionDate());
                actual.setDeadline(temp.getDeadline()); 
                actual.activeBillConfirm(true);
                actual.activeBillReportError(true);
            }
            else if(bill.size() > 1){
                actual.activeBillReportError(false);
                actual.activeBillConfirm(true);
                actual.setMultipleSelection(true);
                actual.setSelectedBills(bill.size());
            }
            else{
                actual.activeBillConfirm(false);
                actual.activeBillReportError(false);
                actual.setMultipleSelection(true);
                actual.setSelectedBills(bill.size());
            }
    }
    
    private void buttonClicked(Component c){
        int i = actual.checkButton(c);
        switch(i){
            case 1: selectAllClicked(); break;
            case 2: deselectAllClicked(); break;
            case 3: confirmClicked(); break;
            case 4: reportClicked(); break;
        }
    }
    
    private void confirmClicked(){
        LinkedList<Bill> selected=new LinkedList<>();
        for(Integer i: actual.getSelectedBill()){
            selected.add(bills.get(i));
        }
        actual.setEnabled(false);
        if(selected.size()==1)
            current = new ConfirmBill_Controller(selected.getFirst(),this);
        else
            current = new ConfirmBill_Controller(selected,this);
    }
    
    
    public void back(){
        actual.setEnabled(true);
        updateBillsQueue();
    }
    
    
    
    private void initBillsQueue() {
        tableModelBillsQueue = actual.getTableModelBillsQueue();
        tableModelBillsQueue.setRowCount(0);
        String[] columns = {"Contract ID", "Reference detection", "Generated on", "Total", "Selected"};
        tableModelBillsQueue.setColumnIdentifiers(columns);
        setDefaultRender(actual.getBillTable());
        actual.setMultipleSelection(true);
    }

    void updateBillsQueue(){
        DAO_Document daoBill = new Bill_MYSQL(dbManager);
        bills.clear();
        tableModelBillsQueue.setRowCount(0);
        bills = daoBill.getAllDocuments(operator);
        
        for(Bill temp : bills){
            if(temp.getOperatorID() == null){
                daoBill.setManagedOperator(temp,operator);
                Log_Controller.writeLog("User: "+ operator.getId()+" manages the bill "+temp.getId(), this.getClass());
            }
            Log_Controller.writeLog("User: "+ operator.getId()+" manages the bill "+temp.getId(), this.getClass());
            Object[] row = {temp.getContractID(), temp.getDetectionDate(), temp.getGeneratedDate(), temp.getTotal(), false};
            tableModelBillsQueue.addRow(row);
        }
    }
    
    private void setDefaultRender(JTable table) {
        TableColumnModel tableModel = table.getColumnModel();
        TableColumn tableColumn;
        Integer columns = table.getColumnCount();
        if(table.getColumnName(columns-1).equals("Selected"))
            columns--;
        for(Integer i = 0; i < columns; i++){
            tableColumn = tableModel.getColumn(i);
            tableColumn.setCellRenderer(defaultRender);
        }
    }
    
    private void selectAllClicked(){
        DefaultTableModel table = actual.getTableModelBillsQueue();
        for(Integer i = 0; i < table.getRowCount(); i++)
            table.setValueAt(true, i, 4);
        actual.setMultipleSelection(true);
        actual.setSelectedBills(table.getRowCount());
        actual.setSelectAllButton(false);
        actual.activeBillConfirm(true);
        actual.activeBillReportError(false);
    }
    
    private void deselectAllClicked(){
        DefaultTableModel table = actual.getTableModelBillsQueue();
        for(Integer i = 0; i < table.getRowCount(); i++)
            table.setValueAt(false, i, 4);
        actual.setMultipleSelection(true);
        actual.setSelectedBills(0);
        actual.setSelectAllButton(true);
        actual.activeBillConfirm(false);
        actual.activeBillReportError(false);
    }

    private void reportClicked() {
        
    }

}
