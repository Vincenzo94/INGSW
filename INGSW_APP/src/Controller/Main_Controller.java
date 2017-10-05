/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Operator;
import View.Home;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Andrea
 */

//Classe implementata come singleton
public class Main_Controller{
    
    private final String first = ("1) To make a new search it's enough to fill one or more field and click on SEARCH button"
                                                                   + "\n2) After have selected a single row from the table will be can to: \n "
                                                                    + "\t\t 2.1) add a new contract through the ADD button; \n "
                                                                    + "\t\t 2.2) alter the holder through ALTER HOLDER button; \n "
                                                                    + "\t\t 2.3) remove the contract through REMOVE button. \n "
                                                                    + "\t\t 2.4) view bills through BILLS button or injuctions through INJUCTIONS button. ");
    
    
    private final String second = ("After have selected a single row from the table it will be possible to confirm or delete the injuction");
    private final String third = ("After have selected a single or multiple rows from the table it will be possible confirm or deselect them");
    private Controller current;
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
            case 0: regy.updateView(); break; 
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
            case 0: JOptionPane.showConfirmDialog(actual, first,"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE); break;
            case 1: JOptionPane.showConfirmDialog(actual, second,"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE); break;
            case 2: JOptionPane.showConfirmDialog(actual, third,"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE); break;
        }
    }
    
    private void logOut(){
        actual.dispose();
        Log_Controller.writeLog(" logout",Main_Controller.class);
        instance=null;
        try {
            instance = new Main_Controller();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(actual, ex.getMessage(),"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
    }   
    
       
}
