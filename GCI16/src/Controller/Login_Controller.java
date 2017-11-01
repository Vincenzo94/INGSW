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
    private final Main_Controller main;
    private Database_Controller dbController;
    private final String helpMessage = "To log in you have to insert \nyour ID and Password and \nthen click on \"Login\" button";

    Login_Controller(Main_Controller m){
        main=m;
        login = new Login();
        login.setSize();
        login.setVisible(true);      
        login.addListener(new Listener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    buttonCliked((Component)e.getSource());
            }
        });
    }
    
    private void doLogin(){
        String user = login.getUser();
        String passw = login.getPassword();
        Boolean result = check(user,passw);
        if(result==null)
            JOptionPane.showConfirmDialog(login, "Problems with DataBase!","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        else{
            if(result==false)
                JOptionPane.showConfirmDialog(login, "Invalid ID and/or Password!","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            else{
                Log_Controller.setOperator(operator);
                ErrorModel.setOperatorID(operator.getId());
                Log_Controller.writeLog(" logged",Login_Controller.class);
                login.dispose();
                main.loginDone(operator);
            }
        }
    }
    
    Boolean check(String user, String passw){
        DAO_Operator DAO;
        try {
            dbController = Database_Controller.getDBController();
            if(user==null || !user.matches("[0-9]*"))
                return false;
            operator=new Operator(Integer.valueOf(user),passw);
            DAO = new Operator_MYSQL(dbController);
            operator = DAO.check(operator);
            return operator!=null && !operator.getIsAdmin() && !operator.getIsDetector();
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private void buttonCliked(Component j){
            int i=login.checkButton(j);
            switch(i){
                case 1: doLogin(); break;
                case 2: helpCliked(); break;
            }
                }
    
    private void helpCliked(){
        JOptionPane.showConfirmDialog(login,helpMessage ,"Info",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
    }
}
