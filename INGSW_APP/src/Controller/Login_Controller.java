/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Operator;
import DAO.Operator_MYSQL;
import Model.Operator;
import View.Login;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.awt.Component;
import View.Popup;
/**
 *
 * @author ansan
 */
public class Login_Controller implements Controller{
    Controller current;
    private Login login = null;
    private Operator operator;
    private DAO_Operator DAO;
    private Main_Controller main;
    private DatabaseManager dbManager;

    
    private Popup_Controller Popup_Control;
    private Login_Controller l;
    private Popup popup=null;
    Popup_Controller popupController ;


    static Logger log = Logger.getLogger(Login_Controller.class.getName());
    Login_Controller(Main_Controller m) throws SQLException{
        main=m;
        dbManager = DatabaseManager.getDbManager();
        popupController = Popup_Controller.getPopup_C();
        this.DAO = new Operator_MYSQL(dbManager.getDbConnection());
        login = new Login();
        //INGSW_APP.device.setFullScreenWindow(login);
        login.pack();
        login.setVisible(true);
        login.addListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
                    l = (Login_Controller) controller;
                    l.buttonCliked(e);
            }
        });
    }
    
    
    public void doLogin(){
               Integer user = login.getUser();
                String passw = login.getPassword();
                operator=new Operator(user,passw);
                operator = DAO.check(operator);
                if(operator!=null && !operator.getIsAdmin() && !operator.getIsDetector()){
                    PropertyConfigurator.configure("src/ingsw_app/log4j.properties");
                    log.info("Logged user: "+ user);
                    login.dispose();
                    main.loginDone(operator);
                    }
                else{
                    popupController.showPopup("Invalid ID and/or Password!");
                } 
    }
    
    public void buttonCliked(ActionEvent e){
            Component j = (Component)e.getSource();
            int i=login.checkButton(j);
            switch(i){
                case 1: loginClicked(); break;
                case 2: helpCliked(); break;
            }
                }

    
    public void loginClicked(){
        l.doLogin();
        
    }
    
    public void helpCliked(){
        popupController.showPopup("To log in you have to insert your ID and Password and then click on \"Login\" button");
    }
}
