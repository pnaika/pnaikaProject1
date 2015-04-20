<%-- 
    Document   : updateCustomer
    Created on : Feb 13, 2015, 6:10:52 PM
    Author     : Prashanth
--%>
<%@page import="edu.iit.sat.itmd4515.pnaika.mp2.repository.jdbc.JdbcCustomerRepository"%>
<%@page import="edu.iit.sat.itmd4515.pnaika.mp2.repository.jdbc.JdbcCustomerRepositoryImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/WEB-INF/header.jspf" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Actor Page</title>
        <script type="text/javascript">
            function formValidation(){
                var id = document.getElementById('customerId').value;
                if(id === ""){
                    alert('ID is a mandatory field.');
                    document.getElementById('customerId').style.borderColor = "red";
                    document.getElementById('customerId').focus();
                    document.getElementById('customerId').select();
                    return false;
                }
                var fn = document.getElementById('firstName').value;
                if(fn === ""){
                    alert('We feel You missed to enter First Name !!');
                    document.getElementById('firstName').style.borderColor = "red";
                    document.getElementById('firstName').focus();
                    document.getElementById('firstName').select();
                    return false;
                }
                var ln=document.getElementById('lastName').value;
                if(ln === ""){
                    alert('Last Name Please ?');
                    document.getElementById('lastName').style.borderColor = "red";
                    document.getElementById('lastName').focus();
                    document.getElementById('lastName').select();        
                    return false;
                }
                var adds =document.getElementById('address').value;
                if(adds === ""){
                    alert('Please enter your Address.');
                    document.getElementById('address').style.borderColor = "red";
                    document.getElementById('address').focus();
                    document.getElementById('address').select();        
                    return false;
                }
                var vemail = document.getElementById('email').value;
                if(vemail === ""){
                    alert('Enter your email');
                    document.getElementById('email').style.borderColor = "red";
                    document.getElementById('email').focus();
                    document.getElementById('email').select();        
                    return false;
                }
                var phone =document.getElementById('phone').value;
                if(phone === ""){
                    alert('Contact number Please ?');
                    document.getElementById('phone').style.borderColor = "red";
                    document.getElementById('phone').focus();
                    document.getElementById('phone').select();        
                    return false;
                }
            }    
            function confirmSubmit() {
                var message;
                message = "Are you sure abt the update you made ?";
                var agree=confirm(message);
                if (agree)
                    return true ;
                else
                    return false ;
            }
        </script>
    </head>
    
        <a name="top"></a>
        <br>
        <h5>Please enter following fields that need to be Updated.</h5>
        <form name="updateCustomer" action="/pnaika-MP2/updateCustomer" method="post" onsubmit="return formValidation() && confirmSubmit()">
            <div class="row">
                <div class="large-4 columns ">
                    <label>Please enter Customer's ID :
                        <input type="text" id="customerId" value="${sessionScope.cust.customerId}" name="customerId" size="40" placeholder="Customer ID"/>
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="large-8 columns ">
                    <label>Customer's First Name :
                        <input type="text" id="firstName" value="${sessionScope.cust.firstName}" name="firstName" size="40" placeholder="First Name"/>
                    </label>
                </div>
                <div class="large-4 columns ">
                    <label>Customer's Last Name :
                        <input type="text" id="lastName" value="${sessionScope.cust.lastName}" name="lastName" size="40" placeholder="Last Name"/>
                    </label>
                </div>    
            </div>
            <div class="row">
                <div class="large-12 columns ">
                    <label>Customer's Full Address :
                        <input type="text" id="address" value="${sessionScope.cust.address}" name="address" size="40" placeholder=" Full Address"/>
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="large-4 columns ">
                    <label>District :
                        <input type="text" id="district" value="${sessionScope.cust.district}" name="district" size="40" placeholder="District"/>
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="large-4 columns ">
                    <label>Contact Number :
                        <input type="text" id="phone" value="${sessionScope.cust.phone}" name="phone" size="40" placeholder="Contact Number"/>
                    </label>
                </div>
                <div class="large-7 columns ">
                    <label>email :
                        <input type="email" id="email" value="${sessionScope.cust.email}" name="email" size="40" placeholder="email Address"/>
                    </label>
                </div>
            </div>
            <hr>        
            <div class="large-12" align="center">       
                <input type="reset" value="CLEAR" name="clear" />
                <input type="submit" value="SUBMIT" name="submit" />
            </div>
        </form>          
        <hr>
        <h5>Please Check for the Customer ID to be updated from the database !</h5>
        <table border="1" align="center">
            <thead>
            <tr>
                <th width="50" align="center">Customer ID</th>
                <th width="150">First Name</th>
                <th width="150">Last Name</th>
                <th width="200">Address</th>
                <th width="50">District</th>
                <th width="100">email</th>
                <th width="80">Phone Number</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.updateCustomer}" var="customer">
                <tr>
                    <td><c:out value = "${customer.customerId}" /></td>
                    <td><c:out value = "${customer.firstName}"/></td>
                    <td><c:out value = "${customer.lastName}"/></td>
                    <td><c:out value = "${customer.address}"/></td>
                    <td><c:out value = "${customer.district}"/></td>
                    <td><c:out value = "${customer.email}"/></td>
                    <td><c:out value = "${customer.phone}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>
        <a href="#top">
            <strong>Click here if u want go to SCROLL UP !!</strong>
        </a>
        
</html>
<%@include file="/WEB-INF/footer.jspf" %>