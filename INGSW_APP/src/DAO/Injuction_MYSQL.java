/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.DatabaseManager;
import Model.Bill;
import Model.Injuction;
import Model.Contract;
import Model.Document;
import Model.Operator;
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
public class Injuction_MYSQL implements DAO_Document{
    private Connection connection = null;
    private final String TABLE = "Injuction";
    private final String TABLE_BILL = "Bill_AUX";
    private final String QUERY_GET_ALL_INJUCTIONS = "SELECT * FROM " + DatabaseManager.schema + "." + TABLE + " WHERE MANAGED_BY_OPERATOR IS NULL OR MANAGED_BY_OPERATOR = ? LIMIT 5";
    private final String QUERY_SEARCH_BILL_ID = "SELECT * FROM " + DatabaseManager.schema + ". " + TABLE_BILL + " WHERE ID = ?;";
    private final String QUERY_UPDATE_MANAGED_BY_OPERATOR = "UPDATE " + DatabaseManager.schema + "." + TABLE + " SET MANAGED_BY_OPERATOR = ? WHERE ID = ?";

    public Injuction_MYSQL(Connection connection) {
        this.connection = connection;
    }

    private Bill getReferredBill(Integer billID) {
        Bill bill = null;
        try{
            System.out.println(QUERY_SEARCH_BILL_ID);
            PreparedStatement statement = connection.prepareStatement(QUERY_SEARCH_BILL_ID, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1, billID);
            ResultSet rs = statement.executeQuery();
            rs.next();
            bill = new Bill(rs.getInt(1), rs.getString(4), rs.getDate(2), rs.getDate(3), rs.getDate(6), rs.getDate(7), rs.getFloat(8), rs.getDate(9), rs.getInt(11), rs.getInt(10), rs.getDate(4), rs.getDate(12), rs.getFloat(14), rs.getFloat(15));
        } catch (SQLException ex) {
            Logger.getLogger(Bill_MYSQL.class.getName()).log(Level.SEVERE, null, ex);
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
    public List<?> getAllDocuments(Operator o) {
    List<Injuction> injuctions = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_ALL_INJUCTIONS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1, o.getId());
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                injuctions.add(new Injuction(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getString(4), getReferredBill(rs.getInt(6))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operator_MYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return injuctions;    
    }

    @Override
    public List<?> getAllDocuments(Contract c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T extends Document> void setManagedOperator(List<T> document, Operator o) {
        for(T injuction: document){
            try {
                connection.setAutoCommit(false);
                PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE_MANAGED_BY_OPERATOR);
                statement.setInt(1, o.getId());
                statement.setInt(2, injuction.getId());
                if ( statement.executeUpdate() >= 0) {
                    connection.commit();
                } else {
                    connection.rollback();
                }
                connection.setAutoCommit(true);
                statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Operator_MYSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
