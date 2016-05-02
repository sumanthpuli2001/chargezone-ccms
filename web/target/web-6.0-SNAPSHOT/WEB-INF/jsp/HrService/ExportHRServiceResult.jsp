<%-- 
    Document   : ExportHRServiceResult
    Created on : Mar 23, 2016, 5:05:10 PM
    Author     : Vinita
--%>
<%-- 
    Document   : HrApproveResult
    Created on : Nov 19, 2015, 2:33:35 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HR Service Result</title>
       <style>
            table,th,td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty hrApprovelist}">
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
                                                                    <th>HR Service</th>
                                                                    <th>Requested Date</th>
                                                                    <th>Approved Date</th>
                                                                    <th>Status</th>
                                                                    <!--<th>Status</th>-->
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="hrlist" items="${hrApprovelist}">
                                                            <tr>
                                                                <td>${hrlist[1]}</td>
                                                                <td>${hrlist[2]}</td>
                                                                <td>${hrlist[3].text}</td>
                                                                  <td>${hrlist[6]}</td>
                                                                <td>${hrlist[7]}</td>
                                                                <td>
                                                                    <c:if test="${hrlist[5] eq 1}">
                                                                        <span class="badge">Pending</span>
                                                                        </c:if>
                                                                        <c:if test="${hrlist[5] eq 2}">
                                                                            <span class="badge">Closed</span>
                                                                        </c:if>
                                                                </td>
                                                                <!--<td>-->
                                                                    <%--<c:if test="${list[5] eq 1}">--%>
                                                                        <!--<span class="badge">Pending</span>-->
                                                                        <%--</c:if>--%>
                                                                        <%--<c:if test="${list[5] eq 5}">--%>
                                                                            <!--<span class="badge">Pending</span>-->
                                                                        <%--</c:if>--%>
                                                                        <%--<c:if test="${list[5] eq 6}">--%>
                                                                            <!--<span class="badge">Withdraw Pending</span>-->
                                                                        <%--</c:if>--%>
                                                                        <%--<c:if test="${list[5] eq 10}">--%>
                                                                            <!--<span class="badge">Withdraw Pending</span>-->
                                                                        <%--</c:if>--%>
                                                                <!--</td>-->
                                                               
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
    </body>
</html>
