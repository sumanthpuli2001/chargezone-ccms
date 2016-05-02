<%--
    Document   : LeaveRequestExcelData
    Created on : Feb 26, 2016, 6:29:42 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Leave Detail</title>
        <style>
            table,th,td {
                border: 1px solid black;

            }
        </style>
    </head>
    <section class="content-header">
        <h1>Employee Leave Detail</h1>
    </section>

    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
        <c:choose>
            <c:when test="${empty leaveListExcel}">
                <tr>
                    <td align="center">
                        <c:out value="There is no record found."></c:out>
                        </td>
                    </tr>
            </c:when>
            <c:otherwise>
                <thead>
                    <tr>
                        <th>Employee Id</th>
                        <th>Employee Name</th>
                        <th>Department</th>
                        <th>Designation</th>
                        <th>Leave Type</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>No Of Day</th>
                        <th>Status</th>
                    </tr>
                </thead>
            </c:otherwise>
        </c:choose>
        <tbody>
            <c:forEach var="list" items="${leaveListExcel}">
                <tr>
                    <td>${list[0]}</td>
                    <td>${list[1]}</td>
                    <td>${list[2]}</td>
                    <td>${list[3]}</td>
                    <td>${list[4]}</td>
                    <td>${list[5]}</td>
                    <td>${list[6]}</td>
                    <td>${list[8]}</td>
                    <c:if test="${list[7] eq 0}">
                        <td><span class="badge">Pending</span></td>
                    </c:if>
                    <c:if test="${list[7] eq 3}">
                        <td><span class="label label-success">Approved</span></td>
                    </c:if>
                    <c:if test="${list[7] eq 2}">
                        <td> <span class="label label-danger">Rejected</span></td>
                    </c:if>
                    <c:if test="${list[7] eq 1}">
                        <td><span class="label label-warning">Reworked</span></td>
                    </c:if>
                    <c:if test="${list[7] eq 4}">
                        <td><span class="label label-info">WithDraw Request</span></td>
                    </c:if>
                    <c:if test="${list[7] eq 5}">
                        <td><span class="label label-info">WithDrawn</span></td>
                    </c:if>


                </tr>
            </c:forEach>
        </tbody>
    </table>

</html>




