/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingsw_app;

import Controller.Main_Controller;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ansan
 */
public class INGSW_APP {
    public static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main_Controller main;
                try {
                    main = Main_Controller.getMain();
                } catch (SQLException ex) {
                    Logger.getLogger(INGSW_APP.class.getName()).log(Level.SEVERE, null, ex);
                }
               // new Login_Controller();
            }
        });
    }
 
}
