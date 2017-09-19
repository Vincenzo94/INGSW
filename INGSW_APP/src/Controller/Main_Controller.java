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
import ingsw_app.INGSW_APP;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrea
 */

//Classe implementata come singleton
public class Main_Controller implements ActionListener, MouseListener{
    Controller current;
    private Operator operator;
    private Component actualView;
    private static Main_Controller instance;
    private DatabaseManager dbManager;
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
        actual.addMouseListener(this);
        actual.addActionListener(this);
        initBillsQueue();
        initInjuctionsQueue();
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
    
    public void mouseClicked(MouseEvent e) {
        switch(actual.checkTab(e.getComponent())){
            case 1:{
                contracts = ((Search_Controller)current).getContracts();
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
                Bill bill = bills.get(actual.getSelectedBill());
                actual.activeBillConfirm();
                actual.activeBillReportError();
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
    public void actionPerformed(ActionEvent e) {
        System.out.println("Premuto search");
        current = new Search_Controller(instance,actual);
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
