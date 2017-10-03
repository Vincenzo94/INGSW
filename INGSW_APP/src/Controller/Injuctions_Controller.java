/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Contract;
import Model.Injuction;
import View.Injuctions;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 *
 * @author ansan
 */
public class Injuctions_Controller implements Controller {
    private final Contract contract;
    private final Registry_Controller reg;
    private Database_Controller dbManager;
    private Injuctions view;
    private List<Injuction> injuctions;
    
    public Injuctions_Controller(Registry_Controller reg, Contract contract) {
        this.contract=contract;
        this.reg=reg;
        view=new Injuctions();
        view.setVisible(true);
        view.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
                Injuctions_Controller bc = (Injuctions_Controller)controller;
                bc.buttonCliked((Component)e.getSource());            
            }
        });
        
        view.addMouseListener(new Listener(this){
            @Override
            public void mouseClicked(MouseEvent e){
                Injuctions_Controller bc = (Injuctions_Controller)controller;
                bc.tableClicked();
            }
        });
    }

    private void buttonCliked(Component component) {
        int i = view.checkButton(component);
        switch(i){
            case 1: buildClicked();break;
            case 2: view.dispose(); break;
        }
    }

    private void tableClicked() {
        view.enableBuildPDFButton(true);
    }

    private void buildClicked() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
