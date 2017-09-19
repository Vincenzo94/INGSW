/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Contract;
import View.AlterHolder;
import java.awt.Component;

/**
 *
 * @author Andrea
 */
public class AlterContract_Controller implements Controller{
    private final Contract contract;
    private final Main_Controller main;
    Component view;
    
    public AlterContract_Controller(Main_Controller main, Contract contract) {
        this.main=main;
        this.contract=contract;
        view=new AlterHolder();
        view.setVisible(true);
    }
    
    
    
}
