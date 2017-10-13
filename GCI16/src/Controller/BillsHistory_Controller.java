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
import View.BillsHistory;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
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
 * @author ansan
 */
public class BillsHistory_Controller implements Controller {
    private final Contract contract;
    private final Registry_Controller reg;
    private Database_Controller dbManager;
    private final BillsHistory view;
    private final DefaultTableCellRenderer defaultRender;
    private DefaultTableModel billsModel;
    private List<Bill> bills;
    private Controller current;
    
    BillsHistory_Controller(Registry_Controller reg, Contract contract) {
        this.contract = contract;
        this.reg = reg;
        view = new BillsHistory();
        view.setSize();
        view.setVisible(true);
        view.addActionListener(new Listener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCliked((Component)e.getSource());            
            }
        });
        view.addMouseListener(new Listener(){
            @Override
            public void mouseClicked(MouseEvent e){
                tableCliked(e);   
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

    private void buttonCliked(Component j) {
        Integer i = view.checkButton(j);
        switch (i){
            case 1: backClicked(); break;
            case 2: buildPDFClicked(); break;
            case 3: reportErrorClicked(); break;
        }
    }

    private void tableCliked(MouseEvent e) {
        Integer billCont = view.getBillCount();
        if(billCont>0){
            Integer bill = view.getSelectedBill();
            if(bill != null && bill>=0 && bill<bills.size()){
                Bill temp = bills.get(bill);
                view.setTax(temp.getTax());
                view.setTotal(temp.getTotal());
                view.setDetection(temp.getDetectionValue());
                view.setDetector(temp.getDetector());
                view.setDetectionDate(temp.getDetectionDate());
                view.activeGenPDF(true);
                view.activeBillReportError(true);
            }
            else
                JOptionPane.showConfirmDialog(view, "Invalid Selection from the table","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
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
            dbManager = Database_Controller.getDbManager();
            billsModel = view.getTableModelBills();
            billsModel.setRowCount(0);
            String[] columns = {"Invoice N.", "Period", "State", "Due date"};
            billsModel.setColumnIdentifiers(columns);
            setDefaultRender(view.getBillTable());
            DAO_Document daoBill = new Bill_MYSQL(dbManager);
            bills.clear();
            bills = daoBill.getAllDocuments(contract);
            for(Bill temp : bills){
                Object[] row = {temp.getId(), temp.getPeriod(), temp.getState(), temp.getDeadline()};
                billsModel.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(view, ex.getMessage(),"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void backClicked(){
        view.dispose();
        reg.back();
    }

    private void buildPDFClicked() {
        int i= view.getSelectedBill();
        Bill b;
        if(i>=0 && i<bills.size()){
            b= bills.get(i);
            view.dispose();
            current = new ConfirmBill_Controller(b,this);
        }
        else
            JOptionPane.showConfirmDialog(view, "Invalid Selection from the table","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
    }

    private void reportErrorClicked() {
        int i =view.getSelectedBill();
        Bill b;
        if(i>=0 && i<bills.size()){
            b= bills.get(i);
            view.dispose();
            current = new ReportError_Controller(b);
        }
        else
            JOptionPane.showConfirmDialog(view, "Invalid Selection from the table","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
    }

    public void back() {
        view.setVisible(true);
    }
}
