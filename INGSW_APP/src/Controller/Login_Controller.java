/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Operator;
import DAO.Operator_MYSQL;
import Model.ErrorModel;
import Model.Operator;
import View.Login;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Component;
import javax.swing.JOptionPane;
/**
 *
 * @author ansan
 */
public class Login_Controller implements Controller{
    private Login login = null;
    private Operator operator;
    private DAO_Operator DAO;
    private Main_Controller main;
    private Database_Controller dbManager;

    
    private Login_Controller l;


    Login_Controller(Main_Controller m){
        main=m;
        login = new Login();
        login.setVisible(true);
        
        try {
                dbManager = Database_Controller.getDbManager();
                this.DAO = new Operator_MYSQL(dbManager);
            login.addListener(new Listener(this){
                @Override
                public void actionPerformed(ActionEvent e) {
                        l = (Login_Controller) controller;
                        l.buttonCliked(e);
                }
            });
            } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(login, ex.getMessage(),"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void doLogin(){
        Integer user = login.getUser();
        String passw = login.getPassword();
        operator=new Operator(user,passw);
        try {
                operator = DAO.check(operator);
            if(operator!=null && !operator.getIsAdmin() && !operator.getIsDetector()){
                Log_Controller.setOperator(operator);
                ErrorModel.setOperatorID(operator.getId());
                Log_Controller.writeLog(" logged",Login_Controller.class);
                login.dispose();
                main.loginDone(operator);
            }
            else{
                JOptionPane.showConfirmDialog(login, "Invalid ID and/or Password!","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            } 
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(login, ex.getMessage(),"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
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
        JOptionPane.showConfirmDialog(login,"To log in you have to insert \nyour ID and Password and \nthen click on \"Login\" button" ,"Info",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
    }
}
