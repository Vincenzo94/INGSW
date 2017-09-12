/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingsw_app;

import View.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;

/**
 *
 * @author rolan
 */
public class Database {
    
    static private Connection conn;
    
    public Database(){
        try {
            conn = getDefaultConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Restituisce la connessione di default al DB.
     *
     * @return Connessione di default (quella gi&agrave; attiva, o una nuova
     * ottenuta in base ai parametri di connessione attualmente impostati
     * @throws SQLException In caso di problemi di connessione
     */
    static public Connection getDefaultConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = nuovaConnessione();
            System.out.println("nuova connessione");
        } else {
            //System.out.println("ricicla connessione");
        }
        
        return conn;
    }
    
    /**
     * Imposta una connessione specificata in input come default.
     *
     * @param c Connessione al DB
     */
    static public void setDefaultConnection(Connection c) {
        conn = c;
    }
    
    /**
     * Restituisce una nuova connessione al DB.
     *
     * @return Connessione al DB secondo i parametri attualmente impostati
     * @throws java.sql.SQLException in caso di problemi di connessione
     */
    static public Connection nuovaConnessione() throws SQLException {
       
        return DriverManager.getConnection("jdbc:mysql://sql425.your-server.de:3306/ingwsw_andread", "ingwsw_andreau", "q9d3GLLfzTdy7Y5X");
    }
    
    
   /**
    * Effettua una query e restituisce i valori.
    * 
    * @param query String contenente l'interrogazione
    * @return oggetto contenente il risultato
    */   
   static public ResultSet leggiValori(String query){
       ResultSet rs = null;
   
        try {
            Connection conn = Database.getDefaultConnection();
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            rs = st.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
   }
}
