/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Contract;
import View.AlterHolder;

/**
 *
 * @author Andrea
 */
public class AlterContract_Controller implements Controller{
    private final Contract contract;
    private final Main_Controller main;
    AlterHolder view;
    
    public AlterContract_Controller(Main_Controller main, Contract contract) {
        this.main=main;
        this.contract=contract;
        view=new AlterHolder();
        view.setVisible(true);
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
    
    
    
}
