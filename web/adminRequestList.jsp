<%-- 
    Document   : adminMentorList
    Created on : Oct 13, 2021, 11:16:31 PM
    Author     : LongNV
--%>
<%@page import="java.sql.ResultSet"%>
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
            ResultSet rs = (ResultSet) request.getAttribute("ketQua");
            int count = 0;
        %>
        <div class="body-container">
            <%@include file="headerNew.jsp" %>
            <!--Thay code vao day-->
            <div class="main-content">
                <div class="mentor-table-container" style="padding: 40px">
                    <table id="example" class="display" style="width:100%">
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th>Mentee ID</th>
                                <th>Full Name</th>
                                <th>Message</th>
                                <th>Skill Request</th>
                                <th>Deadline Hours</th>
                                <th>Deadline Date</th>
                                <th>Creation Date</th>
                                <th>Status</th>
                                <th>Manage</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%while (rs.next()) {%>
                            <%count++;%>
                            <tr>
                                <td><%=count%></td>
                                <td><%=rs.getInt(1)%></td>
                                <td><%=rs.getString(2)%></td>
                                <td><%=rs.getString(3)%></td>
                                <td><%=rs.getString(4)%></td>
                                <td><%=rs.getInt(5)%></td>
                                <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "<%=rs.getDate(6)%>"/></td>
                                <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "<%=rs.getDate(7)%>"/></td>
                                <td><%=rs.getInt(8) == 2 ? "Cancle" : "Active"%></td>
                                <td>
                                    <c:if test="<%=rs.getInt(8) != 2%>">
                                        <form action="UserController?service=adminRequest" method="POST">
                                            <input type="hidden" value="<%=rs.getInt(9)%>" name="requestId">
                                            <input style="width: 100px;" class="mb-1 btn btn-danger" type="submit" value="Cancel" id="submit" onclick ="return confirm('Do you want Cancel this request?')">
                                        </form>

                                    </c:if>
                                    <c:if test="<%=rs.getInt(8) == 2%>">
                                        Disable
                                    </c:if>
                                </td>
                            </tr>
                            <%}%>
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
