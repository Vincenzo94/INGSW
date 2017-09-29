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
import java.sql.Date;

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
        view.setPersonName(contract.getName());
        view.setSurname(contract.getSurname());
        view.setTaxC(contract.getTaxCode());
        view.setEmail(contract.getEmailAddress());
        view.setTelephone(contract.getTelephone());
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
            case 0: view.dispose(); break;
            case 1:{
                contract.setName(view.getPersonName());
                contract.setSurname(view.getSurname());
                contract.setTaxCode(view.getTaxC());
                String phone = view.getTelephone();
                Integer i = phone.indexOf("-");
                contract.setPhone(phone.substring(0, i-2));
                contract.setMobile(phone.substring(i+2));
                contract.seteMail(view.getEmail());
                daoContract.update(contract);
            } break;
            case 2:  break;
            case 3: break;
        }
    }
    
    
    
}
