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


/**
 *
 * @author Andrea
 */
public class Database_Controller {
    private static Database_Controller instance;
    private static Connection connection;
    public static final String SCHEMA = "ingwsw_andread";
    
    private Database_Controller() throws SQLException{
            connection = connect();
    }
    
    static Database_Controller getDBController() throws SQLException{
        if(instance==null || connection.isClosed()){
            instance = new Database_Controller();
        }
        return instance;
    }
    
    
    public ResultSet doQuery(PreparedStatement statement) throws SQLException{
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    private Connection connect() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://sql425.your-server.de:3306/ingwsw_andread", "ingwsw_andreau", "q9d3GLLfzTdy7Y5X");    
    }
 

    public PreparedStatement getStatement(String QUERY) throws SQLException{
        PreparedStatement statement = connection.prepareStatement(QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return statement;
    }

    public Boolean doUpdate(PreparedStatement statement) throws SQLException{
        Boolean ret = false;
            connection.setAutoCommit(false);
            if (statement.executeUpdate() >=0) {
                    ret = true;
                    connection.commit();
                } else {
                    connection.rollback();
                }
                connection.setAutoCommit(true);
                statement.close();
        return ret;
    }
}
