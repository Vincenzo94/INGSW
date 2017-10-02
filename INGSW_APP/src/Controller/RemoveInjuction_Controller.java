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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ansan
 */
public class RemoveInjuction_Controller implements Controller {
    Database_Controller dbController;
    InjuctionsQueue_Controller controller;
    Delete view;
    Injuction injuction;
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
            } catch (SQLException ex) {
                Logger.getLogger(RemoveContract_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            DAO_Document daoDocument = new Injuction_MYSQL(dbController); 
            daoDocument.remove(injuction);
            view.dispose();
        }
        view.dispose();
        controller.back();
    }
}
