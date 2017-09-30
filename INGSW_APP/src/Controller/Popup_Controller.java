/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Popup;
import java.awt.event.ActionEvent;
/**
 *
 * @author vincenzo94
 */
public class Popup_Controller implements Controller {
    
    public Popup view;
    private Popup_Controller p;
    private static Popup_Controller instance;
    
    private Popup_Controller() {     
    }
    
    public static Popup_Controller getPopup_C(){
        if(instance==null){
            instance = new Popup_Controller();
        }
        return instance;
    }
    public void showPopup(String t){
        if(view==null){
            view = new Popup(t);
        }
        else{
           view.dispose();
           view = new Popup(t);
        }
        view.setResizable(false);
        view.addListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
                    view.dispose();
            }
        });        
        view.setVisible(true);
    }
    
}
    

    
