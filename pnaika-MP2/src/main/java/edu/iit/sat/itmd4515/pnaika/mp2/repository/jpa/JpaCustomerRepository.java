/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.pnaika.mp2.repository.jpa;

import edu.iit.sat.itmd4515.pnaika.mp2.model.Customer;
import edu.iit.sat.itmd4515.pnaika.mp2.model.UpdCustomer;
import edu.iit.sat.itmd4515.pnaika.mp2.repository1.CustomerRepository;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Prashanth
 */
public class JpaCustomerRepository implements CustomerRepository{

    @Override
    public Collection<Customer> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int remCustomer(short Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public UpdCustomer findById(short Id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public int updCustomer(short Id, String firstName, String lastName, String address, String district, String email, String phone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertCustomerAdds(String address, String district, String phone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertCustomer(String firstName, String lastName, String email, Timestamp ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer findById(short Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
