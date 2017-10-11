/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.DAO_Document;
import DAO.Injuction_MYSQL;
import Model.Injuction;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author ansan
 */
public class RemoveInjuction_Controller implements Controller {
    private final String success= "Injuction removed";
    private final String error = "Injuction not removed";
    
    RemoveInjuction_Controller(InjuctionsQueue_Controller controller,Injuction injuction){
        int n = JOptionPane.showConfirmDialog(controller.getPanel(),"Are you sure to delete the injuction" + injuction.getId()+"?",
                "Delete Contract",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(n == 0){
            try {
                Database_Controller dbController = Database_Controller.getDbManager();
                DAO_Document daoDocument = new Injuction_MYSQL(dbController); 
                daoDocument.remove(injuction);
                Log_Controller.writeLog(" removed the injuction "+injuction.getId(),RemoveInjuction_Controller.class);
                JOptionPane.showConfirmDialog(controller.getPanel(), success,"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
                controller.back();
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(controller.getPanel(), ex.getMessage()+"\n"+error,"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }
        } 
            else
                JOptionPane.showConfirmDialog(controller.getPanel(),"Operation cancelled" ,"Info",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
    }
}
