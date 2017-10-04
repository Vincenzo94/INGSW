/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Contract_MYSQL;
import DAO.DAO_Contract;
import Model.Contract;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ansan
 */
public class SearchContract_Controller implements Controller{
    private  Database_Controller dbManager;
    private final DefaultTableModel tableModelRegistryManagement;
    private List<Contract> contracts;
    Contract bag;
    Popup_Controller popupcontroller;
    
    SearchContract_Controller(DefaultTableModel table, Contract c) {
        this.bag=c;
        this.tableModelRegistryManagement = table;
        contracts = new ArrayList<>();
        
        initRegistryManagement();
    }
    
    private void initRegistryManagement() {
        try {
            dbManager = Database_Controller.getDbManager();
        } catch (SQLException ex) {
        }
        DAO_Contract daoContract = new Contract_MYSQL(dbManager);
        tableModelRegistryManagement.setRowCount(0);
        String[] columns = {"Name", "Surname", "Contract ID", "Tax C./VAT"};
        tableModelRegistryManagement.setColumnIdentifiers(columns);
        contracts.clear();
        if(bag==null)
            contracts = daoContract.getAllContracts();
        else{
            contracts = daoContract.getAllContracts(bag);
            if(contracts.size()==0){
                popupcontroller=Popup_Controller.getPopup_C();
                popupcontroller.showPopup("No result found!");
            }
                
        }
            
        for(Contract temp : contracts){
                Object[] row = {temp.getName(), (Object)temp.getSurname(), temp.getId(), temp.getTaxCode()};
                tableModelRegistryManagement.addRow(row);
            }
    }

    public List<Contract> getContracts() {
        return contracts;
    }
    
}
