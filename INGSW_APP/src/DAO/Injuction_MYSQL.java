/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.Database_Controller;
import Model.Bill;
import Model.Injuction;
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
public class Injuction_MYSQL implements DAO_Document{
    private Database_Controller dbManager = null;
    private final String TABLE = "Injuction";
    private final String VIEW = "Injuction_AUX";
    private final String TABLE_BILL = "Bill_AUX";
    private final String QUERY_GET_ALL_INJUCTIONS = "SELECT * FROM " + Database_Controller.schema + "." + TABLE + " WHERE (MANAGED_BY_OPERATOR IS NULL OR MANAGED_BY_OPERATOR = ?) AND State = 'Inserted' LIMIT 5";
    private final String QUERY_SEARCH_BILL_ID = "SELECT * FROM " + Database_Controller.schema + ". " + TABLE_BILL + " WHERE ID = ?;";
    private final String QUERY_UPDATE_MANAGED_BY_OPERATOR = "UPDATE " + Database_Controller.schema + "." + TABLE + " SET MANAGED_BY_OPERATOR = ? WHERE ID = ?";
    private final String QUERY_REMOVE = " DELETE FROM " + Database_Controller.schema + "." + TABLE 
                                      + " WHERE ID = ?";
    private final String QUERY_GET_ALL_INJUCTIONS_CONTRACT = " SELECT * FROM " + Database_Controller.schema + "." + VIEW
                                                           + " WHERE CONTRACT = ?";
    private final String QUERY_UPDATE_STATE = " UPDATE " + Database_Controller.schema + "." + TABLE + " SET state = ? WHERE ID = ?";;

    

    public Injuction_MYSQL(Database_Controller dbManager) {
        this.dbManager = dbManager;
    }

    private Bill getReferredBill(Integer billID) {
        Bill bill = null;
        try{
            PreparedStatement statement = dbManager.getStatement(QUERY_SEARCH_BILL_ID);
            statement.setInt(1, billID);
            ResultSet rs = dbManager.doQuery(statement);
            rs.next();
            bill = new Bill(rs.getInt(1), rs.getString(4), rs.getDate(2), rs.getDate(3), rs.getDate(6), rs.getDate(7), rs.getFloat(8), rs.getDate(9), rs.getInt(11), rs.getInt(10), rs.getDate(4), rs.getDate(12), rs.getFloat(14), rs.getFloat(15), rs.getInt(9));
        } catch (SQLException ex) {
        }
        return bill;
    }
    @Override
    public Document search(Document document) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Document d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Injuction> getAllDocuments(Operator o) {
    List<Injuction> injuctions = new ArrayList<>();
        try {
            PreparedStatement statement = dbManager.getStatement(QUERY_GET_ALL_INJUCTIONS);
            statement.setInt(1, o.getId());
            ResultSet rs = dbManager.doQuery(statement);
            while(rs.next()){
                injuctions.add(new Injuction(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getString(4), getReferredBill(rs.getInt(6)), rs.getInt(5)));
            }
        } catch (SQLException ex) {
        }
        return injuctions;    
    }

    @Override
    public List<Injuction> getAllDocuments(Contract c) {
        List<Injuction> injuctions = new ArrayList<>();
        try {
            
            PreparedStatement statement = dbManager.getStatement(QUERY_GET_ALL_INJUCTIONS_CONTRACT);
            statement.setInt(1, c.getId());
            ResultSet rs = dbManager.doQuery(statement);
            while(rs!=null && rs.next()){
                injuctions.add(new Injuction(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getString(4), getReferredBill(rs.getInt(6)), rs.getInt(5)));
            }
        } catch (SQLException ex) {
        }
        return injuctions; 
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
    public void remove(Document document) {
        try {
        PreparedStatement statement = dbManager.getStatement(QUERY_REMOVE);
        statement.setInt(1, document.getId());
        if(!dbManager.doUpdate(statement))
            throw new SQLException("Unable to remove Injuction " +document.getId());
        } catch (SQLException ex) {
        }
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
}
