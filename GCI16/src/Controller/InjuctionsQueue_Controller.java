/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Document;
import DAO.Injuction_MYSQL;
import Model.Injuction;
import Model.Operator;
import View.InjuctionsQueuePanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class InjuctionsQueue_Controller implements Controller {
    
    private final InjuctionsQueuePanel view;
    private DefaultTableModel tableModelInjuctionsQueue = null;
    private final DefaultTableCellRenderer defaultRender;
    private List<Injuction> injuctions;
    private final Database_Controller dbManager;
    private final Operator operator;
    private Controller current;

    InjuctionsQueue_Controller(Database_Controller dbManager, Operator o, Component panel) {
        this.operator=o;
        this.dbManager=dbManager;
        view=(InjuctionsQueuePanel)panel;
        view.setSize();
        injuctions = new ArrayList<>();
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
        
        view.addMouseListener(new Listener(this){
            @Override
            public void mouseClicked(MouseEvent e){
                InjuctionsQueue_Controller c = (InjuctionsQueue_Controller)controller;
                c.activeInjuctionButtons();
            }
        });
        
        view.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e){
                InjuctionsQueue_Controller c = (InjuctionsQueue_Controller)controller;
                c.buttonClicked((Component)e.getSource());
            }
        });
        initInjuctionsQueue();
    }
    
    private void activeInjuctionButtons(){
        view.activeInjuctionButtons();
    }
    
    Component getPanel(){
        return view;
    }
    
    private void buttonClicked(Component c){
        int i = view.checkButton(c);
        switch(i){
            case 1: confirmInjuctionClicked(); break;
            case 2: removeInjuctionClicked(); break;
        }
    }    
        
    private void initInjuctionsQueue() {
        tableModelInjuctionsQueue = view.getTableModelInjuctionsQueue();
        tableModelInjuctionsQueue.setRowCount(0);
        String[] columns = {"Contract ID", "Reference bill", "Expired from", "Arrears"};
        tableModelInjuctionsQueue.setColumnIdentifiers(columns);
        updateInjuctionsQueue();
        
    } 
    
    private void updateInjuctionsQueue(){
        DAO_Document daoInjuction = new Injuction_MYSQL(dbManager);
        tableModelInjuctionsQueue.setRowCount(0);
        injuctions.clear();
        try {
            injuctions = daoInjuction.getAllDocuments(operator);
            for(Injuction temp : injuctions){
                if(temp.getOperatorID() == null){
                        daoInjuction.setManagedOperator(temp,operator);
                    Log_Controller.writeLog(" manages the injuction "+temp.getId(),this.getClass());
                }
                Object[] row = {temp.getContractID(), temp.getBillID(), temp.getExpiredFrom(), Float.valueOf(temp.getArrears().replace(',', '.'))};
                tableModelInjuctionsQueue.addRow(row);
                setDefaultRender(view.getInjuctionTable());

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
    
    private void removeInjuctionClicked() {
        int row = view.getSelectedInjuction();
        if(row>=0 && row<injuctions.size()){
            current = new RemoveInjuction_Controller(this);
            ((RemoveInjuction_Controller)current).removeInjuction(injuctions.get(row));
        }
        else
            JOptionPane.showConfirmDialog(view, "Invalid selection from the table","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
    }
    
    private void confirmInjuctionClicked(){
        int i = view.getSelectedInjuction();
        Injuction b;
        if(i>=0 && i<injuctions.size()){
            b = injuctions.get(i);
            current = new ConfirmInjuction_Controller(b,this);
        }
        else
            JOptionPane.showConfirmDialog(view, "Invalid selection from the table","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
    }
    
    void back(){
        updateInjuctionsQueue();
    }
    
}
