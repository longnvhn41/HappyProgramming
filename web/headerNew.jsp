<%-- 
    Document   : headerNew
    Created on : Oct 13, 2021, 11:22:42 PM
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

        <!--Custom CSS-->
        <link rel="stylesheet" href="css/template.css" />

        <title>Header</title>
    </head>
    <body>
        <nav class="navbar sticky-top navbar-expand-lg navbar-dark" style="background-color: #272727; font-family: Nunito Sans, Arial, sans-serif;">
            <a class="navbar-brand" style="margin-right: 4rem" href="#">Happy Programming</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto" style="flex: auto; justify-content: space-between">

                    <li class="nav-item dropdown">
                        <c:if test="${sessionScope.user!=null}">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <b>
                                    <c:choose>
                                        <c:when test="${sessionScope.user.role==0}">Mentor</c:when>
                                        <c:when test="${sessionScope.user.role==1}">Mentee</c:when>
                                        <c:when test="${sessionScope.user.role==2}">Admin</c:when>
                                    </c:choose>
                                </b>
                                actions
                            </a>

                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <c:choose>
                                    <c:when test="${sessionScope.user.role==0}">
                                        <!--Mentor-->
                                        <a class="dropdown-item" href="#">Mentor Stuff</a>
                                    </c:when>

                                    <c:when test="${sessionScope.user.role==1}">
                                        <!--Mentee-->
                                        <a class="dropdown-item" href="UserController?service=becomeMentor&id=${sessionScope.user.id}">Register as a Mentor</a>
                                    </c:when>

                                    <c:when test="${sessionScope.user.role==2}">
                                        <!--Admin-->
                                        <a class="dropdown-item" href="SkillController?action=adminSkillList">Manage Skills</a>
                                        <a class="dropdown-item" href="#">Manage Mentors</a>
                                    </c:when>
                                </c:choose>
                                <!--<div class="dropdown-divider"></div>-->
                            </div>
                        </c:if>
                    </li>

                    <!--Debug-->
                    <li class="nav-item">
                        <a class="nav-link" href="#">${requestScope['javax.servlet.forward.servlet_path']}</a>
                    </li>

                    <li class="nav-item dropdown">
                        <!--Logged In-->
                        <c:if test="${sessionScope.user!=null}">
                            <a style="padding-right: 30px" class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                ${sessionScope.user.name}
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="UserController?service=userProfile&user=${sessionScope.user.account}">Update Profile</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="UserController?service=logout">Logout</a>
                            </div>
                        </c:if>

                        <!--Haven't Logged In-->
                        <c:if test="${sessionScope.user==null}">
                            <a style="padding-right: 30px" class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                You haven't logged in
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="login.jsp">Login</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="signup.jsp">Register</a>
                            </div>
                        </c:if>
                    </li>
                </ul>
            </div>
        </nav>
    </body>
</html>
