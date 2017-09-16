/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.ResultSet;

/**
 *
 * @author Andrea
 */
public class DatabaseManager {
    private ResultSet result;
    private static DatabaseManager instance;
    
    private DatabaseManager(){
        
    }
    
    public static DatabaseManager getDbManager(){
        if(instance==null){
            instance = new DatabaseManager();
        }
        return instance;
    }
    
    
    public ResultSet doQuery(String query){
        return null;
    }
}
