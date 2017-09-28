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
    private Address billingAddress;
    private Address address;
    
    private class Address{
        private String city;

        
        private String district;
        private String street;
        private Integer number;
        private String zip;
        
        public Address(String city, String district, String street, Integer number, String zip){
            this.city = city;
            this.district = district;
            this.street = street;
            this.number = number;
            this.zip = zip;
        }
        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }
    }
    
    public Contract(Integer ID, Date start, Date modified, Date end, String name, String surname, String taxCode, String phone, String eMail, String mobile,String city,String district,String zip,String street,Integer number,String billingCity,String billingDistrict,String billingZip, String billingStreet, Integer billingNumber) {
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
        if(billingStreet != null)
            billingAddress = new Address(billingCity, billingDistrict, billingStreet,billingNumber, billingZip);
        address = new Address(city,district,street,number,zip);
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

    public String getSurname() {
        return surname;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public String getBillingCity() {
        return billingAddress.getCity();
    }
    public String getBillingDistrict() {
        return billingAddress.getDistrict();
    }
    public Integer getBillingNumber() {
        return billingAddress.getNumber();
    }
    public String getBillingStreet() {
        return billingAddress.getStreet();
    }
    public String getBillingZip(){
        return billingAddress.getZip();
    }
    public String getBillingAddress(){
        if(billingAddress == null)
            return null;
        return billingAddress.getStreet()+billingAddress.getNumber()+", "+billingAddress.getCity()+", "+billingAddress.getDistrict()+", "+billingAddress.getZip();
    }

    public String getCity() {
        return address.getCity();
    }
    public String getDistrict() {
        return address.getDistrict();
    }
    public Integer getNumber() {
        return address.getNumber();
    }
    public String getStreet() {
        return address.getStreet();
    }
    public String getZip(){
        return address.getZip();
    }
    public String getAddress(){
        return address.getStreet()+address.getNumber()+", "+address.getZip()+", "+address.getDistrict()+", "+address.getCity();
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
