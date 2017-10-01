/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Contract_MYSQL;
import DAO.DAO_Contract;
import Model.Contract;
import View.DeleteContract;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ansan
 */
public class RemoveContract_Controller implements Controller {
    private final Contract contract;
    private final Main_Controller main;
    private Database_Controller dbManager;
    private DeleteContract view;
    public RemoveContract_Controller(Main_Controller main, Contract contract) {
        this.contract = contract;
        this.main = main;
        view = new DeleteContract();
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
                Logger.getLogger(RemoveContract_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            DAO_Contract daoContract = new Contract_MYSQL(dbManager); 
            daoContract.remove(contract);
            view.dispose();
        }
        view.dispose();
        main.back();
    }
    
}
