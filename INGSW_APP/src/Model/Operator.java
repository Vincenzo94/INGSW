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

public class Operator {
    private final Integer id;
    private final Boolean isAdmin;
    private final Boolean isDetector;
    private final String password;
    
    public Operator (Integer id, String passwd, Boolean isAdmin, Boolean isDetector){
        this.id=id;
        this.isAdmin = isAdmin;
        this.password = passwd;
        this.isDetector= isDetector;
        
    }
    public Operator(Integer id, String passwd){
        this.id=id;
        this.password = passwd;
        this.isAdmin=null;
        this.isDetector=null;
    }

    public Boolean getIsDetector() {
        return isDetector;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }


    
    
}
