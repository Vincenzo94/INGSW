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
public class Contract {
    private Integer id;
    private String eMail;
    private String name;
    private String surname;
    private String taxCode;

    public Contract(int ID, String name, String surname, String taxCode) {
        this.id = ID;
        this.name = name;
        this.surname = surname;
        this.taxCode = taxCode;
    }
    public Integer getId() {
        return id;
    }

    public String getEmailAddress() {
        return eMail;
    }

    public String getName() {
        return name;
    }

    public Object getSurname() {
        return surname;
    }

    public Object getTaxCode() {
        return taxCode;
    }

    
}
