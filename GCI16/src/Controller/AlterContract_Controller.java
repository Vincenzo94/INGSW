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
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 */
public class AlterContract_Controller implements Controller{
    private final Contract contract;
    private final Registry_Controller controller;
    private final AlterHolder view;
    private final String success = "Contract altered";
    private final String error = "Contract not altered";
    private DAO_Contract daoContract;
    private Database_Controller dbManager;
    
    AlterContract_Controller(Registry_Controller main, Contract contract) {
        this.controller=main;
        this.contract=contract;
        view=new AlterHolder();
        view.setSize();
        view.setVisible(true);
        view.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
                AlterContract_Controller ac = (AlterContract_Controller)controller;
                ac.buttonCliked((Component)e.getSource());            
            }
        });
        init();
    }

    private void init() {
        try {
            dbManager = Database_Controller.getDbManager();
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
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(view, ex.getMessage(),"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buttonCliked(Component c) {
        Integer button = view.checkButton(c);
        daoContract = new Contract_MYSQL(dbManager);
        try{
            switch(button){
                case 0: {
                    view.dispose();
                    controller.back();
                    break; 
                }                         
                case 1:{
                    updateRegistryClicked();
                    break;
                } 
                case 2:{
                    updateBillingAddressClicked();
                    break;
                }
                case 3:{
                    updateAddressClicked();
                    break;
                }
            }
            JOptionPane.showConfirmDialog(view, success,"Info",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException ex) {
            JOptionPane.showConfirmDialog(view, ex.getMessage()+"\n"+error,"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
    }
    private void updateAddressClicked() throws SQLException{
        contract.setCity(view.getCity2());
        contract.setDistrict(view.getDistrict2());
        contract.setStreet(view.getStreet2());
        contract.setZipCode(view.getZip2());
        contract.setNumber(view.getNumber2());
        daoContract.update_Address(contract,controller.getOperator());
    }
    private void updateBillingAddressClicked() throws SQLException{
        String street = view.getStreet1();
            String city = view.getCity1();
            String district = view.getDistrict1();
            String zip = view.getZip1();
            if(contract.getBillingAddress() != null && !street.equals("")&&!district.equals("")&&!city.equals("")&&!zip.equals("")){
                contract.setBillingCity(city);
                contract.setBillingDistrict(district);
                contract.setBillingStreet(street);
                contract.setBillingZipCode(zip);
                contract.setBillingNumber(view.getNumber1());
                daoContract.update_BillingAddress(contract,controller.getOperator());
            }
            else if(!street.equals("")&&!district.equals("")&&!city.equals("")&&!zip.equals("")){
                contract.addBillingAddress(view.getCity1(),view.getDistrict1(),view.getStreet1(),view.getZip1(),view.getNumber1());
                daoContract.addBillingAddress(contract);

            }
            else if(contract.getBillingAddress() != null)
                contract.setBillingAddress(null);
            daoContract.setBillingAddress(contract);
            daoContract.update_UpdatedBy(contract, controller.getOperator());
    }
    private void updateRegistryClicked() throws SQLException{
        contract.setName(view.getPersonName());
        contract.setSurname(view.getSurname());
        contract.setTaxCode(view.getTaxC());
        contract.setPhone(view.getPhone());
        contract.setMobile(view.getMobile());
        contract.seteMail(view.getEmail());
        daoContract.update_Registry(contract,controller.getOperator());
    }
    
}
