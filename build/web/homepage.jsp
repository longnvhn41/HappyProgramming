<%-- 
    Document   : homepage
    Created on : Sep 24, 2021, 2:21:52 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <!-- <title>@ViewData["Title"] - Exercise</title> -->
        <link rel="stylesheet" href="~/lib/bootstrap/dist/css/bootstrap.min.css" />
        <link rel="stylesheet" href="~/css/classlayout.css" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
            crossorigin="anonymous"
            />
        <script src="../Jquery/Jquery_core/jquery_min/jquery-3.6.0.min.js"></script>
    </head>
    <body>

        <style>
      #sign{
        clear: both;
        display: flex;
      }
      #login {
        
      }
      #signup{
        background-color: chocolate;
        color: white;
      }

    </style>
    <nav
      style="border: 5px solid white;background-color: #c1c9d6 "
      class="navbar navbar-expand-lg navbar-light"
    >
      <div class="container-fluid">
        <div style="border-right: 5px solid white;">
          <a class="navbar-brand m-5" href="#">Logo</a>
        </div>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link " aria-current="page" href="#">Mentor</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Chia sẻ</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="userProfile.jsp">Trở thành mentor</a>
            </li>
            <div id="sign" class="bg-light">
            <li id="login" class="nav-item">
              <a class="nav-link" href="login.jsp">Đăng nhập</a>
            </li>
            <li id="signup" class="nav-item">
              <a class="nav-link" href="signup.jsp">Đăng kí</a>
            </li>
            </div>
            
          </ul>
        </div>
      </div>
    </nav>
    <div
      style="height: 300px; border: 5px solid white; background-color: #c1c9d6"
      class="slide col-lg-12"
    >
      slider
    </div>

    <div class="content d-flex">
      <div
        style="height: 300px;border: 5px solid white; background-color: #c1c9d6"
        class="left col-lg-9"
      >
        featured post
      </div>
      <div
        style="height: 300px;border: 5px solid white; background-color: #c1c9d6"
        class="right col-lg-3"
      >
        slider
      </div>
    </div>

    <div
      style="height: 70px;border: 5px solid white; background-color: #c1c9d6"
      class="footer col-lg-12"
    >
      Footer
    </div>
    <script src="~/lib/jquery/dist/jquery.min.js"></script>
    <script src="~/lib/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <script src="~/js/site.js" asp-append-version="true"></script>
    <!-- @await RenderSectionAsync("Scripts", required: false) -->

    </body>
</html>
