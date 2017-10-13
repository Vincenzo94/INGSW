/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Error;
import DAO.Error_MYSQL;
import Model.Bill;
import Model.ErrorModel;
import View.ReportError;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Andrea
 */
public class ReportError_Controller implements Controller{
    
    private final ReportError view;
    private final Bill bill;
    private String text;
    private Database_Controller dbController;

    ReportError_Controller(Bill bill) {
        this.bill=bill;
        view=new ReportError();
        view.setSize();
        view.setVisible(true);
        view.addActionListener(new Listener(){
            @Override
            public void actionPerformed(ActionEvent e){
                buttonClicked((Component)e.getSource());
            }
        });
        try {
            dbController = Database_Controller.getDbManager();
            init();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(view, ex.getMessage(),"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
        
    }

    private void buttonClicked(Component component) {
        int i=view.checkButton(component);
        switch(i){
            case 1: sendClicked();break;
            case 2: cancelClicked();break;
        }
    }

    private void sendClicked() {
        try {
            text = view.getTextMessage();
            DAO_Error daoError = new Error_MYSQL(dbController);
            ErrorModel error = new ErrorModel(bill, text);
            daoError.create(error);
            view.dispose();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(view, ex.getMessage(),"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelClicked() {
        view.dispose();
    }

    private void init() {
        Date detectionDate = bill.getDetectionDate();
        view.setDetectionDateValue(detectionDate.toString());
        Float detectionValue = bill.getDetectionValue();
        view.setDetectionValue(detectionValue.toString());
        Date dueDate = bill.getDeadline();
        view.setDueDateValue(dueDate.toString());
        Integer detectorID = bill.getDetector();
        view.setOperatorIDValueLabel(detectorID.toString());
        Float total = bill.getTotal();
        view.setTotalValue(total.toString());
        Float rate = bill.getTax();
        view.setRateValue(rate.toString());
    }
    
    
    
}
