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
        Log_Controller.setOperator(o);
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
            case 0: Popup_Controller.getPopup_C().showPopup("<html>1) To make a new search it's enough to fill one or more field and click on SEARCH button <br><br>"
                                                                   + "2) After have selected a single row from the table will be can to: <br> <br> "
                                                                    + "&#09 2.1) add a new contract through the ADD button; <br> <br> "
                                                                    + "&#09 2.2) alter the holder through ALTER HOLDER button; <br> <br> "
                                                                    + "&#09 2.3) remove the contract through REMOVE button. <br> <br> "
                                                                    + "&#09 2.4) view bills through BILLS button or injuctions through INJUCTIONS button.  </html>"); break;
            case 1: Popup_Controller.getPopup_C().showPopup("After have selected a single row from the table it will be possible to confirm or delete the injuction"); break;
            case 2: Popup_Controller.getPopup_C().showPopup("After have selected a single or multiple rows from the table it will be possible confirm or deselect them");break;
        }
    }
    
    private void logOut(){
        actual.dispose();
        Log_Controller.writeLog(" logout",Main_Controller.class);
        instance=null;
        try {
            instance = new Main_Controller();
        } catch (SQLException ex) {
        }
    }   
    
       
}
