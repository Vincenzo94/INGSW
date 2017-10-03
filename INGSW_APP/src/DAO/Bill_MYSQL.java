/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.Database_Controller;
import Model.Bill;
import Model.Contract;
import Model.Document;
import Model.Operator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrea
 */
public class Bill_MYSQL implements DAO_Document {
    private Database_Controller dbManager = null;
    private final String TABLE_VIEW = "Bill_AUX";
    private final String TABLE = "Bill";
    private final String QUERY_GET_ALL_BILLS= " SELECT * FROM " + Database_Controller.schema + "." + TABLE_VIEW + " WHERE (Operator IS NULL OR Operator = ?) AND State = 'Inserted' LIMIT 5";
    private final String QUERY_UPDATE_MANAGED_BY_OPERATOR = "UPDATE " + Database_Controller.schema + "." + TABLE + " SET MANAGED_BY_OPERATOR = ? WHERE ID = ?";
    private final String QUERY_UPDATE_STATE = " UPDATE " + Database_Controller.schema + "." + TABLE + " SET state = ? WHERE ID = ?";;
    private final String QUERY_GET_ALL_BILLS_CONTRACT = " SELECT * FROM " + Database_Controller.schema + "." + TABLE_VIEW
                                                      + " WHERE Contract = ?";   
    public Bill_MYSQL(Database_Controller dbManager) {
        this.dbManager = dbManager;
    }

    

    @Override
    public void setState(Document d) {
        try {
            PreparedStatement statement = dbManager.getStatement(QUERY_UPDATE_STATE);
            statement.setString(1, d.getState());
            statement.setInt(2, d.getId());
            if(!dbManager.doUpdate(statement))
                throw new SQLException("Unable to set State to " +d.getId());
            } catch (SQLException ex) {
        }
    }

    @Override
    public List<?> getAllDocuments(Contract c) {
        List<Bill> bills = new ArrayList<>();
        try {
            
            PreparedStatement statement = dbManager.getStatement(QUERY_GET_ALL_BILLS_CONTRACT);
            statement.setInt(1, c.getId());
            ResultSet rs = dbManager.doQuery(statement);
            while(rs.next()){
                bills.add(new Bill(rs.getInt(1), rs.getString(4), rs.getDate(2), rs.getDate(3), rs.getDate(6), rs.getDate(7), rs.getFloat(8), rs.getDate(9), rs.getInt(11), rs.getInt(10), rs.getDate(4), rs.getDate(12), rs.getFloat(14), rs.getFloat(15), rs.getInt(9)));
            }
        } catch (SQLException ex) {
        }
        return bills; 
    }

    @Override
    public List<Bill> getAllDocuments(Operator o) {
    List<Bill> bills = new ArrayList<>();
        try {
            
            PreparedStatement statement = dbManager.getStatement(QUERY_GET_ALL_BILLS);
            statement.setInt(1, o.getId());
            ResultSet rs = dbManager.doQuery(statement);
            while(rs.next()){
                bills.add(new Bill(rs.getInt(1), rs.getString(4), rs.getDate(2), rs.getDate(3), rs.getDate(6), rs.getDate(7), rs.getFloat(8), rs.getDate(9), rs.getInt(11), rs.getInt(10), rs.getDate(4), rs.getDate(12), rs.getFloat(14), rs.getFloat(15), rs.getInt(9)));
            }
        } catch (SQLException ex) {
        }
        return bills;         
    }    

    @Override
    public Document search(Document d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T extends Document> void setManagedOperator(T document, Operator o) {
        try {
            PreparedStatement statement = dbManager.getStatement(QUERY_UPDATE_MANAGED_BY_OPERATOR);
            statement.setInt(1, o.getId());
            statement.setInt(2, document.getId());
            if(!dbManager.doUpdate(statement))
                throw new SQLException("Unable to set MANAGED_BY_OPERATOR  to " +document.getId());
            } catch (SQLException ex) {
        }
    }

    @Override
    public void remove(Document d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Document d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
