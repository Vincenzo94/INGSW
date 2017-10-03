/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Contract;
import Model.Operator;
import View.RegistryPanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Andrea
 */
public class Registry_Controller implements Controller{
    
    private final RegistryPanel actual;
    private final Operator operator;
    private final Database_Controller dbManager;
    private Controller current;
    private List<Contract> contracts = null;

    public Registry_Controller(Database_Controller dbManager, Operator operator, Component panel) {
        this.operator = operator;
        this.dbManager = dbManager;
        this.actual= (RegistryPanel)panel;
        actual.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e){
                Registry_Controller co = (Registry_Controller)controller;
                co.buttonClicked((Component)e.getSource());
            }
        });
        
        actual.addMouseListener(new Listener(this){
            @Override
            public void mouseClicked(MouseEvent e){
                Registry_Controller co = (Registry_Controller)controller;
                co.tableClicked();
            }
        });
        actual.setVisible(true);
    }
    
    JPanel getPanel(){
        return actual;
    }
    
    private void tableClicked(){
        if(!(current instanceof SearchContract_Controller))
                current = new SearchContract_Controller(actual.getTableModelRegistryManagement(),null);  
                contracts = (ArrayList)((SearchContract_Controller)current).getContracts();
                Contract contract = contracts.get(actual.getSelectedContract());
                actual.activeContractButtons();
                actual.setBillingAddress(contract.getBillingAddress());
                actual.setAddress(contract.getAddress());
                actual.setTelephone(contract.getTelephone());
                actual.setEmail(contract.getEmailAddress());
    }
    
    private void buttonClicked(Component c){
        int i = actual.checkButton(c);
        switch (i){
            case 1: searchClicked(); break;
            case 2: alterholderCliked(); break;
            case 3: addClicked(); break;
            case 4: removeContractClicked(); break;
            case 5: billsClicked(); break;
            case 6: injuctionsCliecked(); break;
        }
    }
    
    public void back(){
        actual.setEnabled(true);
        searchClicked();
    } 
    
    public Operator getOperator() {
        return operator;
    }
        
    
    private void addClicked(){
        actual.setEnabled(false);
        current= new AddContract_Controller(this);
    }
    
    void searchClicked(){
        Contract bag=null;
        String name=actual.getNameSearch();
        String surname=actual.getSurnameSearch();
        String tax=actual.getTaxSearch();
        Integer id=actual.getIdSearch();
        if(name.length()!=0 || surname.length()!=0 || tax.length()!=0 || id!=null)
            bag=new Contract(id,null,null,null,name,surname,tax,null,null,null,null,null,null,null,null,null,null,null,null,null);
        current = new SearchContract_Controller(actual.getTableModelRegistryManagement(),bag);
        contracts =((SearchContract_Controller)current).getContracts();
    }
    
    private void alterholderCliked(){
        int row = actual.getSelectedContract();
        actual.setEnabled(false);
        current = new AlterContract_Controller(this,contracts.get(row));
    }
    
    private void removeContractClicked() {
        int row = actual.getSelectedContract();
        actual.setEnabled(false);
        current = new RemoveContract_Controller(this, contracts.get(row));
    }

    private void billsClicked() {
        int row = actual.getSelectedContract();
        actual.setEnabled(false);
        current = new Bills_Controller(this, contracts.get(row));
    }

    private void injuctionsCliecked() {
        int row = actual.getSelectedContract();
        actual.setEnabled(false);
        current = new Injuctions_Controller(this, contracts.get(row));
    }
}
