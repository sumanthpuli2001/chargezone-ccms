<%--
    Document   : ExpenseRequestExcelData
    Created on : Feb 26, 2016, 4:51:11 PM
    Author     : AJAY
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%--<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>--%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <head>
        <style>
            table,th,td {
                border: 1px solid black;

            }
        </style>
    </head>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Expense Request</h1>

        </section>

        <!-- Main content -->

        <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
            <c:choose>
                <c:when test="${empty expenseRequestList}">
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
                            <th>Department</th>
                            <th>Designation</th>
                            <th>Expense Type</th>
                            <th>Date Of Submit</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                </c:otherwise>
            </c:choose>
            <tbody>
                <c:forEach var="list" items="${expenseRequestList}">
                    <tr>
                        <td>${list[0]}</td>
                        <td>${list[1]}</td>
                        <td>${list[2]}</td>
                        <td>${list[3]}</td>
                        <td>${list[4]}</td>
                        <td>${list[6]}</td>
                        <c:if test="${list[5] == 0}"><td><span class="badge">Pending</span></td></c:if>
                        <c:if test="${list[5] == 10}"><td><span class="label label-danger">Reworked By ${list[9]}</span></td></c:if>
                        <c:if test="${list[5] == 1}"><td><span class="label label-danger">Rejected By ${list[9]}</span></td></c:if>
                        <c:if test="${list[5] == 2}"><td><span class="label label-success">Approved By ${list[9]}</span></td></c:if>
                        <c:if test="${list[5] == 3}"><td><span class="label label-default">Saved As Draft</span></td></c:if>
                        <c:if test="${list[5] == 4}"><td><span class="label label-success">Final Approved By ${list[9]}</span></td></c:if>
                        </tr>
                </c:forEach>

            </tbody>
        </table>

</html>



