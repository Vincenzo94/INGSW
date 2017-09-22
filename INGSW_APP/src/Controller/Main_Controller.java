/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Bill_MYSQL;
import DAO.DAO_Document;
import DAO.Injuction_MYSQL;
import Model.Bill;
import Model.Contract;
import Model.Injuction;
import Model.Operator;
import View.Home;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrea
 */

//Classe implementata come singleton
public class Main_Controller{
    Controller current;
    private Operator operator;
    private static Main_Controller instance;
    private final DatabaseManager dbManager;
    DefaultTableModel tableModelBillsQueue = null;
    DefaultTableModel tableModelInjuctionsQueue = null;
    private List<Contract> contracts = null;
    private List<Bill> bills = new ArrayList<>();
    private List<Injuction> injuctions = new ArrayList<>();

    private Home actual = null; 
    
    private Main_Controller() throws SQLException{
        current = new Login_Controller(this);
        dbManager = DatabaseManager.getDbManager();
    }
    
    public static Main_Controller getMain() throws SQLException{
        if(instance==null){
            instance=new Main_Controller();
        }
        return instance;
    }
    
    public void loginDone(Operator o){
        operator=o;
        actual = new Home();
        //INGSW_APP.device.setFullScreenWindow(actual);
        actual.setVisible(true);
        actual.addMouseListener(new Listener(this){
            @Override
            public void mouseClicked(MouseEvent e){
                Main_Controller m = (Main_Controller)controller;
                m.tableClicked(e);
            }
        });
        actual.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
             Main_Controller m = (Main_Controller)controller;
             m.buttonCliked(e);            
            }
        });
        initBillsQueue();
        initInjuctionsQueue();
    }
    
    public void buttonCliked(ActionEvent e){
            Component j = (Component)e.getSource();
            int i=actual.checkButton(j);
            switch(i){
                case 1: searchClicked(); break;
                case 2: alterholderCliked(); break;
                case 3: selectAllClicked(); break;
            }
                }
    
    public void alterholderCliked(){
        int row = actual.getSelectedContract();
        actual.dispose();
        current= new AlterContract_Controller(this,contracts.get(row));
    }
    
    
    public void searchClicked(){
        current=new SearchContract_Controller(this,actual.getTableModelRegistryManagement());
        contracts=((SearchContract_Controller)current).getContracts();
    }

    public void selectAllClicked(){
        DefaultTableModel table = actual.getTableModelBillsQueue();
        for(Integer i = 0; i < table.getRowCount(); i++)
        table.setValueAt(true, i, 4);
        actual.activeMultipleSelection(true);
        actual.setSelectedBills(table.getRowCount());
    }

    private void initBillsQueue() {
        DAO_Document daoBill = new Bill_MYSQL(dbManager);
        tableModelBillsQueue = actual.getTableModelBillsQueue();
        tableModelBillsQueue.setRowCount(0);
        String[] columns = {"Contract ID", "Reference detection", "Generated on", "Total", "Selected"};
        tableModelBillsQueue.setColumnIdentifiers(columns);
        bills.clear();
        bills = daoBill.getAllDocuments(operator);
        daoBill.setManagedOperator(bills,operator);
        for(Bill temp : bills){
            Object[] row = {temp.getContractId(), temp.getDetectionDate(), temp.getGeneratedDate(), temp.getTotal(), false};
            tableModelBillsQueue.addRow(row);
        }
    }

    private void initInjuctionsQueue() {
        DAO_Document daoInjuction = new Injuction_MYSQL(dbManager);
        tableModelInjuctionsQueue = actual.getTableModelInjuctionsQueue();
        tableModelInjuctionsQueue.setRowCount(0);
        String[] columns = {"Contract ID", "Reference bill", "Expired from", "Arrears"};
        tableModelInjuctionsQueue.setColumnIdentifiers(columns);
        injuctions.clear();
        injuctions = daoInjuction.getAllDocuments(operator);
        daoInjuction.setManagedOperator(injuctions,operator);
        for(Injuction temp : injuctions){
            Object[] row = {temp.getContractID(), temp.getBillID(), temp.getExpiredFrom(), Float.valueOf(temp.getArrears().replace(',', '.'))};
            tableModelInjuctionsQueue.addRow(row);
        }
    } 
    
    public void tableClicked(MouseEvent e) {
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
                    actual.activeMultipleSelection(false);
                    Bill temp = bills.get(bill.get(0));
                    actual.setTax(temp.getTax());
                    actual.setTotal(temp.getTotal());
                    actual.setDetection(temp.getDetectionValue());
                    actual.setDetector(temp.getDetector());
                    actual.setDetectionDate(temp.getDetectionDate());
                    actual.setDeadline(temp.getDeadline());
                }
                else{
                    actual.activeMultipleSelection(true);
                    actual.setSelectedBills(bill.size());
                }
                actual.activeBillConfirm();
                actual.activeBillReportError();
                
                break;
            }
        }       
    }
}
