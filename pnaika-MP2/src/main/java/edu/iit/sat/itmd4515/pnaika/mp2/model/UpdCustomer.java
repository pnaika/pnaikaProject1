/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.pnaika.mp2.model;

/**
 *
 * @author Prashanth
 */
public class UpdCustomer {

    public UpdCustomer() {
    }
    
    private short customerId;
    private String firstName;
    private String lastName;    
    private String address;  
    private String district;    
    private String email;        
    private String phone;

    public UpdCustomer(short customerId, String firstName, String lastName, String address, String district, String email, String phone) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.district = district;
        this.email = email;
        this.phone = phone;
    }

    public UpdCustomer(short customerId) {
        this.customerId = customerId;
    }

    
    
    /**
     * Get the value of phone
     *
     * @return the value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the value of phone
     *
     * @param phone new value of phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get the value of district
     *
     * @return the value of district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Set the value of district
     *
     * @param district new value of district
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "updActor{" + "customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", district=" + district + ", email=" + email + ", phone=" + phone + '}';
    }
    
}
