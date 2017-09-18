/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Bill_MYSQL;
import DAO.Contract_MYSQL;
import DAO.DAO_Contract;
import DAO.DAO_Document;
import DAO.Injuction_MYSQL;
import Model.Bill;
import Model.Contract;
import Model.Injuction;
import Model.Operator;
import View.Home;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrea
 */

//Classe implementata come singleton
public class Main_Controller implements MouseListener{
    private Operator operator;
    private Component actualView;
    private static Main_Controller instance;
    private DatabaseManager dbManager;
    DefaultTableModel tableModelRegistryManagement = null;
    DefaultTableModel tableModelBillsQueue = null;
    DefaultTableModel tableModelInjuctionsQueue = null;
    private List<Contract> contracts = new ArrayList<>();
    private List<Bill> bills = new ArrayList<>();
    private List<Injuction> injuctions = new ArrayList<>();

    private Home actual = null; 
    
    private Main_Controller() throws SQLException{
        new Login_Controller(this);
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
        actual.setVisible(true);
        actual.addListener(this);
        initRegistryManagement();
        initBillsQueue();
        initInjuctionsQueue();
    }

    private void initRegistryManagement() {
        DAO_Contract daoContract = new Contract_MYSQL(dbManager.getDbConnection());
        tableModelRegistryManagement = actual.getTableModelRegistryManagement();
        tableModelRegistryManagement.setRowCount(0);
        String[] columns = {"Name", "Surname", "Contract ID", "Tax C./VAT"};
        tableModelRegistryManagement.setColumnIdentifiers(columns);
        contracts.clear();
        contracts = daoContract.getAllContracts();
        for(Contract temp : contracts){
            Object[] row = {temp.getName(), temp.getSurname(), temp.getId(), temp.getTaxCode()};
            tableModelRegistryManagement.addRow(row);
        }
    }

    private void initBillsQueue() {
        DAO_Document daoBill = new Bill_MYSQL(dbManager.getDbConnection());
        tableModelBillsQueue = actual.getTableModelBillsQueue();
        tableModelBillsQueue.setRowCount(0);
        String[] columns = {"Contract ID", "Reference detection", "Generated on", "Total"};
        tableModelBillsQueue.setColumnIdentifiers(columns);
        bills.clear();
        bills = daoBill.getAllDocuments(operator);
        daoBill.setManagedOperator(bills,operator);
        for(Bill temp : bills){
            Object[] row = {temp.getContractId(), temp.getDetectionDate(), temp.getGeneratedDate(), temp.getTotal()};
            tableModelBillsQueue.addRow(row);
        }
    }

    private void initInjuctionsQueue() {
        DAO_Document daoInjuction = new Injuction_MYSQL(dbManager.getDbConnection());
        tableModelInjuctionsQueue = actual.getTableModelInjuctionsQueue();
        tableModelInjuctionsQueue.setRowCount(0);
        String[] columns = {"Contract ID", "Reference bill", "Expired from", "Arrears"};
        tableModelInjuctionsQueue.setColumnIdentifiers(columns);
        injuctions.clear();
        injuctions = daoInjuction.getAllDocuments(operator);
        daoInjuction.setManagedOperator(injuctions,operator);
        for(Injuction temp : injuctions){
            Object[] row = {temp.getContractID(), temp.getBillID(), temp.getExpiredFrom(), temp.getArrears()};
            tableModelInjuctionsQueue.addRow(row);
        }
    } 

    @Override
    public void mouseClicked(MouseEvent e) {
        switch(actual.checkTab(e.getComponent())){
            case 1:{
                Contract contract = contracts.get(actual.getSelectedContract());
                actual.setBillingAddress(contract.getBillingAddress());
                actual.setAddress(contract.getAddress());
                actual.setTelephone(contract.getTelephone());
                actual.setEmail(contract.getEmailAddress());
                break;
            }
            case 3:{
                Bill bill = bills.get(actual.getSelectedBill());
                actual.setTax(bill.getTax());
                actual.setTotal(bill.getTotal());
                actual.setDetection(bill.getDetectionValue());
                actual.setDetector(bill.getDetector());
                actual.setDetectionDate(bill.getDetectionDate());
                actual.setDeadline(bill.getDeadline());
                break;
            }
        }       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
