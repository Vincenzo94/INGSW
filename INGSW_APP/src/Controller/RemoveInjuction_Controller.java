/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.DAO_Document;
import DAO.Injuction_MYSQL;
import Model.Injuction;
import View.Delete;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author ansan
 */
public class RemoveInjuction_Controller implements Controller {
    private Database_Controller dbController;
    private InjuctionsQueue_Controller controller;
    private Delete view;
    private Injuction injuction;
    private final String success= "Injuction removed";
    private final String error = "Injuction not removed";
    
    RemoveInjuction_Controller(InjuctionsQueue_Controller controller,Injuction injuction){
        this.controller = controller;
        this.injuction = injuction;
        view = new Delete(injuction);
        view.setVisible(true);
        view.addActionListener(new Listener(this){
           @Override
           public void actionPerformed(ActionEvent e){
               RemoveInjuction_Controller ri = (RemoveInjuction_Controller)controller;
               ri.buttonClicked(e);
           }
        });
    }

    private void buttonClicked(ActionEvent e) {
        Component c = (Component)e.getSource();
        Integer button = view.checkButton(c);
        if(button == 2){
            try {
                dbController = Database_Controller.getDbManager();
                DAO_Document daoDocument = new Injuction_MYSQL(dbController); 
                daoDocument.remove(injuction);
                Log_Controller.writeLog(" removed the injuction "+injuction.getId(),RemoveInjuction_Controller.class);
                JOptionPane.showConfirmDialog(view, success,"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
                view.dispose();
                controller.back();
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(view, ex.getMessage()+"\n"+error,"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
}
