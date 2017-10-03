/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Injuction_MYSQL;
import Model.Contract;
import Model.Injuction;
import View.Injuctions;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
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
public class Injuctions_Controller implements Controller {
    private final Contract contract;
    private final Registry_Controller reg;
    private Database_Controller dbManager;
    private Injuctions view;
    private List<Injuction> injuctions;
    private final DefaultTableCellRenderer defaultRender;
    
    public Injuctions_Controller(Registry_Controller reg, Contract contract) {
        try {
            dbManager=Database_Controller.getDbManager();
        } catch (SQLException ex) {
            
        }
        
        this.contract=contract;
        this.reg=reg;
        view=new Injuctions();
        view.setVisible(true);
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
            public void actionPerformed(ActionEvent e) {
                Injuctions_Controller bc = (Injuctions_Controller)controller;
                bc.buttonCliked((Component)e.getSource());            
            }
        });
        
        view.addMouseListener(new Listener(this){
            @Override
            public void mouseClicked(MouseEvent e){
                Injuctions_Controller bc = (Injuctions_Controller)controller;
                bc.tableClicked();
            }
        });
        initTable();        
    }

    private void buttonCliked(Component component) {
        int i = view.checkButton(component);
        switch(i){
            case 1: buildClicked();break;
            case 2: view.dispose(); break;
        }
    }

    private void tableClicked() {
        int i= view.countSelectedRows();
        if(i>0){
            i=view.getSelectedRow();
            //Santangelo deve agggiungere delle cose!!! i settere nella view sono già creati
            
            
            view.enableBuildPDFButton(true);
        }
    }

    private void buildClicked() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void initTable() {
        DefaultTableModel model = view.getInjuctionsTableModel();
        String[] columns = {"Contract ID", "Reference bill", "Expired from", "Arrears"};
        model.setColumnIdentifiers(columns);
        Injuction_MYSQL dao = new Injuction_MYSQL(dbManager);
        injuctions=dao.getAllDocuments(contract);
        for(Injuction temp : injuctions){
            Object[] row = {temp.getContractID(), temp.getBillID(), temp.getExpiredFrom(), Float.valueOf(temp.getArrears().replace(',', '.'))};
            model.addRow(row);
            setDefaultRender(view.getInjuctionsTable());
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
    
}
