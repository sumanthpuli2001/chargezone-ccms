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
        <title>Employee PT </title>
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
        <table class="table table-bordered table-striped table-hover" style="" align="Center"  >
            <c:choose>
                <c:when test="${empty employeePtcheck1}">
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
                            <th>PT</th>
                        </tr>
                    </thead>
                </c:otherwise>
            </c:choose>
            <tbody>

                <c:forEach var="list" items="${employeePtcheck1}" varStatus="status">
                    <tr>
                        <td>${list[0]}</td>
                        <td>${list[1]}</td>

                        <td> ${list[2]} </td>


                    </tr>
                </c:forEach>

                <tr>
                    <td></td>
                    <td>Total Amount</td>
                    <td>${sessionTotalPtAmount}</td>

                </tr>
            </tbody>
        </table>
    </body>

</html>



