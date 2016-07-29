<%-- 
    Document   : GatePassSecurityResult
    Created on : Nov 25, 2015, 2:21:06 PM
    Author     : Vinita
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Approve Gate Pass</title>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    </head>
    <style>
        table,th,td {
            border: 1px solid black;
        }
    </style>
    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">
        <c:choose>
            <c:when test="${empty Securitylist}">
                <tr>
                    <td align="center">
                        <c:out value="There is no record found."></c:out>
                        </td>
                    </tr>
            </c:when>
            <c:otherwise>
                <thead>
                    <tr>
                        <th style="width: 10%">Emp Id</th>
                        <th style="width: 10%">Emp Name</th>
                        <th >Assets</th>
                        <th >Return Type</th>
                        <th >Date And Time</th>
                         <th >Requested Date</th>
                        <th>Status</th>
                    </tr>
                </thead>
            </c:otherwise>
        </c:choose>
        <tbody>
            <c:forEach var="Securitylist" items="${Securitylist}">
                <tr>

                    <td style="width: 10%">${Securitylist[1]}</td>
                    <td style="width: 10%">${Securitylist[2]}</td>
                    <td style="width: 10%">${Securitylist[3]}</td>
                    <td style="width: 10%">
                        <c:if test="${Securitylist[4] eq true}">Returnable Gate Pass</c:if>
                        <c:if test="${Securitylist[4] eq false}">Non-Returnable Gate Pass</c:if>
                        </td>
                        <td>${Securitylist[5]}</td>
                        <td>${Securitylist[11]}</td>
                    <td style="width: 10%">
                        <c:if test="${Securitylist[7] eq 1}">
                            <span class="badge">Requested</span>
                        </c:if>
                        <c:if test="${Securitylist[7] eq 2}">
                            <span class="badge"> Approval Pending</span>
                        </c:if>
                        <c:if test="${Securitylist[7] eq 4}">
                            <span class="label label-success">Approved by ${Securitylist[8]}</span>
                        </c:if>
                        <c:if test="${Securitylist[7] eq 9}">
                            <span class="badge"> Approval Pending</span>
                        </c:if>
                        <c:if test="${Securitylist[7] eq 8}">
                            <span class="badge"> Approval Pending</span>
                        </c:if>
                        <c:if test="${Securitylist[7] eq 3}">
                            <span class="label label-danger">Rejected by ${Securitylist[9]}</span>
                        </c:if>
                        <c:if test="${Securitylist[7] eq 5}">
                            <span class="label label-danger">Rejected by ${Securitylist[8]}</span>
                        </c:if>
                        <c:if test="${Securitylist[7] eq 6}">
                            <span class="label label-warning">Returned by ${Securitylist[9]}</span>
                        </c:if>
                        <c:if test="${Securitylist[7] eq 7}">
                            <span class="label label-warning">Returned by ${Securitylist[8]}</span>
                        </c:if>
                        <c:if test="${Securitylist[7] eq 14}">
                            <span class="label label-warning">Withdraw</span>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</html>
