<%-- 
    Document   : SecurityResult
    Created on : Nov 16, 2015, 2:46:32 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Approve Visitor Request</title>
        <style>
            table,th,td {
                border: 1px solid black;
            }
        </style>
    </head>


    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">
        <c:choose>
            <c:when test="${empty Approverlist}">
                <tr>
                    <td align="center">
                <c:out value="There is no record found."></c:out>
                </td>
                </tr>
            </c:when>
            <c:otherwise>
                <thead>
                    <tr>
                        <!--<th align="center" style="width: 1px;"><input type="checkbox" id="toggleId"/></th>-->
                        <th>Employee Id</th>
                        <th>Employee Name</th>
                        <th>Visitor Name</th>
                        <th>Visiting Date And Time</th>
                        <th>Requested Date</th>
                        <th>Status</th>
                    </tr>
                </thead>
            </c:otherwise>
        </c:choose>
        <tbody>
        <%--<c:when test="${empty Approverlist}">--%>
            <c:forEach var="list" items="${Approverlist}">
                <tr>

                    <td>${list[1]}</td>
                    <td>${list[2]}</td>
                    <td>${list[3]}</td>
                    <td>${list[4]}</td>
                    <td>${list[8]}</td>
                    <td>
                <c:if test="${list[6] eq 1}"><span class="badge">Pending</span> 
                </c:if>
                <c:if test="${list[6] eq 2}"><span class="label label-success">Approved by ${list[7]}</span>
                </c:if>
                <c:if test="${list[6] eq 8}"><span class="label label-warning">Withdrawn</span>
                </c:if>
               
                </td>                     
                </tr>
            </c:forEach>
        <%--</c:when>--%>
    </tbody>
</table>
</html>










