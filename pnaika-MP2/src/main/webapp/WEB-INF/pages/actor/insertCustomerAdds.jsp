<%-- 
    Document   : insertCustomerAdds
    Created on : Feb 18, 2015, 11:54:05 AM
    Author     : Prashanth
--%>

<%@page import="edu.iit.sat.itmd4515.pnaika.mp2.service.CrmServiceImpl"%>
<%@page import="edu.iit.sat.itmd4515.pnaika.mp2.model.InsCustomer"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="edu.iit.sat.itmd4515.pnaika.mp2.repository.jdbc.JdbcCustomerRepositoryImpl"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.annotation.Resource"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.Date" %>

<!DOCTYPE html>
<%@include file="/WEB-INF/header.jspf" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Customer Address</title>
        <script type="text/javascript">
            function formValidation(){
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
                message = "Data entered will be inserted into Customer's data base";
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
        <h4>Please enter below details and click on SUBMIT button.</h4>
        <br>
        <form name="InsertActor" action="/pnaika-MP2/insertCustomerAdds" method="post" onsubmit="return formValidation() && confirmSubmit()">
            <div class="row">
                <div class="large-8 columns ">
                    <label>Customer's First Name :
                        <input type="text" id="firstName" name="firstName" size="40" placeholder="First Name"/>
                    </label>
                </div>
                <div class="large-4 columns ">
                    <label>Customer's Last Name :
                        <input type="text" id="lastName" name="lastName" size="40" placeholder="Last Name" />
                    </label>
                </div>    
            </div>
            <div class="row">
                <div class="large-12 columns ">
                    <label>Customer's Full Address :
                        <input type="text" id="address" name="address" size="140" placeholder="Full Address" />
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="large-4 columns ">
                    <label>District :
                        <input type="text" id="district" name="district" size="40" placeholder="District"/>
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="large-4 columns ">
                    <label>Contact Number :
                        <input type="text" id="phone" name="phone" size="40" placeholder="Contact Number"/>
                    </label>
                </div>
                <div class="large-7 columns ">
                    <label>email :
                        <input type="email" id="email" name="email" size="40" placeholder="email Address"/>
                    </label>
                </div>
            </div>
            <hr>        
            <div class="large-12" align="center">       
                <input type="reset" value="CLEAR" name="clear" />
                <input type="submit" value="SUBMIT" name="submit" />
            </div>
        </form>
    </body>
</html>
<%@include file="/WEB-INF/footer.jspf" %>