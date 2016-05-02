<%--
    Document   : TravelRequestExcelData
    Created on : Feb 26, 2016, 11:11:34 AM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%--<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>--%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Travel Request</title>
        <style>
            table,th,td {
                border: 1px solid black;

            }
        </style>
    </head>
    <body>
        <section class="content-header">
            <h1>Travel Request: </h1>
        </section>
        <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
            <c:choose>
                <c:when test="${empty travelRequestList}">
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
                            <th>Travel Type</th>
                            <th>Travel Request No.</th>
                            <th>Start Date Time</th>
                            <th>End Date Time</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                </c:otherwise>
            </c:choose>
            <tbody>
                <c:forEach var="list" items="${travelRequestList}">
                    <tr>
                        <td>${list[0]}</td>
                        <td>${list[1]}</td>
                        <td>${list[2]}</td>
                        <td>${list[3]}</td>
                        <td>${list[4]}</td>
                        <td>${list[5]}</td>
                        <c:if test="${list[8] eq 0}"><td><span class="badge">Pending</span></td></c:if>
                        <c:if test="${list[8] eq 3}"><td><span class="badge">Approved by ${list[9]}</span></td></c:if>
                        <c:if test="${list[8] eq 10}"><td><span class="badge">Return Request Pending</span></td></c:if>
                        <c:if test="${list[8] eq 2}"><td><span class="label label-danger">Rejected by ${list[9]}</span></td></c:if>
                        <c:if test="${list[8] eq 1}"><td><span class="label label-danger">Rework by ${list[9]}</span></td></c:if>
                        <c:if test="${list[8] eq 4}"><td><span class="badge">WithDraw</span></td></c:if>
                        <c:if test="${list[8] eq 5}"><td><span class="label label-success">Final Approved by ${list[9]}</span></td></c:if>
                        <c:if test="${list[8] eq 6}"><td><span class="badge">Approved by ${list[9]}</span></td></c:if>
                        </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>

</html>


