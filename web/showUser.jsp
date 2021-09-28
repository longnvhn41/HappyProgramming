<%-- 
    Document   : showUser
    Created on : Sep 27, 2021, 11:01:21 PM
    Author     : Nguyen Van Long
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Profile</title>
    </head>
    <body>
    
         <table border="0">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>                                      
                    <th>Account</th>
                    <th>Password</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Date of birth</th>
                    <th>Gender</th>
                    <th>Address</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>

                <tr>
                    <td>${sessionScope.u.id}</td>
                    <td>${sessionScope.u.name}</td>
                    <td>${sessionScope.u.account}</td>
                    <td><input type="password" value="${sessionScope.u.password}%>" readonly /></td>
                    <td>${sessionScope.u.email}</td>
                    <td>${sessionScope.u.phone}</td>
                    <td>${sessionScope.u.dob}</td>
                    <td>${sessionScope.u.gender}</td>
                    <td>${sessionScope.u.address}</td>
                    <td><a href="UserController?service=update&id=${sessionScope.u.id}">Update</a></td>
                    
                </tr>
            </tbody>
        </table>
    </body>
</html>
