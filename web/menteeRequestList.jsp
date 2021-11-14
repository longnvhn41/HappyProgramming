<%-- 
    Document   : menteeRequestList
    Created on : Nov 14, 2021, 3:08:32 PM
    Author     : GHC
--%>

<%@page import="dao.SkillDao"%>
<%@page import="entity.Skill"%>
<%@page import="entity.Request"%>
<%@page import="dao.RequestDao"%>
<%@page import="java.util.List"%>
<%@page import="entity.User"%>
<%@page import="context.DBConnect"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Boostrap CSS-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!--Boostrap JS-->
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <!--Boostrap Table CSS-->
        <link rel="stylesheet" href="http://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">

        <!--Boostrap Table JS-->
        <script src="http://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>


        <title>Happy Programming</title>

        <!--Custom CSS-->
        <link rel="stylesheet" href="css/template.css" />

    </head>
    <body>
        <%
            DBConnect dBConnect = new DBConnect();
            RequestDao dao = new RequestDao(dBConnect);
            User user = (User) session.getAttribute("user");   
            List<Request> requestsByMentee = dao.getListRequestById(user.getId());
        %>
        <div class="body-container">
            <%@include file="headerNew.jsp" %>
            <!--Thay code vao day-->
            <div class="main-content">
                <div class="mentor-table-container" style="padding: 40px">
                    <table id="example" class="display" style="width:100%">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Title</th>
                                <th>Deadline</th>
                                <th>Content</th>
                                <th>Hour</th>
                                <th>Skills</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                                for (Request req : requestsByMentee) {
                             %>
                                <tr>
                                    <%
                                        request.setAttribute("o", req);
                                    %>
                                    <td>${o.id}</td>
                                    <td>${o.title}</td>
                                    <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${o.deadline}"/></td>
                                    <td style="white-space: pre-wrap;">${o.mess}</td>
                                    <td>${o.deadlineHour}</td>
                                    <td>
                                        <%
                                            SkillDao skillDAO = new SkillDao(dBConnect);
                                            List<Skill> listSkill = skillDAO.getSkillListByRequestId(req.getId());
                                            request.setAttribute("listSkill", listSkill);
                                        %>
                                        <c:forEach items="${listSkill}" var="i">
                                            ${i.name}<br/>
                                        </c:forEach>
                                    </td>
                                    <td>
                                        <c:if test="${o.status == 1}">
                                            <form action="RequestController?service=updateRequest" method="post">
                                                <input type="hidden" value="${o.id}" name="requestId">
                                                <input style="width: 100px;" class="mb-1 btn btn-success" type="submit" value="Update" id="submit">
                                            </form>
                                            <form action="RequestController?service=cancelRequest" method="post">
                                                <input type="hidden" value="${o.id}" name="requestId">
                                                <input style="width: 100px;" class="mb-1 btn btn-danger" type="submit" value="Cancel" id="submit">
                                            </form>
                                        </c:if>
                                        <c:if test="${o.status == 0}">
                                            Finish Date: <fmt:formatDate pattern = "dd/MM/yyyy" value = "${o.finishDate}"/>
                                        </c:if>
                                        <c:if test="${o.status == 3}">
                                            Cancelled Date: <fmt:formatDate pattern = "dd/MM/yyyy" value = "${o.finishDate}"/>
                                        </c:if>
                                    </td>
                                </tr>
                            <%
                                 }
                             %>
                        </tbody>
                    </table>
                </div>
            </div>
            <%@include file="Footer.jsp" %>
        </div>
        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>
    </body>
</html>

