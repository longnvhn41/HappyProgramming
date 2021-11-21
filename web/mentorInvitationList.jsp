<%-- 
    Document   : adminMentorList
    Created on : Oct 13, 2021, 11:16:31 PM
    Author     : Tri
--%>
<%@page import="dao.SkillDao"%>
<%@page import="entity.Skill"%>
<%@page import="entity.Request"%>
<%@page import="dao.RequestDao"%>
<%@page import="java.util.List"%>
<%@page import="entity.Invitation"%>
<%@page import="entity.User"%>
<%@page import="dao.InvitationDao"%>
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
            User user = (User) session.getAttribute("user");
            InvitationDao dao = new InvitationDao();
            List<Invitation> invitations = dao.getInvitationListByMentorId(user.getId());
            
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
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                                for (Invitation inv : invitations) {
                             %>
                            <tr>
                                <%
                                    RequestDao rDAO = new RequestDao();
                                    Request req = rDAO.getRequestById(inv.getRequest_id());
                                    request.setAttribute("b", req);
                                %>
                                <td>${b.id}</td>
                                <td>${b.title}</td>
                                <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${b.deadline}"/></td>
                                <td style="white-space: pre-wrap;">${b.mess}</td>
                                <td>${b.deadlineHour}</td>
                                <%
                                    SkillDao skillDAO = new SkillDao();
                                    List<Skill> skillList = skillDAO.getSkillListByRequestId(req.getId());
                                    request.setAttribute("skillList", skillList);
                                %>
                                <td>
                                    <c:forEach items="${skillList}" var="c">
                                        ${c.name}<br>
                                    </c:forEach>
                                </td>
                                <%
                                    request.setAttribute("d", inv);
                                %>
                                <td>
                                    <c:if test="${d.status == 'Processing'}">
                                        Processing
                                    </c:if>
                                    <c:if test="${d.status == 'Accept'}">
                                        Accepted
                                    </c:if>
                                    <c:if test="${d.status == 'Cancel'}">
                                        Cancelled
                                    </c:if>
                                    <c:if test="${d.status == 'Decline'}">
                                        Declined
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${d.status == 'Processing'}">
                                        <form action="InvitationController?service=mentorAccept" method="post">
                                            <input type="hidden" value="${d.request_id}" name="requestId">

                                            <input style="width: 100px;" class="mb-1 btn btn-success" type="submit" value="Accept" id="submit" onclick ="return confirm('Do you want to accept this invitation?')">
                                        </form>
                                        <form action="InvitationController?service=mentorDecline" method="post">
                                            <input type="hidden" value="${d.request_id}" name="requestId">
                                            <input style="width: 100px;" class="mb-1 btn btn-danger" type="submit" value="Decline" id="submit" onclick ="return confirm('Do you want to decline this invitation?')">
                                        </form>
                                     </c:if>
                                    <c:if test="${d.status == 'Accept'}">
                                        <form action="InvitationController?service=mentorCallBackAccept" method="post">
                                            <input type="hidden" value="${d.request_id}" name="requestId">

                                            <input style="width: 100px;" class="mb-1 btn btn-danger" type="submit" value="Call back" id="submit" onclick ="return confirm('Do you want to recall this invitation?')">
                                        </form> 
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
