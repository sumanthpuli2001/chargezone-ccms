<%--
    Document   : LeaveBalanceEmployeeWiseExportToExcel
    Created on : May 6, 2016, 5:40:42 PM
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
        <title>Employee Leave Balance</title>
        <style>
            table,th,td {
                border: 1px solid black;

            }
        </style>
    </head>
    <body>
        <!--        <section class="content-header">
                    <h1>Employee Leave Balance: </h1>
                </section>-->
        <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
            <c:choose>
                <c:when test="${empty sessionMapOfLeaveBalance}">
                    <tr>
                        <td align="center">
                            <c:out value="There is no record found."></c:out>
                            </td>
                        </tr>
                </c:when>
                <c:otherwise>
                    <thead>
                        <tr>
                            <th>Employee No</th>
                            <th>Employee Name</th>
                            <th>Casual Leave</th>
                            <th>Sick Leave</th>
                            <th>Privilege Leave</th>
                            <th>Paternity Leave</th>
                            <th>Set Off</th>
                        </tr>
                    </thead>
                </c:otherwise>
            </c:choose>
            <tbody>
                <c:forEach var="employeeBalanceMap" items="${sessionMapOfLeaveBalance}">
                    <tr>
                        <td>${employeeBalanceMap.value[0]}</td>
                        <td>${employeeBalanceMap.value[1]}</td>
                        <td>${employeeBalanceMap.value[2]}</td>
                        <td>${employeeBalanceMap.value[3]}</td>
                        <td>${employeeBalanceMap.value[4]}</td>
                        <td>${employeeBalanceMap.value[5]}</td>
                        <td>${employeeBalanceMap.value[7]}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>

</html>



