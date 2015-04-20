/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.pnaika.mp2.repository.simple;

import edu.iit.sat.itmd4515.pnaika.mp2.model.Customer;
import edu.iit.sat.itmd4515.pnaika.mp2.model.UpdCustomer;
import edu.iit.sat.itmd4515.pnaika.mp2.repository1.CustomerRepository;
import edu.iit.sat.itmd4515.pnaika.mp2.util.RandomName;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author Prashanth
 */
@SimpleCustomerRepository
public class SimpleCustomerRepositoryImpll implements CustomerRepository{
    
    private final Map<Short,Customer> actor =
            Collections.synchronizedMap(createActorMap());

    public SimpleCustomerRepositoryImpll() {
    }
    
    private Map<Short,Customer> createActorMap(){
        SortedMap<Short,Customer> ret = new TreeMap();
        
        for(int i =1 ; i<=50; i++){
            Customer actor = new Customer();
            actor.setCustomerId((short) i);
            actor.setFirstName(RandomName.generateFirstName());
            actor.setLastName(RandomName.generateLastName());
//            ret.putIfAbsent(actor.getActorId(), actor);
//            ret.put(actor.getActorId(), actor);
        }
        
//        return ret;
        return null;
        
    }
    @Override
    public Collection<Customer> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int remCustomer(short Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//
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
