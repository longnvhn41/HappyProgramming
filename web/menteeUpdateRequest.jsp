<%-- 
    Document   : menteeUpdateRequest
    Created on : Oct 20, 2021, 6:32:23 PM
    Author     : GHC
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Skill"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Mentee Create Request</title>
        <link href="css/newcss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div style="background: url('./images/background.jpg') center / cover no-repeat;" class="container">
            <div class="menter-register" id="menter-register">
                <div class="menter-register__heading">
                    <p class="heading-title">UPDATE REQUEST</p>
                </div>
                <form action="RequestController?service=updateRequestAfter&requestId=${requestByMentee.id}" method="POST">
                    <div class="menter-register__body">
                        <p style="color:red;text-align:center" >${alertMess1}</p>
                        <div class="menter-register__item">
                            <label for="request_title" class="menter-register__label">
                                <p class="red-star">*</p>
                                Title:
                            </label>
                            <input type="text" name="title" class="mentor-register__input" value="${requestByMentee.title}" required> 
                        </div>
                        <div class="menter-register__item">
                            <label for="request_content" class="menter-register__label">
                                <p class="red-star">*</p>
                                Deadline:
                            </label>
                            <input type="date" name="deadline" class="mentor-register__input" value="${requestByMentee.deadline}" required>
                        </div>
                        <div class="menter-register__item">
                            <label for="request_content" class="menter-register__label">
                                <p class="red-star">*</p>
                                Content:
                            </label>
                            <input type="text" name="content" class="mentor-register__input" value="${requestByMentee.mess}" require> 
                        </div>
                        <div class="menter-register__item">
                            <label for="skill" class="menter-register__label">
                                <p class="red-star">*</p>
                                Choose Skill:
                            </label>
                            <select name="skill" class="mentor-register__input" multiple="true" size="6" multiple required>
                                <c:forEach items="${listSkill}" var="i">                                                   
                                    <%
                                        ArrayList<Skill> listSkillRequest = (ArrayList<Skill>) request.getAttribute("listSkillRequest");
                                        Skill i = (Skill) pageContext.getAttribute("i");
                                    %>
                                    <option value="${i.id}" <%=listSkillRequest.contains(i) ? "selected" : ""%>>${i.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="menter-register__item">
                            <label for="request_deadlineHours" class="menter-register__label">
                                <p class="red-star">*</p>
                                Deadline Hours:
                            </label>
                            <input type="number" min="0" step=".01" name="deadlineHours" class="mentor-register__input" value="${requestByMentee.deadlineHour}" required> 
                        </div>
                        <div> 
                            <input style="margin-left: 350px" type="submit" value="Update" />
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </body>
</html>

