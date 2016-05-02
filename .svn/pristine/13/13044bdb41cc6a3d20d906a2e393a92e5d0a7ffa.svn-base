<%-- 
    Document   : PoolCarAdminResult
    Created on : Oct 20, 2015, 4:50:07 PM
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
        <title>Pool Car Approver Result</title>
        <style>
            table,th,td {
                border: 1px solid black;
            }
        </style>
    </head>

    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">
        <c:choose>
            <c:when test="${empty approverlist}">
                <tr>
                    <td align="center">
                        <c:out value="There is no record found."></c:out>
                        </td>
                    </tr>
            </c:when>
            <c:otherwise>
                <thead>
                    <tr>
                        <!--<th align="c+enter" style="width: 1px;"><input type="checkbox" id="toggleId"/></th>-->
                        <th>Employee Id</th>
                        <th>Employee Name</th>
                        <th>Start Date And Time</th>
                        <th>End  Date And Time</th>
                        <th>Status</th>

                    </tr>
                </thead>
            </c:otherwise>
        </c:choose>
        <tbody>
            <c:forEach var="list" items="${approverlist}">
                <tr>
                    <%--<c:if test="${list[6] eq 2}">--%>
                    <!--<td align="center"><input type="checkbox" name="checkId" value="$list[0]}"/></td>-->
                    <td>${list[1]}</td>
                    <td>${list[2]}</td>
                    <td>${list[3]}</td>
                    <td>${list[4]}</td>
                    <td>
                        <c:if test="${list[6] eq 1}">
                            <span class="badge">Requested</span>
                        </c:if>
                        <c:if test="${list[6] eq 2}">
                            <span class="badge"> Approval Pending</span>
                        </c:if>
                        <c:if test="${list[6] eq 3}"> <span class="label label-danger">Rejected by ${list[9]}</span>
                        </c:if>
                        <c:if test="${list[6] eq 4}">
                            <span class="label label-success">Approved by ${list[8]}</span>
                        </c:if>
                        <c:if test="${list[6] eq 5}">
                            <span class="label label-danger">Rejected by ${list[8]}</span>
                        </c:if>
                        <c:if test="${list[6] eq 6}">
                            <span class="label label-warning">Approved by ${list[9]}</span>
                        </c:if>
                        <c:if test="${list[6] eq 7}">
                            <span class="label label-warning">Approved by ${list[8]}</span>
                        </c:if>
                        <c:if test="${list[6] eq 8}">
                            <span class="badge"> Approval Pending</span>
                        </c:if>
                        <c:if test="${list[6] eq 9}">
                            <span class="badge"> Approval Pending</span>
                        </c:if>
                        <c:if test="${list[6] eq 14}">
                            <span class="label label-warning">Withdraw</span>
                        </c:if>
                    </td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
</html>

