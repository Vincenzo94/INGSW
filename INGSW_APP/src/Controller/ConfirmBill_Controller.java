/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Bill;
import View.BuildPDF;
import View.BuildPDFMultiple;
import java.util.LinkedList;

/**
 *
 * @author Andrea
 */
public class ConfirmBill_Controller implements Controller{
    private final LinkedList<Bill> bills;
    private final Bill bill;
    private final BuildPDF view;
    private final BuildPDFMultiple views;
    
    public ConfirmBill_Controller(LinkedList<Bill> l){
        bills=l;
        views=new BuildPDFMultiple();
        view=null;
        bill=null;
        views.setVisible(true);
    }
    
    public ConfirmBill_Controller(Bill b){
        bill=b;
        bills=null;
        view= new BuildPDF("Prova");
        views=null;
        view.setVisible(true);
    }
}
