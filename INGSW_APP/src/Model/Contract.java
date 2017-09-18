/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Andrea
 */
public class Contract {
    private final Integer id;
    private String eMail;
    private String name;
    private String surname;
    private String taxCode;
    private Date start;
    private Date end;
    private Date modified;
    private String phone;
    private String mobile;

    public Contract(Integer ID, Date start, Date modified, Date end, String name, String surname, String taxCode, String phone, String eMail, String mobile) {
        this.id = ID;
        this.name = name;
        this.surname = surname;
        this.taxCode = taxCode;
        this.start = start;
        this.end = end;
        this.modified = modified;
        this.eMail = eMail;
        this.mobile = mobile;
        this.phone = phone;
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

    public String getBillingAddress() {
        return null;
    }

    public String getAddress() {
        return null;
    }

    public String getTelephone() {
        if(phone == null)
            return mobile;
        else if(mobile == null)
            return phone;
        else
            return phone.concat(" - "+mobile);
    }

    
}
