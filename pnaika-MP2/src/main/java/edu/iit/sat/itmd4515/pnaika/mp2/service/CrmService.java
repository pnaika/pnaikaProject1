/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.pnaika.mp2.service;

import edu.iit.sat.itmd4515.pnaika.mp2.model.Customer;
import edu.iit.sat.itmd4515.pnaika.mp2.model.InsCustomer;
import edu.iit.sat.itmd4515.pnaika.mp2.model.UpdCustomer;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Prashanth
 */
public interface CrmService {
    
    Collection<Customer> findCustomer();
    Customer findCustomer(short Id);
//    UpdCustomer findCustomer(short Id);
    int insertCustomer(String firstName, String lastName,String email, Timestamp ts);
    int insertCustomerAdds(String address, String district, String phone);
    int remCustomer(short Id);
    int updCustomer(short Id, String firstName, String lastName, String address, String district, String email, String phone);
}
