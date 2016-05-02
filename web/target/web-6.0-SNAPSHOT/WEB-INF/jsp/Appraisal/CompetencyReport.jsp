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
                        <th>Year</th>
                        <th>Competency Evaluation (As Per Zydex Competency Framework)</th>
                        <!--<th>Title</th>-->
                        <th><table><tr><th colspan="6">Smart Execution</th></tr><tr>
                        <th>Start Year</th>
                        <th>Remark</th>
                        <th>Mid Year</th> 
                        <th>Remark</th> 
                        <th>End Year</th> 
                        <th>Remark</th></tr></table></th>
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
            <td>${list[6]}-${list[6]+1}</td>
            <td>${list[7]}</td>
            <!--<td>{list[8]}</td>-->
            <td><table>
                        <td>${list[9]}</td>
                        <td>${list[10]}</td>
                        <td>${list[11]}</td>
                        <td>${list[12]}</td>
                        <td>${list[13]}</td>
                        <td>${list[14]}</td>
                    </table></td>

        </tr>
    </c:forEach>
    </html>
