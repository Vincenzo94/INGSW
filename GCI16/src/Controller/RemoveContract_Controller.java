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
    private final String success= "Contract removed";
    private final String error = "Contract not removed";
    private final Registry_Controller registryController;
    
    RemoveContract_Controller(Registry_Controller controller) {
        registryController = controller;
    }
    
    protected Boolean removeContract(Contract contract){
        int n = JOptionPane.showConfirmDialog(registryController.getPanel(),"Are you sure to delete the contract" + contract.getId()+"?",
                "Delete Contract",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
            if(n == 0){
                try {
                    remove(contract);
                    Log_Controller.writeLog(" removed the contract "+contract.getId(),RemoveContract_Controller.class);
                    JOptionPane.showConfirmDialog(registryController.getPanel(),success ,"Info",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showConfirmDialog(registryController.getPanel(), ex.getMessage()+"\n"+error,"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } 
            else{
                JOptionPane.showConfirmDialog(registryController.getPanel(),"Operation Cancelled" ,"Info",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            registryController.back();
            return true;
    }

    private void remove(Contract contract) throws SQLException{
        Database_Controller dbManager = Database_Controller.getDbManager();
        DAO_Contract daoContract = new Contract_MYSQL(dbManager); 
        daoContract.remove(contract);
    }
}
