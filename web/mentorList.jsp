<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mentor List</title>
        <link rel="stylesheet" href="./css/myStyle.css" type="text/css" />
    </head>
    <style>
        *{
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }
        #main{

        }
        #header{
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            height: 50px;
            background-color: #5993a6;
        }
        #nav{

        }
        #nav li{
            display: inline-block;
        }
        #nav li a{
            color: #fff;
            text-decoration: none;
            line-height: 50px;
            padding: 0 25px;
            display: inline-block;

        }
        #nav li:hover a{
            color: #000;
            background-color: #ccc;
        }
        html{
            font-family: Arial;
        }
        #slider{
            position: relative;
            margin-top: 50px;
            padding-top: 65%;
            background: url(images/1.jpg) top center / cover no-repeat;
        }
        #slider .text-content{
            position: absolute;
            bottom: 700px;
            color: #fff;
            left: 0;
            right: 0;

            text-align: center;
        }
        #slider .text-heading{
            font-weight: 500;
            font-size: 30px;
        }
        #slider .text-description{
            font-size: 20px;
        }
        #footer{
            padding: 60px 20px;
            text-align: center;
            background-color: #5993a6;
            color: #fff;
        }
        .avatar {
            vertical-align: middle;
            width: 30px;
            height: 30px;
            border-radius: 50%;
        }
    </style>
    <body>
        <div class="container">
            <div id="header">
                <ul id=nav>
                    <li><a href="#">Happy Programming</a></li>
                        <c:if test="${sessionScope.user==null}">
                        <li><a href="login.jsp">Login</a></li>
                        <li><a href="signup.jsp">Signup</a></li>
                        </c:if>
                        <c:if test="${sessionScope.user!=null}">
                        <li><a href="#" style="padding-right:0">Hello: ${sessionScope.user.account}                              
                            </a></li>
                        <li><a href="UserController?service=userProfile&user=${sessionScope.user.account}"
                               style="padding: 0 8px"><img src="${sessionScope.user.ava}" alt="Avatar" class="avatar"></a></li>
                        <!-- Phân quyền cho mentee-->
                        <c:if test="${sessionScope.user.role==1}">
                            <li><a href="UserController?service=becomeMentor&id=${sessionScope.user.id}">Become Mentor</a></li>
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
                            <li><a href="SkillController?action=adminSkillList">Skill list</a></li>
                            </c:if>

                        <li><a href="UserController?service=logout">Logout</a></li>
                        <li><a href="changePass.jsp">Change Password</a></li>
                        <li><a href="MentorController">List Mentor</a></li>
                        </c:if>
                </ul>
            </div>

            <div class="my-gallery">
                <div class="search-container">
                    <form action="MentorController">
                        <input type="text" placeholder="Enter Name.." name="name">
                        <button type="submit">Submit</button>
                    </form>
                </div>
                <c:forEach items="${mentors}" var="l">
                    <div class="gallery-item">
                        <div class="gallery-img_preview">
                            <img  src="${l.ava}">
                        </div>
                        <div class="gallery-item_content">
                            <a href="RateMentor?mentorId=${l.id}"><h4 style="margin: 5px">${l.name}</h4></a>
                            <p style="margin: 5px 0 0 0"><i class="fa fa-map-marker"></i> ${l.description}</p>
                            <div style="display: flex">
                                <span>(${l.rate % 1 == 0 ? fn:substring(l.rate,0,1) : fn:substring(l.rate,0,3)}/5)</span>
                                <div class="rate">
                                    <c:forEach varStatus="loop" begin="0" end="4">
                                        <c:if test="${l.rate - loop.count >= 0}">
                                            <span style="color: gold"></span>
                                        </c:if>
                                        <c:if test="${l.rate lt loop.count}">
                                            <c:if test="${loop.count - l.rate <= 0.5 and loop.count - l.rate > 0}" >
                                                <span class="half"></span>
                                            </c:if>
                                            <c:if test="${loop.count - l.rate >0.5}">
                                                <span></span>
                                            </c:if>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>   
                <c:if test="${mentors.size() == 0}">
                    <h1>Not found</h1>
                </c:if>
            </div>
        </div>

    </div>
</body>
</html>
