<%-- 
    Document   : template
    Created on : Oct 13, 2021, 11:16:31 PM
    Author     : Tri
--%>
<%@page import="entity.MentorStatistic"%>
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

        <!--Boostrap Table CSS-->
        <link rel="stylesheet" href="http://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">

        <!--Boostrap Table JS-->
        <script src="http://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>

        <!--Pie Chart-->
        <c:set var="acceptedRequest" value="${ms.acceptedRequest}"/>
        <c:set var="rejectedRequest" value="${ms.rejectedRequest}"/>
        <c:set var="pendingRequest" value="${ms.pendingRequest}"/>

        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawChart);
            function drawChart() {
                var pending = ${pendingRequest}
                var accepted = ${acceptedRequest}
                var rejected = ${rejectedRequest}
                var data = google.visualization.arrayToDataTable([
                    ['Requests', 'Requests'],
                    ['Accepted Requests', accepted],
                    ['Rejected Requests', rejected],
                    ['Pending Requests', pending]
                ]);
                var options = {
                    slices: {
                        0: {color: 'green'},
                        1: {color: 'red'},
                        2: {color: '#007bff'}
                    }
                };
                var chart = new google.visualization.PieChart(document.getElementById('piechart'));
                chart.draw(data, options);
            }
        </script>

        <!-- Font Awesome Icon Library -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <title>Happy Programming</title>

        <!--Custom CSS-->
        <link rel="stylesheet" href="css/template.css" />
        <link rel="stylesheet" href="css/rateMentor.css" />
    </head>
    <body>
        <div class="body-container">
            <%@include file="headerNew.jsp" %>
            <!--Thay code vao day-->
            <div class="main-content">
                <div class="mentor-statistic-container">
                    <div class="left-panel" style="display: flex">
                        <div>
                            <div class="mentor-info-section" style="min-width: 700px">
                                <h2>Mentor Information</h2>
                                <div class="mentor-info">
                                    <div style="height: 100%">
                                        <img class="mentor-avatar" src="images/3.png" alt="avatar">
                                    </div>
                                    <div class="mentor-info-text">
                                        <h3><b>${requestScope.user.name}</b></h3>
                                        <p><b>Email: </b>${requestScope.user.email}</p>
                                        <p><b>Phone: </b>${requestScope.user.phone}</p>
                                        <p><b>Birthday: </b>${requestScope.user.dob}</p>
                                        <p><b>Gender: </b>${requestScope.user.gender==1?"Male":"Female"}</p>
                                        <p><b>Address: </b>${requestScope.user.address}</p>
                                    </div>
                                </div>
                            </div>

                            <div class ="mentor-statistic">
                                <h2 style="margin-top: 20px">Requests Statistic</h2>
                                <div style="display: flex">
                                    <div id="piechart" style="width: 500px; height: 300px;"></div>
                                    <div>
                                        <p>Accepted: <p style="color: green">${acceptedRequest}</p></p>
                                        <p>Rejected: <p style="color: red">${rejectedRequest}</p></p>
                                        <p>Pending: <p style="color: #007bff">${pendingRequest}</p></p>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="other-ratings" style="max-width: 800px; padding-left: 50px; align-self: center">
                            <div class="name-and-stars">
                                <h3>Comments & Ratings</h3>
                                <div class="stars">
                                    <span style="padding-right: 10px">Average: </span>
                                    <span class="checked" style="padding-right: 10px">${averageStars}/5</span>
                                    <span class="fa fa-star ${averageStars>=1?"checked":""}"></span>
                                    <span class="fa fa-star ${averageStars>=2?"checked":""}"></span>
                                    <span class="fa fa-star ${averageStars>=3?"checked":""}"></span>
                                    <span class="fa fa-star ${averageStars>=4?"checked":""}"></span>
                                    <span class="fa fa-star ${averageStars>=5?"checked":""}"></span>
                                </div>
                            </div>
                            <ul class="other-ratings-list" style="height: 500px; overflow-y: scroll">
                                <c:forEach items="${requestScope.ratings}" var="rating">
                                    <li>
                                        <div class="other-rating">
                                            <div class="name-and-stars">
                                                <p class="rater-name"><b>${rating.menteeName}</b></p>
                                                <div class="stars">
                                                    <span class="checked" style="padding-right: 10px">${rating.stars}/5</span>
                                                    <span class="fa fa-star ${rating.stars>=1?"checked":""}"></span>
                                                    <span class="fa fa-star ${rating.stars>=2?"checked":""}"></span>
                                                    <span class="fa fa-star ${rating.stars>=3?"checked":""}"></span>
                                                    <span class="fa fa-star ${rating.stars>=4?"checked":""}"></span>
                                                    <span class="fa fa-star ${rating.stars>=5?"checked":""}"></span>
                                                </div>
                                            </div>
                                            <p>${rating.comment}</p>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="right-panel">
                        <div class="request-pending" style="margin-bottom: 20px">
                            <h2>Pending Requests</h2> 
                            <div class="mentor-table-container">
                                <table id="pending" class="display" style="width:100%">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Requester</th>
                                            <th>Request Title</th>
                                            <th>Created Date</th>
                                            <th>Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${pending}" var="rq">
                                            <tr style="cursor: pointer" onclick="setPendingModalData('${rq.id}', '${rq.menteeName}', '${rq.title}', `${rq.mess}`, '${rq.creationDate}', '${rq.status}')">
                                                <td>${rq.id}</td>
                                                <td>${rq.menteeName}</td>
                                                <td>${rq.title}</td>
                                                <td>${rq.creationDate}</td>
                                                <td>
                                                    <c:choose >
                                                        <c:when test="${rq.status == 0}"><p style="color: #007bff">Pending</p></c:when>
                                                        <c:when test="${rq.status == 1}"><p style="color: green">Accepted</p></c:when>
                                                        <c:when test="${rq.status == 2}"><p style="color: red">Rejected</p></c:when>
                                                    </c:choose>
                                                </td>
                                            </tr>
                                        </c:forEach> 
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="request-history" style="margin-bottom: 20px">
                            <h2>Request History</h2> 
                            <div class="mentor-table-container">
                                <table id="history" class="display" style="width:100%">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Requester</th>
                                            <th>Request Title</th>
                                            <th>Created Date</th>
                                            <th>Status</th> 
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${history}" var="rq">
                                            <tr style="cursor: pointer" onclick="setHistoryModalData('${rq.id}', '${rq.menteeName}', '${rq.title}', `${rq.mess}`, '${rq.creationDate}', '${rq.status}')">
                                                <td>${rq.id}</td>
                                                <td>${rq.menteeName}</td>
                                                <td>${rq.title}</td>
                                                <td>${rq.creationDate}</td>
                                                <td>
                                                    <c:choose >
                                                        <c:when test="${rq.status == 0}"><p style="color: #007bff">Pending</p></c:when>
                                                        <c:when test="${rq.status == 1}"><p style="color: green">Accepted</p></c:when>
                                                        <c:when test="${rq.status == 2}"><p style="color: red">Rejected</p></c:when>
                                                    </c:choose>
                                                </td>
                                            </tr>
                                        </c:forEach> 
                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>
                </div>


            </div>
            <%@include file="Footer.jsp" %>
        </div>
        <!--Modal-->
        <!--History-->
        <div class="modal fade" id="requestDetailModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Request Detail</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form action="#" method="POST">
                            <div class="modal-body">
                                <p><b>ID: </b>${rq.id}</p>
                                <p><b>Requester: </b>${rq.menteeName}</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-link" style="color: #272727" data-dismiss="modal">Cancel</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function setPendingModalData(id, requester, title, message, created, status) {
                let st;
                switch (status) {
                    case '0':
                        st = '<p style="color: #007bff">Pending</p>';
                        break;
                    case '1':
                        st = '<p style="color: green">Accepted</p>';
                        break;
                    case '2':
                        st = '<p style="color: red">Rejected</p>';
                        break;
                }
                $('#requestDetailModal').find('.modal-body').html(`
                        <p><b>ID: </b>` + id + `</p>
                        <p><b>Requester: </b>` + requester + `</p>
                        <p><b>Title: </b>` + title + `</p>
                        <p><b>Message: </b>` + message + `</p>
                        <p><b>Created Date: </b>` + created + `</p>`
                        );
                $('#requestDetailModal').modal('show');
            }

            function setHistoryModalData(id, requester, title, message, created, status) {
                let st;
                switch (status) {
                    case '0':
                        st = '<p style="color: #007bff">Pending</p>';
                        break;
                    case '1':
                        st = '<p style="color: green">Accepted</p>';
                        break;
                    case '2':
                        st = '<p style="color: red">Rejected</p>';
                        break;
                }
                $('#requestDetailModal').find('.modal-body').html(`
                        <p><b>ID: </b>` + id + `</p>
                        <p><b>Requester: </b>` + requester + `</p>
                        <p><b>Title: </b>` + title + `</p>
                        <p><b>Message: </b>` + message + `</p>
                        <p><b>Created Date: </b>` + created + `</p>`
                        );
                $('#requestDetailModal').modal('show');
            }
            $(document).ready(function () {
                $('#pending').DataTable();
                $('#history').DataTable();
            });
        </script>
    </body>
</html>
