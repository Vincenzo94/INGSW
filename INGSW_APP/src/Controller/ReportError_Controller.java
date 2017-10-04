/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Bill;
import View.ReportError;
import java.awt.Component;
import java.awt.event.ActionEvent;

/**
 *
 * @author Andrea
 */
public class ReportError_Controller implements Controller{
    
    private final ReportError view;
    private final Bill bill;

    public ReportError_Controller(Bill bill) {
        this.bill=bill;
        view=new ReportError();
        view.setVisible(true);
        view.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e){
                ReportError_Controller co = (ReportError_Controller)controller;
                co.buttonClicked((Component)e.getSource());
            }
        });
    }

    private void buttonClicked(Component component) {
        int i=view.checkButton(component);
        switch(i){
            case 1: sendClicked();break;
            case 2: cancelClicked();break;
        }
    }

    private void sendClicked() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cancelClicked() {
        view.dispose();
    }
    
    
    
}
