<%-- 
    Document   : adminMentorList
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
        <div class="body-container">
            <%@include file="headerNew.jsp" %>
            <!--Thay code vao day-->
            <div class="main-content">
                <div class="mentor-table-container" style="padding: 40px">
                    <h2>Mentor List</h2>
                    <table id="example" class="display" style="width:100%">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Account</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>DOB</th>
                                <th>Gender</th>
                                <th>Address</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${mentors}" var="mentor">
                                <tr>
                                    <th>${mentor.id}</th>
                                    <th>${mentor.name}</th>
                                    <th>${mentor.account}</th>
                                    <th>${mentor.email}</th>
                                    <th>${mentor.phone}</th>
                                    <th>${mentor.dob}</th>
                                    <th>
                                        <c:choose >
                                            <c:when test="${mentor.gender == 1}">Male</c:when>
                                            <c:when test="${mentor.gender == 0}">Female</c:when>
                                        </c:choose>

                                    </th>
                                    <th>${mentor.address}</th>
                                    <th><a style="color: red; cursor: pointer" onclick="setConfirmModal(${mentor.id},'${mentor.name}')">Demote</a></th>
                                </tr>
                            </c:forEach> 
                        </tbody>
                    </table>
                </div>
            </div>
            <%@include file="Footer.jsp" %>
        </div>
        <!-- Modal -->
        <!-- Delete Confirm Modal -->
        <div class="modal fade" id="deleteConfirmModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Confirm Demotion</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form id="demoteForm" method="POST">
                            <div class="modal-body">
                                Are you sure want demote mentor to mentee?
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-danger" value="Demote">
                                <button type="button" class="btn btn-link" style="color: #272727" data-dismiss="modal">Cancel</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function setConfirmModal(id, name) {
                $('#demoteForm').attr('action', 'AdminMentorList?action=demote&id=' + id);
                $('#deleteConfirmModal').find('.modal-body').html(`<p>Are you sure want demote mentor <b>` + name + `</b> to mentee?</p>`);
                $('#deleteConfirmModal').modal('show');
            }
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>
    </body>
</html>
