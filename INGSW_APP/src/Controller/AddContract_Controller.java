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
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Andrea
 */
public class AddContract_Controller implements Controller{
    private AddHolder view;
    private final Registry_Controller controller;
    private Contract contract;

public AddContract_Controller(Registry_Controller controller){
        this.controller=controller;
        view= new AddHolder();
        view.setVisible(true);
        view.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
                AddContract_Controller m = (AddContract_Controller)controller;
                m.buttonClicked(e);
            }
        });
    }

    private void buttonClicked(ActionEvent e){
        Component j = (Component)e.getSource();
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
        Database_Controller dbManager = null;
        
        try {
            dbManager = Database_Controller.getDbManager();
        } catch (SQLException ex) {
            Logger.getLogger(AddContract_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DAO_Contract daoContract = new Contract_MYSQL(dbManager);
        String billingCity = view.getCity1();
        String billingDistrict = view.getDistrict1();
        String billingZip = view.getZip1();
        String billingStreet = view.getStreet1();
        
        if(billingCity.equals("") && billingDistrict.equals("") && billingZip.equals("") && billingStreet.equals(""))
            contract = new Contract(view.getPersonName(), view.getSurname(), view.getTaxC(), view.getPhone(), view.getEmail(), view.getMobile(), view.getCity2(), view.getDistrict2(), view.getZip2(), view.getStreet2(), view.getNumber2());
        else
            contract = new Contract(view.getPersonName(), view.getSurname(), view.getTaxC(), view.getPhone(), view.getEmail(), view.getMobile(), view.getCity2(), view.getDistrict2(), view.getZip2(), view.getStreet2(), view.getNumber2(), billingCity, billingDistrict, billingZip, billingStreet, view.getNumber1());
        daoContract.create(contract,controller.getOperator());
    }
}
