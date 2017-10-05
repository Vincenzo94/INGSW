/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Contract_MYSQL;
import DAO.DAO_Contract;
import DAO.DAO_Document;
import DAO.Injuction_MYSQL;
import Model.Bill;
import Model.Contract;
import Model.EMailSender;
import Model.Injuction;
import Model.PDFMaker;
import View.BuildPDF;
import View.SendPDF;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ansan
 */
public class ConfirmInjuction_Controller implements Controller{

    private InjuctionsQueue_Controller injuctionsQueueController;
    private final Injuction injuction;
    private Database_Controller dbController;
    private final Bill bill;
    private Contract contract;
    private final BuildPDF view;
    private SendPDF sendPDFview;
    private InjuctionsHistory_Controller injuctionsController;

    public ConfirmInjuction_Controller(Injuction i, InjuctionsQueue_Controller main){
        injuction=i;
        view= new BuildPDF(injuction);
        this.injuctionsQueueController = main;
        view.setVisible(true);
        bill = injuction.getBill();
        try {
            dbController = Database_Controller.getDbManager();
            DAO_Contract daoContract = new Contract_MYSQL(dbController);
            contract = daoContract.getContract(bill.getContractID());
            PDFMaker.createPDF(contract, bill, injuction);        
            view.addActionListener(new Listener(this){
                @Override
                public void actionPerformed(ActionEvent e) {
                    ConfirmInjuction_Controller c = (ConfirmInjuction_Controller)controller;
                    c.buttonCliked(e);            
                }
            });
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(view, ex.getMessage(),"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ConfirmInjuction_Controller(Injuction i,InjuctionsHistory_Controller main){
        injuction=i;
        this.injuctionsController = main;
        view= new BuildPDF(injuction);
        view.setVisible(true);
        bill = injuction.getBill();
        try {
                dbController = Database_Controller.getDbManager();
            DAO_Contract daoContract = new Contract_MYSQL(dbController);
                contract = daoContract.getContract(bill.getContractID());
            PDFMaker.createPDF(contract, bill, injuction);
            view.addActionListener(new Listener(this){
                @Override
                public void actionPerformed(ActionEvent e) {
                    ConfirmInjuction_Controller c = (ConfirmInjuction_Controller)controller;
                    c.buttonCliked(e);            
                }
            });
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(view, ex.getMessage(),"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buttonCliked(ActionEvent e) {
        Component j = (Component)e.getSource();
        Integer i = view.checkButton(j);
        switch(i){
            case 1:{
                    view.dispose();
                if(injuctionsQueueController!=null)
                    injuctionsQueueController.back(); 
                else
                    injuctionsController.back();
                break;
            } 
            case 3: sendClicked(); break;
        }    
    }

    private void sendClicked() {
        DAO_Document daoDocument = new Injuction_MYSQL(dbController);
        String result;
        result = EMailSender.sendEmail(contract, Injuction.class);
        view.dispose();
        sendPDFview = new SendPDF(result);
        sendPDFview.setVisible(true);
        sendPDFview.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
            ConfirmInjuction_Controller c = (ConfirmInjuction_Controller)controller;
            c.okClicked();
            }
        });        
        try {
            injuction.setState("Issued");
            daoDocument.setState(injuction);
            Log_Controller.writeLog(" send the injuction "+injuction.getId()+" to "+contract.getName()+" "+contract.getSurname()+" with ID "+contract.getId()+" at the address: "+contract.getEmailAddress(),ConfirmInjuction_Controller.class);
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(sendPDFview, ex.getMessage(),"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
    }

    private void okClicked() {
        sendPDFview.dispose();
        view.dispose();
        if(injuctionsQueueController!=null)
            injuctionsQueueController.back(); 
        else
            injuctionsController.back();
    }
    
}
