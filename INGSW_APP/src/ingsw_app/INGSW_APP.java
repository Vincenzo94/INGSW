/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingsw_app;

import Controller.Login_Controller;
import View.Login;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ansan
 */
public class INGSW_APP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                /*Login login = new Login();
                login.setLocationRelativeTo(null);
                login.pack();
                login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                login.setVisible((true));*/
                try {
                    Database.setDefaultConnection(Database.nuovaConnessione());
                } catch (SQLException ex) {
                    Logger.getLogger(INGSW_APP.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Login_Controller();
            }
        });
    }
 
}
