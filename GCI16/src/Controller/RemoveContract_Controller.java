/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Contract_MYSQL;
import DAO.DAO_Contract;
import Model.Contract;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ansan
 */
public class RemoveContract_Controller implements Controller {
    private final Registry_Controller controller;
    private Database_Controller dbManager;
    private final String success= "Contract removed";
    private final String error = "Contract not removed";
    
    public RemoveContract_Controller(Registry_Controller main, Contract contract) {
        this.controller = main;
        int n = JOptionPane.showConfirmDialog(main.getPanel(),"Are you sure to delete the contract" + contract.getId()+"?",
                "Delete Contract",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        try {
            if(n == 0){
            
                dbManager = Database_Controller.getDbManager();
                DAO_Contract daoContract = new Contract_MYSQL(dbManager); 
                daoContract.remove(contract);            
                Log_Controller.writeLog(" removed the contract "+contract.getId(),RemoveContract_Controller.class);
                JOptionPane.showConfirmDialog(main.getPanel(),success ,"Info",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            } 
            else
                JOptionPane.showConfirmDialog(main.getPanel(),"Operation Cancelled" ,"Info",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            controller.back();
        } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(main.getPanel(), ex.getMessage()+"\n"+error,"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }
    }    
}
