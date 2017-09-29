/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.AddHolder;
import java.awt.Component;
import java.awt.event.ActionEvent;

/**
 *
 * @author Andrea
 */
public class AddContract_Controller implements Controller{
    private AddHolder view;
    Main_Controller main;

public AddContract_Controller(Main_Controller main){
        this.main=main;
        view= new AddHolder();
        view.setVisible(true);
        view.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
                   AddContract_Controller m = (AddContract_Controller)controller;
                   m.buttonClicked(e);
            }
        });
    }

    private void buttonClicked(ActionEvent e){
        Component j = (Component)e.getSource();
        int i=view.checkButton(j);
        if(i==1){
            main.back();
        }
        else{
            createClicked();
        }
    }
    
    private void createClicked(){
        
    }
}
