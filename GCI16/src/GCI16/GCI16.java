/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCI16;

import Controller.Main_Controller;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ansan
 */
public class GCI16 {
    public static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Main_Controller main;
            try {
                main = Main_Controller.getMain();
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(null, ex.getMessage(),"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }
        });
    }
 
}
