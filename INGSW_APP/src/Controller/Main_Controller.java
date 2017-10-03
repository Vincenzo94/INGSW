/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Operator;
import View.Home;
import ingsw_app.INGSW_APP;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Andrea
 */

//Classe implementata come singleton
public class Main_Controller{
    Controller current;
    private Operator operator;
    private static Main_Controller instance;
    private final Database_Controller dbManager;
    
    private InjuctionsQueue_Controller inj;
    private BillsQueue_Controller bill;
    private Registry_Controller regy;
    
    private Home actual = null; 
    
    private Main_Controller() throws SQLException{

        current = new Login_Controller(this);
        dbManager = Database_Controller.getDbManager();
    }
    
    public static Main_Controller getMain() throws SQLException{
        if(instance==null){
            instance=new Main_Controller();
        }
        return instance;
    }
    
    public Operator getOperator() {
        return operator;
    }
    
    public void loginDone(Operator o){
        operator=o;
        actual = new Home();
        //INGSW_APP.device.setFullScreenWindow(actual);
        actual.setVisible(true);
        actual.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_Controller m = (Main_Controller)controller;
                m.buttonCliked(e);            
            }
        });
        actual.addChangeListener(new Listener(this){
            @Override
            public void stateChanged(ChangeEvent e){
                Main_Controller m = (Main_Controller)controller;
                m.changePane();
            }
        });
        regy=new Registry_Controller(dbManager,operator,actual.getPanel(0));
        inj=new InjuctionsQueue_Controller(dbManager,operator,actual.getPanel(1));
        bill=new BillsQueue_Controller(dbManager,operator,actual.getPanel(2));
    }
    
    private void changePane(){
        int i = actual.getSelectedPanel();
        switch(i){
            case 1: inj.updateInjuctionsQueue(); break;
            case 2: bill.updateBillsQueue(); break;
            case 0: regy.searchClicked(); break; 
        }
    }
    
    private void buttonCliked(ActionEvent e){
        Component j = (Component)e.getSource();
        int i=actual.checkButton(j);
        switch(i){
            case 1: logOut(); break;
            case 2: help(); break;
        }
    }
  
    private void help(){
        int i = actual.getSelectedPanel();
        switch (i){
            case 0: Popup_Controller.getPopup_C().showPopup("Primo pannello"); break;
            case 1: Popup_Controller.getPopup_C().showPopup("Secondo pannello"); break;
            case 2: Popup_Controller.getPopup_C().showPopup("Terzo pannello");break;
        }
    }
    
    private void logOut(){
        actual.dispose();
        instance=null;
        try {
            instance = new Main_Controller();
        } catch (SQLException ex) {
        }
    }    
       
}
