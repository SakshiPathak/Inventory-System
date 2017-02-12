/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryproject;

/**
 *
 * @author HP
 */
public class CustomerClass {
    private String id;
     private String firstrname;
     private String lastname;
    private String gender;
    private String emailid;
    private String address;
    private String city;
    private String pincode;
    private String state;
    private String phoneno;

    public CustomerClass() {
    }

    public CustomerClass(String id, String firstrname, String lastname, String gender, String emailid, String address, String city, String pincode, String state, String phoneno) {
        this.id = id;
        this.firstrname = firstrname;
        this.lastname = lastname;
        this.gender = gender;
        this.emailid = emailid;
        this.address = address;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
        this.phoneno = phoneno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstrname() {
        return firstrname;
    }

    public void setFirstrname(String firstrname) {
        this.firstrname = firstrname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
    

    
    
   
    
}
