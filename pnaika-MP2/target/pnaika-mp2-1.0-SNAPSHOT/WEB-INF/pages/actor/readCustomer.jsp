<%-- 
    Document   : readCustomer
    Created on : Feb 7, 2015, 7:39:13 PM
    Author     : Prashanth
    Description: This JSP page will read customer details from database
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/WEB-INF/header.jspf" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read Customer Page</title>
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
        <a name="top"></a>    
        <form name="rc" action="/pnaika-MP2/readCustomer" method="post" onsubmit="return formValidation() && confirmSubmit()">
            <table border="1">
            <tbody>
                <tr>
                    <td>Please input Customer ID which need to be selected! </td>
                    <td><input type="text" id="customerId" name="customerId" size="15" /></td>
                </tr>
            </tbody>
            </table>
            <input type="submit" value="SUBMIT" name="submit" />
        </form>
        
        <table border="1">
            <thead>
            <tr>
                <th width="80" align="center">Customer ID</th>
                <th width="100">First Name</th>
                <th width="60">Last Name</th>
                <th width="170">Address</th>
                <th width="60">District</th>
                <th width="100">email</th>
                <th width="80">Phone Number</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty sessionScope.cust}">
                    <tr>
                        <td>${sessionScope.cust.customerId}</td>
                        <td>${sessionScope.cust.firstName}</td> 
                        <td>${sessionScope.cust.lastName}</td>
                        <td>${sessionScope.cust.address}</td>
                        <td>${sessionScope.cust.district}</td>
                        <td>${sessionScope.cust.email}</td>
                        <td>${sessionScope.cust.phone}</td>
                    </tr>
            </c:if>
            </tbody>        
        </table>
        <hr>
        <a href="/pnaika-MP2/updateCustomer"><input type="button" value="UPDATE" name="update" /></a>
        <a href="/pnaika-MP2/deleteCustomer"><input type="button" value="DELETE" name="delete" /></a>
        <br>

        <br>
        <br>
        <table border="1" align="center">
            <thead>
            <tr>
                <th width="50" align="center">Customer ID</th>
                <th width="100">First Name</th>
                <th width="60">Last Name</th>
                <th width="170">Address</th>
                <th width="60">District</th>
                <th width="100">email</th>
                <th width="80">Phone Number</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.customer}" var="customer">
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
        <a href="#top">
            <strong>Click here if u want go to SCROLL UP !!</strong>
        </a>
    </body>
</html>
<%@include file="/WEB-INF/footer.jspf" %>