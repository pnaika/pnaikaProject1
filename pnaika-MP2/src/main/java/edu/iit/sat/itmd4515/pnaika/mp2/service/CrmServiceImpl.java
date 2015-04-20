/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.pnaika.mp2.service;

import edu.iit.sat.itmd4515.pnaika.mp2.model.Customer;
import edu.iit.sat.itmd4515.pnaika.mp2.model.InsCustomer;
import edu.iit.sat.itmd4515.pnaika.mp2.model.UpdCustomer;
import edu.iit.sat.itmd4515.pnaika.mp2.repository.jdbc.JdbcCustomerRepository;
import edu.iit.sat.itmd4515.pnaika.mp2.repository1.CustomerRepository;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import javax.inject.Inject;

/**
 *
 * @author Prashanth
 */
public class CrmServiceImpl implements CrmService{
    
    @Inject @JdbcCustomerRepository
    private CustomerRepository customerRepository;

    @Override
    public Collection<Customer> findCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public int insertCustomerAdds(String address, String district, String phone) {
        return customerRepository.insertCustomerAdds(address,district,phone);
//        return res;
    }

    @Override
    public int remCustomer(short Id) {
        return customerRepository.remCustomer(Id);
    }

    @Override
    public Customer findCustomer(short Id) {
        return customerRepository.findById(Id);
    }

//    @Override
//    public UpdCustomer findCustomer(short Id) {
//        return customerRepository.findById(Id);
//    }

    @Override
    public int updCustomer(short Id, String firstName, String lastName, String address, String district, String email, String phone) {
        return customerRepository.updCustomer(Id,firstName,lastName,address,district,email,phone);
    }

    @Override
    public int insertCustomer(String firstName, String lastName, String email, Timestamp ts) {
        return customerRepository.insertCustomer(firstName, lastName, email, ts);
    }
}
