/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrea
 */
public class DatabaseManager {
    private static DatabaseManager instance;
    static private Connection connection;
    public static final String schema = "ingwsw_andread";
    private DatabaseManager(){
        try{
            connection = connect();
        } catch (SQLException ex){
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DatabaseManager getDbManager() throws SQLException{
        if(instance==null || connection.isClosed()){
            instance = new DatabaseManager();
        }
        return instance;
    }
    
    
    public ResultSet doQuery(PreparedStatement statement){
        ResultSet rs = null;
        try {
            rs = statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    private Connection connect() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://sql425.your-server.de:3306/ingwsw_andread", "ingwsw_andreau", "q9d3GLLfzTdy7Y5X");    
    }
 

    public PreparedStatement getStatement(String QUERY) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statement;
    }

    public Boolean doUpdate(PreparedStatement statement) {
        Boolean ret = false;
        try {
            connection.setAutoCommit(false);
            if (statement.executeUpdate() >=0) {
                    ret = true;
                    connection.commit();
                } else {
                    connection.rollback();
                }
                connection.setAutoCommit(true);
                statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
}
