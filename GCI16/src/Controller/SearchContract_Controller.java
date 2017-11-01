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
    private final Contract contract;     
    private final DefaultTableModel tableModelRegistryManagement;
    private List<Contract> contracts;
    
    SearchContract_Controller(DefaultTableModel table, Contract c) throws SQLException {
        this.contract=c;
        this.tableModelRegistryManagement = table;
        contracts = new ArrayList<>();
        initRegistryManagement();
    }
    
    private void initRegistryManagement() throws SQLException {
        Database_Controller dbController = Database_Controller.getDBController();
        DAO_Contract daoContract = new Contract_MYSQL(dbController);
        tableModelRegistryManagement.setRowCount(0);
        String[] columns = {"Name", "Surname", "Contract ID", "Tax C./VAT"};
        tableModelRegistryManagement.setColumnIdentifiers(columns);
        contracts.clear();
        if(contract==null)
            contracts = daoContract.getAllContracts();
        else{
            contracts = daoContract.getAllContracts(contract);
            if(contracts.isEmpty()){
                throw new SQLException ("No Result Found");
            }     
        }
        for (Contract temp : contracts) {
            Object[] row = {temp.getName(), (Object)temp.getSurname(), temp.getId(), temp.getTaxCode()};
            tableModelRegistryManagement.addRow(row);
        }
    }

    List<Contract> getContracts() {
        return contracts;
    }
    
}
