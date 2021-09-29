<%-- 
    Document   : forgetPass
    Created on : Sep 29, 2021, 11:42:33 PM
    Author     : GHC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .container{
            height: 100px;
            text-align: center;
            position: absolute;
            left: 50%;
            top: 50%;
            padding: 30px;
            border: 1px solid;
            transform: translate(-50%, -90%);
            .h4{
                padding-bottom: 10px;
            }  
        }
    </style>
    <body>
        <%
            String mess = (String) request.getAttribute("mess");
            String alert = (String) request.getAttribute("alert");
        %>
        <div class="container">
            <form action="forgetPass" method="POST">
                <c:if test="${mess!=null}">
                    <h4 style="color: red; margin-bottom: 30px"><%=mess%></h4>
                </c:if>
                <c:if test="${alert!=null}">
                    <h4 style="color: red; margin-bottom: 30px"><%=alert%></h4>
                </c:if>
                    Email: <input type="text" name="email"/><br>
                    <input style="margin-top: 15px" type="submit" value="submit"/>
            </form>
        </div>


    </body>
</html>
