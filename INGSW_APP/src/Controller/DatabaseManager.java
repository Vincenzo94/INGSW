/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrea
 */
public class DatabaseManager {
    private ResultSet result;
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
    
    
    public ResultSet doQuery(String query){
        ResultSet rs = null;
        Statement statement = null;
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    private Connection connect() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://sql425.your-server.de:3306/ingwsw_andread", "ingwsw_andreau", "q9d3GLLfzTdy7Y5X");    
    }
    public Connection getDbConnection(){
        return connection;
    }
}
