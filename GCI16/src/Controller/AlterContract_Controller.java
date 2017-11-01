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
    private Database_Controller dbController;
    
    AlterContract_Controller(Registry_Controller main, Contract contract) {
        this.controller=main;
        this.contract=contract;
        view=new AlterHolder();
        view.setSize();
        view.setVisible(true);
        view.addActionListener(new Listener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCliked((Component)e.getSource());            
            }
        });
        init();
    }

    private void init() {
        try {
            dbController = Database_Controller.getDBController();
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
        daoContract = new Contract_MYSQL(dbController);
        try{
            switch(button){
                case 0: {
                    view.dispose();
                    controller.back();
                    break; 
                }                         
                case 1:{
                    updateRegistryClicked();
                    JOptionPane.showConfirmDialog(view, success,"Info",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                    break;
                } 
                case 2:{
                    updateBillingAddressClicked();
                    JOptionPane.showConfirmDialog(view, success,"Info",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                case 3:{
                    updateAddressClicked();
                    JOptionPane.showConfirmDialog(view, success,"Info",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
        }
        catch (SQLException ex) {
            JOptionPane.showConfirmDialog(view, ex.getMessage()+"\n"+error,"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void updateAddressClicked() throws SQLException{
        verifyAddress();
        contract.setCity(view.getCity2());
        contract.setDistrict(view.getDistrict2());
        contract.setStreet(view.getStreet2());
        contract.setZipCode(view.getZip2());
        contract.setNumber(Integer.valueOf(view.getNumber2()));
        daoContract.update_Address(contract,controller.getOperator());
    }
    
    private void verifyAddress() throws SQLException{
                String street = view.getStreet2();
        String city = view.getCity2();
        String district = view.getDistrict2();
        String zip = view.getZip2();
        String number = view.getNumber2();
        String errorMsg = null;
        if(!city.matches("[[a-z]|[A-Z]]*"))
            errorMsg = "Invalid characters in Billing City";
        else if(!district.matches("[[a-z]|[A-Z]]*"))
            errorMsg = "Invalid characters in Billing District";
        else if(!street.matches("[[a-z]|[A-Z]| ]*"))
            errorMsg = "Invalid characters in Billing Street";
        else if(!zip.matches("[0-9]*"))
            errorMsg = "Invalid characters in Billing Zip Code";
        else if(!number.matches("[0-9]*"))
            errorMsg = "Invalid characters in Billing Number";
        if(errorMsg!=null)
            throw new SQLException(errorMsg);
    }
    
    private void updateBillingAddressClicked() throws SQLException{
        String street = view.getStreet1();
        String city = view.getCity1();
        String district = view.getDistrict1();
        String zip = view.getZip1();
        String number = view.getNumber1();
        if(!street.equals("")&&!district.equals("")&&!city.equals("")&&!zip.equals("")){
            verifyBilling(street,district,city,zip,number);
            if(contract.getBillingAddress() != null){
                contract.setBillingCity(city);
                contract.setBillingDistrict(district);
                contract.setBillingStreet(street);
                contract.setBillingZipCode(zip);
                contract.setBillingNumber(Integer.valueOf(number));
                daoContract.update_BillingAddress(contract,controller.getOperator());
            }
            else{
                contract.addBillingAddress(view.getCity1(),view.getDistrict1(),view.getStreet1(),view.getZip1(),Integer.valueOf(number));
                daoContract.addBillingAddress(contract);
            }
        }
        else if(contract.getBillingAddress() != null)
            contract.setBillingAddress(null);
        daoContract.setBillingAddress(contract);
        daoContract.update_UpdatedBy(contract, controller.getOperator());
    }
    
    private void verifyBilling (String street, String district, String city, String zip, String number) throws SQLException{
        String errorMsg=null;
            if(!city.matches("[[a-z]|[A-Z]]*"))
                errorMsg = "Invalid characters in Billing City";
            else if(!district.matches("[[a-z]|[A-Z]]*"))
                errorMsg = "Invalid characters in Billing District";
            else if(!street.matches("[[a-z]|[A-Z]| ]*"))
                errorMsg = "Invalid characters in Billing Street";
            else if(!zip.matches("[0-9]*"))
                errorMsg = "Invalid characters in Billing Zip Code";
            else if(!number.matches("[0-9]*"))
                errorMsg = "Invalid characters in Billing Number";
            if(errorMsg!=null)
                throw new SQLException(errorMsg);
    }
    
    private void updateRegistryClicked() throws SQLException{
        verifyRegistry();
        contract.setName(view.getPersonName());
        contract.setSurname(view.getSurname());
        contract.setTaxCode(view.getTaxC());
        contract.setPhone(view.getPhone());
        contract.setMobile(view.getMobile());
        contract.seteMail(view.getEmail());
        daoContract.update_Registry(contract,controller.getOperator());
    }
    
    private void verifyRegistry() throws SQLException{
        String name=view.getPersonName(),
               surname=view.getSurname(),
               taxc=view.getTaxC(),
               phone=view.getPhone(),
               email=view.getEmail(),
               mobile = view.getMobile(),
               errorMsg = null;
        if(!name.matches("[[a-z]|[A-Z]]*"))
            errorMsg = "Invalid characters in Name";
        else if(!surname.matches("[[a-z]|[A-Z]]*"))
            errorMsg = "Invalid characters in Surname";
        else if(!taxc.matches("[[a-z]|[0-9]]*"))
            errorMsg = "Invalid characters in Tax Code";
        else if(!phone.matches("[0-9]*"))
            errorMsg = "Invalid characters in Telephone";
        else if(!mobile.matches("[0-9]*"))
            errorMsg = "Invalid characters in Mobile";
        else if(!email.matches("[[0-9]|[a-z]|[A-Z]|[_|\\-|.|@]]*"))
            errorMsg = "Invalid characters in eMail";
        if(errorMsg!=null)
            throw new SQLException(errorMsg);
    }
    
}
