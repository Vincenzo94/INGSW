/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Contract_MYSQL;
import DAO.DAO_Contract;
import Model.Contract;
import View.Delete;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 *
 * @author ansan
 */
public class RemoveContract_Controller implements Controller {
    private final Contract contract;
    private final Registry_Controller controller;
    private Database_Controller dbManager;
    private Delete view;
    public RemoveContract_Controller(Registry_Controller main, Contract contract) {
        this.contract = contract;
        this.controller = main;
        view = new Delete(contract);
        view.setVisible(true);
        view.addActionListener(new Listener(this){
           @Override
           public void actionPerformed(ActionEvent e){
               RemoveContract_Controller rc = (RemoveContract_Controller)controller;
               rc.buttonClicked(e);
           }
        });
    }

    private void buttonClicked(ActionEvent e) {
        Component c = (Component)e.getSource();
        Integer button = view.checkButton(c);
        if(button == 2){
            try {
                dbManager = Database_Controller.getDbManager();
            } catch (SQLException ex) {
            }
            DAO_Contract daoContract = new Contract_MYSQL(dbManager); 
            daoContract.remove(contract);
            view.dispose();
            Log_Controller.writeLog(" removed the contract "+contract.getId(),RemoveContract_Controller.class);
        }
        view.dispose();
        controller.back();
    }
    
}
