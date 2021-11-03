<%-- 
    Document   : Thu
    Created on : Nov 1, 2021, 3:45:11 AM
    Author     : Nguyen Van Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String thu=(String)request.getAttribute("long");
            String thu1=(String)request.getAttribute("long1");
        %>
        <h4 style="color: #e0a800; margin-bottom: 30px"><%=thu%></h4>
        <h4 style="color: #e0a800; margin-bottom: 30px"><%=thu1%></h4>
    </body>
</html>
