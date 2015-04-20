<%-- 
    Document   : index
    Created on : Feb 11, 2015, 10:46:20 PM
    Author     : Prashanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/WEB-INF/header.jspf" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <br>
        <h3>'C'reate-'R'ead-'U'pdate-'D'elete Operations !!</h3>
        <br>
        <dl>
            <dt>CRUD Operations</dt>
            <dd><blockquote>In computer programming, create, read, update and delete (as an acronym CRUD or possibly a backronym)
            (Sometimes called SCRUD with an "S" for Search) are the four basic functions of persistent storage. 
            Sometimes CRUD is expanded with the words retrieve instead of read, modify instead of update, or 
            destroy instead of delete. It is also sometimes used to describe user interface conventions that 
            facilitate viewing, searching, and changing information;often using computer-based forms and reports.</blockquote></dd>
        </dl>
        <br>
        <form name="mainPage" action="/pnaika-MP2/insertCustomerAdds" method="GET">
            
            <div class="row">
                <div class="large-12 columns">
                  <div class="row collapse">
                    <div class="small-10 columns">
                      Click this button to CREATE/INSERT new Customer information to the data Base :
                    </div>
                    <div class="small-2 columns">
                      <a href="#" class="button postfix"><input type="submit" value="CLICK" name="read" /></a>
                    </div>
                  </div>
                </div>
            </div>
        </form>
        <form name="mainPage" action="/pnaika-MP2/readCustomer" method="GET">
            <div class="row">
                <div class="large-12 columns">
                  <div class="row collapse">
                    <div class="small-10 columns">
                      Click this button to READ actor information from the data Base :
                    </div>
                    <div class="small-2 columns">
                      <a href="#" class="button postfix"><input type="submit" value="CLICK" name="read" /></a>
                    </div>
                  </div>
                </div>
              </div>
        </form>
        <br>
        <br>
        
        <a href="site/apidocs/index.html"><strong>Please click here to see <u> JAVA DOC</u></strong></a>
        <br>
        <hr>
    </body>
    
</html>
<%@include file="/WEB-INF/footer.jspf" %>