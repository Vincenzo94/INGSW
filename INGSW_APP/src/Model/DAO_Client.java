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
public interface DAO_Client {
 public DAO_Client check (String name, String surname, String tax);
 public boolean update (Integer id, String newName, String newSurname);
 public boolean remove (Integer id);
 public boolean create (String name, String Surname, String tax);
}
