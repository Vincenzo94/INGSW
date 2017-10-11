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
    private final String helpMessage = "To log in you have to insert \nyour ID and Password and \nthen click on \"Login\" button";


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
                        Login_Controller l = (Login_Controller) controller;
                        l.buttonCliked((Component)e.getSource());
                }
            });
            } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(login, ex.getMessage(),"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void doLogin(Integer user, String passw){
        try {
            if(user==null)
                throw new SQLException("Invalid characthers for user's form");
            operator=new Operator(user,passw);
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
    
    public void buttonCliked(Component j){
            int i=login.checkButton(j);
            switch(i){
                case 1: doLogin(login.getUser(),login.getPassword()); break;
                case 2: helpCliked(); break;
            }
                }
    
    public void helpCliked(){
        JOptionPane.showConfirmDialog(login,helpMessage ,"Info",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
    }
}
