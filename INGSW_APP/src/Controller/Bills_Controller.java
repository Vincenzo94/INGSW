/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Contract;
import View.Bills;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author ansan
 */
public class Bills_Controller implements Controller {
    private final Contract contract;
    private final Registry_Controller reg;
    private Database_Controller dbManager;
    Bills view;
    public Bills_Controller(Registry_Controller reg, Contract contract) {
        this.contract = contract;
        this.reg = reg;
        view = new Bills();
        view.setVisible(true);
        view.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
                Bills_Controller bc = (Bills_Controller)controller;
                bc.buttonCliked(e);            
            }
        });
        view.addMouseListener(new Listener(this){
            @Override
            public void mouseClicked(MouseEvent e){
                Bills_Controller bc = (Bills_Controller)controller;
                bc.tableCliked(e);   
            }
        });
    }

    private void buttonCliked(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void tableCliked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
