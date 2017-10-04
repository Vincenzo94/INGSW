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
import java.awt.Component;
import View.Popup;
import static ingsw_app.INGSW_APP.device;
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
    private Database_Controller dbManager;

    
    private Popup_Controller Popup_Control;
    private Login_Controller l;
    private Popup popup=null;
    Popup_Controller popupController ;


    Login_Controller(Main_Controller m) throws SQLException{
        main=m;
        dbManager = Database_Controller.getDbManager();
        popupController = Popup_Controller.getPopup_C();
        this.DAO = new Operator_MYSQL(dbManager);
        login = new Login();
        //device.setFullScreenWindow(login);
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
            Log_Controller.setOperator(operator);
            Log_Controller.writeLog(" logged",Login_Controller.class);
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
