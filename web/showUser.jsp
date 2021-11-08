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
        <!--Boostrap CSS-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!--Boostrap JS-->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <title>Happy Programming</title>

        <!--Custom CSS-->
        <link rel="stylesheet" href="css/showuser.css" />
        
    </head>
    <body>
<<<<<<< HEAD
        <div id="header">
            <ul id=nav>
                <li><a href="#">Happy Programming</a></li>
                    <c:if test="${sessionScope.user==null}">
                    <li><a href="homepage.jsp">Home Page</a></li>
                    <li><a href="UserController?service=logout">Logout</a></li>
                    </c:if>

                <c:if test="${sessionScope.user!=null}">
                    <li><a href="#" style="padding-right:0">Hello: ${sessionScope.user.account}                              
                        </a></li>

                    <!-- Phân quyền cho mentee-->
                    <c:if test="${sessionScope.user.role==1}">
                        <li><a href="homepage.jsp">Home Page </a></li>
                        </c:if>
                    <!-- Phân quyền cho mentor-->
                    <c:if test="${sessionScope.user.role==0}">
                        <li><a href="#">Request of student</a></li>
                        <li><a href="#">Request</a></li>
                        </c:if>
                    <!-- Phân quyền cho admin--> 
                    <c:if test="${sessionScope.user.role==2}">
                        <li><a href="#">Manager User</a></li>
                        <li><a href="#">Request</a></li>
                        <li><a href="#">Contact</a></li>                            
                        </c:if>

                    <li><a href="UserController?service=logout">Logout</a></li>
                    </c:if>
            </ul>
        </div>

        <div class="wrapper bg-white mt-sm-5">
            <form class="col-12">
                <h1 class="pb-4 border-bottom">USER PROFILE</h1>
                <div class="d-flex align-items-start py-3 border-bottom"> 
                    <li><a href="UserController?service=userProfile&user=${sessionScope.user.account}"
                           style="padding: 0 8px"><img src="${sessionScope.user.ava}" alt="Avatar" class="avatar"></a></li>
                </div> 
                <div class="row py-2">
                    <label class="col-md-6" for="id">ID</label> 
                    <input class="col-md-6" type="text"  value="${sessionScope.user.id}" >
                </div>
                <div class="row py-2">
                    <label class="col-md-6" for="name">Name</label> 
                    <input class="col-md-6" type="text"  value="${sessionScope.user.name}" > 
                </div>
                <div class="row py-2">
                    <label class="col-md-6" for="account">Account</label> 
                    <input class="col-md-6" type="text"  value="${sessionScope.user.account}">
                </div>
                <div class="row py-2">
                    <label class="col-md-6" for="password">Password</label> 
                    <input class="col-md-6" type="password" value="${sessionScope.u.password}%>" readonly />
                </div>
                <div class="row py-2">
                    <label class="col-md-6" for="email">Email</label>
                    <input class="col-md-6" type="email"  value="${sessionScope.user.email}">
                </div>
                <div class="row py-2">
                    <label class="col-md-6" for="phone">Phone</label> 
                    <input class="col-md-6" type="text"  value="${sessionScope.user.phone}">
                </div>
                <div class="row py-2">
                    <label class="col-md-6" for="dob">Date of birth</label> 
                    <input class="col-md-6" type="text"  value="${sessionScope.user.dob}" > 
                </div>   
                <div class="row py-2">
                    <label class="col-md-6" for="gender">Gender</label>
                    ${sessionScope.user.gender==1? "Male" : "Female"}
                </div>
                <div class="row py-2">
                    <label class="col-md-6" for="address">Address</label> 
                    <input class="col-md-6" type="text"  value="${sessionScope.user.address}"> 
                </div>
                <div class="row py-2">
                    <div><a href="UserController?service=update&id=${sessionScope.u.id}">Update</a><br>
                        <a href="changePass.jsp">Change password</a>
                    </div>         
=======
        <div class="body-container">
            <%@include file="headerNew.jsp" %>
            <!--Thay code vao day-->
            <div class="main-content">
                <div class="container rounded mt-5 mb-5">
                    <div class="row">
                        <div class="col-md-3 border-right">
                            <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                                <img src="${sessionScope.user.ava}" alt="Avatar" class="avatar" ></div>
                        </div>
                        <div class="col-md-5 border-right">
                            <div class="p-3 py-5">
                                <div class="d-flex justify-content-between align-items-center mb-3">
                                    <h1 class="text-right">USER PROFILE</h1>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-md-6"><label class="labels">ID</label><input type="number" class="form-control"  value="${sessionScope.user.id}" readonly></div>
                                    <div class="col-md-6"><label class="labels">Name</label><input type="text" class="form-control" value="${sessionScope.u.name}"readonly ></div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-md-12"><label class="labels">Account</label><input type="text" class="form-control" value="${sessionScope.user.account}"readonly></div>
                                    <div class="col-md-12"><label class="labels">Password</label><input type="password" class="form-control" value="${sessionScope.user.password}" readonly></div>
                                    <div class="col-md-12"><label class="labels">Email</label><input type="email" class="form-control" value="${sessionScope.user.email}"readonly ></div>
                                    <div class="col-md-12"><label class="labels">Phone</label><input type="number" class="form-control" value="${sessionScope.user.phone}" readonly></div>
                                    <div class="col-md-12"><label class="labels">Address</label><input type="text" class="form-control" value="${sessionScope.user.address}"readonly></div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-md-6"><label class="labels">Date of birth</label><input type="datetime" class="form-control" value="${sessionScope.user.dob}"readonly ></div>
                                    <div class="col-md-6"><label class="labels">Gender</label><input type="text" class="form-control" value="${sessionScope.user.gender==1? "Male" : "Female"}"readonly >                                       
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-md-6 text-center"><a href="UserController?service=update&id=${sessionScope.u.id}"><button class="btn btn-primary profile-button" type="submit">Update Profile</button></a></div>
                                    <div class="col-md-6 text-center"><a href="changePass.jsp"><button class="btn btn-primary profile-button" type="button">Change password</button></a></div>             
                                </div>
                            </div>
                        </div>
                    </div>
>>>>>>> 463ee26fa87e61755658dbe46170b0a989d5f87a
                </div>
            </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
