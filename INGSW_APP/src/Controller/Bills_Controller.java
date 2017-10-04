/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Bill_MYSQL;
import DAO.DAO_Document;
import Model.Bill;
import Model.Contract;
import View.Bills;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ansan
 */
public class Bills_Controller implements Controller {
    private final Contract contract;
    private final Registry_Controller reg;
    private Database_Controller dbManager;
    private final Bills view;
    private final DefaultTableCellRenderer defaultRender;
    private DefaultTableModel billsModel;
    private List<Bill> bills;
    private Database_Controller dbController;
    private Controller current;

    
    public Bills_Controller(Registry_Controller reg, Contract contract) {
        this.contract = contract;
        this.reg = reg;
        view = new Bills();
        view.setVisible(true);
        view.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
                Bills_Controller bc = (Bills_Controller)controller;
                bc.buttonCliked(e);            
            }
        });
        view.addMouseListener(new Listener(this){
            @Override
            public void mouseClicked(MouseEvent e){
                Bills_Controller bc = (Bills_Controller)controller;
                bc.tableCliked(e);   
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
        bills = new LinkedList<>();
        init();
    }

    private void buttonCliked(ActionEvent e) {
        Component j = (Component)e.getSource();
        Integer i = view.checkButton(j);
        switch (i){
            case 1: backClicked(); break;
            case 2: buildPDFClicked(); break;
            case 3: reportErrorClicked(); break;
        }
    }

    private void tableCliked(MouseEvent e) {
        Integer bill = view.getSelectedBill();
        if(bill != null){
            Bill temp = bills.get(bill);
            view.setTax(temp.getTax());
            view.setTotal(temp.getTotal());
            view.setDetection(temp.getDetectionValue());
            view.setDetector(temp.getDetector());
            view.setDetectionDate(temp.getDetectionDate());
            view.activeGenPDF(true);
            view.activeBillReportError(true);
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

    private void init() {
        try {
            dbController = Database_Controller.getDbManager();
        } catch (SQLException ex) {
        }
        billsModel = view.getTableModelBills();
        billsModel.setRowCount(0);
        String[] columns = {"Invoice N.", "Period", "State", "Due date"};
        billsModel.setColumnIdentifiers(columns);
        setDefaultRender(view.getBillTable());
        DAO_Document daoBill = new Bill_MYSQL(dbController);
        bills.clear();
        bills = daoBill.getAllDocuments(contract);
        for(Bill temp : bills){
            System.out.println(temp.getState());
            Object[] row = {temp.getId(), temp.getPeriod(), temp.getState(), temp.getDeadline()};
            billsModel.addRow(row);
        }
    }
    public void backClicked(){
        view.dispose();
        reg.back();
    }

    private void buildPDFClicked() {
        Bill b = bills.get(view.getSelectedBill());
        view.dispose();
        current = new ConfirmBill_Controller(b,this);
    }

    private void reportErrorClicked() {
        Bill b = bills.get(view.getSelectedBill());
        view.dispose();
        current = new ReportError_Controller(b);
    }

    public void back() {
        view.setVisible(true);
    }
}
