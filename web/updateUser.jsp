<%-- 
    Document   : updateUser
    Created on : Sep 28, 2021, 12:41:45 AM
    Author     : Nguyen Van Long
--%>

<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User user = (User) request.getAttribute("us");
            String title = "Update";
        %>
       <form action="UserController" method="POST">
           
            <table border="0">
                <caption><%=title%></caption>
                <tbody>
                    <tr>
                        <td>ID</td>
                        <td><input type="text" name="id" value="<%=user.getId()%>"readonly /></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="name" value="<%=user.getName()%>" /></td>
                    </tr>
                    <tr>
                        <td>Account</td>
                        <td><input type="text" name="acc" value="<%=user.getAccount()%>" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>
                            <input type="password" name="pass" value="<%=user.getPassword()%>"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="<%=user.getEmail()%>" /></td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td><input type="text" name="phone" value="<%=user.getPhone()%>" /></td>
                    </tr>
                    <tr>
                        <td>Date of birth</td>
                        <td><input type="text" name="dob" value="<%=user.getDob()%>" /></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td><input type="text" name="sex" value="<%=user.getGender()%>" /></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><input type="text" name="address" value="<%=user.getAddress()%>" /></td>
                    </tr>
                    
                    
                    
                    <tr>
                        <td><input type="submit" value="update" /></td>
                        <td><input type="reset" value="reset" /></td>
                <input type="hidden" name="service" value="updated" />
                </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
