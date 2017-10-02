/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Contract_MYSQL;
import DAO.DAO_Contract;
import Model.Bill;
import Model.Contract;
import Model.PDFMaker;
import View.BuildPDF;
import View.BuildPDFMultiple;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrea
 */
public class ConfirmBill_Controller implements Controller{
    private final LinkedList<Bill> bills;
    private final Bill bill;
    private final Main_Controller main;
    private final BuildPDF view;
    private final BuildPDFMultiple views;

    
    public ConfirmBill_Controller(LinkedList<Bill> l,Main_Controller main){
        bills=l;
        views=new BuildPDFMultiple();
        view=null;
        bill=null;
        this.main = main;
        views.setVisible(true);
        views.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfirmBill_Controller c = (ConfirmBill_Controller)controller;
                c.buttonCliked(e);            
            }
        });
    }
    
    public ConfirmBill_Controller(Bill b,Main_Controller main){
        bill=b;
        bills=null;
        this.main = main;
        PDFMaker pdfMaker = new PDFMaker();
        Database_Controller dbController = null;
        try {
            dbController = Database_Controller.getDbManager();
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmBill_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        DAO_Contract daoContract = new Contract_MYSQL(dbController);
        Contract contract = daoContract.getContract(b.getContractID());
        pdfMaker.createPDF(contract, b,null);
        view= new BuildPDF(b);
        views=null;
        view.setVisible(true);
        
    }

    private void buttonCliked(ActionEvent e) {
        Component j = (Component)e.getSource();
        Integer i = views.checkButton(j);
        switch(i){
            case 1: view.dispose(); main.back(); break;
            case 2: previewPressed(); break;
            case 3: sendCliecked(); break;
        }
    }

    private void sendCliecked() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void previewPressed() {
        
    }
}
