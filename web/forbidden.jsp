<%-- 
    Document   : template
    Created on : Oct 13, 2021, 11:16:31 PM
    Author     : Tri
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Boostrap CSS-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!--Boostrap JS-->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <title>Happy Programming</title>

        <!--Custom CSS-->
        <link rel="stylesheet" href="css/template.css" />
        <link rel="stylesheet" href="css/rateMentor.css" />

    </head>
    <body>
        <div class="body-container">
            <%@include file="headerNew.jsp" %>
            <!--Thay code vao day-->
            <div class="main-content" style="padding: 50px">
                <div class="mentor-info" style="padding: 20px 50px 20px 50px; width: 100%; height: 60vh; flex-flow: column; justify-content: space-between">
                    <div>
                        <h1>Forbidden Resources</h1>
                        <hr style="width:100%;text-align:left;margin-left:0">
                        <p>You don't have enough permission to view this resource</p>
                    </div>

                    <a class="btn btn-warning" style="height: 70px;
                       color: white;
                       font-size: large;
                       display: flex;
                       align-items: center;
                       justify-content: center;" href="homepage.jsp">Click here to be redirected to Homepage</a>
                </div>
            </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
