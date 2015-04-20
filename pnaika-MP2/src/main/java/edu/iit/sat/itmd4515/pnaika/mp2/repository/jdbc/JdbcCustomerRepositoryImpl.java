/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.pnaika.mp2.repository.jdbc;

import edu.iit.sat.itmd4515.pnaika.mp2.model.Customer;
import edu.iit.sat.itmd4515.pnaika.mp2.model.UpdCustomer;
import edu.iit.sat.itmd4515.pnaika.mp2.repository1.CustomerRepository;
import static java.lang.System.out;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.web.WebEvent;
import javax.sql.DataSource;
import javax.annotation.Resource;
import static jdk.nashorn.internal.codegen.Compiler.LOG;

/**
 *
 * @author Prashanth
 */

@JdbcCustomerRepository
public class JdbcCustomerRepositoryImpl implements CustomerRepository {

    @Resource(lookup = "jdbc/pnaikaMp2DS")
    DataSource dataSource;
    
    @Override
    public Collection<Customer> findAll() {
        
        List<Customer> customer = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select customer_id," 
                    + "first_name, last_name, address, district, email ,phone from customer "
                    + " inner join address where customer.address_id = address.address_id");
            
            while(rs.next()){
                customer.add(new Customer(rs.getShort("customer_id"), 
                                    rs.getString("first_name"), 
                                    rs.getString("last_name"),
                                    rs.getString("address"),
                                    rs.getString("district"),
                                    rs.getString("email"),
                                    rs.getString("phone")));
            }  
            
        } catch (SQLException ex) {
            out.println(ex);
            Logger.getLogger(JdbcCustomerRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        if(customer.isEmpty()){ 
            return null;    
        }else{
            return customer;
        }
    }
    
    
    @Override
    public Customer findById(short Id) {
           try(Connection c = dataSource.getConnection()){
           
            PreparedStatement ps = c.prepareStatement("select * from customer inner join address on "
                                                      + "customer.address_id= address.address_id " 
                                                      + "where customer_id = ?");
            ps.setShort(1, Id);
            
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                return new Customer(rs.getShort("customer_id"), 
                                    rs.getString("first_name"), 
                                    rs.getString("last_name"),
                                    rs.getString("address"),
                                    rs.getString("district"),
                                    rs.getString("email"),
                                    rs.getString("phone"));
           }
           
       } catch (SQLException ex) {
            Logger.getLogger(JdbcCustomerRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return null;
    }
    
    short sAddressIdRem = 0;
    @Override
    public int remCustomer(short Id) {
        int res1= 0,res2 =0 ,res3= 0,res4 = 0;
        try(Connection c = dataSource.getConnection()){
            Statement s = c.createStatement();
            
            PreparedStatement deleteCustomerRen =  c.prepareStatement("delete from rental where customer_id = ?");           
            deleteCustomerRen.setShort(1, Id);
            res1 = deleteCustomerRen.executeUpdate();
            
            PreparedStatement deleteCustomerPay =  c.prepareStatement("delete from payment where customer_id = ?");           
            deleteCustomerPay.setShort(1, Id);
            res2 = deleteCustomerPay.executeUpdate();

            ResultSet rs = s.executeQuery("select address_id from sakila.customer where customer_id = " + Id);
    
            while(rs.next()){
                sAddressIdRem = rs.getShort(1);
            }
            
            PreparedStatement deleteCustomer =  c.prepareStatement("delete from customer where customer_id = ?");           
            deleteCustomer.setShort(1, Id);
            res3 = deleteCustomer.executeUpdate();
            
            PreparedStatement deleteCustomerAdds =  c.prepareStatement("delete from address where address_id = " + sAddressIdRem);           
            deleteCustomerAdds.setShort(1, Id);
            res4 = deleteCustomerAdds.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcCustomerRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res1;
    }

    @Override
    public int updCustomer(short Id, String firstName, String lastName, String address, String district, String email, String phone) {
        
        int res3 = 0;
        try(Connection c = dataSource.getConnection()){
            Statement s = c.createStatement();            
            PreparedStatement updateCustomer =  c.prepareStatement("update address inner join customer "
                                                                + " on  address.address_id = customer.address_id set " 
                                                                + "first_name = ? ,last_name = ? , "
                                                                + "address = ? ,district = ? ," 
                                                                + "email= ? ,phone= ? where customer.customer_id = ?");
            
            updateCustomer.setString(1, firstName);
            updateCustomer.setString(2, lastName);
            updateCustomer.setString(3, address);
            updateCustomer.setString(4, district);
            updateCustomer.setString(5, email);
            updateCustomer.setString(6, phone);
            updateCustomer.setShort(7, Id);
            
            updateCustomer.execute();
            if (updateCustomer.execute() == true){
                res3 = 1;
            }

        } catch (SQLException ex) {
            Logger.getLogger(JdbcCustomerRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return res3;
    }
    
    short iAddressID = 0;
    @Override
    public int insertCustomerAdds(String address, String district, String phone) {
        
        int res = 0;
        try(Connection c = dataSource.getConnection()){
            Statement s = c.createStatement();
            
            PreparedStatement insertCustomers =  c.prepareStatement("insert into address ( address, district, city_id, phone)"
                    + "values (?,?,?,?)");
            

            insertCustomers.setString(1, address);
            insertCustomers.setString(2, district);
            insertCustomers.setShort(3, (short)555);
            insertCustomers.setString(4, phone);
            
            res = insertCustomers.executeUpdate();
            
            ResultSet rs = s.executeQuery("select max(address_id) from address");
            
            while(rs.next()){
                iAddressID = rs.getShort(1);
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcCustomerRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return res;
    }
    
    @Override
    public int insertCustomer(String firstName, String lastName, String email, Timestamp ts) {
//        Date dt = new Date();
//        Timestamp ts = new Timestamp(dt.getDate());
        int res4 = 0;
        try(Connection c = dataSource.getConnection()){
            Statement s = c.createStatement();
            
            PreparedStatement insertCustomers2 =  c.prepareStatement("insert into customer (store_id, first_name, last_name, "
                                                                    + "email,address_id,create_date)"
                                                                    + "values (?,?,?,?,?,?)");
           
            insertCustomers2.setShort(1, (short)1 );
            insertCustomers2.setString(2, firstName);
            insertCustomers2.setString(3, lastName);
            insertCustomers2.setString(4, email);
            insertCustomers2.setShort(5, iAddressID);
            insertCustomers2.setTimestamp(6, ts);
            
            res4 = insertCustomers2.executeUpdate();
            
                       
            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcCustomerRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return res4;
    }
    
}
