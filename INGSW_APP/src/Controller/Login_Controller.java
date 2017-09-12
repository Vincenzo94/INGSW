/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interface.Observer;
import View.Login;

/**
 *
 * @author ansan
 */
public class Login_Controller implements Observer{
    Login login = null;
    Login_Controller(){
        login = new Login();  
    }
    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
