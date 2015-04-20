<%-- 
    Document   : deleteCustomer
    Created on : Feb 13, 2015, 6:31:20 PM
    Author     : Prashanth
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="edu.iit.sat.itmd4515.pnaika.mp2.repository.jdbc.*"%>
<%@page import="edu.iit.sat.itmd4515.pnaika.mp2.service.CrmServiceImpl"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="edu.iit.sat.itmd4515.pnaika.mp2.service.CrmService" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/WEB-INF/header.jspf" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Actor Page</title>
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
            }
            function confirmSubmit() {
                var message;
                message = "Do you really wanna Delete this Customer from database ?";
                var agree=confirm(message);
                if (agree)
                    return true ;
                else
                    return false ;
            }
        </script>
    </head>
    <body>
        <br>
        <h4>Select ID to delete customer's information</h4>
        <a name="top"></a>
        <form name="deleteCustomer" action="/pnaika-MP2/deleteCustomer" method="post" onsubmit="return formValidation() && confirmSubmit()">
            
            
            <h3>Customer Details</h3>  
            <table border="1">
                <tbody>
                    <tr>
                        <td>Please input Customer ID which need to be deleted! </td>
                        <td><input type="text" id="customerId" value="${sessionScope.cust.customerId}" name="customerId" size="40" /></td>
                    </tr>
                    <tr>
                        <td>Name of the customer</td>
                        <td>${sessionScope.cust.firstName} ${sessionScope.cust.lastName}</td>
                    </tr>
                </tbody>
            </table>
            <input type="reset" value="RESET" name="reset" />
            <input type="submit" value="OKAY !!!" name="ok"/>
        </form>
        <br>
        <br>
        <h5>Please Check for the Customer ID to be deleted from the Customer database !</h5>
        <table border="1" align="center">
            <thead>
            <tr>
                <th width="50" align="center">Customer ID</th>
                <th width="150">First Name</th>
                <th width="150">Last Name</th>
                <th width="200">Address</th>
                <th width="150">email</th>
                <th width="100">Phone Number</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.deleteCustomer}" var="customer">
                <tr>
                    <td><c:out value = "${customer.customerId}" /></td>
                    <td><c:out value = "${customer.firstName}"/></td>
                    <td><c:out value = "${customer.lastName}"/></td>
                    <td><c:out value = "${customer.address}"/></td>
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
        <br>
    </body>
</html>
<%@include file="/WEB-INF/footer.jspf" %>
