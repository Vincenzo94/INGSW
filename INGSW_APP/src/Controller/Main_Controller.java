/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Bill;
import Model.Contract;
import Model.Injuction;
import Model.Operator;
import View.BillsQueuePanel;
import View.Home;
import View.InjuctionsQueuePanel;
import View.RegistryPanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Andrea
 */

//Classe implementata come singleton
public class Main_Controller{
    Controller current;
    private Operator operator;
    private static Main_Controller instance;
    private final Database_Controller dbManager;
    
    private InjuctionsQueue_Controller inj;
    private BillsQueue_Controller bill;
    private Registry_Controller regy;
    
    
    private DefaultTableModel tableModelBillsQueue = null;
    private DefaultTableModel tableModelInjuctionsQueue = null;
    //private final DefaultTableCellRenderer defaultRender;
    
    private List<Contract> contracts = null;
    private List<Bill> bills = new ArrayList<>();
    private List<Injuction> injuctions = new ArrayList<>();
    
    private Home actual = null; 
    
    private Main_Controller() throws SQLException{

        current = new Login_Controller(this);
        dbManager = Database_Controller.getDbManager();
    }
    
    public static Main_Controller getMain() throws SQLException{
        if(instance==null){
            instance=new Main_Controller();
        }
        return instance;
    }
    
    public Operator getOperator() {
        return operator;
    }
    
    public void loginDone(Operator o){
        operator=o;
        actual = new Home();
        //INGSW_APP.device.setFullScreenWindow(actual);
        actual.setVisible(true);
//        actual.addMouseListener(new Listener(this){
//            @Override
//            public void mouseClicked(MouseEvent e){
//                Main_Controller m = (Main_Controller)controller;
//                m.tableClicked(e);
//            }
//        });
        actual.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_Controller m = (Main_Controller)controller;
                m.buttonCliked(e);            
            }
        });
        actual.addChangeListener(new Listener(this){
            @Override
            public void stateChanged(ChangeEvent e){
                Main_Controller m = (Main_Controller)controller;
                m.changePane();
            }
        });
        regy=new Registry_Controller(dbManager,operator,actual.getPanel(0));
        inj=new InjuctionsQueue_Controller(dbManager,operator,actual.getPanel(1));
        bill=new BillsQueue_Controller(dbManager,operator,actual.getPanel(2));
    }
    
    private void changePane(){
        int i = actual.getSelectedPanel();
        switch(i){
            case 1: inj.updateInjuctionsQueue(); break;
            case 2: bill.updateBillsQueue(); break;
            case 0: regy.searchClicked(); break; 
        }
    }
    
    private void buttonCliked(ActionEvent e){
        Component j = (Component)e.getSource();
        int i=actual.checkButton(j);
        switch(i){
            case 1: logOut(); break;
            case 2: help(); break;
        }
    }
    
//    public void back(){
//        //current=null;
//        actual.setVisible(true);
//        actual.setEnabled(true);
//        changePane();
//    }
//    
    private void help(){
        int i = actual.getSelectedPanel();
        switch (i){
            case 0: Popup_Controller.getPopup_C().showPopup("Primo pannello"); break;
            case 1: Popup_Controller.getPopup_C().showPopup("Secondo pannello"); break;
            case 2: Popup_Controller.getPopup_C().showPopup("Terzo pannello");break;
        }
    }
    
    private void logOut(){
        actual.dispose();
        instance=null;
        try {
            instance = new Main_Controller();
        } catch (SQLException ex) {
            Logger.getLogger(Main_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    

//    private void initBillsQueue() {
//        tableModelBillsQueue = actual.getTableModelBillsQueue();
//        tableModelBillsQueue.setRowCount(0);
//        String[] columns = {"Contract ID", "Reference detection", "Generated on", "Total", "Selected"};
//        tableModelBillsQueue.setColumnIdentifiers(columns);
//        setDefaultRender(actual.getBillTable());
//    }
//
//    private void updateBillsQueue(){
//        DAO_Document daoBill = new Bill_MYSQL(dbManager);
//        bills.clear();
//        tableModelBillsQueue.setRowCount(0);
//        bills = daoBill.getAllDocuments(operator);
//        
//        for(Bill temp : bills){
//            if(temp.getOperatorID() == null){
//                daoBill.setManagedOperator(temp,operator);
//                Log_Controller.writeLog("User: "+ operator.getId()+" manages the bill "+temp.getId(), this.getClass());
//            }
//            Log_Controller.writeLog("User: "+ operator.getId()+" manages the bill "+temp.getId(), this.getClass());
//            Object[] row = {temp.getContractId(), temp.getDetectionDate(), temp.getGeneratedDate(), temp.getTotal(), false};
//            tableModelBillsQueue.addRow(row);
//        }
//    }
//    
//    private void initInjuctionsQueue() {
//        tableModelInjuctionsQueue = actual.getTableModelInjuctionsQueue();
//        tableModelInjuctionsQueue.setRowCount(0);
//        String[] columns = {"Contract ID", "Reference bill", "Expired from", "Arrears"};
//        tableModelInjuctionsQueue.setColumnIdentifiers(columns);
//        
//    } 
//    
//    private void updateInjuctionsQueue(){
//        DAO_Document daoInjuction = new Injuction_MYSQL(dbManager);
//        tableModelInjuctionsQueue.setRowCount(0);
//        injuctions.clear();
//        injuctions = daoInjuction.getAllDocuments(operator);
//        for(Injuction temp : injuctions){
//            if(temp.getOperatorID() == null){
//                daoInjuction.setManagedOperator(temp,operator);
//                Log_Controller.writeLog("User: "+ operator.getId()+" manages the injuction "+temp.getId(),this.getClass());
//            }
//            Log_Controller.writeLog("User: "+ operator.getId()+" manages the injuction "+temp.getId(), this.getClass());
//            Object[] row = {temp.getContractID(), temp.getBillID(), temp.getExpiredFrom(), Float.valueOf(temp.getArrears().replace(',', '.'))};
//            tableModelInjuctionsQueue.addRow(row);
//            setDefaultRender(actual.getInjuctionTable());
//
//        }
//    }
    
    /*private void tableClicked(MouseEvent e) {
        switch(actual.checkTab(e.getComponent())){
            case 1:{
                contracts = ((SearchContract_Controller)current).getContracts();
                Contract contract = contracts.get(actual.getSelectedContract());
                actual.activeContractButtons();
                actual.setBillingAddress(contract.getBillingAddress());
                actual.setAddress(contract.getAddress());
                actual.setTelephone(contract.getTelephone());
                actual.setEmail(contract.getEmailAddress());
                break;
            }
            case 2:{
                actual.activeInjuctionButtons();
                break;
            }
            case 3:{
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
                break;
            }
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
*/
    

    
}
