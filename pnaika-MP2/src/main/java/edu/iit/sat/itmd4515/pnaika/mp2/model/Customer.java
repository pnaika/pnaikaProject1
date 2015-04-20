/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.pnaika.mp2.model;

import java.sql.Timestamp;

/**
 *
 * @author Prashanth
 */
public class Customer {

    public Customer() {
    }
    
    private short CustomerId;
    private String firstName;
    private String lastName;
    private String district;
    private String address;
    private String phone;
    private String email;
    private Timestamp ts;

    public Customer(String firstName, String lastName, String email, Timestamp ts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ts = ts;
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

    public Customer(short CustomerId, String firstName, String lastName, String address, String district, String email, String phone) {
        this.CustomerId = CustomerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.district = district;
        this.address = address;
        this.phone = phone;
        this.email = email;
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


    public short getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(short CustomerId) {
        this.CustomerId = CustomerId;
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

    @Override
    public String toString() {
        return "Customer{" + "CustomerId=" + CustomerId + ", firstName=" + firstName + ", lastName=" + lastName + ", district=" + district + ", address=" + address + ", phone=" + phone + ", email=" + email + '}';
    } 
}
