/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Operator;
import View.Home;
import java.awt.Component;
import java.sql.SQLException;

/**
 *
 * @author Andrea
 */

//Classe implementata come singleton
public class Main_Controller {
    private Operator operator;
    private Component actualView;
    private static Main_Controller instance;
    private DatabaseManager DbManager;
    
    private Main_Controller() throws SQLException{
        new Login_Controller(this);
        DbManager = DatabaseManager.getDbManager();
    }
    
    public static Main_Controller getMain() throws SQLException{
        if(instance==null){
            instance=new Main_Controller();
        }
        return instance;
    }
    
    public void loginDone(Operator o){
        operator=o;
        Home actual = new Home();
        actual.setVisible(true);
    }
}
