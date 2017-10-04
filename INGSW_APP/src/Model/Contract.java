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
    private Integer id;
    private String eMail;
    private String name;
    private String surname;
    private String taxCode;
    private  Date start;
    private Date end;
    private Date modified;
    private String phone;
    private String mobile;
    private Address billingAddress;
    private final Address address;

    

    

   


    
    private class Address{
        private String city;

        private Integer id;
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
        public Address(Integer id,String city, String district, String street, Integer number, String zip){
            this.id = id;
            this.city = city;
            this.district = district;
            this.street = street;
            this.number = number;
            this.zip = zip;
        }
        public Integer getID(){
            return id;
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
    public Contract(String name, String surname, String taxCode, String phone, String eMail, String mobile,String city,String district,String zip,String street,Integer number,String billingCity,String billingDistrict,String billingZip, String billingStreet, Integer billingNumber) {
        this.name = name;
        this.surname = surname;
        this.taxCode = taxCode;
        this.eMail = eMail;
        this.mobile = mobile;
        this.phone = phone;
        billingAddress = new Address(billingCity, billingDistrict, billingStreet,billingNumber, billingZip);
        address = new Address(city,district,street,number,zip);
    }
    public Contract(String name, String surname, String taxCode, String phone, String eMail, String mobile,String city,String district,String zip,String street,Integer number) {
        this.name = name;
        this.surname = surname;
        this.taxCode = taxCode;
        this.eMail = eMail;
        this.mobile = mobile;
        this.phone = phone;
        address = new Address(city,district,street,number,zip);
    }
    
    public void addBillingAddress(String city, String district, String street, String zip, Integer number) {
        billingAddress = new Address(city,district,street,number,zip);
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
        String city=null;
        String street=null;
        String zip=null;
        String district=null;
        if(billingAddress != null){
            street = billingAddress.getStreet();
            city = billingAddress.getCity();
            district = billingAddress.getDistrict();
            zip = billingAddress.getZip();
            if((street.equals("")&&district.equals("")&&city.equals("")&&zip.equals("")))
                return null;
            return street+" "+billingAddress.getNumber()+", "+zip+", "+city+", "+district;
        }
        return null;
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
        return address.getStreet()+" "+address.getNumber()+", "+address.getZip()+", "+address.getDistrict()+", "+address.getCity();
    }
    public String getPhone(){
        return phone;
    }
    public String getMobile(){
        return mobile;
    }
    public String getTelephone() {
        if(phone == null)
            return mobile;
        else if(mobile == null)
            return phone;
        else
            return phone.concat(" - "+mobile);
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public void setNumber(Integer number) {
        address.setNumber(number);
    }

    public void setCity(String city) {
        address.setCity(city);
    }

    public void setDistrict(String district) {
        address.setDistrict(district);
    }

    public void setStreet(String street) {
        address.setStreet(street);
    }

    public void setZipCode(String zip) {
        address.setZip(zip);
    }
    public void setBillingNumber(Integer number) {
        billingAddress.setNumber(number);
    }

    public void setBillingCity(String city) {
        billingAddress.setCity(city);
    }

    public void setBillingDistrict(String district) {
        billingAddress.setDistrict(district);
    }

    public void setBillingStreet(String street) {
        billingAddress.setStreet(street);
    }

    public void setBillingZipCode(String zip) {
        billingAddress.setZip(zip);
    }
    
    public void setBillingAddress(Address ba) {
        billingAddress = null;
    }
    
    
}
