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
import java.util.ArrayList;
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
public class InjuctionsQueue_Controller implements Controller{
    
    private final InjuctionsQueuePanel actual;
    private DefaultTableModel tableModelInjuctionsQueue = null;
    private final DefaultTableCellRenderer defaultRender;
    private List<Injuction> injuctions;
    private final Database_Controller dbManager;
    private final Operator operator;
    private Controller current;

    public InjuctionsQueue_Controller(Database_Controller dbManager, Operator o, Component panel) {
        this.operator=o;
        this.dbManager=dbManager;
        actual=(InjuctionsQueuePanel)panel;
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
        
        actual.addMouseListener(new Listener(this){
            @Override
            public void mouseClicked(MouseEvent e){
                InjuctionsQueue_Controller c = (InjuctionsQueue_Controller)controller;
                c.activeInjuctionButtons();
            }
        });
        
        actual.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e){
                InjuctionsQueue_Controller c = (InjuctionsQueue_Controller)controller;
                c.buttonClicked((Component)e.getSource());
            }
        });
        initInjuctionsQueue();
        updateInjuctionsQueue();
    }
    
    JPanel getPanel(){
        return actual;
    }
    
    
    public void activeInjuctionButtons(){
        actual.activeInjuctionButtons();
    }
    
    private void buttonClicked(Component c){
        int i = actual.checkButton(c);
        switch(i){
            case 1: removeInjuctionClicked(); break;
            case 2: confirmInjuctionClicked(); break;
            }
    }
    
    private void confirmInjuctionClicked(){
        
    }
    
    
        
    private void initInjuctionsQueue() {
        tableModelInjuctionsQueue = actual.getTableModelInjuctionsQueue();
        tableModelInjuctionsQueue.setRowCount(0);
        String[] columns = {"Contract ID", "Reference bill", "Expired from", "Arrears"};
        tableModelInjuctionsQueue.setColumnIdentifiers(columns);
        
    } 
    
    void updateInjuctionsQueue(){
        DAO_Document daoInjuction = new Injuction_MYSQL(dbManager);
        tableModelInjuctionsQueue.setRowCount(0);
        injuctions.clear();
        injuctions = daoInjuction.getAllDocuments(operator);
        for(Injuction temp : injuctions){
            if(temp.getOperatorID() == null){
                daoInjuction.setManagedOperator(temp,operator);
                Log_Controller.writeLog(" manages the injuction "+temp.getId(),this.getClass());
            }
            Log_Controller.writeLog(" manages the injuction "+temp.getId(), this.getClass());
            Object[] row = {temp.getContractID(), temp.getBillID(), temp.getExpiredFrom(), Float.valueOf(temp.getArrears().replace(',', '.'))};
            tableModelInjuctionsQueue.addRow(row);
            setDefaultRender(actual.getInjuctionTable());

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
        int row = actual.getSelectedInjuction();
        actual.setEnabled(false);
        current = new RemoveInjuction_Controller(this, injuctions.get(row));
    }
    
    public void back(){
        actual.setEnabled(true);
        updateInjuctionsQueue();
    }
    
}
