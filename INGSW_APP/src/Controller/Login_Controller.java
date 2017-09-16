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
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ansan
 */
public class Login_Controller implements ActionListener{
    Login login = null;
    Operator operator;
    DAO_Operator DAO;
    MainController main;
    
    
    Login_Controller(MainController m){
        main=m;
        this.DAO = new Operator_MYSQL();
        login = new Login();
        login.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Integer user = login.getUser();
        String passw = login.getPassword();
        operator=new Operator(user,passw);
        operator = DAO.check(operator);
        if(operator!=null){
            main.loginDone(operator);
        }
        else{
            //MOSTRARE POPUP ERRORE LOGIN
        }
    }

}
