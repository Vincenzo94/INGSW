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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    
    private final BillsQueuePanel view;
    private DefaultTableModel tableModelBillsQueue = null;
    private final DefaultTableCellRenderer defaultRender;
    private final Database_Controller dbManager;
    private List<Bill> bills;
    private final Operator operator;
    private Controller current;

    public BillsQueue_Controller(Database_Controller dbManager, Operator o, Component panel) {
        this.dbManager=dbManager;
        this.operator=o;
        view = (BillsQueuePanel)panel;
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
        
        view.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e){
                BillsQueue_Controller c = (BillsQueue_Controller)controller;
                c.buttonClicked((Component)e.getSource());
            }
        });
        
        view.addMouseListener(new Listener(this){
            @Override
            public void mouseClicked(MouseEvent e){
                BillsQueue_Controller co = (BillsQueue_Controller)controller;
                co.tableClicked();
            }
        });
        initBillsQueue();
        updateBillsQueue();
    }
       
    private void tableClicked(){
        List<Integer> bill = view.getSelectedBill();
            if(bill.size() ==  1){
                view.setMultipleSelection(false);
                Bill temp = bills.get(bill.get(0));
                view.setTax(temp.getTax());
                view.setTotal(temp.getTotal());
                view.setDetection(temp.getDetectionValue());
                view.setDetector(temp.getDetector());
                view.setDetectionDate(temp.getDetectionDate());
                view.setDeadline(temp.getDeadline()); 
                view.activeBillConfirm(true);
                view.activeBillReportError(true);
            }
            else if(bill.size() > 1){
                view.activeBillReportError(false);
                view.activeBillConfirm(true);
                view.setMultipleSelection(true);
                view.setSelectedBills(bill.size());
            }
            else{
                view.activeBillConfirm(false);
                view.activeBillReportError(false);
                view.setMultipleSelection(true);
                view.setSelectedBills(bill.size());
            }
    }
    
    private void buttonClicked(Component c){
        int i = view.checkButton(c);
        switch(i){
            case 1: selectAllClicked(); break;
            case 2: deselectAllClicked(); break;
            case 3: confirmClicked(); break;
            case 4: reportClicked(); break;
        }
    }
    
    private void confirmClicked(){
        
        
        LinkedList<Bill> selected=new LinkedList<>();
        for(Integer i: view.getSelectedBill()){
            selected.add(bills.get(i));
        }
        
        if(selected.size()==1)
            current = new ConfirmBill_Controller(selected.getFirst(),this);
        else
            current = new ConfirmBill_Controller(selected,this);
    }
     
    public void back(){
        view.getParent().setEnabled(true);
        view.setEnabled(true);
        updateBillsQueue();
    }
        
    private void initBillsQueue() {
        tableModelBillsQueue = view.getTableModelBillsQueue();
        tableModelBillsQueue.setRowCount(0);
        String[] columns = {"Contract ID", "Reference detection", "Generated on", "Total", "Selected"};
        tableModelBillsQueue.setColumnIdentifiers(columns);
        setDefaultRender(view.getBillTable());
        view.setMultipleSelection(true);
    }

    void updateBillsQueue(){
        DAO_Document daoBill = new Bill_MYSQL(dbManager);
        bills.clear();
        tableModelBillsQueue.setRowCount(0);
        try {
                bills = daoBill.getAllDocuments(operator);        
            for(Bill temp : bills){
                if(temp.getOperatorID() == null){
                        daoBill.setManagedOperator(temp,operator);
                }
                Log_Controller.writeLog(" manages the bill "+temp.getId(), this.getClass());
                Object[] row = {temp.getContractID(), temp.getDetectionDate(), temp.getGeneratedDate(), temp.getTotal(), false};
                tableModelBillsQueue.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(view, ex.getMessage(),"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
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
        DefaultTableModel table = view.getTableModelBillsQueue();
        for(Integer i = 0; i < table.getRowCount(); i++)
            table.setValueAt(true, i, 4);
        view.setMultipleSelection(true);
        view.setSelectedBills(table.getRowCount());
        view.setSelectAllButton(false);
        view.activeBillConfirm(true);
        view.activeBillReportError(false);
    }
    
    private void deselectAllClicked(){
        DefaultTableModel table = view.getTableModelBillsQueue();
        for(Integer i = 0; i < table.getRowCount(); i++)
            table.setValueAt(false, i, 4);
        view.setMultipleSelection(true);
        view.setSelectedBills(0);
        view.setSelectAllButton(true);
        view.activeBillConfirm(false);
        view.activeBillReportError(false);
    }

    private void reportClicked() {
        List<Integer> select = view.getSelectedBill();
        if(select.size()==1)
            current = new ReportError_Controller(bills.get(select.get(0)));
    }

}
