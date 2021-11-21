<%-- 
    Document   : forgetPassAfter
    Created on : Nov 9, 2021, 11:32:15 AM
    Author     : GHC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Forget Password</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <link rel="stylesheet" type="text/css" href="css/login_util.css">
        <!--===============================================================================================-->
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100" style="background: url('./images/background.jpg') center / cover no-repeat;">
                <div class="wrap-login100 p-l-50 p-r-50 p-t-77 p-b-30">
                    <form action="UserController?service=forgetPassAfter" method="POST" class="login100-form validate-form" >
                        <span class="login100-form-title p-b-55">
                            Change Password
                        </span>
                        <c:if test="${thongbao!=null}">
                            <h4 style="color: #e0a800; margin-bottom: 30px">${thongbao}</h4>
                        </c:if>
                    
                        <div class="wrap-input100 validate-input m-b-16">
                            <input class="input100" type="text" name="otp" value="" placeholder="Authentic Code" required>
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                
                            </span>
                        </div>
                            
                        <div class="wrap-input100 validate-input m-b-16">
                            <input class="input100" type="password" name="password" value="" placeholder="Password" required>
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <span class="lnr lnr-lock"></span>
                            </span>
                        </div>
                        


                        <div class="container-login100-form-btn p-t-25">
                            <button type="submit" class="login100-form-btn" style="background-color: #333;">
                                Submit
                            </button>
                        </div>


                    </form>
                </div>
            </div>
        </div>




        <!--===============================================================================================-->	
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>

    </body>
</html>

