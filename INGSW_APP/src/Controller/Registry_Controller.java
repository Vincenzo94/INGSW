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
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 */
public class Registry_Controller implements Controller{
    
    private final RegistryPanel view;
    private final Operator operator;
    private final Database_Controller dbManager;
    private Controller current;
    private List<Contract> contracts = null;
    private String name;
    private String surname;
    private String tax;
    private String id_string;
    private Boolean searchedContracts = false;

    public Registry_Controller(Database_Controller dbManager, Operator operator, Component panel) {
        this.operator = operator;
        this.dbManager = dbManager;
        this.view= (RegistryPanel)panel;
        view.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e){
                Registry_Controller co = (Registry_Controller)controller;
                co.buttonClicked((Component)e.getSource());
            }
        });
        
        view.addMouseListener(new Listener(this){
            @Override
            public void mouseClicked(MouseEvent e){
                Registry_Controller co = (Registry_Controller)controller;
                co.tableClicked();
            }
        });
        view.setVisible(true);
    }

    private void tableClicked(){
        try {
            if(!(current instanceof SearchContract_Controller))
                current = new SearchContract_Controller(view.getTableModelRegistryManagement(),null);
            Integer selectedContract = view.getSelectedContract();           
            contracts = ((SearchContract_Controller)current).getContracts();
            if(selectedContract>=contracts.size() || selectedContract<0)
                throw new SQLException("Invalid selection from the table");
            Contract contract = contracts.get(selectedContract);
            view.activeContractButtons();
            view.setBillingAddress(contract.getBillingAddress());
            view.setAddress(contract.getAddress());
            view.setTelephone(contract.getTelephone());
            view.setEmail(contract.getEmailAddress());
        } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(view, ex.getMessage(),"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void buttonClicked(Component c){
        int i = view.checkButton(c);
        switch (i){
            case 1: searchClicked(); break;
            case 2: alterholderCliked(); break;
            case 3: addClicked(); break;
            case 4: removeContractClicked(); break;
            case 5: billsClicked(); break;
            case 6: injuctionsCliecked(); break;
        }
    }
    
    public Component getPanel(){
        return view;
    }
    
    public void back(){
        searchClicked();
    } 
    
    public Operator getOperator() {
        return operator;
    }
          
    private void addClicked(){
        current= new AddContract_Controller(this);
    }
    
    public void searchClicked(){
        searchedContracts = true;
        name=view.getNameSearch();
        surname=view.getSurnameSearch();
        tax=view.getTaxSearch();
        id_string=view.getIdSearch();
        boolean a = (!name.equals("") & !name.matches("[[a-z]|[A-Z]]*"));
        boolean b = (!surname.equals("") & !surname.matches("[[a-z]|[A-Z]]*"));
        boolean c = (!tax.equals("") & !tax.matches("[[a-z]|[0-9]]*"));
        boolean d = (!id_string.equals("") & !id_string.matches("[0-9]*"));

        if(a || b || c || d)
            JOptionPane.showConfirmDialog(view, "Invalid parameters for search's forms","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        else{
            updateView();
        }
    }
    
    public void updateView(){
        if(searchedContracts){
            try {
                Contract bag=null;
                if(!id_string.equals(""))
                    bag=new Contract(Integer.valueOf(id_string),null,null,null,name,surname,tax,null,null,null,null,null,null,null,null,null,null,null,null,null);
                else
                    bag=new Contract(null,null,null,null,name,surname,tax,null,null,null,null,null,null,null,null,null,null,null,null,null);
                current = new SearchContract_Controller(view.getTableModelRegistryManagement(),bag);
                contracts =((SearchContract_Controller)current).getContracts();
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(view, ex.getMessage(),"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void alterholderCliked(){
        int row = view.getSelectedContract();
        if(row >=0 && row<contracts.size()){
            view.setEnabled(false);
            current = new AlterContract_Controller(this, contracts.get(row));
        }
        else
            JOptionPane.showConfirmDialog(view, "Invalid Selection from the table","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
    }
    
    private void removeContractClicked() {
        int row = view.getSelectedContract();
        if(row >= 0 && row<contracts.size()){
            view.setEnabled(false);
            current = new RemoveContract_Controller(this, contracts.get(row));
        }
        else
            JOptionPane.showConfirmDialog(view, "Invalid Selection from the table","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
    }

    private void billsClicked() {
        int row = view.getSelectedContract();
        if(row >= 0 && row<contracts.size()){
            view.setEnabled(false);
            current = new BillsHistory_Controller(this, contracts.get(row));
        }
        else
            JOptionPane.showConfirmDialog(view, "Invalid Selection from the table","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
    }

    private void injuctionsCliecked() {
        int row = view.getSelectedContract();
        if(row >= 0 && row<contracts.size()){
            view.setEnabled(false);
            current = new InjuctionsHistory_Controller(this, contracts.get(row));
        }
        else
            JOptionPane.showConfirmDialog(view, "Invalid Selection from the table","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
    }
}
