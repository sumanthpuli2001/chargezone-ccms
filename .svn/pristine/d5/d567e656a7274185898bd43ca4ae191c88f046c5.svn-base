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

    <table id="table_1" class="table table-bordered table-striped" style="" cellpadding="3" align="Center">
        <c:choose>
            <c:when test="${empty mapList}"> 
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
                        <th>level</th>
                        <th>Year</th>
                        <th>Walk the Talk</th>
                        <th>Deliver Results</th>
                        <th>Build Relationships & Develop Others</th>
                        <th>Act with Courage</th>
                        <th>Believe in Vision & Purpose</th>
                        <th>Remarks For Employee</th>
                        <th>Remarks For Filling BY</th>
                    </tr>
                </thead>


            </c:otherwise>
        </c:choose>
        <tbody>


            <c:forEach var="mapList" items="${mapList}">
                <tr>
                    <td><b>${mapList.key[2]}</b></td>
                    <td><b>${mapList.key[3]}</b></td>
                    <td><b>${mapList.key[4]}</b></td>
                    <td><b>${mapList.key[5]}</b></td>
                    <td><b>${mapList.key[6]}</b></td>
                    <td>
                        <c:set var="string2" value="${fn:split(mapList.key[7], '/')}" />
                        ${string2[2]} - ${string2[2]+1}
                    </td>
                                    <!--<td><b>${mapList.key[7]}</b></td>-->
                    
                </tr> 
                <c:forEach var="list" items="${mapList.value}">
                    <tr>
                        <td>${list[2]}</td> 
                        <td>${list[3]}</td>
                        <td>${list[4]}</td>
                        <td>${list[5]}</td>
                        <td>${list[6]}</td>
                        <td>
                            <c:set var="string2" value="${fn:split(list[7], '/')}" />
                            ${string2[2]} - ${string2[2]+1}
                        </td>
                        <td>
                            <c:if test="${(list[8] eq '1')}">Below Average</c:if>
                            <c:if test="${(list[8] eq '2')}">Average</c:if>
                            <c:if test="${(list[8] eq '3')}">Good</c:if>
                            <c:if test="${(list[8] eq '4')}">Very Good</c:if>
                            <c:if test="${(list[8] eq '5')}">Excellent</c:if>
                            </td>
                            <td>
                            <c:if test="${(list[9] eq '1')}">Below Average</c:if>
                            <c:if test="${(list[9] eq '2')}">Average</c:if>
                            <c:if test="${(list[9] eq '3')}">Good</c:if>
                            <c:if test="${(list[9] eq '4')}">Very Good</c:if>
                            <c:if test="${(list[9] eq '5')}">Excellent</c:if>
                            </td>
                            <td>
                            <c:if test="${(list[10] eq '1')}">Below Average</c:if>
                            <c:if test="${(list[10] eq '2')}">Average</c:if>
                            <c:if test="${(list[10] eq '3')}">Good</c:if>
                            <c:if test="${(list[10] eq '4')}">Very Good</c:if>
                            <c:if test="${(list[10] eq '5')}">Excellent</c:if>
                            </td>
                            <td>
                            <c:if test="${(list[11] eq '1')}">Below Average</c:if>
                            <c:if test="${(list[11] eq '2')}">Average</c:if>
                            <c:if test="${(list[11] eq '3')}">Good</c:if>
                            <c:if test="${(list[11] eq '4')}">Very Good</c:if>
                            <c:if test="${(list[11] eq '5')}">Excellent</c:if>
                            </td>
                            <td>
                            <c:if test="${(list[12] eq '1')}">Below Average</c:if>
                            <c:if test="${(list[12] eq '2')}">Average</c:if>
                            <c:if test="${(list[12] eq '3')}">Good</c:if>
                            <c:if test="${(list[12] eq '4')}">Very Good</c:if>
                            <c:if test="${(list[12] eq '5')}">Excellent</c:if>
                            </td>

                            <td>${list[13]}</td>
                        <td>${list[14]}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
    </table>
</html>
