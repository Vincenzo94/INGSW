/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Contract_MYSQL;
import DAO.DAO_Contract;
import Model.Contract;
import View.AlterHolder;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrea
 */
public class AlterContract_Controller implements Controller{
    private final Contract contract;
    private final Main_Controller main;
    private DatabaseManager dbManager;
    AlterHolder view;
    
    public AlterContract_Controller(Main_Controller main, Contract contract) {
        this.main=main;
        this.contract=contract;
        view=new AlterHolder();
        view.setVisible(true);
        view.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
                AlterContract_Controller ac = (AlterContract_Controller)controller;
                ac.buttonCliked(e);            
            }
        });
        init();
    }

    private void init() {
        try {
            dbManager = DatabaseManager.getDbManager();
        } catch (SQLException ex) {
            Logger.getLogger(AlterContract_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.setPersonName(contract.getName());
        view.setSurname(contract.getSurname());
        view.setTaxC(contract.getTaxCode());
        view.setEmail(contract.getEmailAddress());
        view.setPhone(contract.getPhone());
        view.setMobile(contract.getMobile());
        if(contract.getBillingAddress() != null){
            view.setCity1(contract.getBillingCity());
            view.setDistrict1(contract.getBillingDistrict());
            view.setZip1(contract.getBillingZip());
            view.setStreet1(contract.getBillingStreet());
            view.setNumber1(contract.getBillingNumber());
        }
        view.setCity2(contract.getCity());
        view.setDistrict2(contract.getDistrict());
        view.setZip2(contract.getZip());
        view.setStreet2(contract.getStreet());
        view.setNumber2(contract.getNumber());    
    }

    private void buttonCliked(ActionEvent e) {
        Component c = (Component)e.getSource();
        Integer button = view.checkButton(c);
        DAO_Contract daoContract = new Contract_MYSQL(dbManager);
        switch(button){
            case 0: view.dispose(); main.back(); break;
            case 1:{
                contract.setName(view.getPersonName());
                contract.setSurname(view.getSurname());
                contract.setTaxCode(view.getTaxC());
                contract.setPhone(view.getPhone());
                contract.setMobile(view.getMobile());
                contract.seteMail(view.getEmail());
                daoContract.update_Registry(contract,main.getOperator());
            } break;
            case 2:{
                if(contract.getBillingAddress() != null){
                    contract.setBillingCity(view.getCity1());
                    contract.setBillingDistrict(view.getDistrict1());
                    contract.setBillingStreet(view.getStreet1());
                    contract.setBillingZipCode(view.getZip1());
                    contract.setBillingNumber(view.getNumber1());
                    daoContract.update_BillingAddress(contract,main.getOperator());
                }
                else{
                    contract.addBillingAddress(view.getCity1(),view.getDistrict1(),view.getStreet1(),view.getZip1(),view.getNumber1());
                    daoContract.addBillingAddress(contract,main.getOperator());
                }
                    
                
                break;
            }
            case 3:{
                contract.setCity(view.getCity2());
                contract.setDistrict(view.getDistrict2());
                contract.setStreet(view.getStreet2());
                contract.setZipCode(view.getZip2());
                contract.setNumber(view.getNumber2());
                daoContract.update_Address(contract,main.getOperator());
                break;
            }
        }
    }
    
    
    
}
