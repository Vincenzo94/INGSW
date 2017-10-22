/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.Contract_MYSQL;
import DAO.DAO_Contract;
import Model.Contract;
import View.AddHolder;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Andrea
 */
public class AddContract_Controller implements Controller{
    private final AddHolder view;
    private final Registry_Controller controller;
    private Contract contract;
    private final String success = "New contract added";
    private final String error = "No contract added";
    

    AddContract_Controller(Registry_Controller controller){
        this.controller=controller;
        view= new AddHolder();
        view.setSize();
        view.setVisible(true);
        view.addActionListener(new Listener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonClicked((Component)e.getSource());
            }
        });
    }

    private void buttonClicked(Component j){
        int i=view.checkButton(j);
        if(i==1){
            view.dispose();
            controller.back();
        }
        else{
            createClicked();
        }
    }
    
    private void createClicked(){
        Database_Controller dbManager;
        try {
            dbManager = Database_Controller.getDbManager();        
            DAO_Contract daoContract = new Contract_MYSQL(dbManager);
            String billingCity = view.getCity1(),
                   billingDistrict = view.getDistrict1(),
                   billingZip = view.getZip1(),
                   billingStreet = view.getStreet1(),
                   billingNumber=view.getNumber1(),
                   name=view.getPersonName(),
                   surname=view.getSurname(),
                   taxc=view.getTaxC(),
                   phone=view.getPhone(),
                   email=view.getEmail(),
                   mobile=view.getMobile(),
                   city=view.getCity2(),
                   district=view.getDistrict2(),
                   zip=view.getZip2(),
                   street=view.getStreet2(),
                   number=view.getNumber2(),
                   errorMsg = null;
            if(!name.matches("[[a-z]|[A-Z]]*"))
                errorMsg = "Invalid characters in Name";
            else if(!surname.matches("[[a-z]|[A-Z]]*"))
                errorMsg = "Invalid characters in Surname";
            else if(!taxc.matches("[[a-z]|[0-9]]*"))
                errorMsg = "Invalid characters in Tax Code";
            else if(!city.matches("[[a-z]|[A-Z]]*"))
                errorMsg = "Invalid characters in City";
            else if(!district.matches("[[a-z]|[A-Z]]*"))
                errorMsg = "Invalid characters in District";
            else if(!street.matches("[[a-z]|[A-Z]| ]*"))
                errorMsg = "Invalid characters in Street";
            else if(!phone.matches("[0-9]*"))
                errorMsg = "Invalid characters in Telephone";
            else if(!mobile.matches("[0-9]*"))
                errorMsg = "Invalid characters in Mobile";
            else if(!zip.matches("[0-9]*"))
                errorMsg = "Invalid characters in Zip Code";
            else if(!number.matches("[0-9]*"))
                errorMsg = "Invalid characters in Number";
            else if(!billingCity.matches("[[a-z]|[A-Z]]*"))
                errorMsg = "Invalid characters in Billing City";
            else if(!billingDistrict.matches("[[a-z]|[A-Z]]*"))
                errorMsg = "Invalid characters in Billing District";
            else if(!billingStreet.matches("[[a-z]|[A-Z]| ]*"))
                errorMsg = "Invalid characters in Billing Street";
            else if(!billingNumber.matches("[0-9]*"))
                errorMsg = "Invalid characters in Billing Billing Number";
            else if(!billingZip.matches("[0-9]*"))
                errorMsg = "Invalid characters in Billing Zip Code";
            else if(!email.matches("[[0-9]|[a-z]|[A-Z]|[_|\\-|.|@]]*"))
                errorMsg = "Invalid characters in eMail";
            if(errorMsg!=null)
                throw new SQLException(errorMsg);
            if(billingCity.equals("") && billingDistrict.equals("") && billingZip.equals("") && billingStreet.equals(""))
                contract = new Contract(name,surname,taxc,phone,email,mobile,city,district,zip,street,Integer.valueOf(number));
            else
                contract = new Contract(name,surname,taxc,phone,email,mobile,city,district,zip,street,Integer.valueOf(number), billingCity, billingDistrict, billingZip, billingStreet, Integer.valueOf(billingNumber));
            daoContract.create(contract,controller.getOperator());
            Log_Controller.writeLog(" creates a new contract with the Tax Code "+contract.getTaxCode(),AddContract_Controller.class);
            JOptionPane.showConfirmDialog(view, success,"Info",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            view.dispose();
            controller.back();
        }catch (SQLException ex) {
            JOptionPane.showConfirmDialog(view, ex.getMessage()+"\n"+error,"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
    }
}
