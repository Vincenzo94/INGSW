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
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author ansan
 */
public class Login_Controller implements ActionListener{
    private Login login = null;
    private Operator operator;
    private DAO_Operator DAO;
    private Main_Controller main;
    private DatabaseManager dbManager;
    
    Login_Controller(Main_Controller m) throws SQLException{
        main=m;
        dbManager = DatabaseManager.getDbManager();
        this.DAO = new Operator_MYSQL(dbManager.getDbConnection());
        login = new Login();
        login.setVisible(true);
        login.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Integer user = login.getUser();
        String passw = login.getPassword();
        operator=new Operator(user,passw);
        operator = DAO.check(operator);
        if(operator!=null && !operator.getIsAdmin() && !operator.getIsDetector()){
            login.dispose();
            main.loginDone(operator);
        }
        else{
            //MOSTRARE POPUP ERRORE LOGIN
        }
    }

}
