<%-- 
    Document   : YearWiseReport
    Created on : 13 Apr, 2018, 5:23:54 PM
    Author     : Admin
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
        <title>Employee Year Sheet</title>
        <style>
            table,th,td {
                border: 1px solid black;

            }
        </style>
    </head>

    <table id="table_2" class="table table-bordered table-striped" style="" cellpadding="3" align="Center"  >
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
                    <tr></tr>
                    <tr>
                        <th>Cycle</th>
                        <th>Unlock</th>
                        <th>Lock</th>
                        <th>Unlock</th>
                        <th>Lock</th>
                        <th>KRA Rating Out Of</th>
                        <th>Self Rating</th>
                        <th>Management Rating</th>


                    </tr>
                </thead>
            </c:otherwise>
        </c:choose>
        <tbody>
            <c:forEach var="list" items="${list}">
                <tr>
                    <td>${list[7]}-${list[8]}</td>
                    <td>${list[2]}</td>
                    <td>${list[3]}</td>
                    <td>${list[0]}</td>
                    <td>${list[1]}</td>
                    <td>${list[4]}</td>
                    <td>${list[5]}</td>
                    <td>${list[6]}</td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</html>
