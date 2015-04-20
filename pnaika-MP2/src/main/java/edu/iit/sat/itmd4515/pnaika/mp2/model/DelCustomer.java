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
public class DelCustomer {

    public DelCustomer() {
    }
    private short customerId;
    private String firstName;
    private String lastName;
    private Timestamp ts;

    public DelCustomer(short customerId) {
        this.customerId = customerId;
    }
 
    
    /**
     * Get the value of customerId
     *
     * @return the value of customerId
     */
    public short getCustomerId() {
        return customerId;
    }

    /**
     * Set the value of customerId
     *
     * @param customerId new value of customerId
     */
    public void setCustomerId(short customerId) {
        this.customerId = customerId;
    }
    public DelCustomer(String firstName, String lastName, Timestamp ts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ts = ts;
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
        return "DelCustomer{" + "customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", ts=" + ts + '}';
    }

    
}
