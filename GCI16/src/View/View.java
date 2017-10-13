/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author ansan
 */
public abstract class View extends JFrame{
    public void setSize(){
        Toolkit tk = Toolkit.getDefaultToolkit();  
        Dimension screenSize = tk.getScreenSize();
        int xSize = ((int) screenSize.getWidth());  
        int ySize = ((int) screenSize.getHeight());  
        this.setSize(xSize,ySize);
    }
}
