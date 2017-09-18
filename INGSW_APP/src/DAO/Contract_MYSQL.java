/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.DatabaseManager;
import Model.Contract;
import DAO.DAO_Contract;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Andrea
 */
public class Contract_MYSQL implements DAO_Contract{
    private Connection connection = null;
    private final String TABELLA = "Contract";
    private final String QUERY_GET_ALL_CONTRACT= "SELECT * FROM " + DatabaseManager.schema + "." + TABELLA;
    public Contract_MYSQL(Connection connection){
        this.connection = connection;
    }
    @Override
    public Contract search(Contract c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Contract c){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Contract c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Contract c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contract> getAllContracts() {
        List<Contract> contracts = new ArrayList<Contract>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_ALL_CONTRACT, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                contracts.add(new Contract(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operator_MYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contracts;         
    }

    @Override
    public List<Contract> getAllContracts(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
