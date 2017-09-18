/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.DatabaseManager;
import Model.Bill;
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
import java.sql.Date;

/**
 *
 * @author Andrea
 */
public class Bill_MYSQL implements DAO_Document {
    private Connection connection = null;
    private final String TABLE_VIEW = "Bill_AUX";
    private final String TABLE = "Bill";
    private final String QUERY_GET_ALL_BILLS= "SELECT * FROM " + DatabaseManager.schema + "." + TABLE_VIEW + " WHERE Operator IS NULL OR Operator = ? LIMIT 5";
    private final String QUERY_UPDATE_MANAGED_BY_OPERATOR = "UPDATE " + DatabaseManager.schema + "." + TABLE + " SET MANAGED_BY_OPERATOR = ? WHERE ID = ?";
    public Bill_MYSQL(Connection connection) {
        this.connection = connection;
    }

    

    @Override
    public boolean update(Document d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> getAllDocuments(Contract c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> getAllDocuments(Operator o) {
    List<Bill> bills = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_ALL_BILLS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1, o.getId());
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                bills.add(new Bill(rs.getInt(1), rs.getString(4), rs.getDate(2), rs.getDate(3), rs.getDate(6), rs.getDate(7), rs.getFloat(8), rs.getDate(9), rs.getInt(11), rs.getInt(10), rs.getDate(4), rs.getDate(12), rs.getFloat(14), rs.getFloat(15)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operator_MYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;         
    }    

    @Override
    public Document search(Document d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T extends Document> void setManagedOperator(List<T> document, Operator o) {
        for(T bill: document){
            try {
                connection.setAutoCommit(false);
                PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE_MANAGED_BY_OPERATOR);
                statement.setInt(1, o.getId());
                statement.setInt(2, bill.getId());
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
