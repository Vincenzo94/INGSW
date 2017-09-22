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
import ingsw_app.INGSW_APP;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
<<<<<<< Updated upstream
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
=======
//import org.apache.log4j.Logger;
>>>>>>> Stashed changes
/**
 *
 * @author ansan
 */
public class Login_Controller implements Controller{
    private Login login = null;
    private Operator operator;
    private DAO_Operator DAO;
    private Main_Controller main;
    private DatabaseManager dbManager;
<<<<<<< Updated upstream
    
    static Logger log = Logger.getLogger(Login_Controller.class.getName());
=======
    //static Logger log = Logger.getLogger(Login_Controller.class.getName());
>>>>>>> Stashed changes
    Login_Controller(Main_Controller m) throws SQLException{
        main=m;
        dbManager = DatabaseManager.getDbManager();
        this.DAO = new Operator_MYSQL(dbManager.getDbConnection());
        login = new Login();
        INGSW_APP.device.setFullScreenWindow(login);
        
        //login.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        //login.pack();
        login.setVisible(true);
        login.addListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
                    Login_Controller l = (Login_Controller) controller;
                    l.doLogin();
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
<<<<<<< Updated upstream
=======
                    //log.info("Logged user: "+ user);
>>>>>>> Stashed changes
                    }
                else{
                    //MOSTRARE POPUP ERRORE LOGIN
                    } 
    }

}
