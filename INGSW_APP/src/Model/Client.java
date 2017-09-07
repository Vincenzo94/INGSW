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
public class Client implements DAO_Client{
    private final String name;
    private final String surname;
    private final Integer taxcode;
    
    private Client (String name, String surname, Integer tax){
        this.name=name;
        this.surname=surname;
        this.taxcode=tax;
    }
    
    @Override
    public Client check(String name, String surname, String tax) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Integer id, String newName, String newSurname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(String name, String Surname, String tax) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
