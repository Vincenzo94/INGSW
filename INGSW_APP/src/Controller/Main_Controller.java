/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Operator;

/**
 *
 * @author Andrea
 */
public class MainController {
    Operator operator;
    
    public void loginDone(Operator o){
        operator=o;
    }
}
