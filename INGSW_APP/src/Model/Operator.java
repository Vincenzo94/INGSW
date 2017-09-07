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
    private final String name;
    private final String surname;
    private final Integer id;
    
    private Operator (String name, String surname, Integer id){
        this.name=name;
        this.surname=surname;
        this.id=id;
    }
    
    public static Operator checkOperator(String name, String surname, String passw){
        Integer id=null;
        //Dopo aver verificato se esiste nel database restitusco 
        //una nuova istanza di operatore, null altrimenti
        return new Operator(name,surname,id);
    }

    private Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    
    
}
