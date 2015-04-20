<%-- 
    Document   : error
    Created on : Feb 10, 2015, 3:51:07 PM
    Author     : Prashanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<%@include file="/WEB-INF/header.jspf" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <br>
        <h5>There has been an error in the page</h5>
        <br>
        <hr>
        <p>Status Code is :<strong>${pageContext.errorData.statusCode}</strong></p>        
        <hr>
        <c:choose>
            <c:when test="${pageContext.errorData.statusCode eq 404}">
                <p>Sorry this page is not available</p>
                <p>${pageContext.errorData.requestURI}</p>
            </c:when>
            <c:otherwise>
                <c:if test="${not empty pageContext.exception}">
                    <P>Exception Occured : </P>
                    <p>${pageContext.exception}<p>
                </c:if>
            </c:otherwise>    
        </c:choose>
    <h2>Please click on to the MENU and perform required Operations!</h2>
    </body>
</html>
<%@include file="/WEB-INF/footer.jspf" %>