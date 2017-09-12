/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model; 

/**
 *
 * @author Andrea
 */
//Classe implementata come Singleton
public class Operator {
    private final Integer id;
    private final Boolean isAdmin;
    private final String password;
    
    private Operator (Integer id, String passwd, Boolean isAdmin){
        this.id=id;
        this.isAdmin = isAdmin;
        this.password = passwd;
    }
    
    public static Operator checkOperator(String id, String passw){
        id=null;
        //Dopo aver verificato se esiste nel database restitusco 
        //una nuova istanza di operatore, null altrimenti
        
        //return new Operator(id, passws, isAdmin);
        return null;
    }

    private Integer getId() {
        return id;
    }
    
    
}
