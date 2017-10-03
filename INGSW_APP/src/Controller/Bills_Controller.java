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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void tableCliked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    }
    public void back(){
        view.setEnabled(true);
    }
}
