<%-- 
    Document   : PMP Report
    Created on : Feb 4, 2016, 3:35:29 PM
    Author     : Dhaval parmar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%--<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>--%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Detail Sheet</title>
        <style>
            table,th,td {
                border: 1px solid black;

            }
        </style>
    </head>

    <table id="table_1" class="table table-bordered table-striped" style="" cellpadding="3" align="Center"  >
        <c:choose>
            <c:when test="${empty list}"> 
                <tr>
                    <td align="center">
                        <c:out value="There is no record found."></c:out>
                        </td>
                    </tr>
            </c:when>
            <c:otherwise>
                <thead>
                    <tr>
                        <th>Employee ID</th>
                        <th>Employee Name</th>
                        <th>Department</th>
                        <th>Designation</th>
                        <th>Reporting Manager</th>
                        <th>level</th>
                        <th>Year</th>
                        <th>Kra Score</th>
                        <th>WLB Score</th>
                        <th>Total Score</th>
                        <th>Final/Performance Ratings</th>
                        <th>Additional Projects/Activity Score</th>
                    </tr>
                </thead>
            </c:otherwise>
        </c:choose>
        <tbody>
            <c:forEach var="list" items="${list}">
                <tr>
                    <td>${list[2]}</td> 
                    <td>${list[3]}</td>
                    <td>${list[4]}</td>
                    <td>${list[5]}</td>
                    <td>${list[11]}</td>
                    <td>${list[8]}</td>
                    <td>${list[6]}-${list[6]+1}</td>
                    <td>${list[9]}</td><!--//Kra Score-->
                    <td>${list[10]}</td><!--//WLB Score-->
                    <td>${list[7]}</td><!--//Total Score-->

                    <td>
                        <c:if test="${(list[7] ge 106 && list[7] le 110)}">Far Exceeds Expectations</c:if>
                        <c:if test="${(list[7] ge 101 && list[7] le 105)}">Exceeds Expectations</c:if>
                        <c:if test="${(list[7] ge 80  && list[7] le 100)}">Meets Expectations</c:if> 
                        <c:if test="${(list[7] ge 51  && list[7] le 79) }">Partially Meets Expectations</c:if>
                        <c:if test="${(list[7] ge 1   && list[7] le 50)}">Does Not Meet Expectations</c:if>   
                        </td>
                         <td>${list[12]}</td>
                    </tr> 
            </c:forEach>
    </table>
</html>
